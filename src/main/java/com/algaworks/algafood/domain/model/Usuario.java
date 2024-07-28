package com.algaworks.algafood.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "usuario")
public class Usuario {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuarioId", nullable = false)
	private Long id;
	
	@Column(name = "usuarioNome", nullable= false)
	private String nome;
	
	@Column(name = "usuarioEmail", nullable = false)
	private String email;
	
	@Column(name = "usuarioSenha", nullable = false)
	private String senha;
	
	@CreationTimestamp
	@Column(name = "usuarioDataCadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@ManyToMany
	@JoinTable(name = "usuarioGrupo",
				joinColumns = @JoinColumn(name = "usuarioId"),
				inverseJoinColumns = @JoinColumn(name = "grupoId"))
	private List<Grupo> grupos = new ArrayList<>();
}
