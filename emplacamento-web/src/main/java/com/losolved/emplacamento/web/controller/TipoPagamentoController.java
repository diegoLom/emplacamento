package com.losolved.emplacamento.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.emplacamento.domain.TipoPagamento;
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.integration.repository.TipoPagamentoRepository;
import com.losolved.emplacamento.services.impl.TaxasServiceImpl;
import com.losolved.emplacamento.services.impl.TipoPagamentoServiceImpl;


@RestController 
@RequestMapping("/tipoPagamento")
public class TipoPagamentoController  extends BaseController<TipoPagamento, Integer>{
	
	
	
	@Autowired
	public TipoPagamentoController(TipoPagamentoServiceImpl baseService,
			TipoPagamentoRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
}
