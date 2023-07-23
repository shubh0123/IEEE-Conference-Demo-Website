package com.IEEE.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.IEEE.dao.MyOrderRepository;
import com.IEEE.entity.MyOrder;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class PaymentController {
	@Autowired
	private MyOrderRepository myOrderRepository;
	
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
		System.out.println(data);
		int amount=Integer.parseInt(data.get("amount").toString());
		String currency=data.get("currency").toString();
		RazorpayClient client =new RazorpayClient("rzp_test_Dn0WYeYaBLZF58","Ig7TjarBXCaePTOVkfUnHcMI");
		JSONObject options = new JSONObject();
		options.put("amount", amount*100); 
		options.put("currency", currency); 
		options.put("receipt", "txn_123456"); 
		//creating new Order Order
		Order order = client.Orders.create(options); 
		System.out.println(order);
		//save the order in database
		MyOrder myOrder=new MyOrder();
		myOrder.setAmount(order.get("amount"));
		
		myOrder.setOrderId(order.get("id"));
		myOrder.setPaymentId(null);
		myOrder.setStatus("created");
		myOrder.setReceipt(order.get("receipt"));
		this.myOrderRepository.save(myOrder);
		return order.toString();
		
		
	}
	@PostMapping("/update_payment")
	public ResponseEntity<?> updateOrder(@RequestBody Map<String,Object> data){
		System.out.println("Congo!!!!");
		MyOrder myOrder=this.myOrderRepository.findByOrderId(data.get("order_id").toString());
		myOrder.setPaymentId(data.get("payment_id").toString());
		myOrder.setStatus(data.get("status").toString());
		System.out.println(myOrder);
		this.myOrderRepository.save(myOrder);
		return ResponseEntity.ok(Map.of("msg","updated"));
		
	}
}
