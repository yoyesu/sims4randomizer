package com.ms.sims4randomnizer.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AspirationAgeId implements Serializable {

    private static final long serialVersionUID = 2969364269986936979L;
    @NotNull
    @Column(name = "aspiration", nullable = false)
    private Integer aspiration;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    public Integer getAspiration() {
        return aspiration;
    }

    public void setAspiration(Integer aspiration) {
        this.aspiration = aspiration;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
