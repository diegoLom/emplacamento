package com.losolved.emplacamento.services;

import com.losolved.emplacamento.domain.Emplacamento;
import org.springframework.stereotype.Service;

@Service
public interface EmplacamentoService {
	
	
	  public Emplacamento findByNumPedido(String numpedido);

}
