package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.*;
import com.ms.sims4randomnizer.model.entities.*;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aspirations")
public class AspirationController {
    private AspirationRepository aspirationRepository;
    private AspirationAgeRepository aspirationAgeRepository;
    private AgeRepository ageRepository;

    @Autowired
    public AspirationController(AspirationRepository aspirationRepository, AspirationAgeRepository aspirationAgeRepository, AgeRepository ageRepository){
        this.aspirationRepository = aspirationRepository;
        this.aspirationAgeRepository = aspirationAgeRepository;
        this.ageRepository = ageRepository;
    }

    @GetMapping("/all")
    public List<Aspiration> getAllAspirations(){
        return aspirationRepository.findAll();
    }

    @GetMapping("/all/{ageName}")
    public List<Aspiration> getAllAspirationsByAge(@PathVariable String ageName){
        return getAllAspirationsByAgeName(ageName, aspirationAgeRepository);
    }

    @GetMapping("/random/{age}")
    public Aspiration getRandomAspirationByAge(@PathVariable String age){
        return Randomizer.getAspiration(age);
    }

    public static List<Aspiration> getAllAspirationsByAgeName(String ageName, AspirationAgeRepository aspirationAgeRepository){
        List<Aspiration> aspirations = new ArrayList<>();
        List<AspirationAge> aspirationAges = aspirationAgeRepository.findAll().stream().filter(entry -> entry.getAge().getAgeName().equalsIgnoreCase(ageName)).toList();

        aspirationAges.forEach(entry -> aspirations.add(entry.getAspiration()));

        return aspirations;
    }
}
