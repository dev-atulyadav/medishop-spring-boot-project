package com.jsp.medishop.dao;

/**
 * @author Atul
 */

import com.jsp.medishop.dto.OrderEntity;

public interface OrderDao {

	public OrderEntity saveOrderDao(OrderEntity order);

	public OrderEntity getOrderByIdDao(int id);

	public OrderEntity updateOrderStatusByIdDao(int id, String status);

	public OrderEntity deleteOrderByIdDao(int id);
}
