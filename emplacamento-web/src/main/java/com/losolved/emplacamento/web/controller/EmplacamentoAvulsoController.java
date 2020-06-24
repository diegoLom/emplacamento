package com.losolved.emplacamento.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.integration.repository.EmplacamentoAvulsoRepository;

import com.losolved.emplacamento.services.impl.EmplacamentoAvulsoServiceImpl;


@RestController("avulso") 
@RequestMapping("/emplacamento/avulso")
public class EmplacamentoAvulsoController extends BaseController<EmplacamentoAvulso, Integer>  {
	
	
	@Autowired
	public EmplacamentoAvulsoController(EmplacamentoAvulsoServiceImpl baseService,
			EmplacamentoAvulsoRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(
			  value = "/get-file/{id}",
			  produces = MediaType.APPLICATION_PDF_VALUE
			)
	public byte[] generatePdf(@PathVariable("id") Integer id) throws IOException {
		
		
		return ((EmplacamentoAvulsoServiceImpl) getBaseService()).generateReport(id) ;
	}
	
	
	

}