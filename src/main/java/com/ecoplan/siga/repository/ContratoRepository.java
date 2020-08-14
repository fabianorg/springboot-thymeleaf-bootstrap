package com.ecoplan.siga.repository;

import com.ecoplan.siga.model.Contrato;
import org.springframework.data.repository.CrudRepository;

public interface ContratoRepository extends CrudRepository<Contrato, String> {

    Contrato findById(long id);
}
