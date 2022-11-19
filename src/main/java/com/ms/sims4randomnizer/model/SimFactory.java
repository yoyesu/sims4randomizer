package com.ms.sims4randomnizer.model;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class SimFactory {

    public static Sim createSims(AgeGroup ageGroup) throws RuntimeException{
        switch(ageGroup){
            case TODDLER -> {
                return new ToddlerSim();
            }
            case CHILD -> {
                return new ChildSim();
            }
            case TEEN -> {
                return new TeenSim(getAspiration(), getRandomTeenJob(),getSexualPreference(), getSkillsToMax());
            }
            case ADULT, YOUNG_ADULT, ELDERLY -> {
                return new AdultSim(ageGroup, getAspiration(), getRandomJob(),getSexualPreference(),
                        getNumberOfChildren(), getSkillsToMax(), getMarriageStatus(), getNewWedding());
            }
            default -> throw new RuntimeException();
        }
    }
}