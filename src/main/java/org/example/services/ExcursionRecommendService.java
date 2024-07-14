package org.example.services;

import org.example.dtos.ClientDTO;
import org.example.dtos.ExcursionDTO;
import org.example.entities.ExcursionEntity;

import java.util.List;

public interface ExcursionRecommendService {
    List<ExcursionEntity> recommendExcursions(ClientDTO clientDTO);
}
