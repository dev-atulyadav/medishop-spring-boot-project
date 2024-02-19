package com.jsp.medishop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.AdminDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.exception.InvalidUserCredentialException;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;

/**
 * @author Atul
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;
	@Autowired
	private ResponseStructure<Admin> structure;

	public ResponseStructure<Admin> getAdminByEmailService(Admin admin) {
		Admin admin2 = dao.getAdminByEmailDao(admin);
		if (admin2 != null) {
			if (admin.getPassword().equals(admin2.getPassword())) {
				structure.setData(admin2);
				structure.setMsg("Logged in successfully!!!");
				structure.setStatus(HttpStatus.FOUND.value());
			}
		} else {
			throw new InvalidUserCredentialException();
		}
		return structure;
	}

}
