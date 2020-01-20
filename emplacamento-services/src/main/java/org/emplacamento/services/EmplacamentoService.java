package org.emplacamento.services;

import org.emplacamento.domain.Emplacamento;
import org.springframework.stereotype.Service;

@Service
public interface EmplacamentoService {
	
	
	  public Emplacamento findByNumPedido(String numpedido);

}
