package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public List<Restaurante> listar() {
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante busca(Long id) {
		return manager.find(Restaurante.class,  id );
	}

	
	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}

	@Override
	@Transactional
	public void remover(Restaurante restaurante) {
		manager.remove(restaurante);
		
	}

	@Override
	public List<Restaurante> filtraRestaurante(String nomeRestaurante) {
		return manager.createQuery("from Restaurante where upper(nome) like upper(:nomeRestaurante)", Restaurante.class)
				.setParameter("nomeRestaurante", "%" + nomeRestaurante + "%")
				.getResultList();
	}
	
}
