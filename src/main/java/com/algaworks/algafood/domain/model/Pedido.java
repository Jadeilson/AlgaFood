package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(nullable = false)
	private BigDecimal subtotal;
	
	@Column(nullable = false)
	private BigDecimal taxaFrete;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime dataCriacao;
	
	@Column(nullable = true)
	private LocalDateTime dataConfirmacao;
	
	@Column(nullable = true)
	private LocalDateTime dataCancelamento;
	
	@Column(nullable = true)
	private LocalDateTime dataEntrega;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	
	@Embedded
	private Endereco enderecoEntrega;
	
	@ManyToOne
	@JoinColumn(name = "usuario_cliente_id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id", nullable = false)
	private Restaurante restaurante;
	
	@ManyToOne
	@JoinColumn(name = "formaPagamentoId", nullable = false)
	private FormaPagamento formaPagamento;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedido = new ArrayList<>();	

	
}
