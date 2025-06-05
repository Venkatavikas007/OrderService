package com.example.demo.Client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@FeignClient(name = "user-servic", url= "http://localhost:8080")
public interface UserClient {

	@Bean
	@GetMapping("/user/login")
	ResponseEntity<String>login(@RequestBody Map<String,String> credentials);
}
