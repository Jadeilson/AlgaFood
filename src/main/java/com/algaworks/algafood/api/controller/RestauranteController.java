package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoExistenteException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {
	
	@Autowired
	RestauranteRepository restauranteRepository; 
	
	@Autowired
	CadastroRestauranteService cadastroRestauranteService;

	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Restaurante> listar(){
		return restauranteRepository.findAll();
	}
	
	@GetMapping(value = "/filtra-restaurante/{nomeRestaurante}/{nomeCozinha}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Restaurante> filtraRestaurante(@PathVariable String nomeRestaurante, @PathVariable String nomeCozinha){
		
		return restauranteRepository.findFiltraRestauranteByNomeContainingIgnoreCaseAndCozinhaNomeContainingIgnoreCase
					(nomeRestaurante, nomeCozinha);
	}
	
	@GetMapping(value = "/filtra-restaurante2")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Restaurante> filtraRestaurante2
		(@RequestParam("nomeRestaurante") String nomeRestaurante, String nomeCozinha){
		
		return restauranteRepository.findFiltraRestauranteByNomeContainingIgnoreCaseAndCozinhaNomeContainingIgnoreCase
					(nomeRestaurante, nomeCozinha);
	}

	@GetMapping(value = "/{idRestaurante}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long idRestaurante) {
		
		Optional<Restaurante> restaurante = restauranteRepository.findById(idRestaurante);
		
		if(restaurante.isEmpty() ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(restaurante.get());
	}
	
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante){
		
		try {
			
			restaurante = cadastroRestauranteService.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
			
		} catch (EntidadeNaoExistenteException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	
	@PutMapping(value = "/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId,@RequestBody Restaurante restaurante){
		
		try {
			
			Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
			
			if(restauranteAtual.isPresent()) {
				BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id", 
										"formasDePagamentos", "endereco", "dataCadastro", "produtos");
				Restaurante restauranteAtualSalvo = cadastroRestauranteService.salvar(restauranteAtual.get());
				
				return ResponseEntity.status(HttpStatus.OK).body(restauranteAtualSalvo);
			}
			
			return ResponseEntity.notFound().build();
			
		}catch(EntidadeNaoExistenteException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@DeleteMapping(value = "/{restauranteId}")
	public ResponseEntity<?> remover(@PathVariable long restauranteId){
		
		try {
			cadastroRestauranteService.remover(restauranteId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoExistenteException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}		
	}
	
	
	@PatchMapping(value = "/{idRestaurante}")
	public ResponseEntity<?> atualizacaoParcial(@PathVariable Long idRestaurante, 
															@RequestBody Map<String, Object> listaDecampos){
//															@RequestBody Restaurante restaurante){
		
		Optional<Restaurante> restauranteAtual = restauranteRepository.findById(idRestaurante);
		if(restauranteAtual.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		merge(listaDecampos, restauranteAtual.get());
		return atualizar(idRestaurante, restauranteAtual.get());
	}

	
	private void merge(Map<String, Object> listaDecamposOrigem, Restaurante restauranteDestino) {
		
		listaDecamposOrigem.forEach((nomeCampo, valorCampo) -> {
			ObjectMapper objectMapper = new ObjectMapper();
			Restaurante restauranteOrigem = objectMapper.convertValue(listaDecamposOrigem, Restaurante.class);
			
			
			Field field = ReflectionUtils.findField(Restaurante.class, nomeCampo);
			field.setAccessible(true);
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
			
			System.out.println("Nome do Campo = " + nomeCampo + " - Valor do campo = " + valorCampo);
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
			
		});
	}
	
	
}
