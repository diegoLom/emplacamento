package com.losolved.emplacamento.web.configuration;


import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	
	// EXPIRATION_TIME = 10 dias 18_000_000
	static final long EXPIRATION_TIME = 18_000_000;
	static final String SECRET = "LoSolvedCorp";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
	
	static void addAuthentication(HttpServletResponse response, String username) {
		String JWT = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}
	
	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		
		if (token != null) {
			// faz parse do token
			String user = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();
			
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			}
		}
		return null;
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	} 
	
}