package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.db_dtos.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
