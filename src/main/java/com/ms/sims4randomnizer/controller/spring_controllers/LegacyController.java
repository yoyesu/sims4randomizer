package com.ms.sims4randomnizer.controller.spring_controllers;

import com.ms.sims4randomnizer.controller.PropertiesConfiguration;
import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.GameSaveFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegacyController {

    @PostMapping("/legacy")
    public ResponseEntity<GameSave> submitLegacyHouseholdForm(@RequestBody PropertiesConfiguration config) {
        GameSave gameSave = GameSaveFactory.createGameSave("multiple",config);
        gameSave.getHousehold().getSims().get(0).setHeir(true);

        return ResponseEntity.status(HttpStatus.OK).body(gameSave);
    }
}
