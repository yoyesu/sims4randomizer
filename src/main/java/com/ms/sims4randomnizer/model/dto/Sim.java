package com.ms.sims4randomnizer.model.dto;

import com.ms.sims4randomnizer.model.enums.AgeGroup;
import com.ms.sims4randomnizer.model.enums.Gender;

public class Sim {
    protected String name;
    protected String surname;
    protected Gender gender;
    protected AgeGroup ageGroup;
    protected static String[] skills;

    public Sim(Gender gender, AgeGroup ageGroup) {
        this.gender = gender;
        this.ageGroup = ageGroup;
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

    public static String[] getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
