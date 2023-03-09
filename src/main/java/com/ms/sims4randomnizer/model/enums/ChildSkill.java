package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ChildSkill {
    CREATIVITY("Creativity"), MENTAL("Mental"), MOTOR("Motor"), SOCIAL("Social");

    public String name;
    ChildSkill(String name){
        this.name = name;
    }
}
