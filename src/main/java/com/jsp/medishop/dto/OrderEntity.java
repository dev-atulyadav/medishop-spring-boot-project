package com.jsp.medishop.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	@Column(nullable = false)
	private LocalDate orderDate;
	private LocalDate estimateDeliveryDate;
	private LocalDate customerDeliveryDate;
	@Column(nullable = false)
	private String status = "pending";
	@Column(nullable = false)
	private double totalAmount;
	private String paymentMode;
	private int quantity;

	@OneToOne
	private Vendor vendor;
	@OneToOne
	private Customer customer;
	@OneToOne
	private Medicine medicine;
}
