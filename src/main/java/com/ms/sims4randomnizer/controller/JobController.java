package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.controller.repositories.JobAgeRepository;
import com.ms.sims4randomnizer.controller.repositories.JobRepository;
import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.Job;
import com.ms.sims4randomnizer.model.entities.JobAge;
import com.ms.sims4randomnizer.util.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    @GetMapping("/all/{ageName}")
    public static List<Job> getAllJobsByAge(@PathVariable String ageName){
        return getAllJobsByAgeName(ageName);
    }

    @GetMapping("/random/{age}")
    public static Job getRandomJobByAge(@PathVariable String age){
        return Randomizer.getRandomJob(age);
    }

    public static List<Job> getAllJobsByAgeName(String ageId){
        List<Job> jobs = new ArrayList<>();
        List<Age> ages = new ArrayList<>();
        ages.add(ageRepository.findAgeByAgeNameEqualsIgnoreCase(ageId));
        List<JobAge> jobsFilteredByAge = jobAgeRepository.findJobAgesByAges(ages);
        for (JobAge job : jobsFilteredByAge){
            jobs.add(job.getJobs().get(0));
        }

        return jobs;
    }
}
