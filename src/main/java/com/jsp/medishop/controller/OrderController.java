package com.jsp.medishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping(value = "/placeOrder/{medicineId}/{customerId}")
	public ResponseStructure<OrderEntity> saveOrderContoller(@RequestBody OrderEntity order,
			@PathVariable int medicineId, @PathVariable int customerId) {
		return service.saveOrderService(order, medicineId, customerId);
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseStructure<OrderEntity> getOrderByIdController(@PathVariable int id) {
		return service.getOrderByIdService(id);
	}

	@PutMapping(value = "/updateStatusById/{id}/{status}")
	public ResponseStructure<OrderEntity> updateOrderStatusByIdController(@PathVariable int id,
			@PathVariable String status) {
		return service.updateOrderStatusByIdService(id, status);
	}

	@GetMapping(value = "/getOrdersByVendorId/{vendorId}")
	public ResponseStructure<List<OrderEntity>> getOrdersByVendorIdController(@PathVariable int vendorId) {
		return service.getOrdersByVendorIdService(vendorId);
	}

	@GetMapping(value = "/getOrdersByCustomerId/{customerId}")
	public ResponseStructure<List<OrderEntity>> getOrdersByCustomerIdController(@PathVariable int customerId) {
		return service.getOrdersByCustomerIdService(customerId);
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseStructure<OrderEntity> deleteOrderByIdController(@PathVariable int id) {
		return service.deleteOrderByIdService(id);
	}

}
