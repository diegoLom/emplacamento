package com.losolved.emplacamento.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.Uf;
import com.losolved.emplacamento.integration.repository.EmplacamentoAvulsoRepository;
import com.losolved.emplacamento.integration.repository.UfRepository;
import com.losolved.emplacamento.services.impl.EmplacamentoAvulsoServiceImpl;
import com.losolved.emplacamento.services.impl.UfServiceImpl;


@RestController 
@RequestMapping("/uf")
public class UfController extends BaseController<Uf, Byte>  {
	
	
	@Autowired
	public UfController(UfServiceImpl baseService,
			UfRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
	
	
	
	
	

}