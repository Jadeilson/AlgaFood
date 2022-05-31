package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("DEV")
@TipoUrgenciaNotificacao(TipoNotificacao.NORMAL)
@Component
public class NotificadorEmailMock implements Notificador {
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("MOCK: A notificação seria: O cliente %s foi notificado ataravés do email %s.\n", cliente.getNome(), cliente.getEmail());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	

}
