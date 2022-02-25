package com.algaworks.algafood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.di.services.AtivadorClienteService;

@Controller
public class MeuPrimeiroControle {
	
//	Existem três possiveis pontos de injeção de dependencias
//		1 - Através do atributo com a anotação @Autowired
//		2 - Através do construtor com a anotação @Autowired e quando existir mais de uma declaração de construtor, então
//			a anotação irá especificar qual construtor o Spring utilizara para fazer a injeção de dependência.
	
//			Na existência de um único construtor, podse ser utilizada a anotração @Autowires ou também pode ser 
//			gerada a injeção através do recebimento de um objeto @Component como parâmetro do construtor
//		3 - Através dos metodos "set" com a anotação @Autowired
//	Vide os exeplos abaixo	


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
		return "Hello Mundo!";
	}

//	Exemplo 3
//	@Autowired
//	public void setAtivaClienteService(AtivadorClienteService ativaClienteService) {
//		this.ativaClienteService = ativaClienteService;
//	}
	
}
