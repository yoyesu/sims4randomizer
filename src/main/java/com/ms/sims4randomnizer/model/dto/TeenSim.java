package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.model.enums.Aspiration;
import com.ms.sims4randomnizer.model.enums.SexualPreference;
import com.ms.sims4randomnizer.model.enums.TeenJob;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class TeenSim extends Sim {
    private Aspiration aspiration;
    private TeenJob job;
    private SexualPreference sexualPreference;
    private Object[] skillsToMax;

    public TeenSim(Aspiration aspiration, TeenJob job, SexualPreference sexualPreference, Object[] skillsToMax) {
        super(Randomizer.getGender(), AgeGroup.TEEN);
        this.aspiration = aspiration;
        this.job = job;
        this.sexualPreference = sexualPreference;
        this.skillsToMax = skillsToMax;
    }

    public Aspiration getAspiration() {
        return aspiration;
    }

    public TeenJob getJob() {
        return job;
    }

    public SexualPreference getSexualPreference() {
        return sexualPreference;
    }

//    public Object[] getSkillsToMax() {
//        return skillsToMax;
//    }

    @Override
    public String getSkills() {

        return Arrays.toString(skillsToMax);
    }

    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                + "<br>Aspiration: " + aspiration
                + "<br>Job: " + job
                + "<br>Sexual Preference: " + sexualPreference
                + "<br>Skills they need to Max: " + Arrays.toString(skillsToMax)
                ;
    }
}
