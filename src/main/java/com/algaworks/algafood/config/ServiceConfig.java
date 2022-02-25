package com.algaworks.algafood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.services.AtivadorClienteService;
import com.algaworks.algafood.notificacao.NotificadorEmail;

@Configuration
public class ServiceConfig {
	
	@Bean
	public AtivadorClienteService ativadorClienteService (NotificadorEmail notificadorEmail) {
		AtivadorClienteService ativadorClienteService = new AtivadorClienteService(notificadorEmail);
		return ativadorClienteService;
	}

}
