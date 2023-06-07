package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoExistenteException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CadastroEstadoService cadastroEstadoService;
	
	@GetMapping
	@ResponseStatus(value =HttpStatus.OK)
	public List<Estado> listar() {
		return estadoRepository.listar();
	}
	
	@GetMapping(value = "/filtra-estado/{nomeEstado}")
	public List<Estado> filtraEstado(@PathVariable String nomeEstado){
		return estadoRepository.filtraEstado(nomeEstado);
	}
	
	@GetMapping(value = "/{idEstado}")
	public ResponseEntity<Estado> buscar(@PathVariable Long idEstado) {
		Estado estado =  estadoRepository.buscar(idEstado);
		
		if(estado == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estado);
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado) {
		return cadastroEstadoService.salvar(estado);
	}
	
	
	@PutMapping(value = "/{idEstado}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long idEstado, @RequestBody Estado estado) {
		
		Estado estadoAtual = estadoRepository.buscar(idEstado);
		
		if(estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual,"id");
			estadoAtual = cadastroEstadoService.salvar(estadoAtual);
			return ResponseEntity.ok().body(estadoAtual);
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping(value = "/{idEstado}")
	public ResponseEntity<?> remover(@PathVariable Long idEstado) {
		try {
			cadastroEstadoService.remover(idEstado);
			return ResponseEntity.noContent().build();
					
		} catch (EntidadeNaoExistenteException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
		
	}
	
	
}
