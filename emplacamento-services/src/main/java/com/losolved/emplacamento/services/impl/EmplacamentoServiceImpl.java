package com.losolved.emplacamento.services.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.commons.exceptions.BiggestCortesiaException;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.EmplacamentoTaxa;
import com.losolved.emplacamento.domain.EmplacamentoTaxaKey;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.domain.Taxa;
import com.losolved.emplacamento.integration.repository.EmplacamentoRepository;
import com.losolved.emplacamento.integration.repository.EmplacamentoTaxaRepository;
import com.losolved.emplacamento.integration.repository.FormaPagamentoRepository;
import com.losolved.emplacamento.integration.repository.FormaPagamentoRepository.OnlyForma;
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.services.BaseService;
import com.losolved.emplacamento.services.EmplacamentoAvulsoService;
import com.losolved.emplacamento.services.EmplacamentoService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmplacamentoServiceImpl extends BaseService<Emplacamento, Integer> implements EmplacamentoService {

	@Autowired
	FormaPagamentoRepository fRepository;

	@Autowired
	EmplacamentoTaxaRepository eRepository;

	@Autowired
	TaxasRepository tRepository;
	
	public List<Emplacamento> getOnlyEmplacamento(){
		
		 
		return ((EmplacamentoRepository) this.getRepository()).findOnlyEmplacamentoProposta();
	}

	public Emplacamento salvar(Emplacamento toSave) {

		if (!validaCortesia(toSave))
			throw new BiggestCortesiaException("");

		return toSave;
	}

	@Override
	public Emplacamento createT(Emplacamento t) {
		// TODO Auto-generated method stub
		t = super.createT(t);

//		for(int x = 0; x < t.getPagamentos().size(); x++) {
////			t.getPagamentos().;
////		}
		final Integer id = ((Emplacamento) t).getId();
		t.getPagamentos().forEach(p -> {
			
			if(p.getTipoPagamentoId() != null)
				p.setTipoPagamentoId(p.getTipoPagamentoId());
			
			p.setEmplacamento(new Emplacamento());
			p.getEmplacamento().setId(id);
			fRepository.save(p);
		});

		t.getTaxas().forEach(te -> {
			EmplacamentoTaxaKey taxaKey = new EmplacamentoTaxaKey();
			taxaKey.setEmplcamentoId(id);
			
			if(te.getTaxa_Id() != null) {
				taxaKey.setTaxaId(te.getTaxa_Id());
				te.setTaxaKey(taxaKey);
				te.setValor_final(te.getTaxa().getVl_final());
			}else if(te.getTaxa() != null && te.getTaxa().getId() != null) {
				taxaKey.setTaxaId(te.getTaxa().getId());
				te.setValor_final(te.getValor_final());
			}
			
			te.setTaxaKey(taxaKey);
			te.setEmplacamento(new Emplacamento());
			te.getEmplacamento().setId(id);
			
			eRepository.save(te);
		});

		return t;
	}

	@Override
	public List<Emplacamento> pegar() {
		// TODO Auto-generated method stub
		
		List<Emplacamento> empl = IteratorUtils.toList(getRepository().findAll().iterator());
		
		
		empl.forEach(e -> {  
			System.out.println(e.getId());
		Set<EmplacamentoTaxa> taxas =  eRepository.findByEmplacamento(e);
		
		
		   e.setTaxas(taxas);
                 //e.setTaxas();	
                   
      Set<OnlyForma> pagamentos = fRepository.findByEmplacamento(e);
      Set<FormaPagamento> formas = new HashSet<FormaPagamento>();
    //  e.setPagamentos(pagamentos);	
      pagamentos.forEach(x -> { FormaPagamento fp = new FormaPagamento(); fp.setTipoPagamento(x.getTipoPagamento()); fp.setValor(x.getValor());  formas.add(fp); });
      
      e.setPagamentos(formas);
		});
		
		
		return empl;
	}

	
	
	@Override
	public Optional<Emplacamento> pegar(Integer i) {
		// TODO Auto-generated method stub
		Optional<Emplacamento> oEmplaca =  super.pegar(i);
		
		if(oEmplaca.isPresent()) {
			Emplacamento emplacamento = oEmplaca.get();
			
			Set<EmplacamentoTaxa> taxas =  eRepository.findByEmplacamento(emplacamento);
			
			
			emplacamento.setTaxas(taxas);
	                 //e.setTaxas();	
	                   
	      Set<OnlyForma> pagamentos = fRepository.findByEmplacamento(emplacamento);
	      Set<FormaPagamento> formas = new HashSet<FormaPagamento>();
	    //  e.setPagamentos(pagamentos);	
	      pagamentos.forEach(x -> { FormaPagamento fp = new FormaPagamento(); fp.setTipoPagamento(x.getTipoPagamento()); fp.setValor(x.getValor());  formas.add(fp); });
	      
	      emplacamento.setPagamentos(formas);
		}
		
		return oEmplaca;
	}

	public Boolean validaCortesia(Emplacamento toSave) {

		Set<FormaPagamento> pagamentos = toSave.getPagamentos();

		Optional<FormaPagamento> oPagamento = pagamentos.stream()
				.filter(s -> s.getTipoPagamento().getNome().equalsIgnoreCase("CORTESIA")).findFirst();

		BigDecimal valorCortesia = oPagamento.isPresent() ? oPagamento.get().getValor() : new BigDecimal(0);

		if (valorCortesia.compareTo(toSave.getValorEmplacamento()) > 0) {
			return false;
		}

		return true;
	}

	public byte[] generateReport(Integer id) throws IOException {

		byte[] reportData = null;

		try {
			Map parameters = new HashMap();
			
		 Optional<Emplacamento> oEmplacamento = 	this.pegar(id); 
		
			Emplacamento emplacamento = oEmplacamento.get(); 
			
			
			parameters.put("dept_venda", "Indiana");
			parameters.put("data_solicitacao", "16/05/2020");
			parameters.put("model_veiculo", emplacamento.getModelo_veiculo());
			parameters.put("munc_veiculo", "Salvador");
			
			parameters.put("vlr_proposta", new java.text.DecimalFormat("R$ #,##0.00").format( emplacamento.getValor_nf()));
			parameters.put("obsv", emplacamento.getObservacao());
			parameters.put("vlr_total", new java.text.DecimalFormat("R$ #,##0.00").format(emplacamento.getValorEmplacamento()));
			
			
			parameters.put("hasCortesia", false);

			
			System.out.println(emplacamento.getValorEmplacamento());
		//	parameters.put("vlr_proposta", emplacamento.getValor_proposta().toString());
			
//			parameters.put("obsv", emplacamento.getValorEmplacamento().toString());
//
			
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(emplacamento.getTaxas());

				JasperPrint jasperPrint = JasperFillManager.fillReport(
						"/opt/webapps/emplacamento/orcamento.jasper", parameters,
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
