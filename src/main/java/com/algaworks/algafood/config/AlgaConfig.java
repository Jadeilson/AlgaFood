package com.algaworks.algafood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.services.AtivadorClienteService;
import com.algaworks.algafood.notificacao.NotificadorEmail;

//@Confsiguration 
//Ao comentar está anotação, a classe passa a ser ignorada quando da instânciação para injeção de dependencias
public class AlgaConfig {
	
	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificadorEmail = new NotificadorEmail(true, "SMTP@algaworks.com.br");
		return notificadorEmail;
	}
	
	@Bean
	public AtivadorClienteService ativadorClienteService() {
		AtivadorClienteService ativadorClienteService = new AtivadorClienteService(notificadorEmail());
		return ativadorClienteService;
	}

}
