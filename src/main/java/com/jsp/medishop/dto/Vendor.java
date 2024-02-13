package com.jsp.medishop.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class Vendor {

	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	@Column(unique = true,nullable = true , length = 12)
	private long adhar;
	private String password;
	private String address;

	@ManyToMany
	private List<Customer> customers;

}
