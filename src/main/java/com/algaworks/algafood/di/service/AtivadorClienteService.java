package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.event.ClienteAtivadoEvent;

@Component
public class AtivadorClienteService {
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	public void ativarCliente(Cliente cliente) {
		cliente.ativar(true);
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}

}
