package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.forms.StarterNewSimFormConfig;
import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.util.Generator;
import com.ms.sims4randomnizer.util.PropertiesLoader;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewSimController {

    @PostMapping("/new-sim")
    public ResponseEntity<GameSave> submitNewSimForm(@RequestBody StarterNewSimFormConfig config) {
        //get params from front-end --> IT'S THE REQUEST BODY

        //map params to properties loader
        PropertiesLoader.setGenderOfSim(config.getGender());
        PropertiesLoader.setDifficulty(config.getDifficulty());
        Randomizer.difficulty = Randomizer.getDifficulty();
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setSimAge(config.getAge());
        PropertiesLoader.setAspiration(config.getAspiration());
        PropertiesLoader.setJob(config.getJob());
        PropertiesLoader.setChildrenToHave(config.getChildren());
        PropertiesLoader.setAlreadyMarried(config.getIsMarried());
        PropertiesLoader.setWedding(config.getWillMarry());
        PropertiesLoader.setSexuality(config.getSexuality());
        PropertiesLoader.setJobLevel(config.getJobLevel());
        PropertiesLoader.setMaxNumberOfSkills(config.getSkillsArrayLength());

        Household household = Generator.generateHousehold();
        household.setStarterSims(1);
        List<Sim> sim = Generator.generateSims(household);

        //return json with new sim data
        return ResponseEntity.status(HttpStatus.OK).body(new GameSave(household,sim));
    }
}
