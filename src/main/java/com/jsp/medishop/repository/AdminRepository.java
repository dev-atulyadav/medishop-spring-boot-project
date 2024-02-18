package com.jsp.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.Admin;

/**
 * @author Atul
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);
}
