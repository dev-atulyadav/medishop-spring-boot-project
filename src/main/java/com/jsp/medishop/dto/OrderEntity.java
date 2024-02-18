package com.jsp.medishop.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class OrderEntity {

	@Id
	private int orderId;
	@Column(nullable = false)
	private LocalDate orderDate;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private double totalAmount;

	@ManyToMany
	private List<Vendor> vendors;
	@ManyToOne
	private Customer customer;
}
