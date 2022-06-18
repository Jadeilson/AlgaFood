package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("PROD")
@TipoUrgenciaNotificacao(TipoNotificacao.NORMAL)
@Component
public class NotificadorEmail implements Notificador {
	
//Exemplo de como recuperar propriedades do arquivo "Apllication.properties"

	@Autowired
	NotificadorProperties notificadorProperties;	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.println("Servidor: " + notificadorProperties.getHost());
		System.out.println("Porta: " + notificadorProperties.getPorta());
		
		System.out.printf("O cliente %s foi notificado ataravés do email %s.\n", cliente.getNome(), cliente.getEmail());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	

}
