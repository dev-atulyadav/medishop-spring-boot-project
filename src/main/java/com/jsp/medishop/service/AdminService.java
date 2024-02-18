package com.jsp.medishop.service;

import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.response.ResponseStructure;

/**
 * @author Atul
 */
public interface AdminService {

	/**
	 * This will call getAdminByEmailDao(Admin admin) of AdminDao and if bean is
	 * present it will return it else it will return null. If the returned value is
	 * not null this method will check whether the given password is same as
	 * password present in database. If password is same it will return the
	 * ResponseStructure. Else it will set message "Invalid Password!" and return
	 * ResponseStructure. If getAdminByEmailDao method return null it will set
	 * message "No record found!!!" and return ResponseStructure.
	 * 
	 * @param admin
	 * @return ResponseStructure of Admin
	 */
	public ResponseStructure<Admin> getAdminByEmailService(Admin admin);

}
