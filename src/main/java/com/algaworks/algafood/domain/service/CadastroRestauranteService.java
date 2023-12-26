package com.algaworks.algafood.domain.service;

import java.util.Optional;

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
		Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
		
		if(cozinha.isEmpty()) {
			throw new EntidadeNaoExistenteException(
					String.format("Não existe cadastro de cozinha para o id %d.", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha.get());
		return restauranteRepository.save(restaurante);
	}

	public void remover (Long idRestaurante) {
			Optional<Restaurante> restaurante = restauranteRepository.findById(idRestaurante);
			if(restaurante.isEmpty()) {
				throw new EntidadeNaoExistenteException(
						String.format("O restaurante de id %d não foi encontrado na base.", idRestaurante));
			}
			restauranteRepository.delete(restaurante.get());
	}
	
}
