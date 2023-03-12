package com.ms.sims4randomnizer.util;

import com.ms.sims4randomnizer.controller.AspirationController;
import com.ms.sims4randomnizer.controller.JobController;
import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.controller.repositories.AspirationAgeRepository;
import com.ms.sims4randomnizer.controller.repositories.GenderRepository;
import com.ms.sims4randomnizer.model.entities.*;
import com.ms.sims4randomnizer.model.enums.Difficulty;
import com.ms.sims4randomnizer.model.enums.LifeSpan;

import com.ms.sims4randomnizer.controller.PropertiesLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Randomizer {
    private static int lifespan;
    public static Difficulty difficulty;
    private static AgeRepository ageRepository;
    private static GenderRepository genderRepository;
    private static AspirationAgeRepository aspirationAgeRepository;

    @Autowired
    public Randomizer(AgeRepository ageRepository, GenderRepository genderRepository, AspirationAgeRepository aspirationAgeRepository){
        Randomizer.ageRepository = ageRepository;
        Randomizer.genderRepository = genderRepository;
        Randomizer.aspirationAgeRepository = aspirationAgeRepository;
    }


    public static int getRandomJobLevel(){
        int level = PropertiesLoader.getJobLevel();

        if(level != -1){
            return level;
        }

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

    public static Job getRandomJob(String age){
        List<Job> jobs = JobController.getAllJobsByAgeName(age);
        Job generatedJob = null;
        int job = PropertiesLoader.getJob();
        if(job != -1){
            try{
                return generatedJob = jobs.stream().filter(entry -> entry.getJobId() == job).toList().get(0);

            } catch (Exception e){
                //in case ID sent from front-end doesn't match any job
                e.printStackTrace();
            }
        }

        int origin = jobs.stream().mapToInt(Job::getJobId).min().getAsInt();
        int bound = jobs.stream().mapToInt(Job::getJobId).max().getAsInt() + 1;
        boolean lookingForID = true;


        do {
            for(Job jobInList : jobs){
                if(jobInList.getJobId() == new Random().nextInt(origin, bound)){
                    generatedJob = jobInList;
                    lookingForID = false;
                    break;
                }
            }

        } while (lookingForID);

        return generatedJob;
    }

    public static Age getRandomAgeGroup(int starterSims, List<Age> ages){
        Randomizer.difficulty = Randomizer.getDifficulty();
        Difficulty difficulty = Randomizer.difficulty;

        int age = PropertiesLoader.getSimAge();
        int origin = 0;
        int bound = ages.size();
        if(starterSims == 1 && (difficulty == Difficulty.EASY || difficulty == Difficulty.NORMAL) || difficulty == Difficulty.EASY){
            origin = ages.stream().filter(entry -> entry.getAgeName().equalsIgnoreCase("young adult")).toList().get(0).getAgeId() -1;
            bound = ages.stream().filter(entry -> entry.getAgeName().equalsIgnoreCase("elder")).toList().get(0).getAgeId();
        } else if (starterSims == 1 && difficulty == Difficulty.HARD){
            origin = ages.stream().filter(entry -> entry.getAgeName().equalsIgnoreCase("elder")).toList().get(0).getAgeId() -1;
            bound = ages.stream().filter(entry -> entry.getAgeName().equalsIgnoreCase("elder")).toList().get(0).getAgeId();
        } else if(starterSims > 1 && difficulty == Difficulty.NORMAL){
            origin = ages.stream().filter(entry -> entry.getAgeName().equalsIgnoreCase("young adult")).toList().get(0).getAgeId() -1;
            bound = ages.stream().filter(entry -> entry.getAgeName().equalsIgnoreCase("young adult")).toList().get(0).getAgeId();
        }

        int id = age == -1 ? new Random().nextInt(origin, bound) : age;
        return ages.stream().filter(entry -> entry.getAgeId() == id).toList().get(0);
    }

    public static LifeSpan getLifeSpan(){
        int rawLifespan = PropertiesLoader.getLifeSpanType();
        lifespan = rawLifespan == -1 ? new Random().nextInt(0, 3) : rawLifespan;

        return LifeSpan.values()[lifespan];
    }

    public static int getNumberOfSims(){
        int numberOfSims = PropertiesLoader.getNumberOfSims();
        int origin = 1;
        int bound = 9;
        int sims;

        if (numberOfSims == -1){
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
            sims = numberOfSims;
        }
        return sims;
    }

    public static Gender getRandomGender(List<Gender> genders){
        int genderOfSim = PropertiesLoader.getGenderOfSim();

        if(genderOfSim != -1){
            try{
                return genders.stream().filter(gender -> gender.getGenderId() == genderOfSim).toList().get(0);

            } catch (Exception e){
                e.printStackTrace();
            }
        }

        int origin = genders.stream().mapToInt(Gender::getGenderId).min().getAsInt();
        int bound = genders.stream().mapToInt(Gender::getGenderId).max().getAsInt() + 1;
        int id = new Random().nextInt(origin, bound);

        List<Gender> genderList;
        do {
            genderList = genders.stream().filter(entry -> entry.getGenderId() == id).toList();
        } while(genderList.size() == 0);

        return genderList.get(0);
    }

    public static Aspiration getAspiration(String age, List<AspirationAge> aspirationAgeRepository){
        int aspiration = PropertiesLoader.getAspiration();
        List<Aspiration> aspirations = AspirationController.getAllAspirationsByAgeName(age, aspirationAgeRepository);

        int id = aspiration == -1 ? new Random().nextInt(aspirations.size()) : aspiration;

        Aspiration generatedAspiration = null;

        for(int i = 0; i < aspirations.size(); i++){
            if(i == id){
                generatedAspiration = aspirations.get(i);
                break;
            }
        }

        return generatedAspiration;
    }

    public static SexualPreference getSexualPreference(){
        int sexuality = PropertiesLoader.getSexuality();
        return new SexualPreference();
//        int id = sexuality == -1 ? new Random().nextInt(SexualPreference.values().length) : sexuality;
//        return SexualPreference.values()[id];
    }

    public static int getNumberOfChildren(){
        LifeSpan lifeSpanType = LifeSpan.values()[lifespan];
        int bound = 10;
        int origin = 0;
        switch (lifeSpanType){
            case SHORT -> {
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
            case NORMAL -> {
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

            case LONG -> {
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

    public static Set<Skill> getSkillsToMax(){
        int numberOfSkillsToMax = PropertiesLoader.getMaxNumberOfSkills();
        int origin = 0;
//        int bound = Skill.values().length;

//        if(numberOfSkillsToMax == -1) {
//
//            LifeSpan lifeSpanType = LifeSpan.values()[lifespan];
//
//            switch (lifeSpanType) {
//                case SHORT -> {//short
//                    if (difficulty == Difficulty.EASY) {
//                        bound = 4;
//                    } else if (difficulty == Difficulty.NORMAL) {
//                        origin = 1;
//                        bound = 6;
//                    } else if (difficulty == Difficulty.HARD) {
//                        origin = 3;
//                        bound = 13;
//                    }
//                }
//                case NORMAL -> {//med
//                    if (difficulty == Difficulty.EASY) {
//                        bound = 7;
//                    } else if (difficulty == Difficulty.NORMAL) {
//                        origin = 2;
//                        bound = 9;
//                    } else if (difficulty == Difficulty.HARD) {
//                        origin = 5;
//                        bound = 16;
//                    }
//                }
//
//                case LONG -> {
//                    if (difficulty == Difficulty.EASY) {
//                        bound = 11;
//                    } else if (difficulty == Difficulty.NORMAL) {
//                        origin = 3;
//                        bound = 13;
//                    } else if (difficulty == Difficulty.HARD) {
//                        origin = 7;
//                    }
//                }
//            }
//
//            numberOfSkillsToMax = new Random().nextInt(origin, bound);
//        }

        Set<Skill> skills = new HashSet<>();
//        for(int i = 0; i < numberOfSkillsToMax; i++){
//            if(!skills.add(Skill.values()[new Random().nextInt(Skill.values().length)])){ //this picks skills until the max number of skills is reached
//                i--;
//            }
//        }
        return skills;
    }

//    public static Set<ToddlerSkill> getToddlerSkillsToMax(){
//        int id = new Random().nextInt(ToddlerSkill.values().length);
//        Set<ToddlerSkill> skills = new HashSet<>();
//        for(int i = 0; i <= id; i++){
//            if(!skills.add(ToddlerSkill.values()[new Random().nextInt(ToddlerSkill.values().length)])){
//                i--;
//            }
//
//        }
//        return skills;
//    }
//
//    public static Set<ChildSkill> getChildSkillsToMax(){
//        int id = new Random().nextInt(ChildSkill.values().length);
//        Set<ChildSkill> skills = new HashSet<>();
//        for(int i = 0; i <= id; i++){
//            if(!skills.add(ChildSkill.values()[new Random().nextInt(ChildSkill.values().length)])){
//                i--;
//            }
//
//        }
//        return skills;
//    }

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

    public static boolean isHeir(){
        int randomNumber = new Random().nextInt(2);
        //0 == true -- sim is heir
        //1 == false -- sim is not heir
        return randomNumber == 0;
    }
}
