package com.ms.sims4randomnizer.util;

import com.ms.sims4randomnizer.model.*;

import java.util.*;

public class Randomizer {

    public static int getRandomJobLevel(){
        int rn = new Random().nextInt(1, 11);
        return rn;
    }

    public static Job getRandomJob(){
        int id = new Random().nextInt(Job.values().length);
        return Job.values()[id];
    }

    public static AgeGroup getRandomAgeGroup(){
        int id = new Random().nextInt(AgeGroup.values().length);
        return AgeGroup.values()[id];
    }

    public static LifeSpan getRandomLifeSpan(){
        int id = new Random().nextInt(LifeSpan.values().length);
        return LifeSpan.values()[id];
    }

    public static int getNumberOfStarterSims(){
        int id = new Random().nextInt(9);
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
