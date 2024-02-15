package com.jsp.medishop.service;

/**
 * @author Atul
 */

import java.util.List;

import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.response.ResponseStructure;

public interface MediniceService {

	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine);

	public ResponseStructure<List<Medicine>> getAllMedicinesService();
	
	public ResponseStructure<List<Medicine>> getMedicinesByNameService(String name);

}
