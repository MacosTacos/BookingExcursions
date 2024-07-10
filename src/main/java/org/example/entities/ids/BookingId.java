package org.example.entities.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookingId implements Serializable {
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "excursion_id")
    private Long excursionId;

    public BookingId(Long clientId, Long excursionId) {
        this.clientId = clientId;
        this.excursionId = excursionId;
    }

    public BookingId() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(Long excursionId) {
        this.excursionId = excursionId;
    }
}
