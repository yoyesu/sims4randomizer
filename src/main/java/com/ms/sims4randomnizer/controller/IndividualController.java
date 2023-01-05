package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/individual")
public class IndividualController {
    @GetMapping("/age")
    public String getRandomSimAge(){
        return Randomizer.getRandomAgeGroup().name;
    }

    @GetMapping("/job/level")
    public int getJobLevel(){
        return Randomizer.getRandomJobLevel();
    }

    @GetMapping("/job")
    public String getJob(){
        return Randomizer.getRandomJob().jobName;
    }

    @GetMapping("/teen-job")
    public String getTeenJob(){
        return Randomizer.getRandomTeenJob().name();
    }

    @GetMapping("/lifespan")
    public String getLifespan(){
        return Randomizer.getLifeSpan().name();
    }

    @GetMapping("/gender")
    public String getGender(){
        return Randomizer.getGender().name();
    }
}
