package com.ms.sims4randomnizer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ms.sims4randomnizer.model.NewSimFormConfig;
import com.ms.sims4randomnizer.model.StarterFormConfig;
import com.ms.sims4randomnizer.model.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class AppController {

    @PostMapping("/new-sim")
    public ResponseEntity<GameSave> submitNewSimForm(@RequestBody NewSimFormConfig config) throws JsonProcessingException {
        //get params from front-end --> IT'S THE REQUEST BODY

        //map params to properties loader
        PropertiesLoader.setIsSingleSimMode(1);
        PropertiesLoader.setGenderOfSim(config.getGender());
        PropertiesLoader.setDifficulty(config.getDifficulty());
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setSimAge(config.getAge());
        PropertiesLoader.setAspiration(config.getAspiration());
        PropertiesLoader.setJob(config.getJob());

        PropertiesLoader.loadConfiguration();

        Household household = Generator.generateHousehold();
        household.setStarterSims(1);
        List<Sim> sim = Generator.generateSims(household);

        //return json with new sim data
        return ResponseEntity.status(HttpStatus.OK).body(new GameSave(household,sim));
    }

    @PostMapping("/starter-household")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody NewSimFormConfig config) throws JsonProcessingException {
        //get params from front-end --> IT'S THE REQUEST BODY

        //map params to properties loader
        PropertiesLoader.setIsSingleSimMode(0);
        PropertiesLoader.setDifficulty(config.getDifficulty());
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setNumberOfStarterSims(config.getStarterSims());
        PropertiesLoader.loadConfiguration();

        Household household = Generator.generateHousehold();
        List<Sim> sim = Generator.generateSims(household);

        //return json with new sim data
        return ResponseEntity.status(HttpStatus.OK).body(new GameSave(household,sim));
    }
}
