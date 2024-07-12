package org.example.repositories;

import org.example.entities.ClientEntity;
import org.example.entities.ExcursionEntity;
import org.example.entities.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExcursionRepository extends JpaRepository<ExcursionEntity, Long> {

    @Query(value = "select e from ExcursionEntity e " +
            "where e.guideEntity = :guideEntity")
    List<ExcursionEntity> findAllByGuide(@Param(value = "guideEntity")
                                         GuideEntity guideEntity);

    @Modifying
    @Query(value = "update ExcursionEntity e " +
            "set e.guideEntity = null " +
            "where e.guideEntity = :guideEntity")
    void deleteGuideFromAll(@Param("guideEntity")
                            GuideEntity guideEntity);

    @Query(value = "select e from ExcursionEntity e " +
            "join BookingEntity b where b.clientEntity = :clientEntity ")
    List<ExcursionEntity> findAllByClient(@Param("clientEntity")
                                          ClientEntity clientEntity);



}
