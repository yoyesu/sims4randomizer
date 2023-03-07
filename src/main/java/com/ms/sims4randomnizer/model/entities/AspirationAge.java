package com.ms.sims4randomnizer.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "aspiration_age")
public class AspirationAge {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private AspirationAgeId aspirationAgeId;

    @MapsId("aspiration")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aspiration", nullable = false)
    private Aspiration aspiration;

    @MapsId("age")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "age", nullable = false)
    private Age age;


    public AspirationAgeId getAspirationAgeId() {
        return aspirationAgeId;
    }

    public void setAspirationAgeId(AspirationAgeId aspirationAgeId) {
        this.aspirationAgeId = aspirationAgeId;
    }


    public Aspiration getAspiration() {
        return aspiration;
    }

    public void setAspiration(Aspiration aspiration) {
        this.aspiration = aspiration;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }
}
