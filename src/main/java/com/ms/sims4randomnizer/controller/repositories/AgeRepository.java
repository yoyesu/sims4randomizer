package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.db_dtos.Age;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgeRepository extends JpaRepository<Age, Integer> {
        Age findAgeByAgeNameEqualsIgnoreCase(String name);
}
