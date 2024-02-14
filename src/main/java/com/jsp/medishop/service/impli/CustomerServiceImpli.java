package com.jsp.medishop.service.impli;

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
public class CustomerServiceImpli implements CustomerService {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private DataVerification verification;
	@Autowired
	private ResponseStructure<Customer> structure;
	@Autowired
	private ResponseStructure<List<Customer>> structure2;

	@Override
	public ResponseStructure<Customer> saveCustomerDao(Customer customer) {
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
		return structure;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByIdDao(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByEmailDao(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomersDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<List<Customer>> updateCustomerByEmailDao(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> deleteCustomerByEmailDao(String email) {
		return null;
	}

}
