package com.losolved.emplacamento.services.impl;



import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.domain.Taxa;
import com.losolved.emplacamento.integration.repository.ParametroRepository;
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.services.BaseService;




@Service
public class TaxasServiceImpl extends BaseService<Taxa, Integer> {
	
	
	@Autowired
	ParametroRepository paramRepository;
	
	@Autowired
	TaxasRepository taxaRepository; 
	
	public Set<Taxa> getTaxaByEmp(String emp_cd) {
		// TODO Auto-generated method stub
		Optional<Parametro> oParametro = paramRepository.findPorEmpresa(emp_cd);
		
		
		Set<Taxa> taxas = new HashSet<>(); 
		
		if(oParametro.isPresent()) {
			
			Parametro parametro = oParametro.get();
			taxas = taxaRepository.findByParametro(parametro);
			
			return taxas;
		}
		
		return taxas;
	}
		 


	   
	   
	  

}




