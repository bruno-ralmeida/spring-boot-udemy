package com.xxnbr.cursomc.repositories;

import com.xxnbr.cursomc.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}