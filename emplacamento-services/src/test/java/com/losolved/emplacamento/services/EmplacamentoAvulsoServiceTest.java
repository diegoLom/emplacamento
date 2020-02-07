package com.losolved.emplacamento.services;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.losolved.emplacamento.commons.exceptions.BiggestCortesiaException;
import com.losolved.emplacamento.commons.exceptions.EmplacamentoAtLeastOne;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;

import static junit.framework.Assert.*;
import com.losolved.emplacamento.services.impl.*;

@RunWith(MockitoJUnitRunner.class)
public class EmplacamentoAvulsoServiceTest  extends BaseServiceTest {
	
	

	
	
	 private EmplacamentoAvulso emplacamento;
	
	
	@Test
	public void prepareEmplacamento() {
		
		EmplacamentoAvulsoServiceImpl mockServiceEmplacamento = mock(EmplacamentoAvulsoServiceImpl.class);
		
		emplacamento = getEmplacamentoCortesia();
		when(mockServiceEmplacamento.salvar(emplacamento)).thenThrow( new BiggestCortesiaException(""));
		
		
	
		
	}


}
