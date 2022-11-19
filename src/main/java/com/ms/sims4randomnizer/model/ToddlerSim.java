package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.util.Randomizer;

public class ToddlerSim extends Sim{

    public ToddlerSim() {
        super(Randomizer.getGender(), AgeGroup.TODDLER);
    }

    @Override
    public String toString() {
        return "ToddlerSim{" +
                "gender=" + gender +
                ", ageGroup=" + ageGroup +
                '}';
    }
}
