package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Difficulty {
    EASY("Easy"),NORMAL("Normal"),HARD("Hard");

    public String name;
    Difficulty(String name){
        this.name = name;
    }
}
