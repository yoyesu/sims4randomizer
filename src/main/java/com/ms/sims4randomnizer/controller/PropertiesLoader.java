package com.ms.sims4randomnizer.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class PropertiesLoader {

    private static int difficulty;
    private static int lifeSpanType;
    private static int numberOfStarterSims;
    private static int wedding = 0;
    private static int genderOfSim = 0;
    private static int alreadyMarried = 0;
    private static int childrenToHave = -1;
    private static int isSingleSimMode = 0;

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

    public static int getGenderOfSim() {
        return genderOfSim;
    }

    public static int getAlreadyMarried() {
        return alreadyMarried;
    }

    public static int getChildrenToHave() {
        return childrenToHave;
    }

    public static void loadConfiguration() {
        Properties properties = new Properties();
        Properties singleSimProperties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/configuration.properties"));
            singleSimProperties.load(new FileReader("src/main/resources/singleSimConfig.properties"));
//            int mode = Integer.parseInt(properties.getProperty("isSingleSimMode"));
            int difficultyLevel = Integer.parseInt(properties.getProperty("difficultyLevel"));
            int lifeSpan = Integer.parseInt(properties.getProperty("lifeSpan"));
            int starterSims = Integer.parseInt(properties.getProperty("numberOfSimsToStartWith"));
            int wedding = Integer.parseInt(singleSimProperties.getProperty("wedding"));
            int gender = Integer.parseInt(singleSimProperties.getProperty("gender"));
            int married = Integer.parseInt(singleSimProperties.getProperty("alreadyMarried"));
            int children = Integer.parseInt(singleSimProperties.getProperty("childrenToHave"));
            setConfiguration(difficultyLevel, lifeSpan, starterSims, wedding, gender, married, children);


        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void setConfiguration(int difficultyLevel, int lifeSpan, int numberOfSimsToStartWith, int willWed, int gender, int married, int children) {
        difficulty = difficultyLevel > 0 && difficultyLevel <= 3 ? difficultyLevel : new Random().nextInt(1, 4);
        lifeSpanType = lifeSpan > 0 && lifeSpan <= 3 ? lifeSpan : new Random().nextInt(1, 4);
        numberOfStarterSims = numberOfSimsToStartWith > 0 && numberOfSimsToStartWith <= 8 ? numberOfSimsToStartWith : 0;

        if(isSingleSimMode == 1){
            wedding = willWed > 0 && willWed < 3 ? willWed : 0;
            genderOfSim = gender > 0 && gender < 3 ? gender : 0;
            alreadyMarried = married > 0 && married < 3 ? married : 0;
            childrenToHave = children >= 0 ? children : -1;
        } else {
            wedding = 0;
            genderOfSim = 0;
            alreadyMarried = 0;
            childrenToHave = -1;
        }
        System.out.println("childrentohave inside set config = " + childrenToHave);
    }
}
