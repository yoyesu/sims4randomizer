package com.ms.sims4randomnizer;

import com.ms.sims4randomnizer.util.PropertiesLoader;
import com.ms.sims4randomnizer.util.Randomizer;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomClassTests {
    //TODO before hook to reset properties?
    @Test
    @DisplayName("Job level is equal or greater than 1")
    void checkJobLevelIsEqualOrGreaterThan1() {
        PropertiesLoader.setDifficulty(-1);
        PropertiesLoader.setJobLevel(-1);
        assertThat(Randomizer.getRandomJobLevel(), greaterThanOrEqualTo(0));
    }

    @Test
    @DisplayName("Job level is equal or lower than 10")
    void jobLevelIsEqualOrLowerThan10() {
        PropertiesLoader.setDifficulty(-1);
        PropertiesLoader.setJobLevel(-1);
        assertThat(Randomizer.getRandomJobLevel(), lessThanOrEqualTo(10));
        System.out.println("job level should be random " + Randomizer.getRandomJobLevel());
    }

    @Test
    @DisplayName("Job Level is equal to the one in Properties Loader")
    void jobLevelIsEqualToTheOneInPropertiesLoader() {
        PropertiesLoader.setDifficulty(-1);
        PropertiesLoader.setJobLevel(2);
        assertThat(Randomizer.getRandomJobLevel(),is(PropertiesLoader.getJobLevel()));
        System.out.println(Randomizer.getRandomJobLevel());
    }

    @Test
    @DisplayName("Job level difficulty HARD is equal or greater than 5")
    void jobLevelDifficultyHardIsEqualOrGreaterThan5() {
        PropertiesLoader.setJobLevel(-1);
        PropertiesLoader.setDifficulty(2);
        assertThat(Randomizer.getRandomJobLevel(), greaterThanOrEqualTo(5));
    }
}
