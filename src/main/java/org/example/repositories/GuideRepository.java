package org.example.repositories;

import org.example.entities.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface GuideRepository<T, ID> extends Repository {
    Optional<T> findById(ID id);

    <S extends T> S save(S entity);



}
