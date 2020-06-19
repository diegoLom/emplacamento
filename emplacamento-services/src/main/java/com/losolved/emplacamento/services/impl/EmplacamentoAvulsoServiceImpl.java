package com.losolved.emplacamento.services.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.commons.exceptions.BiggestCortesiaException;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.EmplacamentoTaxa;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.integration.repository.EmplacamentoTaxaRepository;
import com.losolved.emplacamento.integration.repository.FormaPagamentoRepository;
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.integration.repository.FormaPagamentoRepository.OnlyForma;
import com.losolved.emplacamento.services.BaseService;
import com.losolved.emplacamento.services.EmplacamentoAvulsoService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class EmplacamentoAvulsoServiceImpl extends BaseService<EmplacamentoAvulso, Integer>
		implements EmplacamentoAvulsoService {
	
	
	@Autowired
	EmplacamentoTaxaRepository eRepository;

	@Autowired
	TaxasRepository tRepository;
	
	@Autowired
	FormaPagamentoRepository fRepository;


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
	
	
	
	@Override
	public Optional<EmplacamentoAvulso> pegar(Integer i) {
		// TODO Auto-generated method stub
		Optional<EmplacamentoAvulso> oEmplaca =  super.pegar(i);
		
		if(oEmplaca.isPresent()) {
			EmplacamentoAvulso emplacamento = oEmplaca.get();
			
			Set<EmplacamentoTaxa> taxas =  eRepository.findByEmplacamento(emplacamento.getEmplacamento());
			
			
			emplacamento.getEmplacamento().setTaxas(taxas);
	                 //e.setTaxas();	
	                   
	      Set<OnlyForma> pagamentos = fRepository.findByEmplacamento(emplacamento.getEmplacamento());
	      Set<FormaPagamento> formas = new HashSet<FormaPagamento>();
	    //  e.setPagamentos(pagamentos);	
	      pagamentos.forEach(x -> { FormaPagamento fp = new FormaPagamento(); fp.setTipoPagamento(x.getTipoPagamento()); fp.setValor(x.getValor());  formas.add(fp); });
	      
	      emplacamento.getEmplacamento().setPagamentos(formas);
		}
		
		return oEmplaca;
	}
	
	   public byte[] generateReport(Integer id) throws IOException {
			 
			byte[] reportData = null;

			try {
				Map parameters = new HashMap();
				
			 Optional<EmplacamentoAvulso> oEmplacamento = 	this.pegar(id); 
			
				EmplacamentoAvulso emplacamento = oEmplacamento.get(); 
				
				
				parameters.put("dept_venda", "Indiana");
				parameters.put("data_solicitacao", "16/05/2020");
				parameters.put("model_veiculo", emplacamento.getDescritivo());
				parameters.put("munc_veiculo", emplacamento.getMunicipio());
				
				parameters.put("vlr_proposta", new java.text.DecimalFormat("R$ #,##0.00").format( emplacamento.getVlVec()));
				parameters.put("obsv", emplacamento.getObservacoes());
				parameters.put("vlr_total", new java.text.DecimalFormat("R$ #,##0.00").format(emplacamento.getEmplacamento().getValorEmplacamento()));

				
				JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(emplacamento.getEmplacamento().getTaxas());

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							this.getClass().getClassLoader().getResource("orcamento.jasper").getPath(), parameters,
							ds);
				
				reportData = JasperExportManager.exportReportToPdf(jasperPrint);
			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return reportData;
	   }




	   
	   
	  

}




