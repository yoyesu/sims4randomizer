package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.db_dtos.Aspiration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AspirationRepository extends JpaRepository<Aspiration, Integer> {
}