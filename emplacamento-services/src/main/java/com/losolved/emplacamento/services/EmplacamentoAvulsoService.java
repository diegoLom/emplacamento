package com.losolved.emplacamento.services;

import java.io.IOException;

import com.losolved.emplacamento.domain.EmplacamentoAvulso;

public interface EmplacamentoAvulsoService {
	
     public EmplacamentoAvulso salvar(EmplacamentoAvulso emplAvulso);
     
     
     public Object generateReport() throws IOException;
     

}
