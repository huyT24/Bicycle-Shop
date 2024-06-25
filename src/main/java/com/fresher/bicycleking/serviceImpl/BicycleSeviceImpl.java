package com.fresher.bicycleking.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.fresher.bicycleking.entity.Bicycle;
import com.fresher.bicycleking.repository.BicycleRepository;
import com.fresher.bicycleking.service.BicycleService;

@Service
public class BicycleSeviceImpl implements BicycleService {

	@Autowired
	private BicycleRepository bicycleRepository;

	private Sort.Direction getDirection(String direction) {
		if ("asc".equalsIgnoreCase(direction)) {
			return Sort.Direction.ASC;
		} else if ("desc".equalsIgnoreCase(direction)) {
			return Sort.Direction.DESC;
		}

		return Sort.Direction.ASC;
	}
	
	private Pageable pageAndSortBicycle(int page, int size, String[] sort) {
		List<Order> orders = new ArrayList<Order>();

		if (sort[0].contains(",")) {
			for (String sortOrder : sort) {
				String[] _sort = sortOrder.split(",");
				orders.add(new Order(getDirection(_sort[1]), _sort[0]));
			}
		} else {
			orders.add(new Order(getDirection(sort[1]), sort[0]));
		}

		Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
	
		return pagingSort;
	}

	@Override
	public Page<Bicycle> getAllBicycles(int page, int size, String[] sort) {
		Page<Bicycle> pageBicycle = 
				bicycleRepository
				.findAll(pageAndSortBicycle(page, size, sort));

		return pageBicycle;
	}
	
	/**
	 * --start--
	 * Filter Operations
	 */

	@Override
	public Page<Bicycle> findByType(String bicycleType, 
			int page, int size, String[] sort) {
		Page<Bicycle> bicycles = 
				bicycleRepository
				.findByType(bicycleType, 
						pageAndSortBicycle(page, size, sort));
		return bicycles;
	}

	@Override
	public Page<Bicycle> findByPriceRange(int minPrice, int maxPrice,
			int page, int size, String[] sort) {
		Page<Bicycle> bicycles = 
				bicycleRepository
				.findByPrice(minPrice, maxPrice, 
						pageAndSortBicycle(page, size, sort));
		return bicycles;
	}

	@Override
	public Page<Bicycle> findByTypeAndPriceRange(String bicycleType, 
			int minPrice, int maxPrice,
			int page, int size, String[] sort) {
		Page<Bicycle> bicycles = 
				bicycleRepository
				.findByTypeAndPrice(bicycleType, minPrice, maxPrice, 
						pageAndSortBicycle(page, size, sort));

		return bicycles;
	}

	@Override
	public Page<Bicycle> findByTypeAndColor(String bicycleType, String color, 
			int page, int size, String[] sort) {
		Page<Bicycle> bicycles = 
				bicycleRepository
				.findByTypeAndColor(bicycleType, color, 
						pageAndSortBicycle(page, size, sort));
		return bicycles;
	}

	@Override
	public Page<Bicycle> findByTypeAndSize(String bicycleType, int size, 
			int page, int sizePage, String[] sort) {
		Page<Bicycle> bicycles = 
				bicycleRepository
				.findByTypeAndSize(bicycleType, size, 
						pageAndSortBicycle(page, sizePage, sort));

		return bicycles;
	}

	@Override
	public Page<Bicycle> findByPriceRangeAndColor(int minPrice, 
			int maxPrice, String color, 
			int page, int sizePage, String[] sort) {
		Page<Bicycle> bicycles = 
				bicycleRepository
				.findByPriceAndColor(minPrice, maxPrice, color, 
						pageAndSortBicycle(page, sizePage, sort));
		
		return bicycles;
	}

	@Override
	public Page<Bicycle> findByPriceRangeAndSize(int minPrice, 
			int maxPrice, int size, 
			int page, int sizePage, String[] sort) {
		 Page<Bicycle> bicycles = 
				 bicycleRepository
				 .findByPriceAndSize(minPrice, maxPrice, size, 
						 pageAndSortBicycle(page, sizePage, sort));
		return bicycles;
	}
	
	/**
	 * --End--
	 */
}
