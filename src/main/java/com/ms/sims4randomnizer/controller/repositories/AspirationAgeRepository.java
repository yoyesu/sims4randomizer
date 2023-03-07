package com.ms.sims4randomnizer.controller.repositories;

import com.ms.sims4randomnizer.model.entities.Age;
import com.ms.sims4randomnizer.model.entities.AspirationAge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AspirationAgeRepository extends JpaRepository<AspirationAge, Integer> {

//    List<AspirationAge> findAspirationAgesByAges(List<Age> ages);
}
