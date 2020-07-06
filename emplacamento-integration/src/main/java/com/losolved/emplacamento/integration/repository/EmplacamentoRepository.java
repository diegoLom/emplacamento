package com.losolved.emplacamento.integration.repository;

import com.losolved.emplacamento.domain.Emplacamento;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmplacamentoRepository extends CrudRepository<Emplacamento, Long> {
	
	
	
		@Query("SELECT * FROM emplacamento WHERE form_tp = 1 ")
		List<Emplacamento> findOnlyEmplacamentoProposta();
		
		
	
	
}
