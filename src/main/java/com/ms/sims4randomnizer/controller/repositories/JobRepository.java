package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.entities.Job;
import com.ms.sims4randomnizer.model.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    Job findJobByJobId(int id);
    List<Job> findJobsByPack(Pack pack);
}
