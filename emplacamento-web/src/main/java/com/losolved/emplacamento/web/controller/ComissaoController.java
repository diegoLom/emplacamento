package com.losolved.emplacamento.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.emplacamento.domain.Comissao;
import com.losolved.emplacamento.integration.repository.ComissaoRepository;
import com.losolved.emplacamento.services.impl.ComissaoServiceImpl;


@RestController 
@RequestMapping("/comissao")
public class ComissaoController extends BaseController<Comissao, Integer>  {
	
	
	@Autowired
	public ComissaoController(ComissaoServiceImpl baseService,
			ComissaoRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
	

	
	

}