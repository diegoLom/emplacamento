package org.emplacamento.services;


import java.net.URI;
import java.util.Optional;

import org.emplacamento.domain.BaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public  abstract class BaseService<T extends BaseEntity<I>, I> {
	
	
	private JpaRepository repository;
	
	public Optional<T> pegar(I i){
		return repository.findById(i);
	}
	
	public T createT( T t) {
		T savedT = (T) repository.save(t);
		return savedT;
		
	}
	
	public Optional<T> atualizarT( T t,  I id) {
		Optional<T> studentOptional = repository.findById( id);

		if (!studentOptional.isPresent())
			return studentOptional;

		t.setId(id);
		
		t =  (T) repository.save(t);
		Optional<T> retorno = Optional.of(t);
		
		return retorno;
	}
	
	public Boolean deletar(I i) {
		Boolean retorno = false; 
		
		if(i!= null) {
			Optional<T> objetoRetornado = pegar(i); 
			
			if(objetoRetornado.isPresent()) {
				repository.deleteById(i);
				
				retorno = true;
			}
		}
		
			return retorno;
	}

	
	
	
	
	

}
