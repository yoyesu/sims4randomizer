package com.ms.sims4randomnizer.util;

import com.ms.sims4randomnizer.model.dto.AdultSim;
import com.ms.sims4randomnizer.model.dto.ChildSim;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.model.dto.ToddlerSim;
import com.ms.sims4randomnizer.model.enums.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Randomizer {

    private static int difficulty;
    private static int lifeSpanType;
    static {
        loadConfiguration();
    }

    private static void loadConfiguration() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/configuration.properties"));
            int difficultyLevel = Integer.parseInt(properties.getProperty("difficultyLevel"));
            int lifeSpan = Integer.parseInt(properties.getProperty("lifeSpan"));
            setConfiguration(difficultyLevel, lifeSpan);


        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void setConfiguration(int difficultyLevel, int lifeSpan) {
        difficulty = difficultyLevel > 0 && difficultyLevel <= 3 ? difficultyLevel : 0;
        lifeSpanType = lifeSpan > 0 && lifeSpan <= 3 ? lifeSpan : 0;

    }
    public static int getRandomJobLevel(){
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

    public static LifeSpan getRandomLifeSpan(){
        int id = new Random().nextInt(LifeSpan.values().length);
        return LifeSpan.values()[id];
    }

    public static int getNumberOfStarterSims(){
        int id = new Random().nextInt(1,9);
        return id;
    }

    public static Gender getGender(){
        int id = new Random().nextInt(Gender.values().length);
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
        int id = new Random().nextInt(8);
        return id;
    }

    public static Object[] getSkillsToMax(){
        int id = new Random().nextInt(Skill.values().length);
        Set<Skill> skills = new HashSet<>();
        for(int i = 0; i <= id; i++){
            if(!skills.add(Skill.values()[new Random().nextInt(Skill.values().length)])){
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
        int id = new Random().nextInt(2);
        // 0 married, 1 single
        return id == 0;
    }

    public static boolean getNewWedding(){
        int id = new Random().nextInt(2);
        // 0 sim will marry if single or will marry AGAIN if already married, 1 will not marry again or at all
        return id == 0;
    }
}
