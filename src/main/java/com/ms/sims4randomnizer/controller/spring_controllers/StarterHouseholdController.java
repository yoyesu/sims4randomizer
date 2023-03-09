package com.ms.sims4randomnizer.controller.spring_controllers;

import com.ms.sims4randomnizer.controller.PropertiesConfiguration;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.model.GameSaveFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StarterHouseholdController {

    @PostMapping("/starter-household")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody PropertiesConfiguration config) {
        return ResponseEntity.status(HttpStatus.OK).body(GameSaveFactory.createGameSave("multiple",config));
    }
}
