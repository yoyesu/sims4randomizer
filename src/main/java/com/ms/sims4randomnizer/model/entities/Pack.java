package com.ms.sims4randomnizer.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "packs")
public class Pack {

    @Id
    private int packId;

    @Column(name = "pack_name")
    private String packName;

    @ManyToOne
    @JoinColumn(name = "pack_type")
    private PackType packType;

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public PackType getPackType() {
        return packType;
    }

    public void setPackType(PackType packType) {
        this.packType = packType;
    }
}
