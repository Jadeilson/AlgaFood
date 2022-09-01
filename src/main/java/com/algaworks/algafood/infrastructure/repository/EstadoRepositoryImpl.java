package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Estado> listar() {
		// TODO Auto-generated method stub
		TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
		return query.getResultList();
	}

	@Override
	public Estado buscar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Estado.class, id);
	}

	@Transactional
	@Override
	public Estado salvar(Estado estado) {
		// TODO Auto-generated method stub
		return manager.merge(estado);
	}

	@Transactional
	@Override
	public void remover(Estado estado) {
		// TODO Auto-generated method stub
		estado = buscar(estado.getId());
		manager.remove(estado);
	}

}
