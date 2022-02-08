package com.serviceproduct.entities.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceproduct.entities.Category;
import com.serviceproduct.entities.Product;

public interface ProductoRepositoy extends JpaRepository<Product, Integer>{
	
	public List<Product> findByCategory(Category category);

}
