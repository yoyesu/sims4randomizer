package com.ms.sims4randomnizer.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs_ages")
public class JobAge {

    @Id
    private int jobAgeId;

    @ManyToMany
    @JoinColumn(name = "jobs_name")
    private List<Job> jobs;

    @ManyToMany
    @JoinColumn(name = "age_name")
    private List<Age> ages;

    public int getJobAgeId() {
        return jobAgeId;
    }

    public void setJobAgeId(int jobAgeId) {
        this.jobAgeId = jobAgeId;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Age> getAges() {
        return ages;
    }

    public void setAges(List<Age> ages) {
        this.ages = ages;
    }
}
