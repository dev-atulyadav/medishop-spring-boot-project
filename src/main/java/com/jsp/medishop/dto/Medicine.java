package com.jsp.medishop.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private String expiryData;
	private String companyName;
	private int quantity;
	private double price;
	private String description;
	private String status = "Not Approved";

	@ManyToMany(mappedBy = "medicines",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Vendor> vendors;

}
