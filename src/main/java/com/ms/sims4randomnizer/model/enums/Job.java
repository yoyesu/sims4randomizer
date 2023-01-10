package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ms.sims4randomnizer.util.Randomizer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Job {

    CULINARY(Randomizer.getRandomJobLevel(), "Culinary"),
    HOUSEPERSON(0, "No work"),
    ASTRONAUT(Randomizer.getRandomJobLevel(), "Astronaut"),
    ARTIST(Randomizer.getRandomJobLevel(), "Artist"),
    ATHLETE(Randomizer.getRandomJobLevel(), "Athlete"),
    BUSINESS(Randomizer.getRandomJobLevel(), "Business"),
    CRIMINAL(Randomizer.getRandomJobLevel(), "Criminal"),
    ENTERTAINER(Randomizer.getRandomJobLevel(), "Entertainer"),
    FREELANCER(Randomizer.getRandomJobLevel(), "Freelancer"),
    SECRET_AGENT(Randomizer.getRandomJobLevel(), "Secret Agent"),
    TECH_GURU(Randomizer.getRandomJobLevel(), "Tech Guru"),
    WRITER(Randomizer.getRandomJobLevel(), "Writer")
    ;

    public int level;
    public String name;

    Job(int level, String jobName) {

        this.level = level;
        this.name = jobName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }
}
