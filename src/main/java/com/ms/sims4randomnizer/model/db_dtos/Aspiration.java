package com.ms.sims4randomnizer.model.db_dtos;

import javax.persistence.*;

@Entity
@Table(name = "aspirations")
public class Aspiration {

    @Id
    private int aspirationId;

    @Column(name = "aspiration_name")
    private String aspirationName;

    @ManyToOne
    @JoinColumn(name = "pack_name")
    private Pack pack;

    public int getAspirationId() {
        return aspirationId;
    }

    public void setAspirationId(int aspirationId) {
        this.aspirationId = aspirationId;
    }

    public String getAspirationName() {
        return aspirationName;
    }

    public void setAspirationName(String aspirationName) {
        this.aspirationName = aspirationName;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }
}
