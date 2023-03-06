package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.forms.StarterNewSimFormConfig;
import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.util.Generator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegacyController {

    @PostMapping("/legacy")
    public ResponseEntity<GameSave> submitStarterHouseholdForm(@RequestBody StarterNewSimFormConfig config) {
        GameSave gameSave = Generator.generateGameSaveForGeneralHousehold(config);
        gameSave.getSims().get(0).setHeir(true);

        return ResponseEntity.status(HttpStatus.OK).body(gameSave);
    }
}
