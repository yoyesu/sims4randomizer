package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
