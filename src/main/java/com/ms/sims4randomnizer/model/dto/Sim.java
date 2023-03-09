package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.model.enums.Gender;

import java.util.Set;

public class Sim {
    protected String name;
    protected String surname;
    protected Gender gender;
    protected AgeGroup ageGroup;
    protected Set<? extends Enum<?>> skillsToMaster;
    protected boolean isHeir;

    public Sim(Gender gender, AgeGroup ageGroup, Set<? extends Enum<?>> skillsToMaster) {
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

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Set<? extends Enum<?>> getSkillsToMaster() {

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
