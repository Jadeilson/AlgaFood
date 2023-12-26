package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoExistenteException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void remover(Long idEstado) {
				
		try {
			estadoRepository.deleteById(idEstado);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoExistenteException(
				String.format("Não foi encontrado um estado com o código %d.", idEstado));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("O estado de codigo %d não pode ser apagado, pois se encontra em uso.", idEstado));
		}
	}
}
