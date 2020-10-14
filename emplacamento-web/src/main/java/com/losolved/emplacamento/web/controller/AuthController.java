package com.losolved.emplacamento.web.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.losolved.emplacamento.domain.ResetModel;
import com.losolved.emplacamento.domain.Token;
import com.losolved.emplacamento.domain.User;
import com.losolved.emplacamento.integration.sdk.UsuarioResult;

import com.losolved.emplacamento.services.impl.TokenServiceImpl;
import com.losolved.emplacamento.services.impl.UserServiceImpl;
import com.losolved.emplacamento.web.services.EmailSender;

@RestController("auth") 
@RequestMapping("/auth")
public class AuthController {
	
	
//	/auth/token  envia o token por email e salva na base c periodo de expiracao
//	/auth/reset  setar a senha do usuario
//	/auth/check  checar se o token informado é valido 
	
	
	
	@Autowired
	private TokenServiceImpl tokenService;
	

	@Autowired
	private UserServiceImpl userService;
	
	
	
	@Autowired
	private EmailSender eSender;
	
	@Autowired
	private DeController de;


	

	@CrossOrigin(origins = "*", methods = RequestMethod.POST)
	@PostMapping(value = "token")
	public ResponseEntity<Object> token(@RequestBody ResetModel t){
		ResponseEntity<UsuarioResult> responseResult = null;
		try {
			 responseResult = de.getUsuario(t.getUser()); 
			
		}catch(Exception e) {
			
		}
		
		if(responseResult.getStatusCode().equals(HttpStatus.OK) ) {
		
			Token savedT = tokenService.createT(t.getUser());
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(savedT).toUri();
		
			
			try {
				if(savedT.getToken() != null) {
					eSender.sendSimpleMessage(responseResult.getBody().getEmail(), "Token reset senha", savedT.getToken());
				}
				
				return ResponseEntity.created(location).body(savedT);
			}catch(Exception e) {
				tokenService.excluir(savedT.getToken(), savedT.getUserName());
				e.printStackTrace();
			}
		}
		
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin(origins = "*", methods = RequestMethod.POST)
	@PostMapping(value = "reset")
	public ResponseEntity<Object> reset(@RequestBody ResetModel t){
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(t.getNewPassword());
		
		User u = new User();
		u.setUsername(t.getUser());
		u.setPassword(hashedPassword);
	
		u = userService.atualizar(u); 
    
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(u).toUri();
		
		 
		return ResponseEntity.created(location).body(u );
		
	}
	
	@CrossOrigin(origins = "*", methods = RequestMethod.POST)
	@PostMapping(value = "check")
	public ResponseEntity<Object> check(@RequestBody ResetModel t){
		Object savedT = tokenService.check(t.getToken(), t.getUser());
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(savedT).toUri();
		
		return ResponseEntity.created(location).body(savedT);
		
	}

}
