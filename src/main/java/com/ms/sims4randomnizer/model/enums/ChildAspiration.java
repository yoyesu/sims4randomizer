package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ChildAspiration {

    ARTISTIC_PRODIGY("Artistic prodigy"), RAMBUNCTIOUS_SCAMP("Rambunctious scamp"), SOCIAL_BUTTERFLY("Social butterfly"), WHIZ_KID("Whiz kid");

    public String name;
    ChildAspiration(String name){
        this.name = name;
    }
}
