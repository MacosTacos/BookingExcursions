package org.example.repositories;

import org.example.entities.ExcursionEntity;
import org.example.entities.ExcursionTypeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcursionTypeRepository extends GeneralRepository<ExcursionTypeEntity, Long> {

    @Query(value = "select distinct t from ExcursionTypeEntity t " +
            "join t.excursionEntityList e where e in :excursions")
    List<ExcursionTypeEntity> findAllByExcursions(@Param("excursions")
                                                  List<ExcursionEntity> excursions);

}
