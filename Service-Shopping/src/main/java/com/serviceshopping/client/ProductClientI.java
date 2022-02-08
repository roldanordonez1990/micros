package com.serviceshopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.serviceshopping.models.Product;

@FeignClient(name = "product-service")
public interface ProductClientI {
	
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id);
	
	@GetMapping(value = "/products/updateStock/{id}/stock")
	public ResponseEntity<Product> updateStock(@PathVariable("id") Integer id,
			@RequestParam(name = "cantidad", required = false) Integer cantidad);

}