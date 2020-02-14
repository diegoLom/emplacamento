package com.losolved.emplacamento.services.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.losolved.emplacamento.commons.exceptions.BiggestCortesiaException;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.integration.repository.EmplacamentoAvulsoRepository;
import com.losolved.emplacamento.services.BaseService;
import com.losolved.emplacamento.services.EmplacamentoAvulsoService;
import com.losolved.emplacamento.services.EmplacamentoService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


@Service
public class EmplacamentoAvulsoServiceImpl extends BaseService<EmplacamentoAvulso, Integer>
		implements EmplacamentoAvulsoService {

	public EmplacamentoAvulso salvar(EmplacamentoAvulso toSave) {
			
		if(!validaCortesia(toSave))
			throw new BiggestCortesiaException("");
		
		
		
		return toSave;
	}
	
	
	public Boolean validaCortesia(EmplacamentoAvulso toSave) {
		
		Set<FormaPagamento> pagamentos =  toSave.getEmplacamento().getPagamentos();
		
		Optional<FormaPagamento> oPagamento = pagamentos.stream().filter(s -> 
			s.getTipoPagamento().getNome().equalsIgnoreCase("CORTESIA")).findFirst();
		
		BigDecimal valorCortesia =  oPagamento.isPresent() ? oPagamento.get().getValor() : new BigDecimal(0);
		
		if(valorCortesia.compareTo(toSave.getEmplacamento().getValorEmplacamento()) > 0 ) {
			return false;
		}
		
		return true ;
	}
	
	
	   public byte[] generateReport() throws IOException {
			 
	       byte[] reportData = null;
	       
	       try {
	    	   Map parameters = new HashMap();
	           JasperPrint jasperPrint = 
	        		   JasperFillManager.fillReport( this.getClass().getClassLoader().getResource("orcamento.jasper").getPath() , parameters, new JREmptyDataSource());
           reportData = JasperExportManager.exportReportToPdf(jasperPrint);
	       } catch (JRException e) {
	           e.printStackTrace();
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       
	    
	     
	 
	       return reportData;
	   }

	   
	   
	  

}




