package com.ms.sims4randomnizer.model;

import com.ms.sims4randomnizer.controller.PropertiesConfiguration;
import com.ms.sims4randomnizer.controller.PropertiesLoader;
import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;
import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.AspirationAge;
import com.ms.sims4randomnizer.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

import static com.ms.sims4randomnizer.util.Randomizer.*;

public class GameSaveFactory {

    public static GameSave createGameSave(String modality, PropertiesConfiguration config, List<Age> ages, List<AspirationAge> aspirationAgeRepository){
        switch (modality){
            case "single" ->{ return generateGameSaveForSingleSimHousehold(config, ages, aspirationAgeRepository);}
            case "multiple" -> {return generateGameSaveForGeneralHousehold(config, ages, aspirationAgeRepository);}
            default -> throw new RuntimeException();
        }
    }

    private static GameSave generateGameSaveForSingleSimHousehold(PropertiesConfiguration config, List<Age> ages, List<AspirationAge> aspirationAgeRepository) {

        PropertiesLoader.setGenderOfSim(config.getGender());
        PropertiesLoader.setDifficulty(config.getDifficulty());
        Randomizer.difficulty = Randomizer.getDifficulty();
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setSimAge(config.getAge());
        PropertiesLoader.setAspiration(config.getAspiration());
        PropertiesLoader.setJob(config.getJob());
        PropertiesLoader.setChildrenToHave(config.getChildren());
        PropertiesLoader.setAlreadyMarried(config.getIsMarried());
        PropertiesLoader.setWedding(config.getWillMarry());
        PropertiesLoader.setSexuality(config.getSexuality());
        PropertiesLoader.setJobLevel(config.getJobLevel());
        PropertiesLoader.setMaxNumberOfSkills(config.getSkillsArrayLength());

        return new GameSave(generateHousehold(1, ages, aspirationAgeRepository));
    }

    private static Household generateHousehold(int numberOfSims, List<Age> ages, List<AspirationAge> aspirationAgeRepository){
        return new Household(getLifeSpan(), generateSims(numberOfSims, ages, aspirationAgeRepository));
    }

    private static List<Sim> generateSims(int numberOfSims, List<Age> ages, List<AspirationAge> aspirationAgeRepository){
        List<Sim> sims = new ArrayList<>();

        for(int i = 0; i < numberOfSims; i++){
            Sim sim = SimFactory.createSims(Randomizer.getRandomAgeGroup(numberOfSims, ages), aspirationAgeRepository);
            sims.add(sim);
        }

        return sims;
    }

    private static GameSave generateGameSaveForGeneralHousehold(PropertiesConfiguration config, List<Age> ages, List<AspirationAge> aspirationAgeRepository){

        PropertiesLoader.resetProperties();

        PropertiesLoader.setDifficulty(config.getDifficulty());
        Randomizer.difficulty = Randomizer.getDifficulty();
        PropertiesLoader.setLifeSpanType(config.getLifespan());
        PropertiesLoader.setNumberOfStarterSims(config.getStarterSims());

        return new GameSave(generateHousehold(getNumberOfSims(), ages, aspirationAgeRepository));
    }

}
