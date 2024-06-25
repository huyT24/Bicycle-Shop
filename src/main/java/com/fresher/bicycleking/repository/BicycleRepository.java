package com.fresher.bicycleking.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.Bicycle;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long>{
	Page<Bicycle> findByType(String bicycleType, 
			Pageable pageable);
	
	@Query(value = "select * from bicycles "
			+ "where bicycles.bicycle_price >= ?1 "
			+ "and bicycles.bicycle_price <= ?2"
			, nativeQuery = true)
	Page<Bicycle> findByPrice(int minPrice, 
			int maxPrice, Pageable pageable);
	
	@Query(
			value = "select b from bicycles as b where b.bicycle_type = ?1 "
					+ "and b.bicycle_price >= ?2 and b.bicycle_price <= ?3"
			, nativeQuery = true)
	Page<Bicycle> findByTypeAndPrice(String bicycleType, 
			int minPrice, int maxPrice, Pageable pageable);
	
	@Query(value = "select b from "
			+ "((bicycles as b inner join bicycle_color as bc "
			+ "on b.id = bc.bicycle_id) "
			+ "inner join colors as c on bc.color_id = c.id) "
			+ "where b.bicycle_type = ?1 and c.color_name = ?2"
			, nativeQuery = true)
	Page<Bicycle> findByTypeAndColor(String bicycleType, 
			String color, Pageable pageable);
	
	@Query(value = "select b from "
			+ "((bicycles as b inner join bicycle_size as bs "
			+ "on b.id = bs.bicycle_id) "
			+ "inner join size as s on s.id = bs.size_id) "
			+ "where b.bicycle_type = ?1 and s.size = ?2"
			, nativeQuery = true)
	Page<Bicycle> findByTypeAndSize(String bicycleType, 
			int size, Pageable pageable);
	
	@Query(value = "select b  from "
			+ "((bicycles as b inner join bicycle_color as bc "
			+ "on b.id = bc.bicycle_id) "
			+ "inner join colors as c on bc.color_id = c.id) "
			+ "where c.color_name = ?3 and b.bicycle_price between ?1 and ?2"
			, nativeQuery = true)
	Page<Bicycle> findByPriceAndColor(int minPrice, 
			int maxPrice, String color, Pageable pageable);
	
	@Query(value = "select b from "
			+ "((bicycles as b inner join bicycle_size as bs on b.id = bs.bicycle_id)"
			+ "inner join size as s on bs.size_id = s.id) "
			+ "where s.size = ?3 and b.bicycle_price between ?1 and ?2", 
			nativeQuery = true)
	Page<Bicycle> findByPriceAndSize(int minPrice, int maxPrice, 
			int size, Pageable pageable);
	
}