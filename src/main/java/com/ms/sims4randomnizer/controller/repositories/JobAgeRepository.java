package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.JobAge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAgeRepository extends JpaRepository<JobAge, Integer> {
//    List<JobAge> findJobAgesByAges(List<Age> ages);
}
