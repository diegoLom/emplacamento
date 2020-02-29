package com.losolved.emplacamento.integration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.emplacamento.domain.Uf;

@Repository
public interface UfRepository  extends CrudRepository<Uf, Byte> {

}
