package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.util.Randomizer;

public class ChildSim extends Sim{
    public ChildSim() {
        super(Randomizer.getGender(), AgeGroup.CHILD);
    }

    @Override
    public String toString() {
        return "ChildSim{" +
                "gender=" + gender +
                ", ageGroup=" + ageGroup +
                '}';
    }
}
