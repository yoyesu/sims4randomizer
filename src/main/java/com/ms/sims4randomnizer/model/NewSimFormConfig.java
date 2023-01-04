package com.ms.sims4randomnizer.model;

import java.util.Arrays;

public class NewSimFormConfig {

    private int difficulty;
    private int lifespan;
    private int starterSims;
    private int aspiration;
    private int gender;
    private int age = -1;
    private int job;
    private int jobLevel;
    private int sexuality;
    private int[] skills;
    private int skillsArrayLength;
    private int children;
    private int isMarried;
    private int willMarry;

    public NewSimFormConfig() {
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

    @Override
    public String toString() {
        return "NewSimFormConfig{" +
                "difficulty=" + difficulty +
                ", lifespan=" + lifespan +
                ", starterSims=" + starterSims +
                ", aspiration=" + aspiration +
                ", gender=" + gender +
                ", age=" + age +
                ", job=" + job +
                ", jobLevel=" + jobLevel +
                ", sexuality=" + sexuality +
                ", skills=" + Arrays.toString(skills) +
                ", children=" + children +
                ", isMarried=" + isMarried +
                ", willMarry=" + willMarry +
                '}';
    }
}
