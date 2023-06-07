package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoExistenteException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		
		Long idEstado = cidade.getEstado().getId();
		Estado estado =  estadoRepository.buscar(idEstado);
		
		if(estado !=null) {
			cidade.setEstado(estado);
			return cidadeRepository.salvar(cidade);
		}
		
		throw new EntidadeNaoExistenteException(
				String.format("Não existe cadastro de estado para o id %d.", idEstado));
	}

	
	public void remover(Long idCidade){
		
		Cidade cidade = cidadeRepository.buscar(idCidade);
		if(cidade == null) {
			throw new EntidadeNaoExistenteException(
					String.format("A cidade de id %d não foi encontrada na base.", idCidade));
		}
		cidadeRepository.remover(cidade);			
	}

}
