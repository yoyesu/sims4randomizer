package com.ms.sims4randomnizer.controller;

import java.util.Random;

public class PropertiesLoader {

    private static int difficulty;
    private static int lifeSpanType;
    private static int numberOfStarterSims;
    private static int wedding = -1;
    private static int genderOfSim = -1;
    private static int alreadyMarried = -1;
    private static int childrenToHave = -1;
    private static int isSingleSimMode = 0;
    private static int simAge = -1;
    private static int aspiration = -1;
    private static int job = -1;
    private static int jobLevel = -1;
    private static int sexuality = -1;
    private static int maxNumberOfSkills = -1;

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

    public static int getIsSingleSimMode() {
        return isSingleSimMode;
    }

    public static void setIsSingleSimMode(int isSingleSimMode) {
        PropertiesLoader.isSingleSimMode = isSingleSimMode;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static int getLifeSpanType() {
        return lifeSpanType;
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

    public static void loadConfiguration() {
        try {
            int difficultyLevel = difficulty;
            int lifeSpan = lifeSpanType;
            int starterSims = numberOfStarterSims;
            int age = simAge;
            int wedding = PropertiesLoader.wedding;
            int gender = genderOfSim;
            int married = alreadyMarried;
            int children = childrenToHave;
            setConfiguration(difficultyLevel, lifeSpan, starterSims, wedding, gender, married, children, age);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void setConfiguration(int difficultyLevel, int lifeSpan, int numberOfSimsToStartWith, int willWed, int gender, int married, int children, int age) {
        difficulty = difficultyLevel > 0 && difficultyLevel <= 3 ? difficultyLevel : new Random().nextInt(1, 4);
        lifeSpanType = lifeSpan >= 0 && lifeSpan <= 2 ? lifeSpan : new Random().nextInt(0, 3);
        numberOfStarterSims = numberOfSimsToStartWith > 0 && numberOfSimsToStartWith <= 8 ? numberOfSimsToStartWith : -1;

        if(isSingleSimMode == 1){

            wedding = willWed >= 0 && willWed < 2 ? willWed : -1;
            genderOfSim = gender >= 0 && gender < 2 ? gender : -1;
            alreadyMarried = married >= 0 && married < 2 ? married : -1;
            childrenToHave = children >= 0 ? children : -1;
            simAge = age >= 0 ? age : -1;
        } else {
            wedding = -1;
            genderOfSim = -1;
            alreadyMarried = -1;
            childrenToHave = -1;
            simAge = -1;
        }
    }
}
