package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;

/**
 * @author Atul
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping(value = "/login")
	public ResponseStructure<Admin> getAdminByEmailController(@RequestBody Admin admin) {
		return service.getAdminByEmailService(admin);
	}
	
	@GetMapping(value = "/logout")
	public ResponseEntity<String> logoutAdminController(){
		return service.logoutAdminService();
	}

}
