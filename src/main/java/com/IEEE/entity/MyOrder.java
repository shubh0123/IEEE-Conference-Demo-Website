package com.IEEE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class MyOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long myOrderId;
	
	private String orderId;
	
	private Integer amount;
	
	private String receipt;
	
	private String status;
	

	
	
	private String paymentId;




	public Long getMyOrderId() {
		return myOrderId;
	}




	public void setMyOrderId(Long myOrderId) {
		this.myOrderId = myOrderId;
	}




	public String getOrderId() {
		return orderId;
	}




	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}




	public Integer getAmount() {
		return amount;
	}




	public void setAmount(Integer amount) {
		this.amount = amount;
	}




	public String getReceipt() {
		return receipt;
	}




	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getPaymentId() {
		return paymentId;
	}




	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}












	
}
