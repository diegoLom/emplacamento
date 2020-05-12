package com.losolved.emplacamento.integration.repository;


import com.losolved.emplacamento.domain.TipoPagamento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoPagamentoRepository extends CrudRepository<TipoPagamento, Integer> {
	
	
 
}
