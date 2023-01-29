package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.model.db_dtos.Age;
import com.ms.sims4randomnizer.model.enums.Difficulty;
import com.ms.sims4randomnizer.util.PropertiesLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

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
        Difficulty difficulty = Difficulty.values()[PropertiesLoader.getDifficulty()];
//        int starterSims = PropertiesLoader.getNumberOfStarterSims();
        int age = PropertiesLoader.getSimAge();
        int origin = 0;
        int bound = ageRepository.findAll().size();
        if(starterSims == 1 && (difficulty == Difficulty.EASY || difficulty == Difficulty.NORMAL) || difficulty == Difficulty.EASY){
            origin = ageRepository.findAgeByAgeNameEqualsIgnoreCase("young adult").getAgeId() -1;
            bound = ageRepository.findAgeByAgeNameEqualsIgnoreCase("elder").getAgeId();
        } else if (starterSims == 1 && difficulty == Difficulty.HARD){
            origin = ageRepository.findAgeByAgeNameEqualsIgnoreCase("elder").getAgeId() -1;
            bound = ageRepository.findAgeByAgeNameEqualsIgnoreCase("elder").getAgeId();
        } else if(starterSims > 1 && difficulty == Difficulty.NORMAL){
            origin = ageRepository.findAgeByAgeNameEqualsIgnoreCase("young adult").getAgeId() -1;
            bound = ageRepository.findAgeByAgeNameEqualsIgnoreCase("elder").getAgeId();
        }

        int id = age == -1 ? new Random().nextInt(origin, bound) : age;
        return ageRepository.findById(id).orElseThrow();
    }
}
