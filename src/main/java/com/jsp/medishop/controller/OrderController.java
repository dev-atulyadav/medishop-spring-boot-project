package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.OrderService;

/**
 * @author Atul
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping(value = "/placeOrder/{medicineId}")
	public ResponseStructure<OrderEntity> saveOrderContoller(@RequestBody OrderEntity order,
			@PathVariable int medicineId) {
		return service.saveOrderService(order, medicineId);
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseStructure<OrderEntity> getOrderByIdController(@PathVariable int id) {
		return service.getOrderByIdService(id);
	}

	@PatchMapping(value = "/updateStatusById/{id}/{status}")
	public ResponseStructure<OrderEntity> updateOrderStatusByIdController(@PathVariable int id,
			@PathVariable String status) {
		return service.updateOrderStatusByIdService(id, status);
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseStructure<OrderEntity> deleteOrderByIdController(@PathVariable int id) {
		return service.deleteOrderByIdService(id);
	}

}
