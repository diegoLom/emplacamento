package com.losolved.emplacamento.services;

import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.losolved.emplacamento.domain.EmplacamentoAvulso;

import static junit.framework.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmplacamentoAvulsoServiceTest {
	
	
	@Mock
	private EmplacamentoAvulsoService emplacamentoServiceAvulso;
	
	
	 private EmplacamentoAvulso emplacamento;
	
	
	@Teste
	public void prepareEmplacamento() {
		
		
		
		when(emplacamentoServiceAvulso.salvar(emplacamento)).then
	}


}
