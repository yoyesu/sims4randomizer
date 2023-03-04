package com.ms.sims4randomnizer;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.ms.sims4randomnizer.model.enums.Difficulty;
import com.ms.sims4randomnizer.model.enums.Job;
import com.ms.sims4randomnizer.model.enums.TeenJob;
import com.ms.sims4randomnizer.util.PropertiesLoader;
import com.ms.sims4randomnizer.util.Randomizer;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomClassTests {

    @BeforeEach
    public void resetPropertiesLoader(){
        PropertiesLoader.resetProperties();
    }
    @Test
    @DisplayName("Job level is equal or greater than 1")
    void checkJobLevelIsEqualOrGreaterThan1() {
        Randomizer.difficulty = Randomizer.getDifficulty();
        PropertiesLoader.setJobLevel(-1);
        assertThat(Randomizer.getRandomJobLevel(), greaterThanOrEqualTo(0));
    }

    @Test
    @DisplayName("Job level is equal or lower than 10")
    void jobLevelIsEqualOrLowerThan10() {
        Randomizer.difficulty = Randomizer.getDifficulty();
        PropertiesLoader.setJobLevel(-1);
        assertThat(Randomizer.getRandomJobLevel(), lessThanOrEqualTo(10));
    }

    @Test
    @DisplayName("Job Level is equal to the one in Properties Loader")
    void jobLevelIsEqualToTheOneInPropertiesLoader() {
        Randomizer.difficulty = Randomizer.getDifficulty();
        PropertiesLoader.setJobLevel(2);
        assertThat(Randomizer.getRandomJobLevel(),is(PropertiesLoader.getJobLevel()));
    }

    @Test
    @DisplayName("Job level difficulty HARD is equal or greater than 5")
    void jobLevelDifficultyHardIsEqualOrGreaterThan5() {
        PropertiesLoader.setJobLevel(-1);
        Randomizer.difficulty = Difficulty.HARD;
        assertThat(Randomizer.getRandomJobLevel(), greaterThanOrEqualTo(5));
    }

    @Test
    @DisplayName("Job level difficulty NORMAL is equal or greater than 3")
    void jobLevelDifficultyNormalIsEqualOrGreaterThan3() {
        PropertiesLoader.setJobLevel(-1);
        Randomizer.difficulty = Difficulty.NORMAL;
        assertThat(Randomizer.getRandomJobLevel(), greaterThanOrEqualTo(3));
    }

    @Test
    @DisplayName("Job level difficulty NORMAL is less than 8")
    void jobLevelDifficultyNormalIsLessThan8() {
        PropertiesLoader.setJobLevel(-1);
        Randomizer.difficulty = Difficulty.NORMAL;
        assertThat(Randomizer.getRandomJobLevel(), lessThan(8));
    }

    @Test
    @DisplayName("Job level difficulty EASY is less than 4")
    void jobLevelDifficultyEasyIsLessThan4() {
        PropertiesLoader.setJobLevel(-1);
        Randomizer.difficulty = Difficulty.EASY;
        assertThat(Randomizer.getRandomJobLevel(), lessThan(4));
    }

    @Test
    @DisplayName("Random job generated with job set to -1")
    void randomJobGeneratedWithJobSetToMinus1() {
        Job[] jobs = Job.values();
        Randomizer.difficulty = Difficulty.EASY;
        assertThat(Randomizer.getRandomJob(), is(in(jobs)));
    }

    @Test
    @DisplayName("Job index equals job in propertiesLoader")
    void jobIndexEqualsJobInPropertiesLoader() {
        PropertiesLoader.setJob(5);
        Randomizer.difficulty = Difficulty.EASY;
        assertThat(Randomizer.getRandomJob().ordinal(), equalTo(PropertiesLoader.getJob()));
    }

    @Test
    @DisplayName("Random teen job generated with job set to -1")
    void randomTeenJobGeneratedWithJobSetToMinus1() {
        TeenJob[] jobs = TeenJob.values();
        Randomizer.difficulty = Difficulty.EASY;
        assertThat(Randomizer.getRandomTeenJob(), is(in(jobs)));
    }

    @Test
    @DisplayName("Teen Job index equals job in propertiesLoader")
    void teenJobIndexEqualsJobInPropertiesLoader() {
        PropertiesLoader.setJob(3);
        Randomizer.difficulty = Difficulty.EASY;
        assertThat(Randomizer.getRandomTeenJob().ordinal(), equalTo(PropertiesLoader.getJob()));
    }
}
