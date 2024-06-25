package com.fresher.bicycleking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fresher.bicycleking.entity.Bicycle;
import com.fresher.bicycleking.service.BicycleService;

@RestController
@RequestMapping("/bicycleking/shop")
public class BicycleController {
	@Autowired
	private BicycleService bicycleService;

	@GetMapping("/bicycle-list")
	public ResponseEntity<List<Bicycle>> getAllBicycles(
			@RequestParam(defaultValue = "0")
			int page, 
			@RequestParam(defaultValue = "3")
			int sizePage, 
			@RequestParam(defaultValue = "id,asc")
			String[] sort) {
		
		try {
			List<Bicycle> bicycles = new ArrayList<Bicycle>();
			Page<Bicycle> pageBicycle = bicycleService.getAllBicycles(page, sizePage, sort);
			
			if (pageBicycle.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			bicycles = pageBicycle.getContent();

			return new ResponseEntity<>(bicycles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/bicycle-list/filter/type/{type}")
	public ResponseEntity<List<Bicycle>> findByType(
			@PathVariable("type") String type,
			@RequestParam(defaultValue = "0")
			int page, 
			@RequestParam(defaultValue = "3")
			int sizePage, 
			@RequestParam(defaultValue = "id,asc")
			String[] sort
			) {
		try {
			List<Bicycle> bicycles = new ArrayList<Bicycle>();
			Page<Bicycle> pageBicycle = bicycleService.findByType(type, page, sizePage, sort);
			
			if (pageBicycle.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			bicycles = pageBicycle.getContent();
			
			return new ResponseEntity<>(bicycles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/bicycle-list/filter/min-price/{minPrice}/max-price/{maxPrice}")
	public ResponseEntity<List<Bicycle>> findByPriceRange(
			@PathVariable("minPrice") int minPrice,
			@PathVariable("maxPrice") int maxPrice,
			@RequestParam(defaultValue = "0")
			int page, 
			@RequestParam(defaultValue = "3")
			int sizePage, 
			@RequestParam(defaultValue = "id,asc")
			String[] sort
			){
		try {
			List<Bicycle> bicycles = new ArrayList<Bicycle>();
			Page<Bicycle> pageBicycle = 
					bicycleService
					.findByPriceRange(minPrice, maxPrice, 
							page, sizePage, sort);
			
			if (pageBicycle.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			bicycles = pageBicycle.getContent();
			
			return new ResponseEntity<>(bicycles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/bicycle-list/filter/type/{type}/min-price/{minPrice}/max-price/{maxPrice}")
	public ResponseEntity<List<Bicycle>> findByTypeAndPriceRange(
			@PathVariable("type")
			String bicycleType, 
			@PathVariable("minPrice")
			int minPrice,
			@PathVariable("maxPrice")
			int maxPrice,
			@RequestParam(defaultValue = "0")
			int page, 
			@RequestParam(defaultValue = "3")
			int sizePage, 
			@RequestParam(defaultValue = "id,asc")
			String[] sort
			) {
		try {
			List<Bicycle> bicycles = new ArrayList<Bicycle>();
			Page<Bicycle> pageBicycle = 
					bicycleService
					.findByTypeAndPriceRange(bicycleType, minPrice, maxPrice, 
							page, sizePage, sort);
			
			if (pageBicycle.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			bicycles = pageBicycle.getContent();
			
			return new ResponseEntity<List<Bicycle>>(bicycles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/bicycle-list/filter/type/{type}/color/{color}")
	public ResponseEntity<List<Bicycle>> findByTypeAndColor(
			@PathVariable("type")
			String bicycleType, 
			@PathVariable("color")
			String color,
			@RequestParam(defaultValue = "0")
			int page, 
			@RequestParam(defaultValue = "3")
			int sizePage, 
			@RequestParam(defaultValue = "id,asc")
			String[] sort
			) {
		try {
			List<Bicycle> bicycles = new ArrayList<Bicycle>();
			Page<Bicycle> pageBicycle = 
					bicycleService
					.findByTypeAndColor(bicycleType, color, 
							page, sizePage, sort);
			
			if (pageBicycle.isEmpty()) {
				return new ResponseEntity<List<Bicycle>>(HttpStatus.NO_CONTENT);
			}
			
			bicycles = pageBicycle.getContent();
			
			return new ResponseEntity<List<Bicycle>>(bicycles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("bicycle-list/filter/type/{type}/size/{size}")
	public ResponseEntity<List<Bicycle>> findByTypeAndSize(
			@PathVariable("type") String bicycleType, 
			@PathVariable("size") int size,
			@RequestParam(defaultValue = "0")
			int page, 
			@RequestParam(defaultValue = "3")
			int sizePage, 
			@RequestParam(defaultValue = "id,asc")
			String[] sort){
		try {
			List<Bicycle> bicycles = new ArrayList<Bicycle>();
			Page<Bicycle> pageBicycle = 
					bicycleService
					.findByTypeAndSize(bicycleType, size, page, sizePage, sort);
			
			if (pageBicycle.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			bicycles = pageBicycle.getContent();
			return new ResponseEntity<>(bicycles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("bicycle-list/filter/min-price/{minPrice}/max-price/{maxPrice}/color/{color}")
	public ResponseEntity<List<Bicycle>> findByPriceRangeAndColor(
			@PathVariable("minPrice") 
			int minPrice, 
			@PathVariable("maxPrice")
			int maxPrice, 
			@PathVariable("color")
			String color, 
			@RequestParam(defaultValue = "0")
			int page, 
			@RequestParam(defaultValue = "3")
			int sizePage, 
			@RequestParam(defaultValue = "id,asc")
			String[] sort) {
		try {
			List<Bicycle> bicycles = new ArrayList<Bicycle>();
			Page<Bicycle> pageBicycle = bicycleService.findByPriceRangeAndColor(minPrice, 
					maxPrice, color, page, sizePage, sort);
			
			if (pageBicycle.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			bicycles = pageBicycle.getContent();
			return new ResponseEntity<>(bicycles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
