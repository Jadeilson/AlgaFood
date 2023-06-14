package com.algaworks.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Restaurante> localizaRestaurantes(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal){
		
		var jpql = "from Restaurante where upper(nome) like upper(:nome) and taxaFrete between :taxaInicial and :taxaFinal";
		
		return manager.createQuery(jpql, Restaurante.class)
				.setParameter("nome", "%" + nome + "%")
				.setParameter("taxaInicial", taxaInicial)
				.setParameter("taxaFinal", taxaFinal)
				.getResultList();
	}


	@Override
	public List<Restaurante> localizaRestaurantesDinamica(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal) {

		var jpqlDinamica = new StringBuilder();
		jpqlDinamica.append("from Restaurante where 0 = 0 ");
		
		var parametros = new HashMap<String, Object>();
		
		if (StringUtils.hasLength(nome)){
			jpqlDinamica.append("and upper(nome) like upper(:nome) ");
			parametros.put("nome", "%" + nome + "%");
		}
		
		if (taxaInicial != null){
			jpqlDinamica.append("and taxaFrete >= :taxaInicial ");
			parametros.put("taxaInicial", taxaInicial);
		}
		
		if (taxaFinal != null){
			jpqlDinamica.append("and taxaFrete <= :taxaFinal ");
			parametros.put("taxaFinal", taxaFinal);
		}
		
		TypedQuery<Restaurante> query = manager.createQuery(jpqlDinamica.toString(), Restaurante.class);
		parametros.forEach((nomeParametro, valorParametro) -> query.setParameter(nomeParametro, valorParametro));
		
		return query.getResultList();
	}


	@Override
	public List<Restaurante> bucaRestaurantesComCriteriaApi(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		Root<Restaurante> root = criteria.from(Restaurante.class);
		
		var predicados = new ArrayList<Predicate>();
		
		if(StringUtils.hasLength(nome)) {
//			Predicate nomePrecicate = builder.like(root.get("nome"), "%" + nome + "%");
			Predicate nomePrecicate = builder.like(builder.upper(root.get("nome")), 
										"%" + nome.toUpperCase() + "%");
			predicados.add(nomePrecicate);
		}
		
		if(taxaInicial != null) {
			predicados.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaInicial));
		}
		
		if(taxaFinal != null){
			predicados.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFinal));
		}
		
		criteria.where(predicados.toArray(new Predicate[0]));
		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		return query.getResultList();
	}


	
	
}
