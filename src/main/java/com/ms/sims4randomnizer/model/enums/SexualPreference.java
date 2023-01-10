package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SexualPreference {
    STRAIGHT("Straight"), GAY("Gay"), BISEXUAL("Bisexual");

    public String name;

    SexualPreference(String name){
        this.name = name;
    }
}
