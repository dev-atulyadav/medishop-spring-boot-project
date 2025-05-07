package com.jsp.medishop.service;

/**
 * @author Atul
 */

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.response.ResponseStructure;

public interface MediniceService {

	/**
	 * This method will call save method of MedicineDao and if it return bean this
	 * method will set data and return ResponseStructure. Else it will set data null
	 * and return ReponseStructure to the MedicineController.
	 * 
	 * @param medicine
	 * @return ResponseStructure of Medicine
	 */
	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine, int vendorId);

	/**
	 * This will method will call getAllMedicinesDao() of MedicineDao and it will
	 * return collection. Then this method will check whether the collection is
	 * empty or not, if collection is not empty it will set collection and return
	 * ResponseStructure. If the collection is empty it will return
	 * ResponseStructure with a message "No record found!" to the
	 * MedicineController.
	 * 
	 * @return ResponseStructure of Medicine's Collection
	 */
	public ResponseStructure<List<Medicine>> getAllMedicinesService();

	/**
	 * This method will call getMedicinesByNameDao(String name) method of
	 * MedicineDao and it will return the collection of Medicine. Then this method
	 * will check whether the collection is empty of not, if collection is not empty
	 * it will set collection and return the ResponseStructure. If collection is
	 * empty it return ResponseStructure with a message "No record found!" to the
	 * MedicineController.
	 * 
	 * @param name
	 * @return ResponseStructure of Medicine's Collection
	 */
	public ResponseStructure<List<Medicine>> getMedicinesByNameService(String name);

}
