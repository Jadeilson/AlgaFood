package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
				JpaSpecificationExecutor<Restaurante> {
	
	public List<Restaurante> findFiltraRestauranteByNomeContainingIgnoreCaseAndCozinhaNomeContainingIgnoreCase
		(String nomeRestaurante, String nomeCozinha);
	
//	resolvendo o problema de consulta N + 1
	@Query("from Restaurante r left join fetch r.cozinha")
	public List<Restaurante> findAll();

//	resolvendo o problema de consulta N + 1
	@Query("from Restaurante r left join fetch r.cozinha where r.id = :idRestaurante")
	public Optional<Restaurante> findById(Long idRestaurante);
}
