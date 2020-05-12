package com.losolved.emplacamento.integration.repository;

import com.losolved.emplacamento.domain.Comissao;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComissaoRepository extends CrudRepository<Comissao, Integer> {
	
	
 
}
