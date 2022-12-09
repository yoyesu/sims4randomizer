package com.ms.sims4randomnizer.util;

import com.ms.sims4randomnizer.controller.AppController;
import com.ms.sims4randomnizer.controller.PropertiesLoader;
import com.ms.sims4randomnizer.model.enums.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Randomizer {

    private static int difficulty = PropertiesLoader.getDifficulty();
    private static int lifeSpanType = PropertiesLoader.getLifeSpanType();
    private static int numberOfStarterSims = PropertiesLoader.getNumberOfStarterSims();
//    static {
//        loadConfiguration();
//    }

//    private static void loadConfiguration() {
//        Properties properties = new Properties();
//        Properties singleSimProperties = new Properties();
//        try {
//            properties.load(new FileReader("src/main/resources/configuration.properties"));
//            singleSimProperties.load(new FileReader("src/main/resources/singleSimConfig.properties"));
//            int mode = Integer.parseInt(properties.getProperty("isSingleSimMode"));
//            int difficultyLevel = Integer.parseInt(properties.getProperty("difficultyLevel"));
//            int lifeSpan = Integer.parseInt(properties.getProperty("lifeSpan"));
//            int starterSims = Integer.parseInt(properties.getProperty("numberOfSimsToStartWith"));
//            int wedding = Integer.parseInt(singleSimProperties.getProperty("wedding"));
//            int gender = Integer.parseInt(singleSimProperties.getProperty("gender"));
//            int married = Integer.parseInt(singleSimProperties.getProperty("alreadyMarried"));
//            int children = Integer.parseInt(singleSimProperties.getProperty("childrenToHave"));
//            setConfiguration(difficultyLevel, lifeSpan, starterSims, wedding, gender, married, children, mode);
//
//
//        } catch (IOException | NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void setConfiguration(int difficultyLevel, int lifeSpan, int numberOfSimsToStartWith, int willWed, int gender, int married, int children, int mode) {
//        difficulty = difficultyLevel > 0 && difficultyLevel <= 3 ? difficultyLevel : new Random().nextInt(1, 4);
//        lifeSpanType = lifeSpan > 0 && lifeSpan <= 3 ? lifeSpan : new Random().nextInt(1, 4);
//        numberOfStarterSims = numberOfSimsToStartWith > 0 && numberOfSimsToStartWith <= 8 ? numberOfSimsToStartWith : 0;
//
//        System.out.println(mode);
//        if(mode == 1){
//            wedding = willWed > 0 && willWed < 3 ? willWed : 0;
//            genderOfSim = gender > 0 && gender < 3 ? gender : 0;
//            alreadyMarried = married > 0 && married < 3 ? married : 0;
//            childrenToHave = children >= 0 ? children : -1;
//        }
//
//    }

    public static int getRandomJobLevel(){
//        loadConfiguration();
        int bound = 11;
        int origin = 1;
        switch (difficulty){
            case 1 -> bound = 4;
            case 2 -> {
                origin = 3;
                bound = 8;
            }
            case 3 -> origin = 5;
        }
        return new Random().nextInt(origin, bound);
    }

    public static Job getRandomJob(){
        int id = new Random().nextInt(Job.values().length);
        return Job.values()[id];
    }

    public static TeenJob getRandomTeenJob(){
        int id = new Random().nextInt(TeenJob.values().length);
        return TeenJob.values()[id];
    }

    public static AgeGroup getRandomAgeGroup(int starterSims){
        int origin = 0;
        int bound = AgeGroup.values().length;
        if(starterSims == 1 && (difficulty == 1 || difficulty == 2) || difficulty == 1){
            origin = AgeGroup.YOUNG_ADULT.ordinal();
            bound = AgeGroup.ELDERLY.ordinal();
        } else if (starterSims == 1 && difficulty == 3){
            origin = AgeGroup.ELDERLY.ordinal();
            bound = AgeGroup.ELDERLY.ordinal() +1;
        } else if(starterSims > 1 && difficulty == 2){
            origin = AgeGroup.YOUNG_ADULT.ordinal();
            bound = AgeGroup.ELDERLY.ordinal() +1;
        }

        return AgeGroup.values()[new Random().nextInt(origin, bound)];
    }

    public static LifeSpan getLifeSpan(){
        int id = new Random().nextInt(LifeSpan.values().length);
        switch (lifeSpanType){
            case 1 -> id = 0;
            case 2 -> id = 1;
            case 3 -> id = 2;
        }
        return LifeSpan.values()[id];
    }

    public static int getNumberOfStarterSims(){
        int origin = 1;
        int bound = 9;
        int sims;

        if (numberOfStarterSims == 0){//0 means the user wants it random
            switch (difficulty){
                case 1 -> bound = 4;
                case 2 -> {
                    origin = 3;
                    bound = 6;
                }
                case 3 -> origin = 4;
            }
            sims = new Random().nextInt(origin,bound);
        } else {
            sims = numberOfStarterSims;
        }
        return sims;
    }

    public static Gender getGender(){
        int genderOfSim = PropertiesLoader.getGenderOfSim();
        int id = genderOfSim == 0? new Random().nextInt(Gender.values().length) : genderOfSim;
        return Gender.values()[id];
    }

    public static Aspiration getAspiration(){
        int id = new Random().nextInt(Aspiration.values().length);
        return Aspiration.values()[id];
    }

    public static ChildAspiration getChildAspiration(){
        int id = new Random().nextInt(ChildAspiration.values().length);
        return ChildAspiration.values()[id];
    }

    public static SexualPreference getSexualPreference(){
        int id = new Random().nextInt(SexualPreference.values().length);
        return SexualPreference.values()[id];
    }

    public static int getNumberOfChildren(){
        int bound = 10;
        int origin = 0;
        switch (lifeSpanType){
            case 1 -> {//short
                if(difficulty == 1){
                    bound = 3;
                } else if (difficulty == 2) {
                    origin = 1;
                    bound = 5;
                } else if (difficulty == 3){
                    origin = 2;
                    bound = 7;
                }
            }
            case 2 -> {//med
                if(difficulty == 1){
                    bound = 6;
                } else if (difficulty == 2) {
                    origin = 1;
                    bound = 7;
                } else if (difficulty == 3){
                    origin = 3;
                    bound = 8;
                }
            }

            case 3 -> { //long
                if(difficulty == 1){
                    bound = 4;
                } else if (difficulty == 2) {
                    origin = 1;
                    bound = 6;
                } else if (difficulty == 3){
                    origin = 5;
                }
            }
        }
        int childrenToHave = PropertiesLoader.getChildrenToHave();
        int numberOfChildren = childrenToHave == -1 ? new Random().nextInt(origin, bound) : childrenToHave;

        return numberOfChildren;
    }

    public static Object[] getSkillsToMax(){
        int origin = 0;
        int bound = Skill.values().length;

        switch (lifeSpanType) {
            case 1 -> {//short
                if (difficulty == 1) {
                    bound = 4;
                } else if (difficulty == 2) {
                    origin = 1;
                    bound = 6;
                } else if (difficulty == 3) {
                    origin = 3;
                    bound = 13;
                }
            }
            case 2 -> {//med
                if (difficulty == 1) {
                    bound = 7;
                } else if (difficulty == 2) {
                    origin = 2;
                    bound = 9;
                } else if (difficulty == 3) {
                    origin = 5;
                    bound = 16;
                }
            }

            case 3 -> { //long
                if (difficulty == 1) {
                    bound = 11;
                } else if (difficulty == 2) {
                    origin = 3;
                    bound = 13;
                } else if (difficulty == 3) {
                    origin = 7;
                }
            }
        }

        int numberOfSkills = new Random().nextInt(origin, bound); //this sets the max number of skills to complete
        Set<Skill> skills = new HashSet<>();
        for(int i = 0; i <= numberOfSkills; i++){
            if(!skills.add(Skill.values()[new Random().nextInt(Skill.values().length)])){ //this picks skills until the max number of skills is reached
                i--;
            }
        }
        Object[] skillsToMax = skills.toArray();
        return skillsToMax;
    }

    public static Object[] getToddlerSkillsToMax(){
        int id = new Random().nextInt(ToddlerSkills.values().length);
        Set<ToddlerSkills> skills = new HashSet<>();
        for(int i = 0; i <= id; i++){
            if(!skills.add(ToddlerSkills.values()[new Random().nextInt(ToddlerSkills.values().length)])){
                i--;
            }

        }
        Object[] skillsToMax = skills.toArray();
        return skillsToMax;
    }

    public static Object[] getChildSkillsToMax(){
        int id = new Random().nextInt(ChildSkills.values().length);
        Set<ChildSkills> skills = new HashSet<>();
        for(int i = 0; i <= id; i++){
            if(!skills.add(ChildSkills.values()[new Random().nextInt(ChildSkills.values().length)])){
                i--;
            }

        }
        Object[] skillsToMax = skills.toArray();
        return skillsToMax;
    }

    public static boolean getMarriageStatus(){
        int alreadyMarried = PropertiesLoader.getAlreadyMarried();
        int id = alreadyMarried == 0 ? new Random().nextInt(1,2) : alreadyMarried;
        // 1 married, 2 single
        return id == 1;
    }

    public static boolean getNewWedding(){
        int wedding = PropertiesLoader.getWedding();
        int id = wedding == 0 ? new Random().nextInt(2) : wedding;
        // 0 sim will marry if single or will marry AGAIN if already married, 1 will not marry again or at all
        return id == 0;
    }
}
