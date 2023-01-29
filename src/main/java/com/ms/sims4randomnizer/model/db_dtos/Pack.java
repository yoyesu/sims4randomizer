package com.ms.sims4randomnizer.model.db_dtos;

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

}
