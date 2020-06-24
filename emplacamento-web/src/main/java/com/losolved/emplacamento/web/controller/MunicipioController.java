package com.losolved.emplacamento.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.Municipio;
import com.losolved.emplacamento.domain.Uf;
import com.losolved.emplacamento.integration.repository.EmplacamentoAvulsoRepository;
import com.losolved.emplacamento.integration.repository.MunicipioRepository;
import com.losolved.emplacamento.integration.repository.UfRepository;
import com.losolved.emplacamento.services.impl.EmplacamentoAvulsoServiceImpl;
import com.losolved.emplacamento.services.impl.EmplacamentoServiceImpl;
import com.losolved.emplacamento.services.impl.MunicipioServiceImpl;
import com.losolved.emplacamento.services.impl.UfServiceImpl;


@RestController("municipio") 
@RequestMapping("/municipio")
public class MunicipioController extends BaseController<Municipio, Integer>  {
	
	
	@Autowired
	public MunicipioController(MunicipioServiceImpl baseService,
			MunicipioRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(
			  value = "/byUf/{id}"
			  
			)
	public List<Municipio> generatePdfA(@PathVariable("id") Integer id) throws IOException {
		
		
		return ((MunicipioServiceImpl) getBaseService()).getMunicipioByUf(id) ;
	}
	
	
	

}