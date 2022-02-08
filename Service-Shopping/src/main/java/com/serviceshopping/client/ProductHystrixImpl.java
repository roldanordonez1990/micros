package com.serviceshopping.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.serviceshopping.models.Product;

@Component
public class ProductHystrixImpl implements ProductClientI {

	@Override
	public ResponseEntity<Product> getProduct(Integer id) {
		
		Product p = Product.builder().descripcion("none").nombre("none").build();
		
		return ResponseEntity.ok(p);
	}

	@Override
	public ResponseEntity<Product> updateStock(Integer id, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
