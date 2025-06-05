package com.example.demo.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.Product;

@FeignClient(name = "product-service", url = "http://localhost:8081")
public interface ProductClient {
	
	@GetMapping("/products/{id}")
	Product getProductById(@PathVariable Long id);

}
