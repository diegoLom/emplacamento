package com.losolved.emplacamento.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.integration.repository.EmplacamentoRepository;
import com.losolved.emplacamento.integration.repository.ParametroRepository;
import com.losolved.emplacamento.services.impl.EmplacamentoServiceImpl;
import com.losolved.emplacamento.services.impl.ParametroServiceImpl;


@RestController 
@RequestMapping("/parametro")
public class ParametroController extends BaseController<Parametro, Integer>  {
	
	
	@Autowired
	public ParametroController(ParametroServiceImpl baseService,
			ParametroRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
	

	
	

}