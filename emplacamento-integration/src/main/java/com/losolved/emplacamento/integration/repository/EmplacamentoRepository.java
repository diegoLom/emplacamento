package com.losolved.emplacamento.integration.repository;

import com.losolved.emplacamento.domain.Emplacamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.List;


@Repository
public interface EmplacamentoRepository extends CrudRepository<Emplacamento, Long> {
	
	
  public Emplacamento findByNumPedido(String numpedido);

}
