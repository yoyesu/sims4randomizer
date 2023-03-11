package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.Difficulty;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.List;

public class GameSave {

    private Household household;
    private Difficulty difficulty;


    public GameSave(Household household) {
        this.household = household;
        this.difficulty = Randomizer.difficulty;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
