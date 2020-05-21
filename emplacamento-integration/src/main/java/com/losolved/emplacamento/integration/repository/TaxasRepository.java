package com.losolved.emplacamento.integration.repository;


import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.domain.Taxa;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaxasRepository extends CrudRepository<Taxa, Integer> {
	
	
	
	 @Query(value = "select * from taxa  where taxa.id in ( select taxas_id from emplacamento_taxas where emplacamento_taxas.emplacamentos_id = ?1  ) " 
	 		, nativeQuery = true)
	  Set<Taxa> findByEmplacamento(Integer emplacamentoId);
	
 
}
