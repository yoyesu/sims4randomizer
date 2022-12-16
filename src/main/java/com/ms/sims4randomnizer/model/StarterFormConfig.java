package com.ms.sims4randomnizer.model;

public class StarterFormConfig {

    private int difficulty;
    private int lifespan;
    private int starterSims;
//    private int gender;
//    private int age;
    private static StarterFormConfig instance;

    private StarterFormConfig() {
    }

    public static StarterFormConfig getInstance(){
        if (instance == null) {
            instance = new StarterFormConfig();
        }
        return instance;
    }

//    public int getGender() {
//        return gender;
//    }
//
//    public void setGender(int gender) {
//        this.gender = gender;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

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
}
