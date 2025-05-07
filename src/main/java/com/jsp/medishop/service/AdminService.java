package com.jsp.medishop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;

import jakarta.servlet.http.HttpSession;

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
	public ResponseStructure<Admin> getAdminByEmailService(String email, String password);

	public ResponseEntity<String> logoutAdminService();

	public ResponseStructure<List<Vendor>> getAllVendorsByAdminService(String adminEmail);

	public ResponseStructure<List<Customer>> getAllCustomersByAdminService(String adminEmail);

	public ResponseStructure<Medicine> updateMedicineStatusByVendorIdService(int vendorId, int medicineId,
			String status, String adminEmail);

	public ResponseStructure<Vendor> updateVendorDetailsByAdminService(Vendor vendor, String adminEmail);

	public ResponseStructure<Object> getAdminSessionService();

	public ResponseStructure<List<OrderEntity>> getAllOrderByAdminService(String email);
}
