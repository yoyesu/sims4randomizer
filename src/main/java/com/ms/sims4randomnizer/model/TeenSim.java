package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class TeenSim extends Sim{
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

    @Override
    public String toString() {
        return "TeenSim{" +
                "aspiration=" + aspiration +
                ", job=" + job +
                ", sexualPreference=" + sexualPreference +
                ", skillsToMax=" + Arrays.toString(skillsToMax) +
                ", gender=" + gender +
                ", ageGroup=" + ageGroup +
                '}';
    }
}
