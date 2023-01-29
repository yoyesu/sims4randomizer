package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.db_dtos.*;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class AdultSim extends Sim {
    public Aspiration aspiration;
    private Job job;
    private SexualPreference sexualPreference;
    private int children;
    private Object[] skillsToMax;
    private String isMarried;
    private String willMarry;

    public AdultSim(Age ageGroup, Aspiration aspiration,
                    Job job, SexualPreference sexualPreference, int children, Object[] skillsToMax,
                    boolean isMarried, boolean willMarry) {
        super(new Gender(),ageGroup);
        this.ageGroup = ageGroup;
        this.aspiration = aspiration;
        this.job = job;
        this.sexualPreference = sexualPreference;
        this.children = children;
        this.skillsToMax = skillsToMax;
        this.isMarried = isMarried ? "YES" : "NO";
        this.willMarry = willMarry ? "YES" : "NO";
    }

    ////////////////// getters & setters //////////////////////////

    public Aspiration getAspiration() {
        return aspiration;
    }

    public void setAspiration(Aspiration aspiration) {
        this.aspiration = aspiration;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public SexualPreference getSexualPreference() {
        return sexualPreference;
    }

    public void setSexualPreference(SexualPreference sexualPreference) {
        this.sexualPreference = sexualPreference;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    @Override
    public Object[] getSkills() {
        return skillsToMax;
    }
    public void setSkillsToMax(String[] skillsToMax) {
        this.skillsToMax = skillsToMax;
    }

    public String getIsMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        this.isMarried = married ? "Yes" : "No";
    }

    public String getWillMarry() {
        return willMarry;
    }

    public void setWillMarry(boolean willMarry) {
        this.willMarry = willMarry ? "Yes" : "No";
    }

    ///////////////////////////END getters & setters ////////////////////////////////////


    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "\nGender: " + gender
                + "\nAspiration: " + aspiration
                + "\nJob: " + job
//                + "\nJob level: " + job.getLevel()
                + "\nSexual Preference: " + sexualPreference
                + "\nChildren: " + children
                + "\nSkills they need to Max: " + Arrays.toString(skillsToMax)
                + "\nAre they Married?: " + isMarried
                + "\nWill they marry ever o again?: " + willMarry
                ;
    }
}
