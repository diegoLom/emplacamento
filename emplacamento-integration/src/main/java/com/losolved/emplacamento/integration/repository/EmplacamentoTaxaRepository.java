package com.losolved.emplacamento.integration.repository;

import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoTaxa;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmplacamentoTaxaRepository extends CrudRepository<EmplacamentoTaxa, Long> {
	
	
	Set<EmplacamentoTaxa> findByEmplacamento(Emplacamento emplacamento);
	
 
}
