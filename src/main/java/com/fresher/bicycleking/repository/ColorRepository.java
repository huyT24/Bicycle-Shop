package com.fresher.bicycleking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.bicycleking.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long>{
	String findByColorName(String colorName);
}
