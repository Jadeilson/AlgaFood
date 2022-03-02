package com.algaworks.algafood.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.event.ClienteAtivadoEvent;

@Component
public class EmiteNotaFiscalService {
	
	@EventListener
	public void EmiteNotaFicalClienteListener(ClienteAtivadoEvent event) {
		System.out.println("LOCAL 3");
		System.out.println("Nota fical emitida para o cliente " + event.getCliente().getNome());
	}

}
