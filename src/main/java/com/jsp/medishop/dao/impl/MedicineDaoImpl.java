package com.jsp.medishop.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.repository.MedicineRepository;

/**
 * @author Atul
 */
@Repository
public class MedicineDaoImpl implements MedicineDao {

	@Autowired
	private MedicineRepository repository;

	@Override
	public Medicine saveMedicineDao(Medicine medicine) {
		return repository.save(medicine);
	}

	@Override
	public List<Medicine> getAllMedicinesDao() {
		return repository.findAll();
	}

	@Override
	public List<Medicine> getMedicinesByNameDao(String name) {
		return repository.findByName(name);
	}

	@Override
	public Medicine updateMedicineStatusByIdDao(int id, String status) {
		Medicine medicine = repository.findById(id).get();
		if (medicine != null) {
			medicine.setStatus(status);
			return repository.save(medicine);
		}
		return null;
	}

	@Override
	public Medicine getMedicineByIdDao(int id) {
		try {

			return repository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}
