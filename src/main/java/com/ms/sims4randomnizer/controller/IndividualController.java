package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.model.IndividualFormsConfig;
import com.ms.sims4randomnizer.model.StarterFormConfig;
import com.ms.sims4randomnizer.model.dto.*;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/individual")
public class IndividualController {

    @GetMapping("/")
    public String getAllGenerators(){
        return "independent-generators";
    }
    @GetMapping("/age")
    public String getStarterHousehold(Model model){
        model.addAttribute("config", new IndividualFormsConfig());

        return "individual-age";
    }

    @PostMapping("/age")
    public String submitForm(@ModelAttribute("config") IndividualFormsConfig config, Model model) {
        model.addAttribute("age", Randomizer.getRandomAgeGroup());

        return "individual-age";
    }

    @GetMapping("/job/level")
    public String getJobLevel(Model model){
        model.addAttribute("config", new IndividualFormsConfig());

        return "job-level";
    }

    @PostMapping("/job/level")
    public String displayJobLevel(@ModelAttribute("config") IndividualFormsConfig config, Model model) {
        model.addAttribute("level", Randomizer.getRandomJobLevel(0,0));

        return "job-level";
    }

    @GetMapping("/job")
    public String getJob(Model model){
        model.addAttribute("config", new IndividualFormsConfig());

        return "job";
    }

    @PostMapping("/job")
    public String displayJob(@ModelAttribute("config") IndividualFormsConfig config, Model model) {
        model.addAttribute("job", Randomizer.getRandomJob());

        return "job";
    }

    @GetMapping("/teen-job")
    public String getTeenJob(Model model){
        model.addAttribute("config", new IndividualFormsConfig());

        return "teen-job";
    }

    @PostMapping("/teen-job")
    public String displayTeenJob(@ModelAttribute("config") IndividualFormsConfig config, Model model) {
        model.addAttribute("job", Randomizer.getRandomTeenJob());

        return "teen-job";
    }

    @GetMapping("/lifespan")
    public String getLifespan(Model model){
        model.addAttribute("config", new IndividualFormsConfig());

        return "lifespan";
    }

    @PostMapping("/lifespan")
    public String displayLifespan(@ModelAttribute("config") IndividualFormsConfig config, Model model) {
        model.addAttribute("span", Randomizer.getIndependentLifeSpan());

        return "lifespan";
    }

    @GetMapping("/gender")
    public String getGender(Model model){
        model.addAttribute("config", new IndividualFormsConfig());

        return "gender";
    }

    @PostMapping("/gender")
    public String displayGender(@ModelAttribute("config") IndividualFormsConfig config, Model model) {
        model.addAttribute("gender", Randomizer.getGender());

        return "gender";
    }
}
