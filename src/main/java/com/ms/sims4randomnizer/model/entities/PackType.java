package com.ms.sims4randomnizer.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pack_types")
public class PackType {

    @Id
    private int packTypeId;

    @Column(name = "pack_type_name")
    private String packTypeName;

    public int getPackTypeId() {
        return packTypeId;
    }

    public void setPackTypeId(int packTypeId) {
        this.packTypeId = packTypeId;
    }

    public String getPackTypeName() {
        return packTypeName;
    }

    public void setPackTypeName(String packTypeName) {
        this.packTypeName = packTypeName;
    }
}
