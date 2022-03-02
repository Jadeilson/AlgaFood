package com.algaworks.algafood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.di.service.AtivadorClienteService;

@Controller
public class MeuPrimeiroControle {
	
//	Existem três possiveis pontos de injeção de dependencias
//		1 - Através do atributo com a anotação @Autowired
//		2 - Através da declaração de um construtor que receba um component Spring como 
//			parametro. Neste caso, a anoção @Autowired no construtor é opcional por conter apenas um construtor.
	
//			Na existência da declaração de mais de um contrutor, se faz necessário (Obrigatório) a anotação @Autowired 
//			para o construtor que o Spring utilizara para fazer a injeção de dependência.
//		3 - Através dos metodos "set" com a anotação @Autowired
//	Vide os exemplos abaixo	


//	Exemplo 1
	@Autowired
	private AtivadorClienteService ativaClienteService;
	
//	Exemplo 2
//	@Autowired
//	public MeuPrimeiroControle(AtivadorClienteService ativaClienteService) {
//		this.ativaClienteService = ativaClienteService;
//	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String Hello() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("José");
		cliente.setEmail("jose@jose.com.br");
		cliente.setTelefone("9999999");
		
		ativaClienteService.ativarCliente(cliente);
		
		return "O cliente \"" + cliente.getNome() + "\" foi ativado e notificado com sucesso";
	}

//	Exemplo 3
//	@Autowired
//	public void setAtivaClienteService(AtivadorClienteService ativaClienteService) {
//		this.ativaClienteService = ativaClienteService;
//	}
	
}
