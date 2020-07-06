package com.losolved.emplacamento.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.integration.repository.EmplacamentoRepository;
import com.losolved.emplacamento.services.impl.EmplacamentoServiceImpl;


@RestController("emplacamento") 
@RequestMapping("/emplacamento")
public class EmplacamentoController extends BaseController<Emplacamento, Integer>  {
	
	
	@Autowired
	public EmplacamentoController(EmplacamentoServiceImpl baseService,
			EmplacamentoRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value =" /only")
	public List<Emplacamento> pegarTodos() {
		return   ((EmplacamentoServiceImpl) getBaseService()).getOnlyEmplacamento();
	};

	
	@CrossOrigin(origins = "*")
	@GetMapping(
			  value = "/get-file/{id}",
			  produces = MediaType.APPLICATION_PDF_VALUE
			)
	public byte[] generatePdfA(@PathVariable("id") Integer id) throws IOException {
		
		
		return ((EmplacamentoServiceImpl) getBaseService()).generateReport(id) ;
	}
	
	
	

}