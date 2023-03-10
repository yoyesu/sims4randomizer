package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AgeGroup {
    TODDLER(1,"Toddler"), CHILD(2,"Child"), TEEN(3, "Teen"), YOUNG_ADULT(4, "Young adult"), ADULT(5, "Adult"), ELDERLY(6, "Elder");
    public int id;
    public String name;

    AgeGroup(int id, String name){
        this.id = id;
        this.name = name;}
}
