package org.emplacamento.integration;

import org.emplacamento.domain.Programacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgramacaoRepository extends CrudRepository<Programacao, Integer> {

}
