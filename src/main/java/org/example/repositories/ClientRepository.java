package org.example.repositories;

import org.example.entities.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends GeneralRepository<ClientEntity, Long> {

    ClientEntity findById(Long id);

}
