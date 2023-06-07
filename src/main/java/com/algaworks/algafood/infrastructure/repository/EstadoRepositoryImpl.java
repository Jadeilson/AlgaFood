package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Estado> listar() {
		TypedQuery<Estado> query = manager.createQuery("from Estado order by id desc", Estado.class);
		return query.getResultList();
	}

	@Override
	public Estado buscar(Long idEstado) {
		return manager.find(Estado.class, idEstado);
	}

	@Override
	public List<Estado> filtraEstado(String nomeEstado) {
		return manager.createQuery("from Estado where upper(nome) like upper(:nomeEstado)",Estado.class)
			.setParameter("nomeEstado", "%" + nomeEstado + "%")
			.getResultList();
	}
	
	@Transactional
	@Override
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}

	@Transactional
	@Override
	public void remover(Long idEstado) {
		Estado estado = buscar(idEstado);
		
		if(estado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(estado);
	}

}
