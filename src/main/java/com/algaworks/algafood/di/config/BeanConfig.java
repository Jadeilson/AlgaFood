package com.algaworks.algafood.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.services.AtivadorClienteService;

@Configuration
public class BeanConfig {
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public AtivadorClienteService ativadorClienteService() {
		return new AtivadorClienteService();
	}
	

}
