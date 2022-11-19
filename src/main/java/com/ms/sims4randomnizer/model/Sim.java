package com.ms.sims4randomnizer.model;

public class Sim {
    protected String name;
    protected String surname;
    protected Gender gender;
    protected AgeGroup ageGroup;

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

    @Override
    public String toString() {
        return super.toString();
    }
}
