package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.Gender;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class ToddlerSim extends Sim {

    private final Object[] skillsToMax;

    public ToddlerSim(Gender gender, Age ageGroup, Object[] skillsToMax) {

        super(gender, ageGroup);
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
