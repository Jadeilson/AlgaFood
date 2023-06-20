package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	RestauranteRepository restauranteRepository;
		
	@GetMapping("/localizar-restaurantes")
	public List<Restaurante> localizaRestaurantes(@RequestParam String nome, 
													@RequestParam BigDecimal taxaInicial, 
														@RequestParam BigDecimal taxaFinal){
		return restauranteRepository.localizaRestaurantes(nome, taxaInicial, taxaFinal); 
	}
	
//	Ao utilizar a anotação @RequestParam se torna o passagem obrigatória do parametro na requisição
//	O não mapeamento faz com que não seja obrigatório e ele busca automaticamente
//	É possível não tornar obrigatório caso adicione a chave valor required como false
	@GetMapping("/localizar-restaurantes-dinamica")
	public List<Restaurante> localizaRestaurantesDinamica( @RequestParam(required = false)String nome, 
															BigDecimal taxaInicial, 
															BigDecimal taxaFinal){
		
		return restauranteRepository.localizaRestaurantesDinamica(nome, taxaInicial, taxaFinal); 
	}

	
	@GetMapping("/bucaRestaurantesComCriteriaApi")
	public List<Restaurante> bucaRestaurantesComCriteriaApi(String nome, 
															BigDecimal taxaInicial, 
															BigDecimal taxaFinal ){
		
		return restauranteRepository.bucaRestaurantesComCriteriaApi(nome, taxaInicial, taxaFinal);
	}
	
	
	@RequestMapping("/buscaRestauranteComFretegratis")
	public List<Restaurante> buscaRestauranteComFretegratis(String nome){
		
		return restauranteRepository.buscaRestauranteComFretegratis(nome);
	}
	
	@GetMapping("/buscarPrimeiro")
	public Optional<Restaurante> buscarPrimeiro() {
		return restauranteRepository.buscarPrimeiro();
	}
}
















