package com.losolved.emplacamento.integration.repository;


import com.losolved.emplacamento.domain.Token;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokenRepository extends CrudRepository<Token, String> {
	
	Optional<Token> findByTokenAndUserName(String token, String userName);
	
	
	 @Query(value = "select * from token  where token.token = ?1 AND token.user_name = ?2 AND  token.dt_expiracao BETWEEN ?3 AND ?4 " 
		 		, nativeQuery = true)
	Optional<Token> findTokenValid(String token, String userName, java.util.Date today , java.util.Date yesterday);
	
	 
	 
}
