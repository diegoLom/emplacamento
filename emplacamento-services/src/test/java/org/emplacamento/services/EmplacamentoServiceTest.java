package org.emplacamento.services;

import static org.mockito.Mockito.when;

import org.emplacamento.commons.exceptions.NotFoundEmplacamentoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmplacamentoServiceTest {
	
	@Mock
	private EmplacamentoService emplacamentoService;
	
	private final static  Long ESDRUXULO_PEDIDO = Long.MAX_VALUE;

	
	@Test
	public void emptyPedido() {
		
		when(emplacamentoService.findByNumPedido(ESDRUXULO_PEDIDO+"")).thenThrow(NotFoundEmplacamentoException.class);
		
	}

}
