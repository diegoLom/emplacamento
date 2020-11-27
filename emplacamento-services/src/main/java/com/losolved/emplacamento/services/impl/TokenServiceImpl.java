package com.losolved.emplacamento.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.emplacamento.domain.Parametro;
import com.losolved.emplacamento.domain.Taxa;
import com.losolved.emplacamento.domain.TaxaVec;
import com.losolved.emplacamento.domain.Token;
import com.losolved.emplacamento.integration.repository.ParametroRepository;
import com.losolved.emplacamento.integration.repository.TaxaVecRepository;
import com.losolved.emplacamento.integration.repository.TaxasRepository;
import com.losolved.emplacamento.integration.repository.TokenRepository;
import com.losolved.emplacamento.services.BaseService;

@Service
public class TokenServiceImpl {

	@Autowired
	TokenRepository tRepository;

	public Token createT(String userName) {
		// TODO Auto-generated method stub

		Random random = new Random();

		Token token = new Token();

		IntStream limitedIntStreamWithinARange = null;
		int number =0;
		Token exist = new Token();
		exist.setToken("0");
		
		while(exist.getToken() != null) {
			 limitedIntStreamWithinARange = random.ints(6, 100000, 999999);
			 number = limitedIntStreamWithinARange.findAny().getAsInt();
			 
			 exist = check(number+"", "");
		}
		
		
		LocalDateTime date = LocalDateTime.now();

		token.setToken(number+"");
		token.setUserName(userName);
		token.setDtExpiracao(Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));
		
		token = tRepository.save(token);

		return token;
	}
	
	
	public Token check(String token, String userName) {
		
		Token retorno = new Token();
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);
		
		//TODO: corrigir o username
		Optional<Token> oToken = tRepository.findTokenValid(token, Date.from(yesterday.atZone(ZoneId.systemDefault()).toInstant()),
				Date.from(today.atZone(ZoneId.systemDefault()).toInstant()) );

			
		if(oToken.isPresent()) {
			retorno = oToken.get();
		}
		
		
		return retorno;
	}
	
	
	public void excluir(String token, String userName) {
		
		
		Optional<Token> oToken = tRepository.findByTokenAndUserName(token, userName);
		
		if(oToken.isPresent()) {
			tRepository.delete(oToken.get());
		}
		
		
		
	}

}
