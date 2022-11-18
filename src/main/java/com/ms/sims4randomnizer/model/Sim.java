package com.ms.sims4randomnizer.model;

import java.util.List;

public class Sim {
    private String name;
    private String surname;
    private Gender gender;
    private AgeGroup ageGroup;
    private Aspiration aspiration;
    private Job job;
    private SexualPreference sexualPreference;
    private int children;
    private Object[] skillsToMax;
    private String isMarried;
    private String willMarry;

    public Sim(String name, String surname, Gender gender, AgeGroup ageGroup, Aspiration aspiration,
               Job job, SexualPreference sexualPreference, int children, Object[] skillsToMax,
               boolean isMarried, boolean willMarry) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.aspiration = aspiration;
        this.job = job;
        this.sexualPreference = sexualPreference;
        this.children = children;
        this.skillsToMax = skillsToMax;
        this.isMarried = isMarried ? "YES" : "NO";
        this.willMarry = willMarry ? "YES" : "NO";
    }

    public Sim(Gender gender, AgeGroup ageGroup, Aspiration aspiration,
               Job job, SexualPreference sexualPreference, int children, Object[] skillsToMax,
               boolean isMarried, boolean willMarry) {
        this.gender = gender;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
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
}
