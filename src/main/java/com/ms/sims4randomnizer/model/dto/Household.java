package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.LifeSpan;

import java.util.List;

public class Household {
    private final int maxSims = 8;
    private List<Sim> sims;
    private LifeSpan lifeSpan;

    public Household(LifeSpan lifeSpan, List<Sim> sims) {
        this.lifeSpan = lifeSpan;
        this.sims = sims;
    }

    public int getMaxSims() {
        return maxSims;
    }

    public LifeSpan getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(LifeSpan lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public List<Sim> getSims() {
        return sims;
    }

    public void setSims(List<Sim> sims) {
        this.sims = sims;
    }
}
