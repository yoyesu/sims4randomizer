package com.ms.sims4randomnizer.util;

import java.util.Random;

public class PropertiesLoader {

    private static int difficulty;
    private static int lifeSpanType;
    private static int numberOfStarterSims;
    private static int wedding;
    private static int genderOfSim;
    private static int alreadyMarried;
    private static int childrenToHave;
    private static int simAge;
    private static int aspiration;
    private static int job;
    private static int jobLevel;
    private static int sexuality;
    private static int maxNumberOfSkills;

    public static int getMaxNumberOfSkills() {
        return maxNumberOfSkills;
    }

    public static void setMaxNumberOfSkills(int totalNumberOfSkills) {
        maxNumberOfSkills = totalNumberOfSkills;
    }

    public static int getJobLevel() {
        return jobLevel;
    }

    public static void setJobLevel(int levelOfJob) {
        jobLevel = levelOfJob;
    }

    public static int getSexuality() {
        return sexuality;
    }

    public static void setSexuality(int sexuality) {
        PropertiesLoader.sexuality = sexuality;
    }

    public static int getJob() {
        return job;
    }

    public static void setJob(int job) {
        PropertiesLoader.job = job;
    }

    public static int getAspiration() {
        return aspiration;
    }

    public static void setAspiration(int aspiration) {
        PropertiesLoader.aspiration = aspiration;
    }

    public static int getDifficulty() {
        return difficulty == 0 ? new Random().nextInt(1, 4) : difficulty;
    }

    public static int getLifeSpanType() {
        return lifeSpanType == -1 ? new Random().nextInt(0, 3) : lifeSpanType;
    }

    public static int getNumberOfStarterSims() {
        return numberOfStarterSims;
    }

    public static int getWedding() {
        return wedding;
    }

    public int getGenderOfSim() {
        return genderOfSim;
    }

    public static int getAlreadyMarried() {
        return alreadyMarried;
    }

    public static int getChildrenToHave() {
        return childrenToHave;
    }

    public static void setDifficulty(int difficulty) {
        PropertiesLoader.difficulty = difficulty;
    }

    public static void setLifeSpanType(int lifeSpanType) {
        PropertiesLoader.lifeSpanType = lifeSpanType;
    }

    public static void setNumberOfStarterSims(int numberOfStarterSims) {
        PropertiesLoader.numberOfStarterSims = numberOfStarterSims;
    }

    public static void setWedding(int wedding) {
        PropertiesLoader.wedding = wedding;
    }

    public static void setGenderOfSim(int genderOfSim) {
        PropertiesLoader.genderOfSim = genderOfSim;
    }

    public static void setAlreadyMarried(int alreadyMarried) {
        PropertiesLoader.alreadyMarried = alreadyMarried;
    }

    public static void setChildrenToHave(int childrenToHave) {
        PropertiesLoader.childrenToHave = childrenToHave;
    }

    public static void setSimAge(int simAge) {
        PropertiesLoader.simAge = simAge;
    }

    public static int getSimAge() {
        return simAge;
    }
}
