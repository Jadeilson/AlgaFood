package com.algaworks.algafood.domain.repository;

import java.util.List;
import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	public List<Estado> listar();
	public List<Estado> filtraEstado(String nomeEstado);
	public Estado buscar(Long id);
	public Estado salvar(Estado estado);
	public void remover(Long idEstado);
		
}
