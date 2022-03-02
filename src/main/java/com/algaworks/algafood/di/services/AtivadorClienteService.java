package com.algaworks.algafood.di.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.notificacao.Notificador;
import com.algaworks.algafood.notificacao.TipoNotificacao;
import com.algaworks.algafood.notificacao.TipoUrgenciaNotificacao;

//@Component
public class AtivadorClienteService {
	
	@TipoUrgenciaNotificacao(TipoNotificacao.NORMAL)
	@Autowired
	private Notificador notificador;
	
//	@PostConstruct
	public void init() {
		System.out.println("INIT METHOD EXECUTED WITH THE OBJECT ->>" + notificador);
	}
	
//	Caso não seja utilizada a as anotações de "@PostConstruct" e "@PreDestroy", a definição do método
//	pode ser realizada atrvés de uma classe de configuração, como por exemplo a clase BeanConfig que foi
//	criada no pacote "config"	
//	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY METHOD EXECUTED");
	}
	
	public void ativarCliente(Cliente cliente) {
		cliente.ativar(true);
		notificador.notificar(cliente, "O Cliente " + cliente.getNome() + " foi ativado com sucesso.");
	}

}
