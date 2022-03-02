package com.algaworks.algafood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.event.ClienteAtivadoEvent;
import com.algaworks.algafood.notificacao.Notificador;
import com.algaworks.algafood.notificacao.TipoNotificacao;
import com.algaworks.algafood.notificacao.TipoUrgenciaNotificacao;

@Component
public class NotificacaoService {
	
	@TipoUrgenciaNotificacao(TipoNotificacao.NORMAL)
	@Autowired
	Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("LOCAL 1");
		notificador.notificar(event.getCliente(), "O cliente foi ativado!");
	}
	
	@EventListener
	public void clienteAtivadoTesteListener2(ClienteAtivadoEvent event){
		System.out.println("LOCAL 2");
		System.out.println("Teste do segundo método listener para o evento ClienteAtivadoEvent");
	}
}
