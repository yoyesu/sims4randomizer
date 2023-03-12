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
    private Job job;

    @MapsId("age")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "age", nullable = false)
    private Age age;

    public JobAgeId getJobAgeId() {
        return jobAgeId;
    }

    public void setJobAgeId(JobAgeId jobAgeId) {
        this.jobAgeId = jobAgeId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }
}
