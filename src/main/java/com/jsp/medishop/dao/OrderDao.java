package com.jsp.medishop.dao;

import java.util.List;

/**
 * @author Atul
 */

import com.jsp.medishop.dto.OrderEntity;

public interface OrderDao {

	public OrderEntity saveOrderDao(OrderEntity order);

	public OrderEntity getOrderByIdDao(int id);

	public OrderEntity updateOrderStatusByIdDao(int id, String status);

	public OrderEntity deleteOrderByIdDao(int id);
	
	public List<OrderEntity> getAllOrders();
}
