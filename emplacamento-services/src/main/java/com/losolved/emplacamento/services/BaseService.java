package com.losolved.emplacamento.services;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.losolved.emplacamento.domain.BaseEntity;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



public  abstract class BaseService<T extends BaseEntity<I>, I  > {
	
	
	private CrudRepository repository;
	
	
	public List<T> pegar(){
		return IteratorUtils.toList(repository.findAll().iterator());
	}
	
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
		
		
		
		                                    //     t
		
		return retorno;
	}
	
	public Boolean deletar(I i) {
		Boolean retorno = false; 
		
		if(i!= null) {
	
				repository.deleteById(i);
				
				retorno = true;
			
		}
		
			return retorno;
	}

	public CrudRepository getRepository() {
		return repository;
	}

	public void setRepository(CrudRepository repository) {
		this.repository = repository;
	}

	
	
	
	
	
	

}
