package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Skill {

    CHARISMA("Charisma"), COMEDY("Comedy"), COOKING("Cooking"), FISHING("Fishing"), FITNESS("Fitness"), GARDENING("Gardening"), GOURMET_COOKING("Gourmet cooking"), GUITAR("Guitar"), HANDINESS("Handiness"), LOGIC("Logic"), MISCHIEF("Mischief"),
    MIXOLOGY("Mixology"), PAINTING("Painting"), PIANO("Piano"), PHOTOGRAPHY("Photography"), PROGRAMMING("Programming"), ROCKET_SCIENCE("Rocket science"), VIDEO_GAMING("Video gaming"), VIOLIN("Violin"), WRITING("Writing");

    public String skillName;
    Skill(String name){
        skillName = name;
    }
}
