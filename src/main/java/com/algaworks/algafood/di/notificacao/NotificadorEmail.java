package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("PROD")
@TipoUrgenciaNotificacao(TipoNotificacao.NORMAL)
@Component
public class NotificadorEmail implements Notificador {
	
//Exemplo de como recuperar propriedades do arquivo "Apllication.properties"
	@Value("${notificador.email.host}")
	private String host;
	
	@Value("${notificador.email.porta}")
	private Integer porta;
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.println("Servidor: " + host);
		System.out.println("Porta: " + porta);
		
		System.out.printf("O cliente %s foi notificado ataravés do email %s.\n", cliente.getNome(), cliente.getEmail());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	

}
