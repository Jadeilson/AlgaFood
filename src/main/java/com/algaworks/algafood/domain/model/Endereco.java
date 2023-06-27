package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Embeddable
public class Endereco {

	@Column(name = "endereco_logradouro")	
	private String logradouro;
	
	@Column(name = "endereco_numero")
	private String numero;
	
	@Column(name = "endereco_complemento")
	private String complemento;
	
	@Column(name = "endereco_bairro")
	private String bairro;
	
	@Column(name = "endereco_cep")
	private String cep;
	
	@JsonIgnoreProperties("hibernateLazyInitializer")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_cidade")
	private Cidade cidade;
}
