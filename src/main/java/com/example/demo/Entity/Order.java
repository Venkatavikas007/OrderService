package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="OrderInfo")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long orderid;
	private String product;
	private Integer quantity;
	private double price;
	
	public Order() {
		
	}

	public Order(Long orderid, String product, Integer quantity,double price) {
		super();
		this.orderid = orderid;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
