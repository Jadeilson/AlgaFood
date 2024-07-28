package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "produto")
public class Produto {
	
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "produtoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "produtoNome", nullable = false)
	private String nome;
	
	@Column(name = "produtoDescricao",  nullable = false)
	private String Descricao;
	
	@Column(name = "produtoPreco", nullable = false)
	private BigDecimal preco;
	
	@Column(name = "produtoAtivo", nullable = false)
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id", nullable = false)
	private Restaurante restaurante;

}
