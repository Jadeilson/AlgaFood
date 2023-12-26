package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cidade;	

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	public List<Cidade> findFiltraCidadeByNomeContainingIgnoreCase(String nomeCidade);
//	public List<Cidade> readFiltraCidadeByNomeContainingIgnoreCase(String nomeCidade);
//	public List<Cidade> getFiltraCidadeByNomeContainingIgnoreCase(String nomeCidade);
//	public List<Cidade> streamFiltraCidadeByNomeContainingIgnoreCase(String nomeCidade);
//	Todos os metodos acima são iguais, pois os préfixos {find, get, read, stream} possuem a mesma finalidade.
	
//	firt - Retorna apenas primeiro registro
	public Cidade findFirstBuscaPrimeiraCidadeByNomeContainingIgnoreCase (String nomeCidade); 
	
//	top - Faz busca danto um top na quantidade de registros retornado
	public List<Cidade> getTop2CidadesByNomeContainingIgnoreCase(String nomeCidade); 
	
//	exists
	public boolean existsCidadeByNomeContainingIgnoreCase(String nomeCidade); 
	
//	count
	public int countCidadesByNomeContainingIgnoreCase(String nomeCidade); 
	
//	Link com a explicação de como utilizar consultas que retornem resultados diferente 
//	dos objetos do banco de dados, utilizando para isso intefaces ou uma classe de modelo "Model" customizada 
//	para o retorno necessário
//	https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions

}
