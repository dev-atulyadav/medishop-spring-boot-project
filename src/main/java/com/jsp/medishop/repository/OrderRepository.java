package com.jsp.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.OrderEntity;

/**
 * @author Atul
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
