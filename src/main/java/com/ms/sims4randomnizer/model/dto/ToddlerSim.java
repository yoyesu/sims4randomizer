package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.Gender;
import com.ms.sims4randomnizer.util.Randomizer;

public class ToddlerSim extends Sim {

    public ToddlerSim(Age age, Gender gender) {
        super(gender, age, Randomizer.getSkillsToMax());
    }

}
