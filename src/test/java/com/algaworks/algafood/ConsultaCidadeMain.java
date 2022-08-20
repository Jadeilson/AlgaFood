package com.algaworks.algafood;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ApplicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = ApplicationContext.getBean(CidadeRepository.class);
		List<Cidade> cidades = cidadeRepository.listar();
		
		for (Cidade cidade : cidades) {
			System.out.printf("A cidade %s possui o código => %d e é do estado => %s\n", 
					cidade.getNome(), cidade.getId(), cidade.getEstado().getNome());
		}
 }
	
	

}
