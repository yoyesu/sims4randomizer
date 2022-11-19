package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.util.Randomizer;

import java.util.Arrays;

public class AdultSim extends Sim {
    private Aspiration aspiration;
    private Job job;
    private SexualPreference sexualPreference;
    private int children;
    private Object[] skillsToMax;
    private String isMarried;
    private String willMarry;

    public AdultSim(AgeGroup ageGroup, Aspiration aspiration,
                    Job job, SexualPreference sexualPreference, int children, Object[] skillsToMax,
                    boolean isMarried, boolean willMarry) {
        super(Randomizer.getGender(),ageGroup);
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

    public Object[] getSkillsToMax() {
        return skillsToMax;
    }

    public void setSkillsToMax(Object[] skillsToMax) {
        this.skillsToMax = skillsToMax;
    }

    public String isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        this.isMarried = married ? "YES" : "NO";
    }

    public String willMarry() {
        return willMarry;
    }

    public void setWillMarry(boolean willMarry) {
        this.willMarry = willMarry ? "YES" : "NO";
    }

    ///////////////////////////END getters & setters ////////////////////////////////////


    @Override
    public String toString() {
        return "Age: " + ageGroup
                + "<br>Gender: " + gender
                + "<br>Aspiration: " + aspiration
                + "<br>Job: " + job
                + "<br>Sexual Preference: " + sexualPreference
                + "<br>Children: " + children
                + "<br>Skills they need to Max: " + Arrays.toString(skillsToMax)
                + "<br>Are they Married?: " + isMarried
                + "<br>Will they marry ever o again?: " + willMarry
                ;
    }
}
