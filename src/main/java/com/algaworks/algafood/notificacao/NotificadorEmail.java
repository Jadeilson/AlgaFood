package com.algaworks.algafood.notificacao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;

@Primary
@Component
public class NotificadorEmail implements Notificador {
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("O cliente %s foi notificado ataravés do email %s.\n", cliente.getNome(), cliente.getEmail());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	

}
