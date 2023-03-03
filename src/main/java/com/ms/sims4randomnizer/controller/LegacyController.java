package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.forms.StarterNewSimFormConfig;
import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.util.Generator;
import com.ms.sims4randomnizer.util.PropertiesLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LegacyController {

    @PostMapping("/legacy")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody StarterNewSimFormConfig config) {
        //get params from front-end --> IT'S THE REQUEST BODY
        PropertiesLoader.resetProperties();
        //map params to properties loader
        PropertiesLoader.setDifficulty(config.getDifficulty());
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setNumberOfStarterSims(config.getStarterSims());

        Household household = Generator.generateHousehold();
        List<Sim> sim = Generator.generateSims(household);
        sim.get(0).setHeir(true);
        //return json with household data
        return ResponseEntity.status(HttpStatus.OK).body(new GameSave(household,sim));
    }
}
