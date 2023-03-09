package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.Aspiration;
import com.ms.sims4randomnizer.model.entities.Gender;
import com.ms.sims4randomnizer.util.Randomizer;

public class ChildSim extends Sim{

    private Aspiration aspiration;
    private Object[] skillsToMax; //skills the sim has to develop to the max level

    public ChildSim(Gender gender, Age ageGroup, Aspiration aspiration, Object[] skillsToMax) {
        super(gender, ageGroup);
        this.aspiration = aspiration;
        this.skillsToMax = skillsToMax;
    }

    ////////////// GETTERS & SETTERS /////////////////
    public Aspiration getAspiration() {
        return aspiration;
    }

    public void setAspiration(Aspiration aspiration) {
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
