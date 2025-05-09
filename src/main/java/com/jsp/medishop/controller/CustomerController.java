package com.jsp.medishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;

/**
 * @author Atul
 */
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(value = "/insert")
	public ResponseStructure<Customer> saveCustomerController(@RequestBody Customer customer) {
		return service.saveCustomerService(customer);
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseStructure<Customer> getCustomerByIdController(@PathVariable int id) {
		return service.getCustomerByIdService(id);
	}

	@GetMapping(value = "/getByEmail/{email}")
	public ResponseStructure<Customer> getCustomerByEmailController(@PathVariable String email) {
		return service.getCustomerByEmailService(email);
	}

	@GetMapping(value = "/getAllRecords")
	public ResponseStructure<List<Customer>> getAllCustomersController() {
		return service.getAllCustomersService();
	}

	// not working
	@PutMapping(value = "/updateByEmail")
	public ResponseStructure<Customer> updateCustomerByEmailController(@RequestBody Customer customer) {
		return service.updateCustomerByEmailService(customer);
	}

	@DeleteMapping(value = "/deleteByEmail/{email}")
	public ResponseStructure<Customer> deleteCustomerByEmailController(@PathVariable String email) {
		return service.deleteCustomerByEmailService(email);
	}

	@GetMapping(value = "/login/{email}/{password}")
	public ResponseStructure<Customer> loginCustomerWithEmailController(@PathVariable String email,
			@PathVariable String password) {
		return service.loginCustomerWithEmailService(email, password);
	}

	@GetMapping(value = "/logout")
	public ResponseEntity<String> logoutCustomerWithEmailController() {
		return service.logoutCustomerWithEmailService();
	}
}
