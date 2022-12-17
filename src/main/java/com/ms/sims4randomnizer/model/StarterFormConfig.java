package com.ms.sims4randomnizer.model;

public class StarterFormConfig {

    private int difficulty;
    private int lifespan;
    private int starterSims;

    private static StarterFormConfig instance;

    private StarterFormConfig() {
    }

    public static StarterFormConfig getInstance(){
        if (instance == null) {
            instance = new StarterFormConfig();
        }
        return instance;
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
}
