package com.ms.sims4randomnizer;

import com.ms.sims4randomnizer.controller.Generator;
import com.ms.sims4randomnizer.model.GameSave;
import com.ms.sims4randomnizer.model.Household;
import com.ms.sims4randomnizer.model.AdultSim;
import com.ms.sims4randomnizer.model.Sim;
import com.ms.sims4randomnizer.view.Printer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Sims4RandomnizerApplication {

    public static void main(String[] args) {


        SpringApplication.run(Sims4RandomnizerApplication.class, args);

        Household household = Generator.generateHousehold();
        List<Sim> sims = Generator.generateSims(household);
        Printer.printResults(new GameSave(household, sims));
    }

}
