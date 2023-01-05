package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ChildSkills {
    CREATIVITY("Creativity"), MENTAL("Mental"), MOTOR("Motor"), SOCIAL("Social");

    public String skillName;
    ChildSkills(String name){
        skillName = name;
    }
}
