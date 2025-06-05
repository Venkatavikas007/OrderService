package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Order;
import com.example.demo.Repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	public List<Order> getAllOrders(){
		return repo.findAll();
	}
	
	public Order getOrderById(Long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Order could not find"));
	}
	
	public Order createOrder(Order order) {
		return repo.save(order);
	}
	
	public Order updateOrder(Order orderDetails) {
	    Long id = orderDetails.getOrderid(); // extract ID from request body
	    
	    Order updated = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
	    
	    // Update fields
	    updated.setProduct(orderDetails.getProduct());
	    updated.setQuantity(orderDetails.getQuantity());
	    updated.setPrice(orderDetails.getPrice());
	    
	    return repo.save(updated);
		
	}
	
	public Order deleteOrderById(Long id) {
		 repo.deleteById(id);
		return null;
	}
}
