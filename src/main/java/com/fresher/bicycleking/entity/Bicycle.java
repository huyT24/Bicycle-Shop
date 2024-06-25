package com.fresher.bicycleking.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "bicycles")
public class Bicycle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "bicycle_name", nullable = false)
	private String name;
	
	@Column(name = "bicycle_price", nullable = false)
	private Integer price;
	
	@Column(name = "bicycle_type", nullable = false)
	private String type;
	
	@Column(name = "bicycle_description", nullable = false)
	private String description;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	@JoinTable(name = "bicycle_size",
	joinColumns = @JoinColumn(name="bicycle_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="size_id", referencedColumnName = "id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonManagedReference
	private List<Size> sizes;
	
	@OneToMany(mappedBy = "bicycle", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonManagedReference
	private List<BicycleImage> bicycleImages;
	
	@OneToMany(mappedBy = "bicycle", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonManagedReference
	private List<Order> orders;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	@JoinTable(name = "bicycle_color",
	joinColumns = @JoinColumn(name = "bicycle_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name ="color_id", referencedColumnName = "id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonManagedReference
	private List<Color> colors;
}
