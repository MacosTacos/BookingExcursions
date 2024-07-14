package org.example.services;

import org.example.entities.ExcursionEntity;
import org.example.entities.GuideEntity;
import org.example.repositories.ExcursionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcursionService {

    private final ExcursionRepository excursionRepository;

    public ExcursionService(ExcursionRepository excursionRepository) {
        this.excursionRepository = excursionRepository;
    }

}
