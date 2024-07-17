package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingEntity extends BaseEntity {
    private ClientEntity clientEntity;
    private ExcursionEntity excursionEntity;
    private LocalDateTime bookingDate;

    public BookingEntity(ClientEntity clientEntity, ExcursionEntity excursionEntity, LocalDateTime bookingDate) {
        this.clientEntity = clientEntity;
        this.excursionEntity = excursionEntity;
        this.bookingDate = bookingDate;
    }

    protected BookingEntity() {
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ClientEntity.class)
    @JoinColumn(name = "client_id")
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ExcursionEntity.class)
    @JoinColumn(name = "excursion_id")
    public ExcursionEntity getExcursionEntity() {
        return excursionEntity;
    }

    public void setExcursionEntity(ExcursionEntity excursionEntity) {
        this.excursionEntity = excursionEntity;
    }

    @Column(name = "booking_date")
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

}


