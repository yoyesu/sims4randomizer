package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.forms.StarterNewSimFormConfig;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.util.Generator;
import com.ms.sims4randomnizer.util.PropertiesLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class StarterHouseholdController {

    @PostMapping("/starter-household")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody StarterNewSimFormConfig config) {
        //get params from front-end --> IT'S THE REQUEST BODY

        //map params to properties loader
        PropertiesLoader.setDifficulty(config.getDifficulty());
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setNumberOfStarterSims(config.getStarterSims());

        Household household = Generator.generateHousehold();
        List<Sim> sim = Generator.generateSims(household);

        //return json with household data
        return ResponseEntity.status(HttpStatus.OK).body(new GameSave(household,sim));
    }
}
