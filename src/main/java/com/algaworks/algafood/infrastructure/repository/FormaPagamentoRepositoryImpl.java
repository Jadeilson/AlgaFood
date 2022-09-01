package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Repository
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	EntityManager manager;
	
	
	@Override
	public List<FormaPagamento> lista() {
		// TODO Auto-generated method stub
		TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);
		return query.getResultList();
	}

	@Override
	public FormaPagamento buscar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(FormaPagamento.class, id);
	}

	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		// TODO Auto-generated method stub
		return manager.merge(formaPagamento);
	}

	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		// TODO Auto-generated method stub
		formaPagamento = buscar(formaPagamento.getId());
		manager.remove(formaPagamento);
	}

}
