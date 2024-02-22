package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.AdminDao;
import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.exception.InvalidUserCredentialException;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;
import com.jsp.medishop.service.VendorService;

import jakarta.servlet.http.HttpSession;

/**
 * @author Atul
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private HttpSession session;
	@Autowired
	private AdminDao dao;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private ResponseStructure<Admin> structure;
	@Autowired
	private ResponseStructure<List<Vendor>> structure2;
	@Autowired
	private ResponseStructure<Vendor> structure3;

	public ResponseStructure<Admin> getAdminByEmailService(Admin admin) {
		Admin admin2 = dao.getAdminByEmailDao(admin);
		if (admin2 != null) {
			if (admin.getPassword().equals(admin2.getPassword())) {
				session.setAttribute("adminEmail", admin2);
				structure.setData(admin2);
				structure.setMsg("Logged in successfully!!!");
				structure.setStatus(HttpStatus.FOUND.value());
			} else {
				throw new InvalidUserCredentialException();
			}
		} else {
			throw new InvalidUserCredentialException();
		}
		return structure;
	}

	@Override
	public ResponseEntity<String> logoutAdminService() {
		if (session.getAttribute("adminEmail") != null) {
			session.invalidate();
			return new ResponseEntity<String>("Logged out Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invaild request please login first!", HttpStatus.OK);
		}
	}

	@Override
	public ResponseStructure<List<Vendor>> getAllVendorsByAdminService() {
		if (session.getAttribute("adminEmail") != null) {
			return vendorService.getAllVendorsService();
		} else {
			structure2.setData(null);
			structure2.setMsg("Please login as admin to get all data!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<Vendor> updateVendorStatusByVendorIdService(int id, String status) {
		if (session.getAttribute("adminEmail") != null) {
			Vendor vendor = vendorDao.getVendorByIdDao(id);
			if (vendor != null) {
				vendor.setVendorStatus(status);
				vendorDao.updateVendorByEmailDao(vendor);
				structure3.setData(vendor);
				structure3.setMsg("status updated!");
				structure3.setStatus(HttpStatus.OK.value());
			} else {
				structure3.setData(null);
				structure3.setMsg("No record found!");
				structure3.setStatus(HttpStatus.NOT_FOUND.value());
			}
		} else {
			structure3.setData(null);
			structure3.setMsg("Please login as admin to update status!");
			structure3.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure3;
	}

}
