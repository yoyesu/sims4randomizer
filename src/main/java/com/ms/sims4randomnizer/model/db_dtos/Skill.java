package com.ms.sims4randomnizer.model.db_dtos;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    private int skillId;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_max_level")
    private int skillMaxLevel;

    @ManyToOne
    @JoinColumn(name = "pack_name")
    private Pack pack;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillMaxLevel() {
        return skillMaxLevel;
    }

    public void setSkillMaxLevel(int skillMaxLevel) {
        this.skillMaxLevel = skillMaxLevel;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }
}
