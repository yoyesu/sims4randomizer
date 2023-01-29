package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.db_dtos.PackType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackTypeRepository extends JpaRepository<PackType, Integer> {
}
