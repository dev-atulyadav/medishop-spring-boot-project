package com.jsp.medishop.service;

/**
 * @author Atul
 */

import java.util.List;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;

public interface CustomerService {

	public ResponseStructure<Customer> saveCustomerDao(Customer customer);

	public ResponseStructure<Customer> getCustomerByIdDao(int id);

	public ResponseStructure<Customer> getCustomerByEmailDao(String email);

	public List<Customer> getCustomersDao();

	public ResponseStructure<List<Customer>> updateCustomerByEmailDao(Customer customer);

	public ResponseStructure<Customer> deleteCustomerByEmailDao(String email);
}
