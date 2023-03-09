package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.GenderRepository;
import com.ms.sims4randomnizer.model.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {

    private GenderRepository genderRepository;

    @Autowired
    public GenderController(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gender>> getAllCountries(){
        return getListOfAllCountries(genderRepository);
    }

    @GetMapping("/random")
    public ResponseEntity<Gender> getRandomGender(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static ResponseEntity<List<Gender>> getListOfAllCountries(GenderRepository genderRepository) {
        return new ResponseEntity<>(genderRepository.findAll(), HttpStatus.OK);
    }
}