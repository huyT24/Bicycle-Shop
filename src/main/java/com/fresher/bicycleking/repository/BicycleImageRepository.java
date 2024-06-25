package com.fresher.bicycleking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.BicycleImage;

@Repository
public interface BicycleImageRepository extends JpaRepository<BicycleImage, Long>{

}
