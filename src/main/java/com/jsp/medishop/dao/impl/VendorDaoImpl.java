package com.jsp.medishop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.repository.VendorRepository;

/**
 * @author Atul
 */
@Repository
class VendorDaoImpl implements VendorDao {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor saveVendorDao(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	public Vendor getVendorByIdDao(int id) {
		return vendorRepository.findById(id).get();
	}

	@Override
	public Vendor getVendorByEmailDao(String email) {
		return vendorRepository.findByEmail(email);
	}

	@Override
	public List<Vendor> getVendorsDao() {
		return vendorRepository.findAll();
	}

	@Override
	public Vendor updateVendorByEmailDao(Vendor vendor) {
		Vendor vendor2 = getVendorByEmailDao(vendor.getEmail());
		if (vendor2 != null) {
			return vendorRepository.save(vendor);
		}
		return null;
	}

	@Override
	public Vendor deleteVendorByEmailDao(String email) {
		Vendor vendor = getVendorByEmailDao(email);
		if (vendor != null) {
			vendorRepository.delete(vendor);
			return null;
		}
		return vendor;
	}
}
