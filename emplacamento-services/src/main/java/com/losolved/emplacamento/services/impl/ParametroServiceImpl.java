package com.losolved.emplacamento.services.impl;

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
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.services.BaseService;

@Service
public class ParametroServiceImpl extends BaseService<Parametro, Integer> {

	@Autowired
	TaxasRepository tRepository;

	public Parametro salvar(Parametro toSave) {
		return toSave;
	}

	@Override
	public Parametro createT(Parametro p) {
		// TODO Auto-generated method stub
		p = super.createT(p);
		final Integer id = ((Parametro) p).getId();

		p.getTaxas().forEach(te -> {
			te.setParametro(new Parametro());
			te.getParametro().setId(id);
			;

			tRepository.save(te);
		});

		return p;
	}

	@Override
	public List<Parametro> pegar() {
		// TODO Auto-generated method stub

		List<Parametro> params = IteratorUtils.toList(getRepository().findAll().iterator());

		params.forEach(e -> {
			Set<Taxa> taxas = tRepository.findByParametro(e);
			e.setTaxas(taxas);
		});

		return params;
	}

	@Override
	public Optional<Parametro> pegar(Integer i) {
		// TODO Auto-generated method stub
		Optional<Parametro> oParametro = super.pegar(i);

		if (oParametro.isPresent()) {

			Parametro parametro = oParametro.get();
			Set<Taxa> taxas = tRepository.findByParametro(parametro);
			parametro.setTaxas(taxas);

		}

		return oParametro;
	}

	@Override
	public Optional<Parametro> atualizarT(Parametro t, Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Parametro> oParametro =   super.atualizarT(t, id); 
		
		if(oParametro.isPresent()) {
			
			Parametro param = oParametro.get();
			
			Set<Taxa> taxasAtualizar = t.getTaxas().stream().filter(		taxa ->  taxa.getAtualiza() == true	).collect(Collectors.toSet());
			
	/*	
			Set<Taxa> taxasVerificar  = t.getTaxas().stream().filter(taxa ->  taxa.getAtualiza() == false).collect(Collectors.toSet());
	  
	  	Set<Taxa> taxasPersistidas = tRepository.findByParametro(param);
			
			Set<Taxa> taxasRemover = new HashSet<Taxa>();
			Set<Taxa> taxasInserir = new HashSet<Taxa>();
			
			
			List<Integer> idVerificar =  taxasVerificar.stream().map( ta -> ta.getId()).collect(Collectors.toList());
			List<Integer> idAtualizar =  taxasAtualizar.stream().map( ta -> ta.getId()).collect(Collectors.toList());
	 taxasPersistidas.forEach(to -> {
				
				System.out.println(); 
				
				if(!idVerificar.contains(to.getId())  &&  idAtualizar.contains(to.getId())) {
					taxasRemover.add(to);
				}
			});
			
			
			List<Integer> idPersistidas =  taxasPersistidas.stream().map( ta -> ta.getId()).collect(Collectors.toList());
			
			taxasVerificar.forEach(to -> {
				if(!idPersistidas.contains(to.getId())) {
					taxasInserir.add(to);
				}
			});
			
			taxasRemover.forEach(taxa -> { tRepository.delete(taxa);});
			taxasInserir.forEach(taxa -> { tRepository.save(taxa);}); **/
			taxasAtualizar.forEach(taxa -> { tRepository.save(taxa);});
		}
		
		return oParametro;
	}

	
	
}
