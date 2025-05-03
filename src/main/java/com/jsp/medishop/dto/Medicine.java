package com.jsp.medishop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	private String imageUrl;
	private String expiryDate;
	private String companyName;
	private int quantity;
	private double price;
	private String description;
	private String status = "Not Approved";

	@ManyToOne(cascade = CascadeType.ALL)
	private Vendor vendor;

}
