package com.ms.sims4randomnizer.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "job_age")
public class JobAge {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private JobAgeId jobAgeId;

    @MapsId("job")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "job", nullable = false)
    private Job jobs;

    @MapsId("age")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "age", nullable = false)
    private Age ages;

    public JobAgeId getJobAgeId() {
        return jobAgeId;
    }

    public void setJobAgeId(JobAgeId jobAgeId) {
        this.jobAgeId = jobAgeId;
    }

    public Job getJobs() {
        return jobs;
    }

    public void setJobs(Job jobs) {
        this.jobs = jobs;
    }

    public Age getAges() {
        return ages;
    }

    public void setAges(Age ages) {
        this.ages = ages;
    }
}
