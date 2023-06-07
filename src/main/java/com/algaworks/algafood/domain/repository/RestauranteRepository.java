package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {
	
	public List<Restaurante> listar();
	public List<Restaurante> filtraRestaurante(String nomeRestaurante);
	public Restaurante busca(Long id);
	public Restaurante salvar(Restaurante restaurante);
	public void remover(Restaurante restaurante);

}
