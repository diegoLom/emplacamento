package com.losolved.emplacamento.services.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.text.MaskFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.commons.exceptions.BiggestCortesiaException;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoAvulso;
import com.losolved.emplacamento.domain.EmplacamentoTaxa;
import com.losolved.emplacamento.domain.EmplacamentoTaxaKey;
import com.losolved.emplacamento.domain.FormaPagamento;
import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.integration.repository.EmplacamentoTaxaRepository;
import com.losolved.emplacamento.integration.repository.FormaPagamentoRepository;
import com.losolved.emplacamento.integration.repository.ParametroRepository;
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
	ParametroRepository pRepository;

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
		
		Optional<FormaPagamento> oPagamento = 
				pagamentos.stream()
				.filter(s -> s.getTipoPagamento().getNome().equalsIgnoreCase("CORTESIA")).findFirst();

		
		BigDecimal valorCortesia =  oPagamento.isPresent() ? oPagamento.get().getValor() : new BigDecimal(0);
		
		if(valorCortesia.compareTo(toSave.getEmplacamento().getValorEmplacamento()) > 0 ) {
			return false;
		}
		
		return true ;
	}
	
	@Override
	public EmplacamentoAvulso createT(EmplacamentoAvulso t) {
		// TODO Auto-generated method stub
		t = super.createT(t);

//		for(int x = 0; x < t.getPagamentos().size(); x++) {
////			t.getPagamentos().;
////		}
		final Integer id = ((EmplacamentoAvulso) t).getId();
		t.getEmplacamento().getPagamentos().forEach(p -> {
			
			if(p.getTipoPagamentoId() != null)
				p.setTipoPagamentoId(p.getTipoPagamentoId());
			
			p.setEmplacamento(new Emplacamento());
			p.getEmplacamento().setId(id);
			fRepository.save(p);
		});

		t.getEmplacamento().getTaxas().forEach(te -> {
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
	public Optional<EmplacamentoAvulso> pegar(Integer i) {
		// TODO Auto-generated method stub
		Optional<EmplacamentoAvulso> oEmplaca =  super.pegar(i);
		
		if(oEmplaca.isPresent()) {
			EmplacamentoAvulso emplacamento = oEmplaca.get();
			
			Emplacamento emplacamentot = new Emplacamento();
			
			emplacamentot.setId(emplacamento.getEmplacamento().getId());
			
			Set<EmplacamentoTaxa> taxas =  eRepository.findByEmplacamento(emplacamentot);
			
			
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
	
	BigDecimal valor_abate = new BigDecimal(0);
	public byte[] generateReport(Integer id) throws IOException {

		byte[] reportData = null;

		try {
			Map parameters = new HashMap();
			
		 Optional<EmplacamentoAvulso> oEmplacamento = 	this.pegar(id); 
		 
		 
		 EmplacamentoAvulso emplacamentoA = (oEmplacamento.get());
			Emplacamento emplacamento = (oEmplacamento.get()).getEmplacamento(); 
			
			
			parameters.put("dept_venda", emplacamento.getEstado().equals("VN")  ? "NOVOS" :  emplacamento.getEstado().equals("VU") ?  "SEMI-NOVOS" : "VENDA DIRETA");
			parameters.put("data_solicitacao", emplacamento.getPropdata());
			parameters.put("model_veiculo", emplacamentoA.getDescritivo());
			parameters.put("munc_veiculo", "Salvador");
			
			parameters.put("vlr_proposta", new java.text.DecimalFormat("R$ #,##0.00").format( emplacamentoA.getVlVec() ));
			parameters.put("obsv", emplacamento.getObservacao());
			parameters.put("vlr_total", new java.text.DecimalFormat("R$ #,##0.00").format(emplacamento.getValorEmplacamento()));
			parameters.put("nome_cliente", emplacamentoA.getNome());
			parameters.put("cpf", formataCpf(emplacamento.getCpf()) );
			
			
			parameters.put("obsv", emplacamento.getObservacao() != null ?  emplacamento.getObservacao() : "");
			
			
			parameters.put("loja", emplacamento.getEmp_ds() );
			parameters.put("responsavel", emplacamentoA.getVendedor() );
			parameters.put("cliente", emplacamentoA.getNome() );
			parameters.put("data", emplacamento.getPropdata() );
			parameters.put("setor", emplacamento.getEstado().equals("VN") ? "VEÍCULOS NOVOS" :  emplacamento.getEstado().equals("VU") ?  "SEMI-NOVOS" : "VENDA DIRETA"    );
			parameters.put("codigo", "" );
			parameters.put("placa", emplacamento.getPlaca() );
			
			BigDecimal valor_ipva = new BigDecimal(0);
			
			List<EmplacamentoTaxa> emplacaIpva = 
			emplacamento.getTaxas().stream().filter( taxa -> taxa.getTaxa().getDescr().contains("IPVA")).collect(Collectors.toList());
			
			
			emplacamento.getEmp_cd();
			
			Optional<Parametro> oParam = pRepository.findPorEmpresa(emplacamento.getEmp_cd()); 
			
			
			BigDecimal valor_base = new BigDecimal(0);
			
			if(oParam.isPresent()) {
				Parametro param =	oParam.get();
				valor_base = param.getValorBase();
			}
			
			
		//	BigDecimal valor_abate = new BigDecimal(0); 
			
			emplacamento.getTaxas().forEach(empl_taxa ->{
				
				if(empl_taxa.getTaxa().getAbateBase()) {
					valor_abate = valor_abate.add(empl_taxa.getValor_final());
				}
								
			});
			
			Boolean hasCortesia = false; 
			Optional<FormaPagamento> oFormas =
					
			emplacamento.getPagamentos().stream().filter(
					s -> 
			s.getTipoPagamento().getNome().toUpperCase().indexOf("CORTESIA") >= 0
			
					).findFirst();
			
			
			if(oFormas.isPresent()) {
				 hasCortesia = true ;
				parameters.put("valor", new java.text.DecimalFormat("R$ #,##0.00").format(oFormas.get().getValor())  );
			}		
			
			
			
			
			
			parameters.put("hasCortesia", hasCortesia);

			
			System.out.println(emplacamento.getValorEmplacamento());
	
			emplacamento.getTaxas().forEach(e -> {
				
					e.setValor_final(e.getValor_final());
			});
			
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


public static String formataCpf(String numero) {
	
	MaskFormatter mf;
	try {
		mf = new MaskFormatter("###.###.###-##");
		
		mf.setValueContainsLiteralCharacters(false);  
		
		return mf.valueToString(numero);	
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
		return "";
}

		}




