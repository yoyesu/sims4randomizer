package com.ms.sims4randomnizer.model.db_dtos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aspirations_age")
public class AspirationAge {

    @Id
    private int aspirationsAgeId;

    @ManyToMany
    @JoinColumn(name = "aspirations_name")
    private List<Aspiration> aspiration;

    @ManyToMany
    @JoinColumn(name = "age_name")
    private List<Age> ages;

    public int getAspirationsAgeId() {
        return aspirationsAgeId;
    }

    public void setAspirationsAgeId(int aspirationsAgeId) {
        this.aspirationsAgeId = aspirationsAgeId;
    }

    public List<Aspiration> getAspiration() {
        return aspiration;
    }

    public void setAspiration(List<Aspiration> aspiration) {
        this.aspiration = aspiration;
    }

    public List<Age> getAges() {
        return ages;
    }

    public void setAges(List<Age> ages) {
        this.ages = ages;
    }
}
