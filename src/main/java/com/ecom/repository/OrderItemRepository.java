package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
