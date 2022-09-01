package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName = "estados")
@Data
public class EstadoXmlWrapper {

	@NonNull
	@JsonProperty(value = "estado")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Estado> estados;
}
