package org.example.repositories;

import org.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcursionRepository extends GeneralRepository<ExcursionEntity, Long> {

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

    @Query(value = "select e from ExcursionEntity e " +
            "join e.excursionTypeEntityList t where t in :types")
    List<ExcursionEntity> findAllByTypes(@Param("types")
                                        List<ExcursionTypeEntity> types);

    @Query(value = "select e from ExcursionEntity e " +
            "join e.bookingEntityList b where b in :bookings")
    List<ExcursionEntity> findAllByBookings(@Param("bookings")List<BookingEntity> bookings);



}
