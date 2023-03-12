package com.ms.sims4randomnizer.controller.spring_controllers;

import com.ms.sims4randomnizer.controller.PropertiesConfiguration;
import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.controller.repositories.AspirationAgeRepository;
import com.ms.sims4randomnizer.controller.repositories.GenderRepository;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.model.GameSaveFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StarterHouseholdController {

    private AgeRepository ageRepository;
    private AspirationAgeRepository aspirationAgeRepository;
    private GenderRepository genderRepository;

    @Autowired
    public StarterHouseholdController(AgeRepository ageRepository, AspirationAgeRepository aspirationAgeRepository, GenderRepository genderRepository) {
        this.ageRepository = ageRepository;
        this.aspirationAgeRepository = aspirationAgeRepository;
        this.genderRepository = genderRepository;
    }

    @PostMapping("/starter-household")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody PropertiesConfiguration config) {
        return ResponseEntity.status(HttpStatus.OK).body(GameSaveFactory.createGameSave("multiple",config, ageRepository.findAll(),aspirationAgeRepository.findAll(), genderRepository.findAll()));
    }
}
