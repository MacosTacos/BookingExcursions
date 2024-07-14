package org.example.services.impl;

import org.example.dtos.ClientDTO;
import org.example.dtos.ExcursionDTO;
import org.example.entities.BookingEntity;
import org.example.entities.ClientEntity;
import org.example.entities.ExcursionEntity;
import org.example.entities.ExcursionTypeEntity;
import org.example.repositories.BookingRepository;
import org.example.repositories.ClientRepository;
import org.example.repositories.ExcursionRepository;
import org.example.repositories.ExcursionTypeRepository;
import org.example.services.ExcursionRecommendService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcursionRecommendServiceImpl implements ExcursionRecommendService {

    private final ExcursionRepository excursionRepository;
    private final ExcursionTypeRepository excursionTypeRepository;
    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;

    public ExcursionRecommendServiceImpl(ExcursionRepository excursionRepository,
                                         ExcursionTypeRepository excursionTypeRepository,
                                         BookingRepository bookingRepository,
                                         ClientRepository clientRepository) {
        this.excursionRepository = excursionRepository;
        this.excursionTypeRepository = excursionTypeRepository;
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ExcursionEntity> recommendExcursions(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientRepository.findById(clientDTO.getId());
        List<BookingEntity> bookings = bookingRepository.findAllByClient(clientEntity);
        if (bookings.isEmpty()) return null;
        List<ExcursionEntity> excursions = excursionRepository.findAllByBookings(bookings);
        List<ExcursionTypeEntity> types = excursionTypeRepository.findAllByExcursions(excursions);
        List<ExcursionEntity> recommendedExcursions = excursionRepository.findAllByTypes(types);
        recommendedExcursions.removeIf(excursion -> !isAvailable(excursion));

//        List<ExcursionDTO> availableExcursions = recommendedExcursions.stream()
//                .map(excursion
//
//                )

        return recommendedExcursions;
    }

    private boolean isAvailable(ExcursionEntity excursion) {
        int reservedSlots = bookingRepository.countByExcursion(excursion);
        return reservedSlots < excursion.getSlots();
    }




}
