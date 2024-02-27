package com.jsp.medishop.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToMany(mappedBy = "admin")
	@JsonIgnore
	private List<Vendor> vendors;

}
