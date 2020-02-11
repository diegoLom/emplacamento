package com.losolved.emplacamento.services;


import java.util.Optional;
import com.losolved.emplacamento.domain.BaseEntity;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



public  abstract class BaseService<T extends BaseEntity<I>, I  > {
	
	
	private CrudRepository repository;
	
	
	
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

	public CrudRepository getRepository() {
		return repository;
	}

	public void setRepository(CrudRepository repository) {
		this.repository = repository;
	}

	
	
	
	
	
	

}
