package com.jsp.medishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MediniceService;

/**
 * @author Atul
 */
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MediniceService service;

	@PostMapping(value = "/insert/{vendorId}")
	public ResponseStructure<Medicine> saveMedicineController(@RequestBody Medicine medicine, @PathVariable int vendorId) {
		return service.saveMedicineService(medicine, vendorId);
	}

	@GetMapping(value = "/getAllRecords")
	public ResponseStructure<List<Medicine>> getAllMedicinesController() {
		return service.getAllMedicinesService();
	}

	@GetMapping(value = "/getByName/{name}")
	public ResponseStructure<List<Medicine>> getMedicinesByNameController(@PathVariable String name) {
		return service.getMedicinesByNameService(name);
	}

}
