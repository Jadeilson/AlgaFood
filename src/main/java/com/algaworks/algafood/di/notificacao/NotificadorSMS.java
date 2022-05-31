package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("PROD")
@TipoUrgenciaNotificacao(TipoNotificacao.URGENTE)
@Component
public class NotificadorSMS implements Notificador {
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("O cliente %s foi notificado ataravés do telefone %s.\n", cliente.getNome(), cliente.getTelefone());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	

}
