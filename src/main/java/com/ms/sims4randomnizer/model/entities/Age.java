package com.ms.sims4randomnizer.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "ages")
public class Age {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "age_id", nullable = false)
    private int ageId;

    @Column(name = "age_name", nullable = false)
    private String ageName;

    public int getAgeId() {
        return ageId;
    }

    public void setAgeId(int ageId) {
        this.ageId = ageId;
    }

    public String getAgeName() {
        return ageName;
    }

    public void setAgeName(String ageName) {
        this.ageName = ageName;
    }
}
