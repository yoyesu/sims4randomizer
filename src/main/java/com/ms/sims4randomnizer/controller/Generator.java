package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.model.Household;
import com.ms.sims4randomnizer.model.Sim;

import java.util.ArrayList;
import java.util.List;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class Generator {

    public static Household generateHousehold(){
        Household household = new Household(getRandomLifeSpan(), getNumberOfStarterSims());
        return household;
    }

    public static List<Sim> generateSims(){
        List<Sim> sims = new ArrayList<>();
        for(int i = 0; i < generateHousehold().getStarterSims(); i++){
            Sim sim = new Sim(getGender(),getRandomAgeGroup(), getAspiration(), getRandomJob(),getSexualPreference(),
                    getNumberOfChildren(), getSkillsToMax(), getMarriageStatus(), getNewWedding());
            sims.add(sim);
        }

        return sims;
    }
}
