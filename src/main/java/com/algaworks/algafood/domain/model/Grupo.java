package com.algaworks.algafood.domain.model;

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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "grupo")
public class Grupo {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grupoId", nullable = false)
	private Long id;
	
	@Column(name = "grupoNome", nullable = false)
	private String nome;

	@ManyToMany
	@JoinTable(name = "grupoPermissao",
				joinColumns = @JoinColumn(name = "grupoId"),
				inverseJoinColumns = @JoinColumn(name = "permissaoId"))
	private List<Permissao> permissoes = new ArrayList<>();
	
}
