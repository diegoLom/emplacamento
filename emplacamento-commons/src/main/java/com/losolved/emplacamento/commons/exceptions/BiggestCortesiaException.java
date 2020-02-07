package com.losolved.emplacamento.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class BiggestCortesiaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public BiggestCortesiaException(String message) {
		super(" Erro cortesia maior que o valor do emplacamento ");
		// TODO Auto-generated constructor stub
	}
	
	

}
