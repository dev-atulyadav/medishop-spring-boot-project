package com.jsp.medishop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.AdminDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.exception.InvalidUserCredentialException;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;

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
	private ResponseStructure<Admin> structure;

	public ResponseStructure<Admin> getAdminByEmailService(Admin admin) {
		Admin admin2 = dao.getAdminByEmailDao(admin);
		if (admin2 != null) {
			if (admin.getPassword().equals(admin2.getPassword())) {
				session.setAttribute("adminEmail", admin2);
				structure.setData(admin2);
				structure.setMsg("Logged in successfully!!!");
				structure.setStatus(HttpStatus.FOUND.value());
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

}
