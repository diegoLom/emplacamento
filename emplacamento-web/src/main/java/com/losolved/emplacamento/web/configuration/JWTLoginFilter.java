package com.losolved.emplacamento.web.configuration;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losolved.emplacamento.domain.User;
import com.losolved.emplacamento.integration.repository.UserRepository;
import com.losolved.emplacamento.integration.sdk.UsuarioResult;
import com.losolved.emplacamento.services.BaseService;
import com.losolved.emplacamento.services.impl.AuthoritiesServiceImpl;
import com.losolved.emplacamento.services.impl.EmplacamentoServiceImpl;
import com.losolved.emplacamento.services.impl.UserServiceImpl;
import com.losolved.emplacamento.web.controller.DeController;


public  class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	
	protected JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}
	@Autowired
	private DeController de;
	
		@Autowired
	private  UserServiceImpl uService;
	

	



	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		AccountCredentials credentials = new ObjectMapper()
				.readValue(request.getInputStream(), AccountCredentials.class);
		
		
		//Optional<User> oUser =  userServices.pegar(credentials.getUsername());
		
		 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
			
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(credentials.getPassword());
		
		// oUser =  userServices.pegar(credentials.getUsername());
		
		
		  ServletContext servletContext = request.getServletContext();
		   WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		 
		if(uService == null) {
		  uService  = webApplicationContext.getBean(UserServiceImpl.class);
	
		}
		
		if(de == null) {
			  de  = webApplicationContext.getBean(DeController.class);
				
		}
		
		Optional<User> oUser = uService.pegar(credentials.getUsername());
		
		
		if(oUser.isPresent() ) {
			if(!oUser.get().getEnabled()) {
				
		
			}
			
		}else {
			User user = new User();
			user.setUsername(credentials.getUsername());
			user.setPassword(hashedPassword);
			user.setEnabled(true);
			
			uService.create(user);
			
			
		}
		
		
		
		
		ResponseEntity<UsuarioResult> responseResult = de.getUsuario(credentials.getUsername()); 
		

		return getAuthenticationManager().   authenticate(
				new CustomAuthenticationFilter(
						credentials.getUsername(), 
						credentials.getPassword(),
						responseResult.getBody().getEmpresa(),
						Collections.emptyList()
						)
				);
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filterChain,
			Authentication auth) throws IOException, ServletException {
		
		TokenAuthenticationService.addAuthentication(response, auth.getName());
	}

}
