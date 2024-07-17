package org.example.controllers;

import org.example.dtos.GuideDTO;
import org.example.services.GuideService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("guide")
public class GuideController {
    private final GuideService guideService;

    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @PatchMapping("fire")
    public void fire(@RequestBody GuideDTO guideDTO){
        guideService.fireGuide(guideDTO);
    }


}
