package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {
	
	public List<Restaurante> localizaRestaurantes(String nome, 
			BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	public List<Restaurante> localizaRestaurantesDinamica(String nome, 
			BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	public List<Restaurante> bucaRestaurantesComCriteriaApi(String nome, 
			BigDecimal taxaInicial, BigDecimal taxaFinal);
	
}
