package com.jsp.medishop.dao;

import java.util.List;

/**
 * @author Atul
 */

import com.jsp.medishop.dto.Medicine;

public interface MedicineDao {

	public Medicine saveMedicineDao(Medicine medicine);

	public List<Medicine> getAllMedicinesDao();

	public List<Medicine> getMedicinesByNameDao(String name);
	
	public Medicine updateMedicineStatusByIdDao(int id,String status);

}
