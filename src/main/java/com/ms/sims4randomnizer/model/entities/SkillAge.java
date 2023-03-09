package com.ms.sims4randomnizer.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills_ages")
public class SkillAge {

    @Id
    private int skillAgeID;

    @ManyToMany
    @JoinColumn(name = "skill_name")
    private List<Skill> skills;

    @ManyToMany
    @JoinColumn(name = "age_name")
    private List<Age> ages;

    public int getSkillAgeID() {
        return skillAgeID;
    }

    public void setSkillAgeID(int skillAgeID) {
        this.skillAgeID = skillAgeID;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Age> getAges() {
        return ages;
    }

    public void setAges(List<Age> ages) {
        this.ages = ages;
    }
}
