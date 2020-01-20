package org.emplacamento.integration;

import org.emplacamento.domain.Taxa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaxaRepository extends CrudRepository<Taxa, Integer> {

}
