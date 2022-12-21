package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.model.enums.Skill;
import com.ms.sims4randomnizer.model.enums.ToddlerSkills;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;
import java.util.List;

public class ToddlerSim extends Sim {

    private final Object[] skillsToMax;

    public ToddlerSim(Object[] skillsToMax) {

        super(Randomizer.getGender(), AgeGroup.TODDLER);
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
