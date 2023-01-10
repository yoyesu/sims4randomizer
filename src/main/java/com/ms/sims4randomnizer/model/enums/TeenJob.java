package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TeenJob {
    BARISTA("Barista"), BABYSITTER("Babysitter"), FAST_FOOD_EMPLOYEE("Fast food employee"), MANUAL_LABORER("Manual laborer"), RETAIL("Retail employee");

    public String name;
    TeenJob(String name){
        this.name = name;
    }
}
