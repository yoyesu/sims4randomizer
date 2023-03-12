package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ages")
public class AgeController {

    private static AgeRepository ageRepository;

    @Autowired
    public AgeController(AgeRepository ageRepository) {
        AgeController.ageRepository = ageRepository;
    }

    @GetMapping("/all")
    public static ResponseEntity<List<Age>> getAllAges(){
        return new ResponseEntity<>(ageRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/random")
    public static ResponseEntity<Age> getRandomAge(){
        PropertiesLoader.resetProperties();
        //TODO check this method works after one of the spring controllers has been used after setting a custom number for number of sims. This endpoint should always return ANY of the ages
        return new ResponseEntity<>(Randomizer.getRandomAgeGroup(PropertiesLoader.getNumberOfSims(), ageRepository.findAll()), HttpStatus.OK);
    }
}
