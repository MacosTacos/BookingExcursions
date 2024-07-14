package org.example.repositories;

import org.example.entities.BookingEntity;
import org.example.entities.ClientEntity;
import org.example.entities.ExcursionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends GeneralRepository<BookingEntity, Long> {

    @Query(value = "select b from BookingEntity b " +
            "where b.clientEntity = :client")
    List<BookingEntity> findAllByClient(@Param("client") ClientEntity client);

    @Query(value = "select b from BookingEntity b " +
            "where b.excursionEntity = :excursion")
    List<BookingEntity> findAllByExcursion(@Param("excursion") ExcursionEntity excursion);

    @Query(value = "select count(b) from BookingEntity b " +
            "where b.excursionEntity = :excursion")
    Integer countByExcursion(@Param("excursion") ExcursionEntity excursion);

}
