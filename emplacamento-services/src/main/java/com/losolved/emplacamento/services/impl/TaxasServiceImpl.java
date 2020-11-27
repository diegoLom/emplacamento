package com.losolved.emplacamento.services.impl;



import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.domain.Taxa;
import com.losolved.emplacamento.domain.TaxaVec;
import com.losolved.emplacamento.integration.repository.ParametroRepository;
import com.losolved.emplacamento.integration.repository.TaxaVecRepository;
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.services.BaseService;




@Service
public class TaxasServiceImpl extends BaseService<Taxa, Integer> {
	
	
	@Autowired
	ParametroRepository paramRepository;
	
	@Autowired
	TaxasRepository taxaRepository;
	
	@Autowired
	TaxaVecRepository tRepository;
	
	public Set<Taxa> getTaxaByEmp(String emp_cd) {
		// TODO Auto-generated method stub
		Optional<Parametro> oParametro = paramRepository.findPorEmpresa(emp_cd);
		
		
		Set<Taxa> taxas = new HashSet<>(); 
		
		if(oParametro.isPresent()) {
			
			Parametro parametro = oParametro.get();
			taxas = taxaRepository.findByParametro(parametro);
			
			

			taxas.forEach(e -> {
				Set<TaxaVec> taxasVec = tRepository.findByTaxa(e);
				e.setTaxasVec(taxasVec);
			
			});

			
			return taxas;
		}
		
		return taxas;
	}
	
	

	@Override
	public Taxa createT(Taxa t) {
		// TODO Auto-generated method stub
		Taxa saved = super.createT(t);
		final Integer id = ((Taxa) saved).getId();
		
		final BigDecimal vl_final = ((Taxa) saved).getVl_final();
		final Boolean obrigatorio = ((Taxa) saved).getObrigatorio();


		t.getTaxasVec().forEach(te -> {
			te.setTaxa(new Taxa());
			te.getTaxa().setId(id);
			;
			
			if(te.getVl_final() == null || te.getVl_final().compareTo(new BigDecimal(0))  <= 0) {
				te.setVl_final(vl_final);
			}
			
			te.setTp_valor("FIXO");
			
			if(te.getObrigatorio() == null) {
				te.setObrigatorio(obrigatorio);
			}

			tRepository.save(te);
		});

		return t;
	}
	
	
	public Set<Taxa> pegar(Parametro p) {
		
		Set<Taxa> taxas = taxaRepository.findByParametro(p);

		taxas.forEach(e -> {
			Set<TaxaVec> taxasVec = tRepository.findByTaxa(e);
			e.setTaxasVec(taxasVec);
		
		});

		return taxas;

		
	}
	
	@Override
	public List<Taxa> pegar() {
		// TODO Auto-generated method stub

		List<Taxa> taxas = IteratorUtils.toList(getRepository().findAll().iterator());

		taxas.forEach(e -> {
			Set<TaxaVec> taxasVec = tRepository.findByTaxa(e);
			e.setTaxasVec(taxasVec);
		
		});

		return taxas;
	}
		 

	@Override
	public Optional<Taxa> pegar(Integer i) {
		// TODO Auto-generated method stub
		Optional<Taxa> oTaxa = super.pegar(i);

		if (oTaxa.isPresent()) {

			Taxa parametro = oTaxa.get();
			Set<TaxaVec> taxas = tRepository.findByTaxa(parametro);
			parametro.setTaxasVec(taxas);
			
		}

		return oTaxa;
	}
	
	
	@Override
	public Optional<Taxa> atualizarT(Taxa t, Integer id) {
		// TODO Auto-generated method stub

		Optional<Taxa> oTaxa = super.atualizarT(t, id);

		if (true) {

			Taxa param = t;


			Set<TaxaVec> TaxaVecsPersistidas = tRepository.findByTaxa(param);

			Set<TaxaVec> TaxaVecsRemover = new HashSet<TaxaVec>();
			Set<TaxaVec> TaxaVecsAtualizar = new HashSet<TaxaVec>();
			Set<TaxaVec> TaxaVecsInserir = new HashSet<TaxaVec>();

			List<Integer> idVerificar = t.getTaxasVec().stream().filter(ts -> ts.getId() != 0).map(ta -> ta.getId()).collect(Collectors.toList());
			TaxaVecsPersistidas.forEach(to -> {

				System.out.println();

				if (!idVerificar.contains(to.getId())) {
					TaxaVecsRemover.add(to);
				}
			});

			List<Integer> idPersistidas = TaxaVecsPersistidas.stream().map(ta -> ta.getId()).collect(Collectors.toList());

			t.getTaxasVec().forEach(to -> {
				if (!idPersistidas.contains(to.getId())) {
					TaxaVecsInserir.add(to);
				}
			});

			TaxaVecsRemover.forEach(TaxaVec -> {
				tRepository.delete(TaxaVec);
			});
			TaxaVecsInserir.forEach(TaxaVec -> {
				TaxaVec.setTaxa(new Taxa()); 
				TaxaVec.getTaxa().setId(id); 
				tRepository.save(TaxaVec);
			});
			
			List<Integer> idRemover = TaxaVecsRemover.stream().map(ta -> ta.getId()).collect(Collectors.toList());
			List<Integer> idInserir = TaxaVecsInserir.stream().map(ta -> ta.getId()).collect(Collectors.toList());
			
			t.getTaxasVec().forEach(to -> {

				System.out.println();

				if (!idRemover.contains(to.getId()) && !idInserir.contains(to.getId() ) ) {
					TaxaVecsAtualizar.add(to);
				}
			});
			
			TaxaVecsAtualizar.forEach(TaxaVec -> {
				TaxaVec.setId(TaxaVec.getId());
				TaxaVec.setTaxa(new Taxa()); 
				TaxaVec.getTaxa().setId(id); 
				tRepository.save(TaxaVec);
			});
		}

		return Optional.of(t);
	}
	
	

	public void deletar(Set<Taxa> taxas ) {
		// TODO Auto-generated method stub
		
		
		
		if(taxas != null) {
			taxas.forEach(t -> {
				tRepository.deleteAll(t.getTaxasVec());
				super.deletar(t.getId());
				
			});
			
		}
		
		
	}

	@Override
	public Boolean deletar(Integer i) {
		// TODO Auto-generated method stub
		
		
		Optional<Taxa> oParam = this.pegar(i);
		
		if(oParam.isPresent()) {
			Taxa param  = oParam.get();
			tRepository.deleteAll(param.getTaxasVec());
			super.deletar(i);
			
			return true;
		}		

		
		return false;
	}
	   
	   
	  

}

