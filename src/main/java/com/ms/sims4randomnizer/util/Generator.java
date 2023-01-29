package com.ms.sims4randomnizer.util;

import com.ms.sims4randomnizer.controller.AgeController;
import com.ms.sims4randomnizer.controller.forms.StarterNewSimFormConfig;
import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.model.SimFactory;

import java.util.ArrayList;
import java.util.List;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class Generator {


    public static Household generateHousehold(){
        return new Household(getLifeSpan(), getNumberOfStarterSims());
    }

    public static List<Sim> generateSims(Household household){
        List<Sim> sims = new ArrayList<>();
        int starterSims = household.getStarterSims();
        for(int i = 0; i < starterSims; i++){
            Sim sim = SimFactory.createSims(Randomizer.getRandomAgeGroup(starterSims));
            sims.add(sim);
        }

        return sims;
    }

    public static GameSave generateGameSaveForGeneralHousehold(StarterNewSimFormConfig config){
        //get params from front-end --> IT'S THE REQUEST BODY
        PropertiesLoader.resetProperties();
        //map params to properties loader
        PropertiesLoader.setDifficulty(config.getDifficulty());
        Randomizer.difficulty = Randomizer.getDifficulty();
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setNumberOfStarterSims(config.getStarterSims());

        Household household = Generator.generateHousehold();
        List<Sim> sim = Generator.generateSims(household);

        return new GameSave(household, sim);
    }

}
