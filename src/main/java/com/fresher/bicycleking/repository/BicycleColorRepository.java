package com.fresher.bicycleking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.bicycleking.entity.Color;

public interface BicycleColorRepository extends JpaRepository<Color, Long>{
	Optional<List<Color>> findByColorName(String color);
}
