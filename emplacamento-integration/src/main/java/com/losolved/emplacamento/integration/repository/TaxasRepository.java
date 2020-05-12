package com.losolved.emplacamento.integration.repository;


import com.losolved.emplacamento.domain.Taxa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaxasRepository extends CrudRepository<Taxa, Integer> {
	
	
 
}
