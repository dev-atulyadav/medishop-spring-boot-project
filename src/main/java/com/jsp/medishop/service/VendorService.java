package com.jsp.medishop.service;

import java.util.List;

import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;

/**
 * @author Atul
 */
public interface VendorService {

	public ResponseStructure<Vendor> saveVendorService(Vendor vendor);

	public ResponseStructure<Vendor> getVendorByIdService(int id);

	public ResponseStructure<Vendor> getVendorByEmailService(String email);

	public ResponseStructure<List<Vendor>> getAllVendorsService();

	public ResponseStructure<Vendor> updateVendorByEmailService(Vendor vendor);

	public ResponseStructure<Vendor> deleteVendorByEmailService(String email);

}
