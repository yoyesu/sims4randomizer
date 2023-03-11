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
public class NewSimController {

    @PostMapping("/new-sim")
    public ResponseEntity<GameSave> submitNewSimForm(@RequestBody PropertiesConfiguration config) {
        return ResponseEntity.status(HttpStatus.OK).body(GameSaveFactory.createGameSave("single", config));
    }
}
