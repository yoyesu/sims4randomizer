package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.model.SimFactory;
import com.ms.sims4randomnizer.util.Randomizer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class Generator {


    public static Household generateHousehold(){
        return new Household(getRandomLifeSpan(), getNumberOfStarterSims());
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

}
