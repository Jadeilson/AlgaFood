package com.algaworks.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	EntityManager manager;
	
//	Lista De Cozinhas (Toas as Cozinhas)
	public List<Cozinha> listar(){
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		return query.getResultList();
		
//		Outra forma que fazer a mesma consulta de forma mais direta
//		return manager.createQuery("select c from Cozinha", Cozinha.class)
//				.getResultList();
	}
	
	
//	Buscar
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	
//	Adicionar
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
//	remover
	@Transactional
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		manager.remove(cozinha);
	}
	
}
