package com.fresher.bicycleking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.Order;
import com.fresher.bicycleking.entity.OrderId;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderId>{

}
