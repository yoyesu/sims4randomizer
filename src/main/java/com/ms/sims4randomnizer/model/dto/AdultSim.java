package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.*;
import com.ms.sims4randomnizer.util.Randomizer;

public class AdultSim extends Sim {
    public Aspiration aspiration;
    private Job job;
    private SexualPreference sexualPreference;
    private int children;
    private String isMarried;
    private String willMarry;

    public AdultSim(AgeGroup ageGroup, Aspiration aspiration,
                    Job job, SexualPreference sexualPreference, int children,
                    boolean isMarried, boolean willMarry) {
        super(Randomizer.getGender(),ageGroup, Randomizer.getSkillsToMax());
        this.ageGroup = ageGroup;
        this.aspiration = aspiration;
        this.job = job;
        this.sexualPreference = sexualPreference;
        this.children = children;
        this.isMarried = isMarried ? "YES" : "NO";
        this.willMarry = willMarry ? "YES" : "NO";
    }

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


    @Override
    public String toString() {
        return "AdultSim{" +
                "aspiration=" + aspiration +
                ", job=" + job +
                ", sexualPreference=" + sexualPreference +
                ", children=" + children +
                ", isMarried='" + isMarried + '\'' +
                ", willMarry='" + willMarry + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", ageGroup=" + ageGroup +
                ", skills=" + skillsToMaster +
                ", isHeir=" + isHeir +
                '}';
    }
}
