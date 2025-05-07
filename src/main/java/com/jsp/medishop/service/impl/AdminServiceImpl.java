package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.AdminDao;
import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.OrderDao;
import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.exception.InvalidUserCredentialException;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;
import com.jsp.medishop.service.CustomerService;
import com.jsp.medishop.service.VendorService;

import jakarta.servlet.http.HttpSession;

/**
 * @author Atul
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private HttpSession session;
	@Autowired
	private AdminDao dao;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private MedicineDao medicineDao;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private ResponseStructure<Admin> structure;
	@Autowired
	private ResponseStructure<List<Vendor>> structure2;
	@Autowired
	private ResponseStructure<List<Customer>> customerStructure;
	@Autowired
	private ResponseStructure<Vendor> structure3;

	@Autowired
	private ResponseStructure<Object> structure4;
	@Autowired
	private ResponseStructure<Medicine> structure5;
	@Autowired
	private ResponseStructure<List<OrderEntity>> structure6;

	public ResponseStructure<Admin> getAdminByEmailService(String email, String password) {
		Admin admin = dao.getAdminByEmailDao(email);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				session.setAttribute("adminEmail", email);
				structure.setData(admin);
				structure.setMsg("Logged in successfully!!!");
				structure.setStatus(HttpStatus.FOUND.value());
			} else {
				throw new InvalidUserCredentialException();
			}
		} else {
			throw new InvalidUserCredentialException();
		}
		return structure;
	}

	@Override
	public ResponseEntity<String> logoutAdminService() {
		if (session.getAttribute("adminEmail") != null) {
			session.invalidate();
			return new ResponseEntity<String>("Logged out Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invaild request please login first!", HttpStatus.OK);
		}
	}

	@Override
	public ResponseStructure<List<Vendor>> getAllVendorsByAdminService(String adminEmail) {
		if (adminEmail != null) {
			return vendorService.getAllVendorsService();
		} else {
			structure2.setData(null);
			structure2.setMsg("Please login as admin to get all data!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<List<Customer>> getAllCustomersByAdminService(String adminEmail) {
		if (adminEmail != null) {
			return customerService.getAllCustomersService();
		} else {
			customerStructure.setData(null);
			customerStructure.setMsg("Please login as admin to get all data!");
			customerStructure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return customerStructure;
	}

	@Override
	public ResponseStructure<Medicine> updateMedicineStatusByVendorIdService(int vendorId, int medicineId,
			String status, String adminEmail) {
		if (adminEmail != null) {
			Vendor vendor = vendorDao.getVendorByIdDao(vendorId);
			if (vendor != null) {
				List<Medicine> list = medicineDao.getAllMedicinesDao();
				if (!list.isEmpty()) {
					for (Medicine medicine : list) {
						if (medicine.getId() == medicineId && medicine.getVendor().getId() == vendorId) {
							Medicine updatedMedicine = medicineDao.updateMedicineStatusByIdDao(medicineId, status);
							if (updatedMedicine != null) {
								structure5.setData(updatedMedicine);
								structure5.setMsg("status updated");
								structure5.setStatus(HttpStatus.ACCEPTED.value());
							}
						}
					}
				} else {
					structure5.setData(null);
					structure5.setMsg("no medicines found!");
					structure5.setStatus(HttpStatus.OK.value());
				}
			} else {
				structure5.setData(null);
				structure5.setMsg("No data found!");
				structure5.setStatus(HttpStatus.NOT_FOUND.value());
			}
		} else {
			structure5.setData(null);
			structure5.setMsg("Please login as admin first before upadting medicines!");
			structure5.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		return structure5;
	}

	@Override
	public ResponseStructure<Vendor> updateVendorDetailsByAdminService(Vendor vendor, String adminEmail) {
		if (dao.getAdminByEmailDao(adminEmail) != null) {
			Vendor updatedVendor = vendorDao.updateVendorByEmailDao(vendor);
			if (updatedVendor != null) {
				structure3.setData(updatedVendor);
				structure3.setMsg("Vendor updated!");
				structure3.setStatus(HttpStatus.ACCEPTED.value());
			} else {
				structure3.setData(null);
				structure3.setMsg("Vendor not found!");
				structure3.setStatus(HttpStatus.NOT_FOUND.value());
			}
		} else {
			structure3.setData(null);
			structure3.setMsg("Admin not found!");
			structure3.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure3;
	}

	@Override
	public ResponseStructure<Object> getAdminSessionService() {
		if (session.getAttribute("adminEmail") != null) {
			structure4.setMsg("Admin is Logged In!");
			structure4.setStatus(HttpStatus.FOUND.value());
			structure4.setData(session.getAttribute("adminEmail"));
		} else {
			structure4.setMsg("Please logged In as admin!");
			structure4.setStatus(HttpStatus.NOT_FOUND.value());
			structure4.setData(null);
		}
		return structure4;
	}

	@Override
	public ResponseStructure<List<OrderEntity>> getAllOrderByAdminService(String email) {
		Admin admin = dao.getAdminByEmailDao(email);
		if (admin != null) {
			List<OrderEntity> entities = orderDao.getAllOrders();
			structure6.setData(entities);
			structure6.setMsg("Found Orders!");
			structure6.setStatus(HttpStatus.FOUND.value());
		} else {
			structure6.setData(null);
			structure6.setMsg("No Admin Found!");
			structure6.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure6;
	}

}
