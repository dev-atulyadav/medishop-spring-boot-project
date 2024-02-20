package com.jsp.medishop.service;

/**
 * @author Atul
 */

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;

public interface CustomerService {

	/**
	 * This method accepts the bean of Customer and it will check whether all
	 * credentials are correct and valid, if all credentials are valid it will send
	 * them to save method of CustomerDao and it will persist it into Database and
	 * save method of CustomerDao will return Customer's bean and if the bean is not
	 * null this method will set the ResponseStructure with the bean of Customer and
	 * send it back to the CustomerController else it will set null in
	 * ResponseStructre and return it back to CustomerController.
	 * 
	 * @param customer
	 * @return ResponseStructure of Customer
	 */
	public ResponseStructure<Customer> saveCustomerService(Customer customer);

	/**
	 * This method will call getCustomerByIdDao(int id) method and if id is present
	 * in database it will return the bean of Customer, if bean is not null it will
	 * set data to ResponseStructure and return it to CustomerController. If the
	 * bean is null it will set data null and return it to CustomerController.
	 * 
	 * @param id
	 * @return ResponseStructure of Customer
	 */
	public ResponseStructure<Customer> getCustomerByIdService(int id);

	/**
	 * This method will call getCustomerByEmailDao(String email) method and if email
	 * is present in database it will return the bean of Customer, if bean is not
	 * null it will set data to ResponseStructure and return it to
	 * CustomerController. If the bean is null it will set data null and return it
	 * to CustomerController.
	 * 
	 * @param email
	 * @return ResponseStructure of Customer
	 */
	public ResponseStructure<Customer> getCustomerByEmailService(String email);

	/**
	 * This method will call getAllCustomerDao() of CustomerDao and it will return
	 * collection of Customer. Then this method will check whether the collection is
	 * empty or not, if collection is not empty will set and return the
	 * ResponseStructure of collection. If collection is empty it will return
	 * ResponseStructure with a message that "No Record Found!" to the
	 * CustomerController.
	 * 
	 * @return ResponseStructure of Customer's Collection
	 */
	public ResponseStructure<List<Customer>> getAllCustomersService();

	/**
	 * This method will call updateCustomerByEmailDao(Customer customer) method of
	 * CustomerDao and it will check whether the email in provided bean exist of not
	 * if not it will return null else the bean of Customer. Then this method will
	 * check if the returned bean is not null it will set the bean and return the
	 * ResponseStructure to the CustomerController else it will set null and return
	 * ResponseStructure to CustomerController.
	 * 
	 * @param customer
	 * @return ResponseStructure of Customer
	 */
	public ResponseStructure<Customer> updateCustomerByEmailService(Customer customer);

	/**
	 * This method will call delete method of CustomerDao and then it will check
	 * then provided email exist or not if bean is present it will delete it and
	 * return null. If data is not deleted it will return the bean of Customer. And
	 * then this method will check if the returned data is null it will set
	 * ResponseStructure with a message "Data deleted!" else it will return the bean
	 * with message "No data found!" to the CustomerController.
	 * 
	 * @param email
	 * @return ResponseStructure of Customer
	 */
	public ResponseStructure<Customer> deleteCustomerByEmailService(String email);

	public ResponseStructure<Customer> loginCustomerWithEmailService(String email,String password);

	public ResponseEntity<String> logoutCustomerWithEmailService();
}
