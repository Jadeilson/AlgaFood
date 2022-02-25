package com.algaworks.algafood.di.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.notificacao.Notificador;

@Component
public class AtivadorClienteService {
	
	@Autowired
	private Notificador notificador;
	
	public void ativarCliente(Cliente cliente) {
		
		cliente.ativar(true);
		this.notificador.notificar(cliente, "O Cliente " + cliente.getNome() + " foi ativado com sucesso.");
	}

}
