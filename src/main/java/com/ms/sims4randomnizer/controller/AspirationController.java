package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.*;
import com.ms.sims4randomnizer.model.entities.*;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aspirations")
public class AspirationController {
    private AspirationRepository aspirationRepository;
    private AspirationAgeRepository aspirationAgeRepository;

    @Autowired
    public AspirationController(AspirationRepository aspirationRepository, AspirationAgeRepository aspirationAgeRepository){
        this.aspirationRepository = aspirationRepository;
        this.aspirationAgeRepository = aspirationAgeRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Aspiration>> getAllAspirations(){
        return new ResponseEntity<>(aspirationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/all/{ageName}")
    public ResponseEntity<List<Aspiration>>  getAllAspirationsByAge(@PathVariable String ageName){
        return new ResponseEntity<>(getAllAspirationsByAgeName(ageName, aspirationAgeRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/random/{age}")
    public ResponseEntity<Aspiration> getRandomAspirationByAge(@PathVariable String age){
        return new ResponseEntity<>(Randomizer.getAspiration(age, aspirationAgeRepository.findAll()), HttpStatus.OK);
    }

    //TODO add getaspirationByPack
    //TODO add aspirationByPackThenAge

    public static List<Aspiration> getAllAspirationsByAgeName(String ageName, List<AspirationAge> aspirationAgeRepository){
        List<Aspiration> aspirations = new ArrayList<>();
        List<AspirationAge> aspirationAges = aspirationAgeRepository.stream().filter(entry -> entry.getAge().getAgeName().equalsIgnoreCase(ageName)).toList();

        aspirationAges.forEach(entry -> aspirations.add(entry.getAspiration()));

        return aspirations;
    }
}
