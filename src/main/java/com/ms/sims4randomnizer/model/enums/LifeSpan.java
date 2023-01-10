package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LifeSpan {
    SHORT("Short"), NORMAL("Normal"), LONG("Long");

    public String name;
    LifeSpan(String name){
        this.name = name;
    }
}
