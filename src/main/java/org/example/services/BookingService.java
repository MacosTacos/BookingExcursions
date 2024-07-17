package org.example.services;

import org.example.dtos.BookingDTO;

public interface BookingService {
    void makeReservation(BookingDTO bookingDTO);
}
