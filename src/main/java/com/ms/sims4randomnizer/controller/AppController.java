package com.ms.sims4randomnizer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.ms.sims4randomnizer.model.NewSimFormConfig;
import com.ms.sims4randomnizer.model.SimFactory;
import com.ms.sims4randomnizer.model.StarterFormConfig;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.model.enums.Gender;
import com.ms.sims4randomnizer.util.Randomizer;
import com.ms.sims4randomnizer.view.Printer;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RestController
public class AppController {

    @PostMapping("/test/new-sim")
    public ResponseEntity<NewSimFormConfig> submitNewSimForm() throws JsonProcessingException {
        //get params from front-end

        //map params to an object
        ObjectMapper mapper = new ObjectMapper();

        NewSimFormConfig config = new NewSimFormConfig();
        //return object
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }

    @PostMapping("/new-sim")
    public ResponseEntity<GameSave> submitNewSimForm(@RequestBody NewSimFormConfig config) throws JsonProcessingException {
        //get params from front-end --> IT'S THE REQUEST BODY

        //map params to properties loader
        System.out.println("request body " + config.toString());
        PropertiesLoader.setIsSingleSimMode(1);
        PropertiesLoader.setGenderOfSim(config.getGender());
        PropertiesLoader.setDifficulty(config.getDifficulty());
        System.out.println("Lifespan in config: " + config.getLifespan());
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setSimAge(config.getAge());

        PropertiesLoader.loadConfiguration();

        Household household = Generator.generateHousehold();
        household.setStarterSims(1);
        List<Sim> sim = Generator.generateSims(household);

        System.out.println(new GameSave(household,sim).getDifficulty());
        //return json with new sim data
        return ResponseEntity.status(HttpStatus.OK).body(new GameSave(household,sim));
    }

//    @GetMapping("/new-sim")
//    public String sendNewSimResults() throws JsonProcessingException {
//        //get object
//
//        //send object values into logic
//
//        //get logic results
//
//        //convert logic results into JSON
//        ObjectMapper mapper = new ObjectMapper();
//        String result = mapper.writeValueAsString(Randomizer.getRandomAgeGroup());
//
//        PropertiesLoader.setIsSingleSimMode(1);
////        PropertiesLoader properties = new PropertiesLoader();
////        PropertiesLoader.setGenderOfSim(config.getGender());
////        PropertiesLoader.setDifficulty(config.getDifficulty());
////        PropertiesLoader.setLifeSpanType(config.getLifespan());
////        PropertiesLoader.setSimAge(config.getAge());
//
//        PropertiesLoader.loadConfiguration();
//
//        Household household = Generator.generateHousehold();
//        household.setStarterSims(1);
//        List<Sim> sim = Generator.generateSims(household);
//
//        if(sim.get(0) instanceof AdultSim adult){
////            model.addAttribute("adult", adult);
//        } else if(sim.get(0) instanceof ChildSim child){
////            model.addAttribute("child", child);
//        } else if(sim.get(0) instanceof TeenSim teen){
////            model.addAttribute("teen", teen);
//        } else if(sim.get(0) instanceof ToddlerSim toddler){
////            model.addAttribute("toddler", toddler);
//        }
//
////        model.addAttribute("sim", sim);
////        model.addAttribute("household", household);
////        model.addAttribute("game", new GameSave(household, sim));
//
////        return "new-sim-results";
//        return result;
//    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("generators", "Sims generator");
        return "index";
    }

    @GetMapping("/starter-household")
    public String getStarterHousehold(Model model){

        model.addAttribute("config", StarterFormConfig.getInstance());
        PropertiesLoader.setIsSingleSimMode(0);
        PropertiesLoader.loadConfiguration();
        return "starter-household";
    }

    @PostMapping("/starter-household/results")
    public String submitForm(@ModelAttribute("config") StarterFormConfig config, Model model) {
        PropertiesLoader.setNumberOfStarterSims(config.getStarterSims());
        PropertiesLoader.setDifficulty(config.getDifficulty());
        PropertiesLoader.setLifeSpanType(config.getLifespan());

        PropertiesLoader.loadConfiguration();
        Household household = Generator.generateHousehold();
        List<Sim> sims = Generator.generateSims(household);
        List<AdultSim> adults = new ArrayList<>();
        List<TeenSim> teens = new ArrayList<>();
        List<ChildSim> children = new ArrayList<>();
        List<ToddlerSim> toddlers = new ArrayList<>();

        for(Sim sim : sims){
            if(sim instanceof AdultSim){
                adults.add((AdultSim) sim);
                model.addAttribute("adults", adults);
            } else if(sim instanceof ChildSim){
                children.add((ChildSim) sim);
                model.addAttribute("children", children);
            } else if(sim instanceof TeenSim){
                teens.add((TeenSim) sim);
                model.addAttribute("teens", teens);
            } else if(sim instanceof ToddlerSim){
                toddlers.add((ToddlerSim) sim);
                model.addAttribute("toddlers", toddlers);
            }
        }


        model.addAttribute("household", household);
        model.addAttribute("game", new GameSave(household, sims));
        return "starter-household-results";
    }

    @ModelAttribute("multiCheckboxAllValues")
    public String[] getMultiCheckboxAllValues() {
        return new String[] {
                "0", "1", "2", "3",
                "4", "5", "6", "7", "8"
        };
    }
}
