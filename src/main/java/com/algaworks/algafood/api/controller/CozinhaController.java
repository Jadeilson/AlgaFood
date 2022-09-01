package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@RestController
//@RequestMapping(value = "/cozinhas", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequestMapping(value = "/cozinhas")
public class CozinhaController {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Autowired
	CadastroCozinhaService cadastroCozinhaService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.listar(); 
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<CozinhasXmlWrapper> listarXml() {
		CozinhasXmlWrapper cozinhasXmlWrapper = new CozinhasXmlWrapper(cozinhaRepository.listar());
//		return ResponseEntity.ok(cozinhasXmlWrapper);
//		return new CozinhasXmlWrapper(cozinhaRepository.listar());
//		return ResponseEntity.status(HttpStatus.CREATED).body(cozinhasXmlWrapper);
//		return ResponseEntity.status(HttpStatus.CREATED).build();
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.add(HttpHeaders.LOCATION, "http://api.algafood.local:8081/cozinhas/1");
//		
//		return ResponseEntity
//				.status(HttpStatus.FOUND)
//				.headers(headers)
//				.build();
		return ResponseEntity.ok().body(cozinhasXmlWrapper);
				
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Cozinha> buscar (@PathVariable Long id) {
		Cozinha cozinha = cozinhaRepository.buscar(id);
		
		if(cozinha !=null) {
			return ResponseEntity.ok(cozinha);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/{cozinhaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cozinha> buscar2 (@PathVariable("cozinhaId") Long id) {

		Cozinha cozinha = cozinhaRepository.buscar(id);
		
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
		Cozinha cozinhaAtual = cozinhaRepository.buscar(idCozinha);
		
		if(cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
			
			return ResponseEntity.ok(cozinhaAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{idCozinha}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long idCozinha){
		
		Cozinha cozinha = cozinhaRepository.buscar(idCozinha);
		try {
			
			if(cozinha != null) {
				cozinhaRepository.remover(cozinha);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.notFound().build();
			
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
