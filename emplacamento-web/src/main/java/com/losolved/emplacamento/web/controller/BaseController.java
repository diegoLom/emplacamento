package com.losolved.emplacamento.web.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.losolved.emplacamento.domain.BaseEntity;
import com.losolved.emplacamento.services.BaseService;



@Component
public class BaseController<T extends BaseEntity<I> ,  I>  {

	
	private BaseService<T, I> baseService;
  	
	
	
//	@GetMapping 
//	public List<T> pegarTodos() {
//		return baseService.;
//	};
	
	public Optional<T> pegar(I i) {
		return baseService.pegar(i);
	};
	@GetMapping("{id}") 
	public T pegarT(@RequestParam I id){
		return pegar(id).get();
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void deletarT(@RequestParam(required=true) I id){
		deletar(id);
	}
	
	@PostMapping 
	public ResponseEntity<Object> createT(@RequestBody T t){
		T savedT = baseService.createT(t);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedT).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> atualizarT(@RequestBody T t, @PathVariable I id) {
		Optional<T> studentOptional = baseService.pegar(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		t.setId(id);
		
		baseService.atualizarT(t, id);

		return ResponseEntity.noContent().build();
	}
	
	public Boolean deletar(I i) {
		Boolean retorno = false; 
		
		if(i!= null) {
			Optional<T> objetoRetornado = pegar(i); 
			
			if(objetoRetornado.isPresent()) {
				baseService.deletar(i);
				
				retorno = true;
			}
		}
		
			return retorno;
		}
	public BaseService<T, I> getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService<T, I> baseService) {
		this.baseService = baseService;
	}
	
	
	
	
	
		
		
		
		
		
		
		
		
	
}
