package com.algaworks.algafood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {
	
	@Bean
	public NotificadorEmail notificadorEmail () {
		NotificadorEmail notificadorEmail = new NotificadorEmail(true, "SMTP.algaworks.com.br");
		return notificadorEmail;
	}

}
