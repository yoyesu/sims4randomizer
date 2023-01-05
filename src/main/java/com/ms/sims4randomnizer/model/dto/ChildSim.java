package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.model.enums.ChildAspiration;
import com.ms.sims4randomnizer.util.Randomizer;

public class ChildSim extends Sim{

    private ChildAspiration aspiration;
    private Object[] skillsToMax; //skills the sim has to develop to the max level

    public ChildSim(ChildAspiration aspiration, Object[] skillsToMax) {
        super(Randomizer.getGender(), AgeGroup.CHILD);
        this.aspiration = aspiration;
        this.skillsToMax = skillsToMax;
    }

    ////////////// GETTERS & SETTERS /////////////////
    public ChildAspiration getAspiration() {
        return aspiration;
    }

    public void setAspiration(ChildAspiration aspiration) {
        this.aspiration = aspiration;
    }

    public Object[] getSkillsToMax() {
        return skillsToMax;
    }

    public void setSkillsToMax(String[] skillsToMax) {
        this.skillsToMax = skillsToMax;
    }

    ////////////////////// END GETTERS & SETTERS ////////////////////////////////

    @Override
    public Object[] getSkills() {

        return skillsToMax;
    }

    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                + "<br>Aspiration: " + aspiration
                ;
    }
}
