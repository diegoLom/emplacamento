package com.losolved.emplacamento.integration.repository;

import com.losolved.emplacamento.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	
	

}
