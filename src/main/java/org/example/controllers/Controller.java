package org.example.controllers;

import org.example.dtos.ClientDTO;
import org.example.entities.ExcursionEntity;
import org.example.services.ExcursionRecommendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/controller")
public class Controller {
    private final ExcursionRecommendService excursionRecommendService;

    public Controller(ExcursionRecommendService excursionRecommendService) {
        this.excursionRecommendService = excursionRecommendService;
    }

    @GetMapping("/get")
    public List<ExcursionEntity> get(@RequestBody ClientDTO clientDTO){
        return excursionRecommendService.recommendExcursions(clientDTO);
    }

}
