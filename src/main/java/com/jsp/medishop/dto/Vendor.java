package com.jsp.medishop.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long phone;
	@Column(unique = true, nullable = true, length = 12)
	private long adhar;
	private String password;
	private String address;
	@Column(name = "vendor_status", nullable = true)
	private String vendorStatus ="inactive";

	@OneToMany
	private List<OrderEntity> entities;
	@ManyToMany
	private List<Customer> customers;
	@OneToMany
	private List<Medicine> medicines;
	@JsonIgnore
	@ManyToOne
	private Admin admin;

}
