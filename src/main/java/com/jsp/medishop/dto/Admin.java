package com.jsp.medishop.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String email;
	@Column(length = 8)
	private String password;

	@OneToMany
	private List<Vendor> vendors;

}
