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
			Set<Taxa> taxas = tRepository.findByParametro(parametro);
			parametro.setTaxas(taxas);
			parametro.setUfnome(parametro.getUf() != null ? parametro.getUf().getNome() : "");
		}

		return oParametro;
	}

	@Override
	public Optional<Parametro> atualizarT(Parametro t, Integer id) {
		// TODO Auto-generated method stub

	//	Optional<Parametro> oParametro = super.atualizarT(t, id);

		if (true) {

			Parametro param = t;


			Set<Taxa> taxasPersistidas = tRepository.findByParametro(param);

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
				tRepository.delete(taxa);
			});
			taxasInserir.forEach(taxa -> {
				taxa.setParametro(new Parametro()); 
				taxa.getParametro().setId(id); 
				tRepository.save(taxa);
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
				tRepository.save(taxa);
			});
		}

		return Optional.of(t);
	}

}
