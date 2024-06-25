package com.fresher.bicycleking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.Size;

@Repository
public interface BicycleSizeRepository extends JpaRepository<Size, Long>{
	Optional<Size> findBySize(int size);
}
