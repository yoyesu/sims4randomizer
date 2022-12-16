package com.ms.sims4randomnizer.model;

public class NewSimFormConfig {

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
    private int children;
    private boolean isMarried;
    private boolean willMarry;

    private static NewSimFormConfig instance;

    private NewSimFormConfig() {
    }

    public static NewSimFormConfig getInstance(){
        if (instance == null) {
            instance = new NewSimFormConfig();
        }
        return instance;
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

    public boolean isMarried() {
        return isMarried;
    }

    public boolean isWillMarry() {
        return willMarry;
    }
}
