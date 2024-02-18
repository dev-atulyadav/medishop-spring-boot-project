package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;
import com.jsp.medishop.verification.DataVerification;

/**
 * @author Atul
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private DataVerification verification;
	@Autowired
	private ResponseStructure<Customer> structure;
	@Autowired
	private ResponseStructure<List<Customer>> structure2;

	@Override
	public ResponseStructure<Customer> saveCustomerService(Customer customer) {
		Customer customer2 = dao.getCustomerByEmailDao(customer.getEmail());
		if (customer2 == null) {
			String email = verification.verifyEmail(customer.getEmail());
			String password = verification.verifyPassword(customer.getPassword());
			if (email != null) {
				if (password != null) {
					dao.saveCustomerDao(customer);
					structure.setData(customer);
					structure.setMsg("Data Inserted!!!!");
					structure.setStatus(HttpStatus.CREATED.value());
				} else {
					structure.setData(customer);
					structure.setMsg("Please check your password!!!!");
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				}
			} else {
				structure.setData(customer);
				structure.setMsg("Please check your email!!!!");
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			}
		} else {
			structure.setData(customer);
			structure.setMsg("User already exists!!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByIdService(int id) {
		Customer customer = dao.getCustomerByIdDao(id);
		if (customer != null) {
			structure.setData(customer);
			structure.setMsg("data found!!!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(customer);
			structure.setMsg("No record found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByEmailService(String email) {
		Customer customer = dao.getCustomerByEmailDao(email);
		if (customer != null) {
			structure.setData(customer);
			structure.setMsg("data found!!!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(customer);
			structure.setMsg("No record found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<List<Customer>> getAllCustomersService() {
		List<Customer> list = dao.getAllCustomersDao();
		if (!list.isEmpty()) {
			structure2.setData(list);
			structure2.setMsg("data found!!!");
			structure2.setStatus(HttpStatus.FOUND.value());
		} else {
			structure2.setData(list);
			structure2.setMsg("no record found!!!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<Customer> updateCustomerByEmailService(Customer customer) {
		Customer customer2 = dao.updateCustomerByEmailDao(customer);
		if (customer2 != null) {
			structure.setData(customer2);
			structure.setMsg("data upadated!!!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(customer2);
			structure.setMsg("Not data found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Customer> deleteCustomerByEmailService(String email) {
		boolean b = dao.deleteCustomerByEmailDao(email);
		if (b) {
			structure.setData(null);
			structure.setMsg("data deleted!!!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(null);
			structure.setMsg("No data found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

}
