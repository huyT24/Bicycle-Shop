package com.fresher.bicycleking.entity;

import com.fresher.bicycleking.enums.OrderStatus;
import com.fresher.bicycleking.enums.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
	@EmbeddedId
	private OrderId orderKey;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@MapsId("bicycleId")
	@JoinColumn(name = "bicycle_id")
	private Bicycle bicycle;
	
	@Column(name = "receiver_full_name")
	private String receiverFullName;
	
	@Column(name = "receiver_address")
	private String receiverAddres;
	
	@Column(name = "receiver_phone_number")
	private String receiverPhoneNumber;
	
	@Column(name = "payment_type")
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@Column(name = "order_status")
	@Enumerated(EnumType.ORDINAL)
	private OrderStatus orderStatus;
}
