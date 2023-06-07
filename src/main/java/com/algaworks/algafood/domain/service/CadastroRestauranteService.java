package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoExistenteException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	
	public Restaurante salvar(Restaurante restaurante) {
		
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		if(cozinha == null) {
			throw new EntidadeNaoExistenteException(
					String.format("Não existe cadastro de cozinha para o id %d.", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha);
		return restauranteRepository.salvar(restaurante);
	}

	public void remover (Long idRestaurante) {
			Restaurante restaurante = restauranteRepository.busca(idRestaurante);
			if(restaurante == null) {
				throw new EntidadeNaoExistenteException(
						String.format("O restaurante de id %d não foi encontrado na base.", idRestaurante));
			}
			restauranteRepository.remover(restaurante);
	}
	
}
