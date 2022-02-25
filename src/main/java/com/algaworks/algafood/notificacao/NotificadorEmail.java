package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.di.model.Cliente;

//@Componenst
public class NotificadorEmail implements Notificador {
	
	private boolean caixaAlta;
	private String hostServidorSMTP;
	
	public NotificadorEmail(boolean caixaAlta, String hostServidorSMTP) {
		System.out.println("NotificadorEmail :: Instanciação - Construtor");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		mensagem = mensagem.toUpperCase();
		
		System.out.printf("O cliente %s foi notificado ataravés do email %s.\n", cliente.getNome(), cliente.getEmail());
		System.out.printf("Mensagem: %s\n", mensagem);
	}
	
	
	public void setHostServidorSMTP(String hostServidorSMTP) {
		this.hostServidorSMTP = hostServidorSMTP;
	}

}
