package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoExistenteException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Autowired
	CadastroCozinhaService cadastroCozinhaService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.findAll(); 
	}
	
	@GetMapping
	@RequestMapping(value = "/filtra-cozinha")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Cozinha> filtraCozinha(@RequestParam String nomeCozinha){
		return cozinhaRepository.findFiltraCozinhaByNomeContaining(nomeCozinha);
	}
	
	@GetMapping
	@RequestMapping(value = "/filtra-cozinha-por-nome")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Cozinha> filtraCozinhaPorNome(@RequestParam String nomeCozinha){
		return cozinhaRepository.consultaCozinhasPorNome(nomeCozinha);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cozinha> buscar (@PathVariable Long id) {
		Optional<Cozinha> cozinha = cozinhaRepository.findById(id);
		
		if(cozinha.isPresent()) {
			return ResponseEntity.ok(cozinha.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
		cozinha = cadastroCozinhaService.salvar(cozinha);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://api.algafood.local/cozinhas/" + cozinha.getId());
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.headers(headers)
				.body(cozinha);
	}
	
	
	@PutMapping(value = "/{idCozinha}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long idCozinha, @RequestBody Cozinha cozinha){
		Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(idCozinha);
		
		if(cozinhaAtual.isPresent()) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
			Cozinha cozinhaSalva = cadastroCozinhaService.salvar(cozinhaAtual.get());
			
			return ResponseEntity.ok(cozinhaSalva);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{idCozinha}")
	public ResponseEntity<?> remover(@PathVariable Long idCozinha){

		try {
			cadastroCozinhaService.remover(idCozinha);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (EntidadeNaoExistenteException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); 
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
}




