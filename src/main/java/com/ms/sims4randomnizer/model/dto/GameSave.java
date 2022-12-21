package com.ms.sims4randomnizer.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.ms.sims4randomnizer.controller.PropertiesLoader;
import com.ms.sims4randomnizer.model.StarterFormConfig;

import java.util.List;

public class GameSave {

    private Household household;
    private List<Sim> sims;
    private int difficulty;


    public GameSave(Household household, List<Sim> sims) {
        this.household = household;
        this.sims = sims;
        this.difficulty = PropertiesLoader.getDifficulty();
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public List<Sim> getSims() {
        return sims;
    }

    public void setSims(List<Sim> sims) {
        this.sims = sims;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
