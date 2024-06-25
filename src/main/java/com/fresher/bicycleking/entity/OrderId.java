package com.fresher.bicycleking.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class OrderId implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "bicycle_id")
	private Long bicycleId;

	public OrderId() {
	}

	public OrderId(Long userId, Long bicycleId) {
		this.userId = userId;
		this.bicycleId = bicycleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Long bicycleId) {
		this.bicycleId = bicycleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bicycleId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderId other = (OrderId) obj;
		return Objects.equals(bicycleId, other.bicycleId) && Objects.equals(userId, other.userId);
	}

}
