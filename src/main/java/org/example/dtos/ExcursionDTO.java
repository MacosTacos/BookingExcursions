package org.example.dtos;

import org.example.entities.*;

import java.time.LocalDateTime;
import java.util.List;

public class ExcursionDTO {
    private Long id;
    private LocalDateTime date;
    private GuideEntity guideEntity;
    private RouteEntity routeEntity;
    private Integer slots;
    private List<BookingEntity> bookingEntityList;
    private List<ExcursionTypeEntity> excursionTypeEntityList;
}
