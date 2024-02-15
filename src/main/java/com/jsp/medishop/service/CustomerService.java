package com.jsp.medishop.service;

/**
 * @author Atul
 */

import java.util.List;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;

public interface CustomerService {

	public ResponseStructure<Customer> saveCustomerService(Customer customer);

	public ResponseStructure<Customer> getCustomerByIdService(int id);

	public ResponseStructure<Customer> getCustomerByEmailService(String email);

	public ResponseStructure<List<Customer>> getAllCustomersService();

	public ResponseStructure<Customer> updateCustomerByEmailService(Customer customer);

	public ResponseStructure<Customer> deleteCustomerByEmailService(String email);
}
