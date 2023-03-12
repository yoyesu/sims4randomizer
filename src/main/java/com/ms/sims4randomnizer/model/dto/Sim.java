package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.Gender;
import com.ms.sims4randomnizer.model.entities.Skill;

import java.util.Set;

public class Sim {
    protected String name;
    protected String surname;
    protected Gender gender;
    protected Age ageGroup;
    protected Set<Skill> skillsToMaster;
    protected boolean isHeir;

    public Sim(Gender gender, Age ageGroup, Set<Skill> skillsToMaster) {
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.skillsToMaster = skillsToMaster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Age getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Age ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Set<Skill> getSkillsToMaster() {

        return skillsToMaster;
    }

    public boolean isHeir() {
        return isHeir;
    }

    public void setHeir(boolean heir) {
        isHeir = heir;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
