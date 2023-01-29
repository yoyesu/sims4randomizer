package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.db_dtos.Age;
import com.ms.sims4randomnizer.model.db_dtos.Job;
import com.ms.sims4randomnizer.model.db_dtos.JobAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface JobAgeRepository extends JpaRepository<JobAge, Integer> {

    List<JobAge> findJobAgesByAges(List<Age> ages);
}
