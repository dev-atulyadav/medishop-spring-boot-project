package com.jsp.medishop.service;

import java.util.List;

/**
 * @author Atul
 */

import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.response.ResponseStructure;

public interface OrderService {

	/**
	 * This method accepts the bean of OrderEntity and it will check whether all
	 * credentials are correct and valid, if all credentials are valid it will send
	 * them to save method of OrderDao and it will persist it into Database and save
	 * method of OrderDao will return OrderEntity's bean and if the bean is not null
	 * this method will set the ResponseStructure with the bean of OrderEntity and
	 * send it back to the OrderController else it will set null in ResponseStructre
	 * and return it back to OrderController.
	 * 
	 * @param order
	 * @return ResponseStructure of OrderEntity
	 */
	public ResponseStructure<OrderEntity> saveOrderService(OrderEntity order, int medicineId, int customerId);

	/**
	 * This method will call getOrderByIdDao(int id) of OrderDao and it will check
	 * whether the data is present or not. If data is present, it will return the
	 * bean of OrderEntity else return null. Then this method will check whether the
	 * returned data is null or or not. If data is not null, it will set data and
	 * return the ResponseStructure of OrderEntity else it will set null and return
	 * ResponseStructure to the OrderController.
	 * 
	 * @param id
	 * @return ResponseStructure of OrderEntity
	 */
	public ResponseStructure<OrderEntity> getOrderByIdService(int id);

	/**
	 * This method will call updateOrderStatusByIdDao(int id, String status) of
	 * OrderDao and it will check whether the bean with given id is present or not.
	 * If the bean is present it will set the status and return the updated bean
	 * else it will return null. Then this method will check if the bean is not null
	 * it will set data and return ResponseStructure of OrderEntity with message
	 * "Status Updated!". Else it will set data null and return ResponseStructure
	 * with message "Invalid Order!!! Can't update!!!" to OrderController.
	 * 
	 * @param id
	 * @param status
	 * @return ResponseStructure of OrderEntity
	 */
	public ResponseStructure<OrderEntity> updateOrderStatusByIdService(int id, String status);

	/**
	 * This method will call delete method of OrderDao and if the data is present it
	 * will check the status, if status is not "Delivered or Cancelled" it will
	 * delete it and return null. And then this method will check if returned data
	 * is null it will set data null and message "Order Cancelled!" to
	 * ResponseStructure. If returned data is not null it will check the present
	 * status on bean if it's "Delivered" it will return ResponseStructure with a
	 * message "Can't delete a delivered order!". Else it will check the status if
	 * status is already "Cancelled" it will return ResponseStructure with a message
	 * "Can't delete a Cancelled order". If status didn't pass both cases it will
	 * return ResponseStructure with a message "Invalid Order Details!" to the
	 * OrderController.
	 * 
	 * @param id
	 * @return ResponseStructure of OrderEntity
	 */
	public ResponseStructure<OrderEntity> deleteOrderByIdService(int id);
	
	public ResponseStructure<List<OrderEntity>> getOrdersByVendorIdService(int vendorId);
	
	public ResponseStructure<List<OrderEntity>> getOrdersByCustomerIdService(int customerId);
}
