package com.example.demo.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Client.ProductClient;
import com.example.demo.Client.UserClient;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
	public OrderRepository repo;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;
    

    public Order placeOrder(Order order, String username, String password) {
        Map<String,String> credentials = Map.of("username", username, "password", password);
        ResponseEntity<String> response = userClient.login(credentials);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("User authentication failed");
        }

     
        Product product = productClient.getProductById(order.getProductId());
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        if (product.getQuantityAvaliable() < order.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        // Set price and save order
        order.setPrice(product.getPrice() * order.getQuantity());
        return repo.save(order);
    }
}
