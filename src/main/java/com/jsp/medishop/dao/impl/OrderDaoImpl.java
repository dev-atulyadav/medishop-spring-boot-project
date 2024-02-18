package com.jsp.medishop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.OrderDao;
import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.repository.OrderRepository;

/**
 * @author Atul
 */
@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private OrderRepository repository;

	@Override
	public OrderEntity saveOrderDao(OrderEntity order) {
		return repository.save(order);
	}

	@Override
	public OrderEntity getOrderByIdDao(int id) {
		return repository.findById(id).get();
	}

	@Override
	public OrderEntity updateOrderStatusByIdDao(int id, String status) {
		OrderEntity order = getOrderByIdDao(id);
		if (order != null) {
			order.setStatus(status);
			return repository.save(order);
		}
		return null;
	}

	@Override
	public OrderEntity deleteOrderByIdDao(int id) {
		OrderEntity order = getOrderByIdDao(id);
		if (order != null) {
			if (!order.getStatus().equals("Delivered") || !order.getStatus().equals("Cancelled")) {
				repository.delete(order);
				return null;
			}
		}
		return order;
	}

}
