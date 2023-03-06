package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.forms.StarterNewSimFormConfig;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.util.Generator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StarterHouseholdController {

    @PostMapping("/starter-household")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody StarterNewSimFormConfig config) {
        return ResponseEntity.status(HttpStatus.OK).body(Generator.generateGameSaveForGeneralHousehold(config));
    }
}
