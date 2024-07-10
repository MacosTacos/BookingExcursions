package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "excursions")
public class ExcursionEntity {
    private Long id;
    private LocalDateTime date;
    private GuideEntity guideEntity;
    private RouteEntity routeEntity;
    private List<BookingEntity> bookingEntityList;

    public ExcursionEntity(Long id, LocalDateTime date, GuideEntity guideEntity, RouteEntity routeEntity, List<BookingEntity> bookingEntityList) {
        this.id = id;
        this.date = date;
        this.guideEntity = guideEntity;
        this.routeEntity = routeEntity;
        this.bookingEntityList = bookingEntityList;
    }

    public ExcursionEntity() {
    }

    @Id
    @SequenceGenerator(
            name = "excursion_sequence",
            sequenceName = "excursion_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "excursion_sequence"
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GuideEntity.class)
    @JoinColumn(name = "guide_id")
    public GuideEntity getGuideEntity() {
        return guideEntity;
    }

    public void setGuideEntity(GuideEntity guideEntity) {
        this.guideEntity = guideEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RouteEntity.class)
    @JoinColumn(name = "route_id")
    public RouteEntity getRouteEntity() {
        return routeEntity;
    }

    public void setRouteEntity(RouteEntity routeEntity) {
        this.routeEntity = routeEntity;
    }

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, targetEntity = BookingEntity.class, mappedBy = "excursionEntity")
    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }
}
