package com.serviceproduct.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serviceproduct.entities.Category;
import com.serviceproduct.entities.Product;
import com.serviceproduct.entities.repository.ProductoRepositoy;
import com.serviceproduct.services.ProductServiceI;

@RestController
@RequestMapping(value = "/products")
public class ProductoController {

	@Autowired
	ProductoRepositoy proRep;

	@Autowired
	ProductServiceI proServ;

	@GetMapping(value = "/all")
	public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "id", required = false) Integer id) {

		List<Product> productList = new ArrayList<>();

		if (id == null) {
			productList = proServ.listAllProduct();

			if (productList.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		} else {
			productList = proServ.findByCategory(Category.builder().id(id).build());

			if (productList.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}

		return ResponseEntity.ok(productList);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {

		Product p = proServ.getProduct(id);

		if (p == null) {
			ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(p);

	}

	@PostMapping(value = "/nuevo")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product p = proServ.createProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(p);

	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {

		product.setId(id);

		Product p = proServ.updateProduct(product);

		return ResponseEntity.ok(p);

	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {

		proServ.deleteProduct(id);

	}

	@GetMapping(value = "/updateStock/{id}/stock")
	public ResponseEntity<Product> updateStock(@PathVariable("id") Integer id,
			@RequestParam(name = "cantidad", required = false) Integer cantidad) {

		Product p = proServ.updateStock(id, cantidad);
		return ResponseEntity.ok(p);

	}

}