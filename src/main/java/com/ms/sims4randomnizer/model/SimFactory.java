package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.controller.JobController;
import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.util.Randomizer;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class SimFactory {

    public static Sim createSims(Age ageGroup) throws RuntimeException{
        switch(ageGroup.getAgeId()){
            case 1 -> {
                return new ToddlerSim(getGender(),ageGroup, getSkillsToMax());
            }
            case 2 -> {
                return new ChildSim(Randomizer.getGender(),ageGroup, getAspiration(ageGroup.getAgeName()), getSkillsToMax());
            }
            case 3 -> {
                return new TeenSim(Randomizer.getGender(), ageGroup, getAspiration(ageGroup.getAgeName()), Randomizer.getRandomJob(ageGroup.getAgeName()),getSexualPreference(), getSkillsToMax());
            }
            case 4, 5, 6 -> {
                return new AdultSim(Randomizer.getGender(),ageGroup, getAspiration(ageGroup.getAgeName()), Randomizer.getRandomJob(ageGroup.getAgeName()),getSexualPreference(),
                        getNumberOfChildren(), getSkillsToMax(), getMarriageStatus(), getNewWedding());
            }
            default -> throw new RuntimeException();
        }
    }
}