package com.losolved.emplacamento.services.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.domain.Authorities;
import com.losolved.emplacamento.domain.AuthoritiesId;
import com.losolved.emplacamento.integration.repository.AuthoritiesRepository;

@Service
public class AuthoritiesServiceImpl {

	
	@Autowired
	private AuthoritiesRepository repository;
	
	
	public List<Authorities> pegar(){
		return IteratorUtils.toList(repository.findAll().iterator());
	}
	
	public List<Authorities> pegar(String arg0){
		return repository.findByUsername(arg0);
	}

	
/*	public Optional<Authorities> pegar(String arg0, String arg1){
		
		AuthoritiesId authId = new AuthoritiesId();
		authId.username = arg0;
		authId.authority = arg1;
		return repository.findById(authId);
	} **/
	
	public Authorities create( Authorities t) {
		Authorities savedT = (Authorities) repository.save(t);
		return savedT;
		
	}
	
	public Optional<Authorities> atualizar( Authorities t,  AuthoritiesId id) {
	
	
		
		t =  (Authorities) repository.save(t);
		Optional<Authorities> retorno = Optional.of(t);
		
		
		return retorno;
	}
	
	

	
	
}
