package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.model.enums.AgeGroup;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class SimFactory {

    public static Sim createSims(AgeGroup ageGroup) throws RuntimeException{
        switch(ageGroup){
            case TODDLER -> {
                return new ToddlerSim();
            }
            case CHILD -> {
                return new ChildSim(getChildAspiration());
            }
            case TEEN -> {
                return new TeenSim(getAspiration(), getRandomTeenJob(),getSexualPreference());
            }
            case ADULT, YOUNG_ADULT, ELDERLY -> {
                return new AdultSim(ageGroup, getAspiration(), getRandomJob(),getSexualPreference(),
                        getNumberOfChildren(), getMarriageStatus(), getNewWedding());
            }
            default -> throw new RuntimeException();
        }
    }
}