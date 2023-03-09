package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.controller.repositories.JobAgeRepository;
import com.ms.sims4randomnizer.controller.repositories.JobRepository;
import com.ms.sims4randomnizer.exceptions.InvalidVariable;
import com.ms.sims4randomnizer.model.entities.*;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private static JobRepository jobRepository;
    private static JobAgeRepository jobAgeRepository;
    private static AgeRepository ageRepository;

    @Autowired
    public JobController(JobRepository jobRepository, JobAgeRepository jobAgeRepository, AgeRepository ageRepository){
        JobController.jobRepository = jobRepository;
        JobController.jobAgeRepository = jobAgeRepository;
        JobController.ageRepository = ageRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs(){
        return new ResponseEntity<>(jobRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/all/{ageName}")
    public static ResponseEntity<List<Job>> getAllJobsByAge(@PathVariable String ageName){
        return new ResponseEntity<>(getAllJobsByAgeName(ageName), HttpStatus.OK);
    }

    @GetMapping("/random/{age}")
    public static ResponseEntity<Job> getRandomJobByAge(@PathVariable String age){
        if(age == null || age.isEmpty()){
            System.out.println("inside error");
            throw new RuntimeException();
        }

        //TODO create util method to check path variable type string

        return new ResponseEntity<>(Randomizer.getRandomJob(age), HttpStatus.OK);
    }

    public static List<Job> getAllJobsByAgeName(String ageName){
        List<Job> jobs = new ArrayList<>();
        List<JobAge> jobAges = jobAgeRepository.findAll().stream().filter(entry -> entry.getAges().getAgeName().equalsIgnoreCase(ageName)).toList();

        jobAges.forEach(entry -> jobs.add(entry.getJobs()));

        return jobs;
    }
}
