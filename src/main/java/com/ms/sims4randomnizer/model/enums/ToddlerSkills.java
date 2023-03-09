package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ToddlerSkills {

    COMMUNICATION("Communication"), IMAGINATION("Imagination"), MOVEMENT("Movement"), POTTY("Potty"), THINKING("Thinking");

    public String name;
    ToddlerSkills(String name){
        this.name = name;
    }
}