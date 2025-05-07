package com.jsp.medishop.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MediniceService;

/**
 * @author Atul
 */
@Service
public class MedicineServiceImpl implements MediniceService {

	@Autowired
	private MedicineDao dao;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private ResponseStructure<Medicine> structure;
	@Autowired
	private ResponseStructure<List<Medicine>> structure2;

	@Override
	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine, int vendorId) {
		Vendor vendor = vendorDao.getVendorByIdDao(vendorId);
		if (vendor == null) {
			structure.setData(medicine);
			structure.setMsg("Vendor not found!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			return structure;
		}
		medicine.setVendor(vendor);
		Medicine savedMedicine = dao.saveMedicineDao(medicine);

		if (savedMedicine != null) {
			structure.setData(savedMedicine);
			structure.setMsg("Data Inserted with image!!!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(medicine);
			structure.setMsg("Please Check your data!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}

		return structure;
	}

	@Override
	public ResponseStructure<List<Medicine>> getAllMedicinesService() {
		List<Medicine> list = dao.getAllMedicinesDao();
		if (!list.isEmpty()) {
			for (Medicine medicine : list) {
				medicine.getVendor().setPassword(null);
			}
			structure2.setData(list);
			structure2.setMsg("Data found!!!");
			structure2.setStatus(HttpStatus.FOUND.value());
		} else {
			structure2.setData(list);
			structure2.setMsg("No record found!!!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<List<Medicine>> getMedicinesByNameService(String name) {
		List<Medicine> list = dao.getMedicinesByNameDao(name);
		if (!list.isEmpty()) {
			structure2.setData(list);
			structure2.setMsg("Data Found!!!");
			structure2.setStatus(HttpStatus.FOUND.value());
		} else {
			structure2.setData(list);
			structure2.setMsg("No record found!!!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

}
