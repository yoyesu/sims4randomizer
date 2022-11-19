package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class ToddlerSim extends Sim{

    public ToddlerSim() {
        super(Randomizer.getGender(), AgeGroup.TODDLER);
    }

    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                ;
    }
}
