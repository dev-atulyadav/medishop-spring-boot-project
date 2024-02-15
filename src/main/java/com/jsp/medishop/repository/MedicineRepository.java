package com.jsp.medishop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.Medicine;

/**
 * @author Atul
 */
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	public List<Medicine> findByName(String name);

}
