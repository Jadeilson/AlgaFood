package com.algaworks.algafood.di.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.notificacao.Notificador;

@Component
public class AtivadorClienteService {
	
	@Autowired(required = false)
	private Notificador notificador;
	
	public void ativarCliente(Cliente cliente) {
		
		cliente.ativar(true);
		
		if(this.notificador != null) {
			notificador.notificar(cliente, "O Cliente " + cliente.getNome() + " foi ativado com sucesso.");
		} else{
			System.out.println("Não possui Notificador ativo, mas cliente foi ativado!");
		}
		
	}

}
