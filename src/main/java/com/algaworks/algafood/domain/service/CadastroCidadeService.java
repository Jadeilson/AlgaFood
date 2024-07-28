package com.algaworks.algafood.domain.service;

import java.util.Optional;

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
		Optional<Estado> estado =  estadoRepository.findById(idEstado);
		
		if(estado.isPresent()) {
			cidade.setEstado(estado.get());
			return cidadeRepository.save(cidade);
		}
		
		throw new EntidadeNaoExistenteException(
				String.format("Não existe cadastro de estado para o id %d.", idEstado));
	}

	
	public void remover(Long idCidade){
		
		Optional<Cidade> cidade = cidadeRepository.findById(idCidade);
		if(cidade.isEmpty()) {
			throw new EntidadeNaoExistenteException(
					String.format("A cidade de id %d não foi encontrada na base.", idCidade));
		}
		cidadeRepository.delete(cidade.get());			
	}

}
