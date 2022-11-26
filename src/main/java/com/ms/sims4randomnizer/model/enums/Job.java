package com.ms.sims4randomnizer.model.enums;

import com.ms.sims4randomnizer.util.Randomizer;

public enum Job {

    CULINARY(Randomizer.getRandomJobLevel()),
    HOUSEPERSON(0),
    ASTRONAUT(Randomizer.getRandomJobLevel()),
    ARTIST(Randomizer.getRandomJobLevel()),
    ATHLETE(Randomizer.getRandomJobLevel()),
    BUSINESS(Randomizer.getRandomJobLevel()),
    CRIMINAL(Randomizer.getRandomJobLevel()),
    ENTERTAINER(Randomizer.getRandomJobLevel()),
    FREELANCER(Randomizer.getRandomJobLevel()),
    SECRET_AGENT(Randomizer.getRandomJobLevel()),
    TECH_GURU(Randomizer.getRandomJobLevel()),
    WRITER(Randomizer.getRandomJobLevel())
    ;

    private int level;

    Job(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


}
