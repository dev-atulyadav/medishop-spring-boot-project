package com.jsp.medishop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.OrderDao;
import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.OrderService;

/**
 * @author Atul
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;
	@Autowired
	private ResponseStructure<OrderEntity> structure;

	@Override
	public ResponseStructure<OrderEntity> saveOrderService(OrderEntity order) {
		OrderEntity order2 = dao.saveOrderDao(order);
		if (order2 != null) {
			structure.setData(order2);
			structure.setMsg("Order Confirmed!!!");
			structure.setStatus(HttpStatus.CREATED.value());
		} else {
			structure.setData(order2);
			structure.setMsg("Order not Confirmed!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<OrderEntity> getOrderByIdService(int id) {
		OrderEntity order = dao.getOrderByIdDao(id);
		if (order != null) {
			structure.setData(order);
			structure.setMsg("Details Matched!!!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(order);
			structure.setMsg("Not Found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<OrderEntity> updateOrderStatusByIdService(int id, String status) {
		OrderEntity order = dao.updateOrderStatusByIdDao(id, status);
		if (order != null) {
			structure.setData(order);
			structure.setMsg("Status Updated!!!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(order);
			structure.setMsg("Invalid Order!!! Can't update!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<OrderEntity> deleteOrderByIdService(int id) {
		OrderEntity order = dao.deleteOrderByIdDao(id);
		if (order == null) {
			structure.setData(order);
			structure.setMsg("Order Cancelled!!!");
		} else if (order.getStatus().equals("Delivered")) {
			structure.setData(order);
			structure.setMsg("Can't delete a delivered order!!!");
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
		} else {
			structure.setData(order);
			structure.setMsg("Invalid Order Details!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

}
