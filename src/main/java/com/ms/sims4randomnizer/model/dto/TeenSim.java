package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.entities.*;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class TeenSim extends Sim {
    private Aspiration aspiration;
    private Job job;
    private SexualPreference sexualPreference;

    public TeenSim(Gender gender, Age ageGroup, Aspiration aspiration, Job job, SexualPreference sexualPreference) {
        super(gender,ageGroup, Randomizer.getSkillsToMax());
        this.aspiration = aspiration;
        this.job = job;
        this.sexualPreference = sexualPreference;
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
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                + "<br>Aspiration: " + aspiration
                + "<br>Job: " + job
                + "<br>Sexual Preference: " + sexualPreference
                ;
    }
}
