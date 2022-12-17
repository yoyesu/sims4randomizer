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
}
