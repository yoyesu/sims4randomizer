package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.db_dtos.Age;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class ToddlerSim extends Sim {

    private final Object[] skillsToMax;

    public ToddlerSim(Age ageGroup, Object[] skillsToMax) {

        super(Randomizer.getGender(), ageGroup);
        this.skillsToMax = skillsToMax;
    }

    public Object[] getSkillsToMax() {
        return skillsToMax;
    }

    @Override
    public Object[] getSkills() {

        return skillsToMax;
    }

    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                + "<br>Skills they need to Max: " + Arrays.toString(skillsToMax)
                ;
    }
}
