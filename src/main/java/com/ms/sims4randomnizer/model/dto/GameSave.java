package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.Difficulty;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.List;

public class GameSave {

    private Household household;
    private List<Sim> sims;
    private Difficulty difficulty;


    public GameSave(Household household, List<Sim> sims) {
        this.household = household;
        this.sims = sims;
        this.difficulty = Randomizer.difficulty;
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

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
