package com.ms.sims4randomnizer.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    private int jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_max_level")
    private int jobMaxLevel;

    @ManyToOne
    @JoinColumn(name = "pack_name")
    private Pack pack;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobMaxLevel() {
        return jobMaxLevel;
    }

    public void setJobMaxLevel(int jobMaxLevel) {
        this.jobMaxLevel = jobMaxLevel;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }
}
