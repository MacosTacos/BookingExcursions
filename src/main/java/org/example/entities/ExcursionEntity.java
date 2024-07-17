package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "excursions")
public class ExcursionEntity extends BaseEntity {
    private LocalDateTime date;
    private GuideEntity guideEntity;
    private RouteEntity routeEntity;
    private Integer slots;
    private List<BookingEntity> bookingEntityList;

    private List<ExcursionTypeEntity> excursionTypeEntityList;

    public ExcursionEntity(LocalDateTime date,
                           GuideEntity guideEntity,
                           RouteEntity routeEntity,
                           Integer slots,
                           List<BookingEntity> bookingEntityList,
                           List<ExcursionTypeEntity> excursionTypeEntityList
    ) {
        this.date = date;
        this.guideEntity = guideEntity;
        this.routeEntity = routeEntity;
        this.slots = slots;
        this.bookingEntityList = bookingEntityList;
        this.excursionTypeEntityList = excursionTypeEntityList;
    }

    protected ExcursionEntity() {
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

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, targetEntity = BookingEntity.class, mappedBy = "excursionEntity")
    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "excursions_excursion_types", joinColumns = @JoinColumn(name = "excursion_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_type_id", referencedColumnName = "id"))
    public List<ExcursionTypeEntity> getExcursionTypeEntityList() {
        return excursionTypeEntityList;
    }

    public void setExcursionTypeEntityList(List<ExcursionTypeEntity> excursionTypeEntityList) {
        this.excursionTypeEntityList = excursionTypeEntityList;
    }
}
