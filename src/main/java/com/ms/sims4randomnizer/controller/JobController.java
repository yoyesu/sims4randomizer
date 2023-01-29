package com.ms.sims4randomnizer.controller;

import com.ms.sims4randomnizer.controller.repositories.AgeRepository;
import com.ms.sims4randomnizer.controller.repositories.JobAgeRepository;
import com.ms.sims4randomnizer.controller.repositories.JobRepository;
import com.ms.sims4randomnizer.model.db_dtos.Age;
import com.ms.sims4randomnizer.model.db_dtos.Job;
import com.ms.sims4randomnizer.model.db_dtos.JobAge;
import com.ms.sims4randomnizer.util.PropertiesLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @GetMapping("/all/adult")
    public static List<Job> getAllAdultJobs(){
        List<Job> jobs = new ArrayList<>();
        List<Age> ages = new ArrayList<>();
        ages.add(ageRepository.findById(4).orElseThrow());
        List<JobAge> jobsFilteredByAge = jobAgeRepository.findJobAgesByAges(ages);
        for (JobAge job : jobsFilteredByAge){
            jobs.add(job.getJobs().get(0));
        }

        return jobs;
    }

    @GetMapping("/all/teen")
    public static List<Job> getAllTeenJobs(){
        List<Job> jobs = new ArrayList<>();
        List<Age> ages = new ArrayList<>();
        ages.add(ageRepository.findById(3).orElseThrow());
        List<JobAge> jobsFilteredByAge = jobAgeRepository.findJobAgesByAges(ages);
        for (JobAge job : jobsFilteredByAge){
            jobs.add(job.getJobs().get(0));
        }

        return jobs;
    }

    @GetMapping("/random/{age}")
    public static Job getRandomJobByAge(@PathVariable String age){
        List<Job> jobs = new ArrayList<>();
        if(age.equals("teen")){
            jobs = getAllAdultJobs();
        } else if (age.equals("adult")){
            jobs = getAllTeenJobs();
        }

        int job = PropertiesLoader.getJob();
        int id = job == -1? new Random().nextInt(jobs.size()) : job;
        Job generatedJob = null;

        for(Job jobInList : jobs){
            if(jobInList.getJobId() == id){
                generatedJob = jobInList;
                break;
            }
        }

        return generatedJob;
    }
}
