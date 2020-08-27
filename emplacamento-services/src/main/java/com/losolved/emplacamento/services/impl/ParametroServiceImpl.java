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
import com.losolved.emplacamento.integration.repository.ParametroRepository;
import com.losolved.emplacamento.integration.repository.TaxaVecRepository;
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.services.BaseService;

@Service
public class ParametroServiceImpl extends BaseService<Parametro, Integer> {

	@Autowired
	TaxasServiceImpl taxasService;


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
			
			taxasService.createT(te);
			 
			 
		});

		return p;
	}

	@Override
	public List<Parametro> pegar() {
		// TODO Auto-generated method stub

		List<Parametro> params = IteratorUtils.toList(getRepository().findAll().iterator());

		params.forEach(e -> {
			Set<Taxa> taxas = taxasService.pegar(e);
			e.setTaxas(taxas);
			e.setUfnome(e.getUf() != null ? e.getUf().getNome() : "");
		});

		return params;
	}

	@Override
	public Optional<Parametro> pegar(Integer i) {
		// TODO Auto-generated method stub
		Optional<Parametro> oParametro = super.pegar(i);

		if (oParametro.isPresent()) {

			Parametro parametro = oParametro.get();
			Set<Taxa> taxas = taxasService.pegar(parametro);
			parametro.setTaxas(taxas);
			parametro.setUfnome(parametro.getUf() != null ? parametro.getUf().getNome() : "");
		}

		return oParametro;
	}
	
	
	
	public BigDecimal pegarValorBase(String emp_cd) {
		// TODO Auto-generated method stub

		BigDecimal retorno = new BigDecimal(0);
		Optional<Parametro> oParam = ((ParametroRepository) getRepository()).findPorEmpresa(emp_cd);
		
		
		if(oParam.isPresent()) {
			Parametro param = oParam.get(); 
			
			retorno = param.getValorBase();
		}
		
		return retorno;

	}
	
	@Override
	public Optional<Parametro> atualizarT(Parametro t, Integer id) {
		// TODO Auto-generated method stub

	//	Optional<Parametro> oParametro = super.atualizarT(t, id);

		if (true) {

			Parametro param = t;


			Set<Taxa> taxasPersistidas = taxasService.pegar(param);

			Set<Taxa> taxasRemover = new HashSet<Taxa>();
			Set<Taxa> taxasAtualizar = new HashSet<Taxa>();
			Set<Taxa> taxasInserir = new HashSet<Taxa>();

			List<Integer> idVerificar = t.getTaxas().stream().filter(ts -> ts.getId() != 0).map(ta -> ta.getId()).collect(Collectors.toList());
			taxasPersistidas.forEach(to -> {

				System.out.println();

				if (!idVerificar.contains(to.getId())) {
					taxasRemover.add(to);
				}
			});

			List<Integer> idPersistidas = taxasPersistidas.stream().map(ta -> ta.getId()).collect(Collectors.toList());

			t.getTaxas().forEach(to -> {
				if (!idPersistidas.contains(to.getId())) {
					taxasInserir.add(to);
				}
			});

			taxasRemover.forEach(taxa -> {
				taxasService.deletar(taxa.getId());
			});
			taxasInserir.forEach(taxa -> {
				taxa.setParametro(new Parametro()); 
				taxa.getParametro().setId(id); 
				taxasService.createT(taxa);
			});
			
			List<Integer> idRemover = taxasRemover.stream().map(ta -> ta.getId()).collect(Collectors.toList());
			List<Integer> idInserir = taxasInserir.stream().map(ta -> ta.getId()).collect(Collectors.toList());
			
			t.getTaxas().forEach(to -> {

				System.out.println();

				if (!idRemover.contains(to.getId()) && !idInserir.contains(to.getId() ) ) {
					taxasAtualizar.add(to);
				}
			});
			
			taxasAtualizar.forEach(taxa -> {
				taxa.setId(taxa.getId());
				taxa.setParametro(new Parametro()); 
				taxa.getParametro().setId(id); 
				taxasService.atualizarT(taxa, taxa.getId());
			});
		}

		return Optional.of(t);
	}

	@Override
	public Boolean deletar(Integer i) {
		// TODO Auto-generated method stub
		
		
		Optional<Parametro> oParam = this.pegar(i);
		
		if(oParam.isPresent()) {
			Parametro param  = oParam.get();
			taxasService.deletar(param.getTaxas());
			super.deletar(i);
			
			return true;
		}		

		
		return false;
	}
	
	

}
