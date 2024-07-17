package org.example.services.impl;

import org.example.dtos.BookingDTO;
import org.example.entities.BookingEntity;
import org.example.entities.ClientEntity;
import org.example.entities.ExcursionEntity;
import org.example.exceptions.BookingNotAvailableException;
import org.example.repositories.BookingRepository;
import org.example.repositories.ClientRepository;
import org.example.repositories.ExcursionRepository;
import org.example.services.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final ExcursionRepository excursionRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, ClientRepository clientRepository, ExcursionRepository excursionRepository) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.excursionRepository = excursionRepository;
    }

    @Override
    public void makeReservation(BookingDTO bookingDTO) {
        ExcursionEntity excursionEntity = excursionRepository.findById(bookingDTO.getExcursionId())
                .orElseThrow();
        if (isAvailable(excursionEntity)){
            ClientEntity clientEntity = clientRepository.findById(bookingDTO.getClientId())
                    .orElseThrow();
            BookingEntity bookingEntity = new BookingEntity(
                    clientEntity,
                    excursionEntity,
                    LocalDateTime.now()
            );
            bookingRepository.save(bookingEntity);
        }
        else {
            throw new BookingNotAvailableException("there are no free places left");
        }
    }

    private boolean isAvailable(ExcursionEntity excursion) {
        int reservedSlots = bookingRepository.countByExcursion(excursion);
        return reservedSlots < excursion.getSlots();
    }
}
