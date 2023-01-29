package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.db_dtos.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Integer> {
}
