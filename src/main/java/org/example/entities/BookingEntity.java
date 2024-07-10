package org.example.entities;

import jakarta.persistence.*;
import org.example.entities.ids.BookingId;

@Entity
@Table(name = "bookings")
public class BookingEntity {

    private BookingId id;
    private ClientEntity clientEntity;
    private ExcursionEntity excursionEntity;


    @EmbeddedId
    public BookingId getId() {
        return id;
    }

    public void setId(BookingId id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = ClientEntity.class)
    @MapsId("clientId")
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = ExcursionEntity.class)
    @MapsId("excursionId")
    public ExcursionEntity getExcursionEntity() {
        return excursionEntity;
    }

    public void setExcursionEntity(ExcursionEntity excursionEntity) {
        this.excursionEntity = excursionEntity;
    }
}

