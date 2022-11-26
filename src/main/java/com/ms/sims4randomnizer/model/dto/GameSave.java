package com.ms.sims4randomnizer.model.dto;

import java.util.List;

public class GameSave {

    private Household household;
    private List<Sim> sims;

    public GameSave(Household household, List<Sim> sims) {
        this.household = household;
        this.sims = sims;
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
}
