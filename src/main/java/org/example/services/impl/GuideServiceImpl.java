package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.dtos.GuideDTO;
import org.example.entities.GuideEntity;
import org.example.entities.GuideStatus;
import org.example.repositories.ExcursionRepository;
import org.example.repositories.GuideRepository;
import org.example.services.GuideService;
import org.springframework.stereotype.Service;

@Service
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guideRepository;
    private final ExcursionRepository excursionRepository;

    public GuideServiceImpl(GuideRepository guideRepository, ExcursionRepository excursionRepository) {
        this.guideRepository = guideRepository;
        this.excursionRepository = excursionRepository;
    }

    @Override
    public void fireGuide(GuideDTO guideDTO) {
        GuideEntity guideEntity = guideRepository.findById(guideDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("guide not found"));
        guideEntity.setGuideStatus(GuideStatus.FIRED);
        guideRepository.save(guideEntity);
        excursionRepository.deleteGuideFromAll(guideEntity);
    }
}
