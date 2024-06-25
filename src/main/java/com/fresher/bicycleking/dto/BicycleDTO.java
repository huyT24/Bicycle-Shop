package com.fresher.bicycleking.dto;

import java.util.List;

import com.fresher.bicycleking.entity.BicycleImage;
import com.fresher.bicycleking.entity.Color;
import com.fresher.bicycleking.entity.Order;
import com.fresher.bicycleking.entity.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BicycleDTO {
	private String nameString;
	private Integer price;
	private String type;
	private String description;
	private List<Size> sizes;
	private List<BicycleImage> bicycleImages;
	private List<Order> orders;
	private List<Color> colors;
}
