package com.jsp.medishop.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.OrderDao;
import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.OrderService;

import jakarta.servlet.http.HttpSession;

/**
 * @author Atul
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private HttpSession session;
	@Autowired
	private OrderDao dao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private MedicineDao medicineDao;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private ResponseStructure<OrderEntity> structure;
	@Autowired
	private ResponseStructure<List<OrderEntity>> structure2;

	@Override
	public ResponseStructure<OrderEntity> saveOrderService(OrderEntity order, int medicineId, int customerId) {
		Customer customer = customerDao.getCustomerByIdDao(customerId);
		if (customer != null) {
			long orderId = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
			order.setOrderId(orderId);
			Medicine medicine = medicineDao.getMedicineByIdDao(medicineId);
			Vendor vendor = vendorDao.getVendorByIdDao(medicine.getVendor().getId());
			order.setVendor(vendor);
			order.setCustomer(customer);
			order.setMedicine(medicine);
			order.setTotalAmount(medicine.getPrice() * order.getQuantity());
			order.setOrderDate(LocalDate.now());
			order.setEstimateDeliveryDate(LocalDate.now().plusDays(4));
			OrderEntity order2 = dao.saveOrderDao(order);
			if (order2 != null) {
				structure.setData(order2);
				structure.setMsg("Order Confirmed!!!");
				structure.setStatus(HttpStatus.OK.value());
			} else {
				structure.setData(order2);
				structure.setMsg("Order not Confirmed!!!");
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			}
		} else {
			structure.setData(null);
			structure.setMsg("please login before placing order!");
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

	@Override
	public ResponseStructure<List<OrderEntity>> getOrdersByVendorIdService(int vendorId) {
		Vendor vendor = vendorDao.getVendorByIdDao(vendorId);
		if (vendor != null) {
			List<OrderEntity> entities = dao.getAllOrders();
			List<OrderEntity> orders = new ArrayList<OrderEntity>();
			if (!entities.isEmpty()) {
				for (OrderEntity entity : entities) {
					if (entity.getVendor().getId() == vendorId) {
						orders.add(entity);
					}
				}
			}
			structure2.setData(entities);
			structure2.setMsg("Orders find!");
			structure2.setStatus(HttpStatus.FOUND.value());
		} else {
			structure2.setData(null);
			structure2.setMsg("Vendor not find!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<List<OrderEntity>> getOrdersByCustomerIdService(int customerId) {
		Customer customer = customerDao.getCustomerByIdDao(customerId);
		if (customer != null) {
			List<OrderEntity> entities = dao.getAllOrders();
			List<OrderEntity> orders = new ArrayList<OrderEntity>();
			if (!entities.isEmpty()) {
				for (OrderEntity entity : entities) {
					if (entity.getVendor().getId() == customerId) {
						orders.add(entity);
					}
				}
			}
			structure2.setData(entities);
			structure2.setMsg("Orders find!");
			structure2.setStatus(HttpStatus.FOUND.value());
		} else {
			structure2.setData(null);
			structure2.setMsg("Customer not find!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

}
