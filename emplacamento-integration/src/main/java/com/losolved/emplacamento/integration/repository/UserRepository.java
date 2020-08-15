package com.losolved.emplacamento.integration.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.emplacamento.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>  {
	
	
	Optional<User> findById(String username);

}
