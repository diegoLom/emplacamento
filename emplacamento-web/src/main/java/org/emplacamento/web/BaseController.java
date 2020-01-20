package org.emplacamento.web;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.emplacamento.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.eb.servlet.support.ServletUriComponentsBuilder;


@Component
public class BaseController<T extends BaseEntity<I>, I>  {

		
    private  JpaRepository<T, I> repository;
	
	public void setRepository( JpaRepository<T, I> arg0){
		repository = arg0 ; 
	}
	
	@GetMapping 
	public List<T> pegarTodos() {
		return repository.findAll();
	};
	
	
		
	@GetMapping("{id}") 
	public Optional<T> pegar(I i) {
		return repository.findById(i);
	};
	
	public T pegarT(@RequestParam I id){
		return pegar(id).get();
	}
	
	
	//@DeleteMapping("{id}") 
	@RequestMapping(method=RequestMethod.DELETE)
	public void deletarT(@RequestParam(required=true) I id){
		deletar(id);
	}
	
	@PostMapping 
	public ResponseEntity<Object> createT(@RequestBody T t){
		T savedT = repository.save(t);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedT).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> atualizarT(@RequestBody T t, @PathVariable I id) {
		Optional<T> studentOptional = repository.findById( id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		t.setId(id);
		
		repository.save(t);

		return ResponseEntity.noContent().build();
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
		}; 
	
}
