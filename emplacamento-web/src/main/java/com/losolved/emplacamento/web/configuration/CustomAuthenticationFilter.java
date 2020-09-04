package com.losolved.emplacamento.web.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationToken{
	
	
	private String empresa;
	
	

	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	public CustomAuthenticationFilter(Object principal, Object credentials, String empresa) {
		super(principal, credentials);
		this.empresa = empresa;
	}



	public CustomAuthenticationFilter(String user, Object object, Object object2,  Object emptyList) {
		// TODO Auto-generated constructor stub
		
		super(user, object, (Collection<? extends GrantedAuthority>) emptyList);
		this.empresa = (String) object2;
	}




}
