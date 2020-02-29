package com.losolved.emplacamento.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.emplacamento.domain.Municipio;
import com.losolved.emplacamento.domain.Uf;


@Repository
public interface MunicipioRepository  extends CrudRepository<Municipio, Integer> {

	
	List<Municipio> findByUf(Uf uf);;
	
}
