package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

    MALE("Male"), FEMALE("Female");

    public String genderName;
    Gender(String name){
        genderName = name;
    }
}
