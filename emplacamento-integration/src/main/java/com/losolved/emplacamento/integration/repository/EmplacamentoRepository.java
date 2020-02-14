package com.losolved.emplacamento.integration.repository;

import com.losolved.emplacamento.domain.Emplacamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmplacamentoRepository extends CrudRepository<Emplacamento, Long> {
	
	
 
}
