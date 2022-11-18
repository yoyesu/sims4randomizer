package com.ms.sims4randomnizer;

import com.ms.sims4randomnizer.controller.Generator;
import com.ms.sims4randomnizer.model.Household;
import com.ms.sims4randomnizer.model.Sim;
import com.ms.sims4randomnizer.util.Randomizer;
import com.ms.sims4randomnizer.view.Printer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.ms.sims4randomnizer.util.Randomizer.*;

@SpringBootApplication
public class Sims4RandomnizerApplication {

    public static void main(String[] args) {


        SpringApplication.run(Sims4RandomnizerApplication.class, args);


        Printer.printResults(Generator.generateHousehold(), Generator.generateSims());
    }

}
