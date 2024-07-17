package org.example.dtos;

public class BookingDTO {
    private Long clientId;
    private Long excursionId;

    public BookingDTO() {
    }

    public BookingDTO(Long clientId, Long excursionId) {
        this.clientId = clientId;
        this.excursionId = excursionId;
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
