package com.algaworks.algafood.domain.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName(value = "cozinha") // Anotação muda Nome da tag raiz do XML
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {	
	
//	@JsonIgnore -- Anotação remove atributo na representação json/xml
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@JsonProperty(value = "nomeCozinha") -- Anotação muda Nome do atributo na representação json/xml
	@Column(name = "nomeCozinha", nullable = false)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cozinha")
	private List<Restaurante> restaurantes;
	
	
}
