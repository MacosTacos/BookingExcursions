package org.example.entities;

import jakarta.persistence.*;
import org.example.entities.ids.BookingId;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingEntity {

    private BookingId id;
    private ClientEntity clientEntity;
    private ExcursionEntity excursionEntity;
    private LocalDateTime bookingDate;
    private AdministratorEntity administratorEntity;

    public BookingEntity(BookingId id, ClientEntity clientEntity, ExcursionEntity excursionEntity, LocalDateTime bookingDate, AdministratorEntity administratorEntity) {
        this.id = id;
        this.clientEntity = clientEntity;
        this.excursionEntity = excursionEntity;
        this.bookingDate = bookingDate;
        this.administratorEntity = administratorEntity;
    }

    public BookingEntity() {
    }

    @EmbeddedId
    public BookingId getId() {
        return id;
    }

    public void setId(BookingId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ClientEntity.class)
    @MapsId("clientId")
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ExcursionEntity.class)
    @MapsId("excursionId")
    public ExcursionEntity getExcursionEntity() {
        return excursionEntity;
    }

    public void setExcursionEntity(ExcursionEntity excursionEntity) {
        this.excursionEntity = excursionEntity;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AdministratorEntity.class)
    @JoinColumn(name = "admin_id")
    public AdministratorEntity getAdministratorEntity() {
        return administratorEntity;
    }

    public void setAdministratorEntity(AdministratorEntity administratorEntity) {
        this.administratorEntity = administratorEntity;
    }
}

