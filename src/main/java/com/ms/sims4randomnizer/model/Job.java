package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.util.Randomizer;

public enum Job {

    COOK(Randomizer.getRandomJobLevel()), HOUSEPERSON(0), ASTRONAUT(Randomizer.getRandomJobLevel()) ;

    private int level;

    Job(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


}
