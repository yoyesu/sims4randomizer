package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.LifeSpan;

public class Household {
    private final int maxSims = 8;
    private LifeSpan lifeSpan;
    private int starterSims;
    private int currentSims;

    public Household(LifeSpan lifeSpan, int currentSims, int starterSims) {
        this.lifeSpan = lifeSpan;
        this.currentSims = currentSims;
        this.starterSims = starterSims;
    }

    public Household(LifeSpan lifeSpan, int starterSims) {
        this.lifeSpan = lifeSpan;
        this.starterSims = starterSims;
    }

    //////////// getters & setters//////////////////

    public int getMaxSims() {
        return maxSims;
    }

    public LifeSpan getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(LifeSpan lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public int getCurrentSims() {
        return currentSims;
    }

    public void setCurrentSims(int currentSims) {
        this.currentSims = currentSims;
    }

    public int getStarterSims() {
        return starterSims;
    }

    public void setStarterSims(int starterSims) {
        this.starterSims = starterSims;
    }

    ////////////// END getters & setters //////////////
}
