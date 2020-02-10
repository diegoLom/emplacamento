package com.losolved.emplacamento.services.impl;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import com.losolved.emplacamento.commons.exceptions.BiggestCortesiaException;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.integration.repository.EmplacamentoAvulsoRepository;
import com.losolved.emplacamento.services.BaseService;
import com.losolved.emplacamento.services.EmplacamentoAvulsoService;
import com.losolved.emplacamento.services.EmplacamentoService;

public class EmplacamentoAvulsoServiceImpl extends BaseService<EmplacamentoAvulso, Integer, EmplacamentoAvulsoRepository>
		implements EmplacamentoAvulsoService {

	public EmplacamentoAvulso salvar(EmplacamentoAvulso toSave) {
			
		if(!validaCortesia(toSave))
			throw new BiggestCortesiaException("");
		
		
		
		return createT(toSave);
	}
	
	
	public Boolean validaCortesia(EmplacamentoAvulso toSave) {
		
		Set<FormaPagamento> pagamentos =  toSave.getEmplacamento().getPagamentos();
		
		Optional<FormaPagamento> oPagamento = pagamentos.stream().filter(s -> 
			s.getTipoPagamento().getNome().equalsIgnoreCase("CORTESIA")).findFirst();
		
		BigDecimal valorCortesia =  oPagamento.isPresent() ? oPagamento.get().getValor() : new BigDecimal(0);
		
		if(valorCortesia.compareTo(toSave.getEmplacamento().getValorEmplacamento()) > 0 ) {
			return false;
		}
		
		return true ;
	}

}




