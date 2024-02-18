package com.jsp.medishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.VendorService;

/**
 * @author Atul
 */
@RestController
@RequestMapping(value = "/vendor")
public class VendorController {

	@Autowired
	private VendorService service;

	@PostMapping(value = "/insert")
	public ResponseStructure<Vendor> saveVendorController(@RequestBody Vendor vendor) {
		return service.saveVendorService(vendor);
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseStructure<Vendor> getVendorByIdController(@PathVariable int id) {
		return service.getVendorByIdService(id);
	}

	@GetMapping(value = "/getByEmail/{email}")
	public ResponseStructure<Vendor> getVendorByEmailController(@PathVariable String email) {
		return service.getVendorByEmailService(email);
	}

	@GetMapping(value = "/getAllRecords")
	public ResponseStructure<List<Vendor>> getAllVendorsController() {
		return service.getAllVendorsService();
	}

	// not working
	@PutMapping(value = "/updateByEmail/{email}")
	public ResponseStructure<Vendor> updateVendorByEmailController(@RequestBody Vendor vendor) {
		return service.updateVendorByEmailService(vendor);
	}

	@DeleteMapping(value = "/deleteByEmail/{email}")
	public ResponseStructure<Vendor> deleteVendorByEmailController(@PathVariable String email) {
		return service.deleteVendorByEmailService(email);
	}
}
