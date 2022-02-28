package com.algaworks.algafood.di.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.notificacao.Notificador;
import com.algaworks.algafood.notificacao.TipoNotificacao;
import com.algaworks.algafood.notificacao.TipoUrgenciaNotificacao;

@Component
public class AtivadorClienteService {
	
	@TipoUrgenciaNotificacao(TipoNotificacao.NORMAL)
	@Autowired
	private Notificador notificador;
	
	public void ativarCliente(Cliente cliente) {
		
		cliente.ativar(true);
		
		if(this.notificador != null) {
			notificador.notificar(cliente, "O Cliente " + cliente.getNome() + " foi ativado com sucesso.");
		} else{
			System.out.println("Não possui Notificador ativo, mas cliente foi ativado!");
		}
		
	}

}
