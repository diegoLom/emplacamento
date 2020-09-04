package com.losolved.emplacamento.web.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.losolved.emplacamento.integration.sdk.ClienteResult;
import com.losolved.emplacamento.integration.sdk.EmpresaResult;
import com.losolved.emplacamento.integration.sdk.PropostaResult;
import com.losolved.emplacamento.integration.sdk.UsuarioResult;

@RestController
@RequestMapping("/de")
public class DeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	private String url = "http://localhost:9099/de/";
		
	
	@GetMapping(path = "proposta/{numeroProposta}/{empresa}" )
	public ResponseEntity<PropostaResult> getProposta(@PathVariable("numeroProposta") String numero,@PathVariable String empresa) {
		
		System.out.print(url);
		System.out.print(url+"proposta/"+numero+"/"+empresa);
		ResponseEntity<PropostaResult> response = restTemplate.getForEntity(url+"proposta/"+numero+"/"+empresa, PropostaResult.class);
		
	
		return    response; 
	}
	
	@GetMapping(path = "cliente/{codigoCliente}/{empresa}" )
	public ResponseEntity<ClienteResult> getCliente(@PathVariable("codigoCliente") String codigoCliente,@PathVariable("empresa") String empresa) {
			ResponseEntity<ClienteResult> response = restTemplate.getForEntity(url+"cliente/"+codigoCliente+"/"+empresa, ClienteResult.class);
		
		return    response;
		
   	}
	
	@GetMapping(path = "usuario/{login}" )
	public ResponseEntity<UsuarioResult> getUsuario(@PathVariable("login") String login) {
		//http://www.jsonschema2pojo.org/
		//
		ResponseEntity<UsuarioResult> response = restTemplate.getForEntity(url+"usuario/"+login, UsuarioResult.class);
		
		return    response;
	}
	
	
	@GetMapping(path = "empresas" )
	public ResponseEntity<EmpresaResult[]> getEmpresas() {
		
		ResponseEntity<EmpresaResult[]> response = restTemplate.getForEntity(url+"empresas", EmpresaResult[].class);
		
		return    response;
	}

	
//	@GetMapping("/empresas") 
//	public ResponseEntity<EmpresaResult> pegarEmpresas( ){
//		
//	    Optional<T> retorno =  pegar(id);
//		
//	    if(retorno.isPresent()) {
//	     	return ResponseEntity.status(HttpStatus.OK).body(retorno.get());
//	    }
//		
//		return ResponseEntity.notFound().build();
//	}

}
