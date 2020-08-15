package com.losolved.emplacamento.services.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.domain.Authorities;
import com.losolved.emplacamento.domain.AuthoritiesId;
import com.losolved.emplacamento.domain.User;
import com.losolved.emplacamento.integration.repository.AuthoritiesRepository;
import com.losolved.emplacamento.integration.repository.UserRepository;


@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthoritiesServiceImpl authService;
	
	private static String SIMPLE_AUTHORITY = "USER";
	
	
	public List<User> pegar(){
		return IteratorUtils.toList(repository.findAll().iterator());
	}
	
	public Optional<User> pegar(String i){
		return repository.findById(i);
	}
	
	
	
	public User create( User t) {
		
		t.setEnabled(true);
		
		User savedT = (User) repository.save(t);
		
		Authorities authorities = new Authorities();
		
		authorities.setUsername(savedT.getUsername());
		authorities.setAuthority(SIMPLE_AUTHORITY);;
		
		
		authService.create(authorities);
		
		return savedT;
		
	}
	
	
	public UserServiceImpl(UserRepository repository, AuthoritiesServiceImpl authService) {
		super();
		this.repository = repository;
		this.authService = authService;
	}

	public User procurarAuthorities(User user) {
		authService.pegar(user.getUsername());
		
		return user;
		
		
	}
	
	public Optional<User> atualizar( User t,  String id) {
	
		t.setUsername(id);
		
		t =  (User) repository.save(t);
		Optional<User> retorno = Optional.of(t);
		
		
		return retorno;
	}

}
