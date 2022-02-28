package com.algaworks.algafood.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;

@Qualifier("URGENTE")
@Component
public class NotificadorSMS implements Notificador {
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("O cliente %s foi notificado ataravés do telefone %s.\n", cliente.getNome(), cliente.getTelefone());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	

}
