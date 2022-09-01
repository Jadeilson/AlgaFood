package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Cidade> listar() {
		// TODO Auto-generated method stub
		TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);
		return query.getResultList();
	}

	@Override
	public Cidade buscar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Cidade.class, id);
	}

	@Transactional
	@Override
	public Cidade salvar(Cidade cidade) {
		// TODO Auto-generated method stub
		return manager.merge(cidade);
	}

	@Transactional
	@Override
	public void remover(Cidade cidade) {
		// TODO Auto-generated method stub
		cidade = buscar(cidade.getId());
		manager.remove(cidade);
	}

}