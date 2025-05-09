package com.jsp.medishop.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDate dob;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(length = 8)
	private String password;
	private String address;
	private long phone;
	@Column(unique = true, nullable = true, length = 12)
	private long adhar;

	@ManyToMany(mappedBy = "customers")
	private List<Vendor> vendors;
	@OneToMany
	private List<OrderEntity> entities;

}
