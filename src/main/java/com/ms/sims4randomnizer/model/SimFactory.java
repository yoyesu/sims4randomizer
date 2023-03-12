package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.model.entities.AspirationAge;
import com.ms.sims4randomnizer.model.entities.Gender;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.List;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class SimFactory {

    public static Sim createSims(Age ageGroup, List<AspirationAge> aspirationAgeRepository, List<Gender> genderRepository) throws RuntimeException{
        switch(ageGroup.getAgeId()){
            case 1 -> {
                return new ToddlerSim(ageGroup, Randomizer.getRandomGender(genderRepository));
            }
            case 2 -> {
                return new ChildSim(Randomizer.getRandomGender(genderRepository),ageGroup, getAspiration(ageGroup.getAgeName(), aspirationAgeRepository));
            }
            case 3 -> {
                return new TeenSim(Randomizer.getRandomGender(genderRepository), ageGroup, getAspiration(ageGroup.getAgeName(), aspirationAgeRepository), Randomizer.getRandomJob(ageGroup.getAgeName()),getSexualPreference());
            }
            case 4, 5, 6 -> {
                return new AdultSim(Randomizer.getRandomGender(genderRepository),ageGroup, getAspiration(ageGroup.getAgeName(),aspirationAgeRepository), Randomizer.getRandomJob(ageGroup.getAgeName()),getSexualPreference(),
                        getNumberOfChildren(), getMarriageStatus(), getNewWedding());
            }
            default -> throw new RuntimeException();
        }
    }
}