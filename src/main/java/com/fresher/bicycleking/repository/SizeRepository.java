package com.fresher.bicycleking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.bicycleking.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Long>{
	Integer findBySize(Integer size);
}
