package com.losolved.emplacamento.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.integration.repository.EmplacamentoAvulsoRepository;
import com.losolved.emplacamento.integration.repository.EmplacamentoRepository;
import com.losolved.emplacamento.services.BaseService;
import com.losolved.emplacamento.services.EmplacamentoAvulsoService;
import com.losolved.emplacamento.services.impl.EmplacamentoAvulsoServiceImpl;


@RestController("/emplacamento/avulso")
public class EmplacamentoAvulsoController extends BaseController<EmplacamentoAvulso, Integer>  {
	
	
	@Autowired
	private EmplacamentoAvulsoServiceImpl baseService;
	
	@Autowired
	private EmplacamentoAvulsoRepository repository;
	
	
	
	
	public EmplacamentoAvulsoController(BaseService<EmplacamentoAvulso, Integer> baseService,
			EmplacamentoAvulsoRepository repository) {
		
		
		setBaseService(this.baseService);
		getBaseService().setRepository(repository);
		
	
	}
	
	@GetMapping(
			  value = "/get-file",
			  produces = MediaType.APPLICATION_PDF_VALUE
			)
	public byte[] generatePdf() {
		
		
		return generatePdf();
	}
	
	
	

}