package com.algaworks.algafood.di.services;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.notificacao.Notificador;

//@Component
public class AtivadorClienteService {
	
	private Notificador notificador;
	
	public AtivadorClienteService(Notificador notificador) {
		this.notificador = notificador;
		System.out.println("AtivaClienteService :: Injeção de dependencias :: " + notificador);
	}
	
	public void ativarCliente(Cliente cliente) {
		
		cliente.ativar(true);
		this.notificador.notificar(cliente, "O Cliente " + cliente.getNome() + " foi ativado com sucesso.");
	}

}
