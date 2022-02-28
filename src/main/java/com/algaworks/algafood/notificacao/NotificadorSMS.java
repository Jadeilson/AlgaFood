package com.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;

@Component
public class NotificadorSMS implements Notificador {
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("O cliente %s foi notificado ataravés do telefone %s.\n", cliente.getTelefone(), cliente.getEmail());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	

}
