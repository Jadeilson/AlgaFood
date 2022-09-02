package com.algaworks.algafood.domain.exception;

public class EntidadeNaoExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public EntidadeNaoExistenteException(String mensagem) {
		super(mensagem);
	}
	
}
