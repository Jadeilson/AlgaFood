package com.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.di.services.AtivadorClienteService;

@Controller
public class MeuPrimeiroControle {
	
	private AtivadorClienteService ativaClienteService;
	
	public MeuPrimeiroControle(AtivadorClienteService ativaClienteService) {
		this.ativaClienteService = ativaClienteService;
		System.out.println("MeuPrimeiroControle :: Injeção de dependencias :: " + ativaClienteService);
	}
	
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

}
