package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.model.SimFactory;
import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.view.Printer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@RestController
public class AppController {

    @GetMapping("/")
    public String index(){
        return "Sims generator";
    }

    @GetMapping("/starter-household")
    public String getStarterHousehold(){
        Household household = Generator.generateHousehold();
        List<Sim> sims = Generator.generateSims(household);
        return Printer.printResults(new GameSave(household, sims));
    }

    @GetMapping("new-sim")
    public String getRandomSim(){
        int chosenAge = loadConfiguration();
        int id = chosenAge > 0 && chosenAge < 7 ? chosenAge : new Random().nextInt(1,7);
        AgeGroup age = AgeGroup.getAgeById(id);
        assert age != null;
        Sim sim = SimFactory.createSims(age);

        return sim.toString();
    }

    private static int loadConfiguration() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/configuration.properties"));
            int age = Integer.parseInt(properties.getProperty("age"));
            return age;

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
