package com.losolved.emplacamento.integration.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.domain.TipoPagamento;

@Repository
public interface FormaPagamentoRepository extends CrudRepository<FormaPagamento, Integer> {
	
	interface OnlyForma {

		  BigDecimal getValor();
		  TipoPagamento getTipoPagamento();
	}
	
	//Set<FormaPagamento> findByEmplacamento(Emplacamento empl);
	
	Set<OnlyForma> findByEmplacamento(Emplacamento empl);
}
