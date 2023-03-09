package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.entities.*;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class TeenSim extends Sim {
    private Aspiration aspiration;
    private Job job;
    private SexualPreference sexualPreference;
    private Object[] skillsToMax;

    public TeenSim(Gender gender, Age ageGroup, Aspiration aspiration, Job job, SexualPreference sexualPreference, Object[] skillsToMax) {
        super(gender,ageGroup);
        this.aspiration = aspiration;
        this.job = job;
        this.sexualPreference = sexualPreference;
        this.skillsToMax = skillsToMax;
    }

    public Aspiration getAspiration() {
        return aspiration;
    }

    public Job getJob() {
        return job;
    }

    public SexualPreference getSexualPreference() {
        return sexualPreference;
    }

    @Override
    public Object[] getSkills() {

        return skillsToMax;
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
