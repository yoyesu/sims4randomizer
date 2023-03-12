package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.controller.JobController;
import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.model.entities.AspirationAge;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.List;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class SimFactory {

    public static Sim createSims(Age ageGroup, List<AspirationAge> aspirationAgeRepository) throws RuntimeException{
        switch(ageGroup.getAgeId()){
            case 1 -> {
                return new ToddlerSim(ageGroup);
            }
            case 2 -> {
                return new ChildSim(Randomizer.getGender(),ageGroup, getAspiration(ageGroup.getAgeName(), aspirationAgeRepository));
            }
            case 3 -> {
                return new TeenSim(Randomizer.getGender(), ageGroup, getAspiration(ageGroup.getAgeName(), aspirationAgeRepository), Randomizer.getRandomJob(ageGroup.getAgeName()),getSexualPreference());
            }
            case 4, 5, 6 -> {
                return new AdultSim(Randomizer.getGender(),ageGroup, getAspiration(ageGroup.getAgeName(),aspirationAgeRepository), Randomizer.getRandomJob(ageGroup.getAgeName()),getSexualPreference(),
                        getNumberOfChildren(), getMarriageStatus(), getNewWedding());
            }
            default -> throw new RuntimeException();
        }
    }
}