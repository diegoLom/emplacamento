package com.losolved.emplacamento.integration.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.domain.Taxa;
import com.losolved.emplacamento.domain.TaxaVec;

@Repository
public interface TaxaVecRepository extends CrudRepository<TaxaVec, Integer> {
	
	  Set<TaxaVec> findByTaxa(Taxa taxa);
		

}
