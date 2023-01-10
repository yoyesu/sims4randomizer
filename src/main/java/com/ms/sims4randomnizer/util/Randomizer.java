package com.ms.sims4randomnizer.util;

import com.ms.sims4randomnizer.model.enums.*;
import java.util.*;

public class Randomizer {
    private static int lifespan;
    public static Difficulty difficulty = getDifficulty();

    public static int getRandomJobLevel(){
        int level = PropertiesLoader.getJobLevel();

        if(level != -1){
            return level; //to skip the switch loop if the user already decided the job level
        }

//        int difficulty = PropertiesLoader.getDifficulty();
        int bound = 11;
        int origin = 1;
        switch (difficulty){
            case EASY -> bound = 4;
            case NORMAL -> {
                origin = 3;
                bound = 8;
            }
            case HARD -> origin = 5;
        }

        return new Random().nextInt(origin, bound);
    }

    public static Job getRandomJob(){
        int job = PropertiesLoader.getJob();
        int id = job == -1? new Random().nextInt(Job.values().length) : job;
        Job generatedJob = Job.values()[id];
        generatedJob.setLevel(getRandomJobLevel());
        return generatedJob;
    }

    public static TeenJob getRandomTeenJob(){
        int job = PropertiesLoader.getJob();
        int id = job == -1? new Random().nextInt(TeenJob.values().length) : job;
        return TeenJob.values()[id];
    }

    public static AgeGroup getRandomAgeGroup(int starterSims){
//        int difficulty = PropertiesLoader.getDifficulty();
        int age = PropertiesLoader.getSimAge();
        int origin = 0;
        int bound = AgeGroup.values().length;
        if(starterSims == 1 && (difficulty == Difficulty.EASY || difficulty == Difficulty.NORMAL) || difficulty == Difficulty.EASY){
            origin = AgeGroup.YOUNG_ADULT.ordinal();
            bound = AgeGroup.ELDERLY.ordinal();
        } else if (starterSims == 1 && difficulty == Difficulty.HARD){
            origin = AgeGroup.ELDERLY.ordinal();
            bound = AgeGroup.ELDERLY.ordinal() +1;
        } else if(starterSims > 1 && difficulty == Difficulty.NORMAL){
            origin = AgeGroup.YOUNG_ADULT.ordinal();
            bound = AgeGroup.ELDERLY.ordinal() +1;
        }

        int id = age == -1 ? new Random().nextInt(origin, bound) : age;
        return AgeGroup.values()[id];
    }

    public static LifeSpan getLifeSpan(){
        int rawLifespan = PropertiesLoader.getLifeSpanType();
        lifespan = rawLifespan == -1 ? new Random().nextInt(0, 3) : rawLifespan;

        return LifeSpan.values()[lifespan];
    }

    public static int getNumberOfStarterSims(){
//        int difficulty = PropertiesLoader.getDifficulty();
        int numberOfStarterSims = PropertiesLoader.getNumberOfStarterSims();
        int origin = 1;
        int bound = 9;
        int sims;

        if (numberOfStarterSims == -1){//-1 means the user wants it random
            switch (difficulty){
                case EASY -> bound = 4;
                case NORMAL -> {
                    origin = 3;
                    bound = 6;
                }
                case HARD -> origin = 4;
            }
            sims = new Random().nextInt(origin,bound);
        } else {
            sims = numberOfStarterSims;
        }
        return sims;
    }

    public static Gender getGender(){
        PropertiesLoader properties = new PropertiesLoader();
        int genderOfSim = properties.getGenderOfSim();
        int id = genderOfSim < 0? new Random().nextInt(Gender.values().length) : genderOfSim;
        return Gender.values()[id];
    }

    public static Aspiration getAspiration(){
        int aspiration = PropertiesLoader.getAspiration();
        int id = aspiration == -1 ? new Random().nextInt(Aspiration.values().length) : aspiration;
        return Aspiration.values()[id];
    }

    public static ChildAspiration getChildAspiration(){
        int aspiration = PropertiesLoader.getAspiration();
        int id = aspiration == -1 ? new Random().nextInt(ChildAspiration.values().length) : aspiration;
        return ChildAspiration.values()[id];
    }

    public static SexualPreference getSexualPreference(){
        int sexuality = PropertiesLoader.getSexuality();
        int id = sexuality == -1 ? new Random().nextInt(SexualPreference.values().length) : sexuality;
        return SexualPreference.values()[id];
    }

    public static int getNumberOfChildren(){
//        int difficulty = PropertiesLoader.getDifficulty();
        LifeSpan lifeSpanType = LifeSpan.values()[lifespan];
        int bound = 10;
        int origin = 0;
        switch (lifeSpanType){
            case SHORT -> {//short
                if(difficulty == Difficulty.EASY){
                    bound = 3;
                } else if (difficulty == Difficulty.NORMAL) {
                    origin = 1;
                    bound = 5;
                } else if (difficulty == Difficulty.HARD){
                    origin = 2;
                    bound = 7;
                }
            }
            case NORMAL -> {//med
                if(difficulty == Difficulty.EASY){
                    bound = 6;
                } else if (difficulty == Difficulty.NORMAL) {
                    origin = 1;
                    bound = 7;
                } else if (difficulty == Difficulty.HARD){
                    origin = 3;
                    bound = 8;
                }
            }

            case LONG -> { //long
                if(difficulty == Difficulty.EASY){
                    bound = 4;
                } else if (difficulty == Difficulty.NORMAL) {
                    origin = 1;
                    bound = 6;
                } else if (difficulty == Difficulty.HARD){
                    origin = 5;
                }
            }
        }
        int childrenToHave = PropertiesLoader.getChildrenToHave();
        int numberOfChildren = childrenToHave == -1 ? new Random().nextInt(origin, bound) : childrenToHave;

        return numberOfChildren;
    }

    public static Object[] getSkillsToMax(){
        int numberOfSkillsToMax = PropertiesLoader.getMaxNumberOfSkills(); //this sets the max number of skills to complete
        int origin = 0;
        int bound = Skill.values().length;

        if(numberOfSkillsToMax == -1) {
//            int difficulty = PropertiesLoader.getDifficulty();

            LifeSpan lifeSpanType = LifeSpan.values()[lifespan];

            switch (lifeSpanType) {
                case SHORT -> {//short
                    if (difficulty == Difficulty.EASY) {
                        bound = 4;
                    } else if (difficulty == Difficulty.NORMAL) {
                        origin = 1;
                        bound = 6;
                    } else if (difficulty == Difficulty.HARD) {
                        origin = 3;
                        bound = 13;
                    }
                }
                case NORMAL -> {//med
                    if (difficulty == Difficulty.EASY) {
                        bound = 7;
                    } else if (difficulty == Difficulty.NORMAL) {
                        origin = 2;
                        bound = 9;
                    } else if (difficulty == Difficulty.HARD) {
                        origin = 5;
                        bound = 16;
                    }
                }

                case LONG -> { //long
                    if (difficulty == Difficulty.EASY) {
                        bound = 11;
                    } else if (difficulty == Difficulty.NORMAL) {
                        origin = 3;
                        bound = 13;
                    } else if (difficulty == Difficulty.HARD) {
                        origin = 7;
                    }
                }
            }

            numberOfSkillsToMax = new Random().nextInt(origin, bound);
        }

        Set<Skill> skills = new HashSet<>();
        for(int i = 0; i < numberOfSkillsToMax; i++){
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
        int id = alreadyMarried == -1 ? new Random().nextInt(2) : alreadyMarried;
        // 0 married, 1 single
        return id == 0;
    }

    public static boolean getNewWedding(){
        int wedding = PropertiesLoader.getWedding();
        int id = wedding == -1 ? new Random().nextInt(2) : wedding;
        // 0 sim will marry if single or will marry AGAIN if already married, 1 will not marry again or at all
        return id == 0;
    }

    public static Difficulty getDifficulty() {
        int difficultyLevel = PropertiesLoader.getDifficulty();
        return difficulty = difficultyLevel == -1 ? Difficulty.values()[new Random().nextInt(Difficulty.values().length)] : Difficulty.values()[difficultyLevel];
    }
}
