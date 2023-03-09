package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AgeGroup {
    TODDLER("Toddler"), CHILD("Child"), TEEN("Teen"), YOUNG_ADULT("Young adult"), ADULT("Adult"), ELDERLY("Elder");

    public final String name;

    AgeGroup(String name){
        this.name = name;}
}
