package com.losolved.emplacamento.integration.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.emplacamento.domain.Authorities;
import com.losolved.emplacamento.domain.AuthoritiesId;
import com.losolved.emplacamento.domain.Emplacamento;
import com.losolved.emplacamento.domain.EmplacamentoTaxa;
import com.losolved.emplacamento.domain.User;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Integer>  {

	
	 Optional<Authorities> findById(Integer id);
	
	List<Authorities>  findByUsername(String userName);
	
}
