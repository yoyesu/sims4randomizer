package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class ChildSim extends Sim{
    public ChildSim() {
        super(Randomizer.getGender(), AgeGroup.CHILD);
    }

    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                ;
    }
}
