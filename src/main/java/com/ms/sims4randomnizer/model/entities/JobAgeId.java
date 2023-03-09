package com.ms.sims4randomnizer.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class JobAgeId implements Serializable {

    private static final long serialVersionUID = 2969364269986936979L;
    @NotNull
    @Column(name = "job", nullable = false)
    private Integer job;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
