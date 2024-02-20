package com.jsp.medishop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;

/**
 * @author Atul
 */
public interface VendorService {

	/**
	 * This method accepts the bean of Vendor and it will check whether all
	 * credentials are correct and valid, if all credentials are valid it will send
	 * them to save method of VendorDao and it will persist it into Database and
	 * save method of VendorDao will return Vendor's bean and if the bean is not
	 * null this method will set the ResponseStructure with the bean of Vendor and
	 * send it back to the VendorController else it will set null in
	 * ResponseStructre and return it back to VendorController.
	 * 
	 * @param vendor
	 * @return ResponseStructure of Vendor
	 */
	public ResponseStructure<Vendor> saveVendorService(Vendor vendor);

	/**
	 * This method will call getVendorByIdDao(int id) method and if id is present in
	 * database it will return the bean of Vendor, if bean is not null it will set
	 * data to ResponseStructure and return it to VendorController. If the bean is
	 * null it will set data null and return it to VendorController.
	 * 
	 * @param id
	 * @return ResponseStructure of Vendor
	 */
	public ResponseStructure<Vendor> getVendorByIdService(int id);

	/**
	 * This method will call getVendorByEmailDao(String email) method and if email
	 * is present in database it will return the bean of Vendor, if bean is not null
	 * it will set data to ResponseStructure and return it to VendorController. If
	 * the bean is null it will set data null and return it to VendorController.
	 * 
	 * @param email
	 * @return ResponseStructure of Vendor
	 */
	public ResponseStructure<Vendor> getVendorByEmailService(String email);

	/**
	 * This method will call getAllVendorDao() of VendorDao and it will return
	 * collection of Vendor. Then this method will check whether the collection is
	 * empty or not, if collection is not empty will set and return the
	 * ResponseStructure of collection. If collection is empty it will return
	 * ResponseStructure with a message that "No Record Found!" to the
	 * VendorController.
	 * 
	 * @return ResponseStructure of Vendor's Collection
	 */
	public ResponseStructure<List<Vendor>> getAllVendorsService();

	/**
	 * This method will call updateVendorByEmailDao(Vendor Vendor) method of
	 * VendorDao and it will check whether the email in provided bean exist of not
	 * if not it will return null else the bean of Vendor. Then this method will
	 * check if the returned bean is not null it will set the bean and return the
	 * ResponseStructure to the VendorController else it will set null and return
	 * ResponseStructure to VendorController.
	 * 
	 * @param vendor
	 * @return ResponseStructure of Vendor
	 */
	public ResponseStructure<Vendor> updateVendorByEmailService(Vendor vendor);

	/**
	 * This method will call delete method of VendorDao and then it will check then
	 * provided email exist or not if bean is present it will delete it and return
	 * null. If data is not deleted it will return the bean of Vendor. And then this
	 * method will check if the returned data is null it will set ResponseStructure
	 * with a message "Data deleted!" else it will return the bean with message "No
	 * data found!" to the VendorController.
	 * 
	 * @param email
	 * @return ResponseStructure of Vendor
	 */
	public ResponseStructure<Vendor> deleteVendorByEmailService(String email);

	public ResponseStructure<Vendor> loginVendorWithEmailService(String email, String password);

	public ResponseEntity<String> logoutVendorWithEmailService();

}
