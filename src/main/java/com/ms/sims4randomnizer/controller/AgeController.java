package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
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
    public static List<Age> getAllAges(){
        return ageRepository.findAll();
    }

    @GetMapping("/random")
    public static Age getRandomAge(int starterSims){
        return Randomizer.getRandomAgeGroup(starterSims, ageRepository.findAll());
    }
}
