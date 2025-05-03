package com.jsp.medishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;

/**
 * @author Atul
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping(value = "/login/{email}/{password}")
	public ResponseStructure<Admin> getAdminByEmailController(@PathVariable String email,
			@PathVariable String password) {
		return service.getAdminByEmailService(email, password);
	}

	@GetMapping(value = "/logout")
	public ResponseEntity<String> logoutAdminController() {
		return service.logoutAdminService();
	}

	@GetMapping(value = "/getAllVendor/{adminEmail}")
	public ResponseStructure<List<Vendor>> getAllVendorsByAdminController(@PathVariable String adminEmail) {
		return service.getAllVendorsByAdminService(adminEmail);
	}


	@PutMapping(value = "/upateVendorDetails/{adminEmail}")
	public ResponseStructure<Vendor> updateVendorDetailsByAdmin(@RequestBody Vendor vendor,
			@PathVariable String adminEmail) {
		return service.updateVendorDetailsByAdminService(vendor, adminEmail);
	}

	@PutMapping(value = "/updateMedicineStatus/{vendorId}/{medicineId}/{status}/{adminEmail}")
	public ResponseStructure<Vendor> updateMedicineStatusByVendorIdService(@PathVariable int vendorId,
			@PathVariable int medicineId, @PathVariable String status, @PathVariable String adminEmail) {
		return service.updateMedicineStatusByVendorIdService(vendorId, medicineId, status,adminEmail);
	}

}
