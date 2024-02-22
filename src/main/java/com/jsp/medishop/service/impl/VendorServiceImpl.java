package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.VendorService;
import com.jsp.medishop.verification.DataVerification;

import jakarta.servlet.http.HttpSession;

/**
 * @author Atul
 */
@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private HttpSession session;
	@Autowired
	private VendorDao dao;
	@Autowired
	private DataVerification verification;
	@Autowired
	private ResponseStructure<Vendor> structure;
	@Autowired
	private ResponseStructure<List<Vendor>> structure2;

	@Override
	public ResponseStructure<Vendor> saveVendorService(Vendor vendor) {
		Vendor vendor2 = dao.getVendorByEmailDao(vendor.getEmail());
		if (vendor2 == null) {
			String email = verification.verifyEmail(vendor.getEmail());
			String password = verification.verifyPassword(vendor.getPassword());
			if (email != null) {
				if (password != null) {
					dao.saveVendorDao(vendor);
					vendor.setPassword("******");
					structure.setData(vendor);
					structure.setMsg("Data Inserted you will be able to login when admin will review your status!!!");
					structure.setStatus(HttpStatus.CREATED.value());
				} else {
					structure.setData(vendor);
					structure.setMsg("Please create a vaild password!!!");
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				}
			} else {
				structure.setData(vendor);
				structure.setMsg("Please enter a vaild email!!!");
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			}
		} else {
			structure.setData(vendor);
			structure.setMsg("User already exists!!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;

	}

	@Override
	public ResponseStructure<Vendor> getVendorByIdService(int id) {
		Vendor vendor = dao.getVendorByIdDao(id);
		if (vendor != null) {
			structure.setData(vendor);
			structure.setMsg("Data found!!!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(vendor);
			structure.setMsg("Data not found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Vendor> getVendorByEmailService(String email) {
		Vendor vendor = dao.getVendorByEmailDao(email);
		if (vendor != null) {
			structure.setData(vendor);
			structure.setMsg("Data found!!!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(vendor);
			structure.setMsg("Data not found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<List<Vendor>> getAllVendorsService() {
		List<Vendor> list = dao.getAllVendorsDao();
		if (!list.isEmpty()) {
			structure2.setData(list);
			structure2.setMsg("data found!!!");
			structure2.setStatus(HttpStatus.FOUND.value());
		} else {
			structure2.setData(list);
			structure2.setMsg("no data found!!!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<Vendor> updateVendorByEmailService(Vendor vendor) {
		Vendor vendor2 = dao.updateVendorByEmailDao(vendor);
		if (vendor2 != null) {
			structure.setData(vendor2);
			structure.setMsg("Data updated");
			structure.setStatus(HttpStatus.ACCEPTED.value());
		} else {
			structure.setData(vendor2);
			structure.setMsg("No data found!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Vendor> deleteVendorByEmailService(String email) {
		boolean b = dao.deleteVendorByEmailDao(email);
		if (b) {
			structure.setData(null);
			structure.setMsg("Data deleted!!!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(null);
			structure.setMsg("No record matched!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Vendor> loginVendorWithEmailService(String email, String password) {
		Vendor vendor2 = dao.getVendorByEmailDao(email);
		if (vendor2 != null) {
			if (vendor2.getPassword().equals(password)) {
				if (vendor2.getVendorStatus().equals("active")) {
					session.setAttribute("vendorEmail", vendor2.getEmail());
					structure.setMsg("You logged successfully!!!");
					structure.setStatus(HttpStatus.OK.value());
					vendor2.setPassword("*******");
					structure.setData(vendor2);
				} else {
					structure.setData(vendor2);
					structure.setMsg(
							"you can't login with inactive status. Please wait for admin to review your status!");
					structure.setStatus(HttpStatus.OK.value());
				}
			} else {
				structure.setData(null);
				structure.setMsg("Invalid Password!!!");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
			}
		} else {
			structure.setData(null);
			structure.setMsg("Invalid Email!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseEntity<String> logoutVendorWithEmailService() {
		if (session.getAttribute("vendorEmail") != null) {
			session.invalidate();
			return new ResponseEntity<String>("You logged out successfully!!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Bad Request!!", HttpStatus.BAD_REQUEST);
		}
	}

}
