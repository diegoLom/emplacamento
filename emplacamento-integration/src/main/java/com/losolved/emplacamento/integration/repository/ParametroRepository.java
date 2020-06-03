package com.losolved.emplacamento.integration.repository;


import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.domain.Taxa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParametroRepository extends CrudRepository<Parametro, Integer> {
	
	
	
	@Query("select p from Parametro p where p.emp_cd = ?1")
	Optional<Parametro> findPorEmpresa(String emp_cd);
	
	
	
 
}
