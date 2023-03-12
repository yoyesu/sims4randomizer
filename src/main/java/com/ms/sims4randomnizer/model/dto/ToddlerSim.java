package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.util.Randomizer;

public class ToddlerSim extends Sim {

    public ToddlerSim(Age age) {
        super(Randomizer.getGender(), age, Randomizer.getSkillsToMax());
    }

}
