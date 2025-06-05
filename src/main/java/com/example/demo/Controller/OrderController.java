package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping()
	public ResponseEntity<List<Order>>getAllOrders(){
		return ResponseEntity.ok(service.getAllOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable Long id){
		Order order = service.getOrderById(id);
	    if (order != null) {
	        return ResponseEntity.status(HttpStatus.FOUND).body(order);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order was not check your id"+id);
	    }
	}
	
	@PostMapping()
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		 Order created=service.createOrder(order);
		 return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order){
		Order updated=service.updateOrder(order);
		return ResponseEntity.status(HttpStatus.SWITCHING_PROTOCOLS).body(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrderById(@PathVariable Long id){
		Order deleted= service.deleteOrderById(id);
		return ResponseEntity.status(HttpStatus.GONE).body(deleted);
	}
	
}
