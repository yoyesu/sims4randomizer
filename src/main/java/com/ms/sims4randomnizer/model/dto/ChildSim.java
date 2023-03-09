package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.model.enums.ChildAspiration;
import com.ms.sims4randomnizer.util.Randomizer;

public class ChildSim extends Sim{

    private ChildAspiration aspiration;

    public ChildSim(ChildAspiration aspiration) {
        super(Randomizer.getGender(), AgeGroup.CHILD, Randomizer.getChildSkillsToMax());
        this.aspiration = aspiration;
    }

    public ChildAspiration getAspiration() {
        return aspiration;
    }

    public void setAspiration(ChildAspiration aspiration) {
        this.aspiration = aspiration;
    }

    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                + "<br>Aspiration: " + aspiration
                ;
    }
}
