package com.losolved.emplacamento.services;

import java.math.BigDecimal;

import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.domain.TipoPagamento;

public class BaseServiceTest  {
	
	
	public static EmplacamentoAvulso getEmplacamentoCortesia() {
		
		EmplacamentoAvulso emplA = new EmplacamentoAvulso();
		Emplacamento empl = new Emplacamento();
		FormaPagamento forma = new FormaPagamento();
		
		TipoPagamento tpPagamento = new TipoPagamento();
		tpPagamento.setNome("CORTESIA");
		
		forma.setValor(BigDecimal.valueOf(1000_000_000));
		forma.setTipoPagamento(tpPagamento);
		empl.setPagamentos(forma);
		
		emplA.setEmplacamento(empl);
		
		
		return emplA;
	}
	
	
	public static EmplacamentoAvulso getSemFormaPagamentoIncidente() {
		EmplacamentoAvulso emplA = new EmplacamentoAvulso();
		Emplacamento empl = new Emplacamento();
		
		emplA.setEmplacamento(empl);
		
		
		return emplA;
		
		
	}
	
	
	
	

}
