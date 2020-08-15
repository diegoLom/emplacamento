package com.losolved.emplacamento.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.Municipio;
import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.integration.repository.EmplacamentoRepository;
import com.losolved.emplacamento.integration.repository.ParametroRepository;
import com.losolved.emplacamento.services.impl.EmplacamentoServiceImpl;
import com.losolved.emplacamento.services.impl.MunicipioServiceImpl;
import com.losolved.emplacamento.services.impl.ParametroServiceImpl;


@RestController("parametro") 
@RequestMapping("/parametro")
public class ParametroController extends BaseController<Parametro, Integer>  {
	
	
	@Autowired
	public ParametroController(ParametroServiceImpl baseService,
			ParametroRepository repository) {
		
		
		setBaseService(baseService);
		getBaseService().setRepository(repository);
		
	
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(
			  value = "/valorBase/{emp_cd}"
			  
			)
	public BigDecimal pegarValorBase(@PathVariable("emp_cd") String emp_cd) throws IOException {
		
		
		return ((ParametroServiceImpl) getBaseService()).pegarValorBase(emp_cd);
	}
	
	

}