package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.util.Randomizer;

public class ToddlerSim extends Sim {

    public ToddlerSim() {
        super(Randomizer.getGender(), AgeGroup.TODDLER, Randomizer.getToddlerSkillsToMax());
    }

}
