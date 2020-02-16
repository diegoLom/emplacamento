package com.losolved.emplacamento.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.losolved.emplacamento.domain.Municipio;
import com.losolved.emplacamento.domain.Uf;

public interface MunicipioRepository  extends CrudRepository<Municipio, Integer> {

	
	List<Municipio> findByUf(Uf uf);;
	
}
