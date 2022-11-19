package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.model.Household;
import com.ms.sims4randomnizer.model.AdultSim;
import com.ms.sims4randomnizer.model.Sim;
import com.ms.sims4randomnizer.model.SimFactory;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class Generator {

    public static Household generateHousehold(){
        Household household = new Household(getRandomLifeSpan(), getNumberOfStarterSims(9));
        return household;
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
