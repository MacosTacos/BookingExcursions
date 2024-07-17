package org.example.controllers;

import org.example.dtos.BookingDTO;
import org.example.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(path = "create")
    public void makeReservation(@RequestBody BookingDTO bookingDTO) {
        bookingService.makeReservation(bookingDTO);
    }

}
