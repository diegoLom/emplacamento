package com.losolved.emplacamento.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class EmplacamentoAtLeastOne extends NullPointerException {
 
	
	private static final long serialVersionUID = 1L;

	public EmplacamentoAtLeastOne() {
		super(" É esperado ao menos uma forma \n de pagamento e uma taxa ");
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
