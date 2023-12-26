package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	
	public List<Cozinha> findFiltraCozinhaByNomeContaining(String nomeCozinha);
	
//	@Query("from Cozinha where upper(nome) like upper(concat('%',:nome,'%'))")
	public List<Cozinha> consultaCozinhasPorNome(@Param ("nome") String nomeCozinha);

}
