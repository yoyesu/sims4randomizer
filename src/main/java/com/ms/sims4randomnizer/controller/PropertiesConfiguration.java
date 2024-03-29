package com.ms.sims4randomnizer.controller;

public class PropertiesConfiguration {

    private int difficulty;
    private int lifespan;
    private int starterSims;
    private int aspiration;
    private int gender;
    private int age;
    private int job;
    private int jobLevel;
    private int sexuality;
    private int[] skills;
    private int skillsArrayLength;
    private int children;
    private int isMarried;
    private int willMarry;

    public PropertiesConfiguration() {
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public int getStarterSims() {
        return starterSims;
    }

    public void setStarterSims(int starterSims) {
        this.starterSims = starterSims;
    }

    public int getAspiration() {
        return aspiration;
    }

    public int getJob() {
        return job;
    }

    public int getJobLevel() {
        return jobLevel;
    }

    public int getSexuality() {
        return sexuality;
    }

    public int[] getSkills() {
        return skills;
    }

    public int getChildren() {
        return children;
    }

    public int getIsMarried() {
        return isMarried;
    }

    public int getWillMarry() {
        return willMarry;
    }

    public int getSkillsArrayLength() {
        return skillsArrayLength;
    }
}
