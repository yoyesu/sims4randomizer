package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.forms.StarterNewSimFormConfig;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.util.Generator;
import com.ms.sims4randomnizer.util.PropertiesLoader;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class StarterHouseholdController {

    @PostMapping("/starter-household")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody StarterNewSimFormConfig config) {
        //return json with household data
        return ResponseEntity.status(HttpStatus.OK).body(Generator.generateGameSaveForGeneralHousehold(config));
    }
}
