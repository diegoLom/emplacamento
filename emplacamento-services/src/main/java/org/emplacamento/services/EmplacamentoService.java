package org.emplacamento.services;

import org.emplacamento.domain.Emplacamento;
import org.springframework.stereotype.Service;

@Service
public interface EmplacamentoService extends BaseService<Emplacamento, Long>{
	
	
	  public Emplacamento findByNumPedido(String numpedido);

}
