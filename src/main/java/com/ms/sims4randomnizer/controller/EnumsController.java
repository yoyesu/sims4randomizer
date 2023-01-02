package com.ms.sims4randomnizer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ms.sims4randomnizer.model.enums.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enums")
public class EnumsController {

    @GetMapping("/age")
    public ResponseEntity<AgeGroup[]> getAgeList() {

        AgeGroup[] ages = AgeGroup.values();
        return ResponseEntity.status(HttpStatus.OK).body(ages);
    }

    @GetMapping("/aspirations")
    public ResponseEntity<Aspiration[]> getAspirationList() {

        Aspiration[] aspirations = Aspiration.values();
        return ResponseEntity.status(HttpStatus.OK).body(aspirations);
    }

    @GetMapping("/child-aspirations")
    public ResponseEntity<ChildAspiration[]> getChildAspirationList() {

        ChildAspiration[] aspirations = ChildAspiration.values();
        return ResponseEntity.status(HttpStatus.OK).body(aspirations);
    }

    @GetMapping("/child-skills")
    public ResponseEntity<ChildSkills[]> getChildSkillsList() {

        ChildSkills[] skills = ChildSkills.values();
        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }

    // NOT MAKING A REQUEST FOR GENDER ENUMS

    @GetMapping("/jobs")
    public ResponseEntity<Job[]> getJobsList() {

        Job[] jobs = Job.values();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    // NOT MAKING A REQUEST FOR LIFESPAN

    @GetMapping("/sexual-preference")
    public ResponseEntity<SexualPreference[]> getSexualPreferenceList() {

        SexualPreference[] preference = SexualPreference.values();
        return ResponseEntity.status(HttpStatus.OK).body(preference);
    }

    @GetMapping("/skills")
    public ResponseEntity<Skill[]> getSkillsList() {

        Skill[] skills = Skill.values();
        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }

    @GetMapping("/teen-jobs")
    public ResponseEntity<TeenJob[]> getTeenJobsList() {

        TeenJob[] jobs = TeenJob.values();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @GetMapping("/toddler-skills")
    public ResponseEntity<ToddlerSkills[]> getToddlerSkillsList() {

        ToddlerSkills[] skills = ToddlerSkills.values();
        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }
}
