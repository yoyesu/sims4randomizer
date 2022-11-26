package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.view.Printer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @GetMapping("/")
    public String index(){
        Household household = Generator.generateHousehold();
        List<Sim> sims = Generator.generateSims(household);
        return Printer.printResults(new GameSave(household, sims));
    }
}
