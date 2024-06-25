package com.fresher.bicycleking.service;

import org.springframework.data.domain.Page;

import com.fresher.bicycleking.entity.Bicycle;

public interface BicycleService {
	Page<Bicycle> getAllBicycles(int page, int size, String[] sort);
	
	Page<Bicycle> findByType(String bicycleType, 
			int page, int size, String[] sort);

	Page<Bicycle> findByPriceRange(int minPrice, int maxPrice, 
			int page, int size, String[] sort);

	Page<Bicycle> findByTypeAndPriceRange(String bicycleType, 
			int minPrice, int maxPrice, int page, int size,
			String[] sort);

	Page<Bicycle> findByTypeAndColor(String bicycleType, 
			String color, int page, int size, String[] sort);

	Page<Bicycle> findByTypeAndSize(String bicycleType, 
			int size, int page, int size2, String[] sort);

	Page<Bicycle> findByPriceRangeAndColor(int minPrice, 
			int maxPrice, String color, int page, int sizePage,
			String[] sort);

	Page<Bicycle> findByPriceRangeAndSize(int minPrice, 
			int maxPrice, int size, int page, int sizePage, String[] sort);

}
