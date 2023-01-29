package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.controller.JobController;
import com.ms.sims4randomnizer.model.db_dtos.Age;
import com.ms.sims4randomnizer.model.dto.*;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class SimFactory {

    public static Sim createSims(Age ageGroup) throws RuntimeException{
        switch(ageGroup.getAgeId()){
            case 1 -> {
                return new ToddlerSim(getToddlerSkillsToMax());
            }
            case 2 -> {
                return new ChildSim(getChildAspiration(), getChildSkillsToMax());
            }
            case 3 -> {
                return new TeenSim(getAspiration(), JobController.getRandomJobByAge("teen"),getSexualPreference(), getSkillsToMax());
            }
            case 4, 5, 6 -> {
                return new AdultSim(ageGroup, getAspiration(), JobController.getRandomJobByAge("adult"),getSexualPreference(),
                        getNumberOfChildren(), getSkillsToMax(), getMarriageStatus(), getNewWedding());
            }
            default -> throw new RuntimeException();
        }
    }
}