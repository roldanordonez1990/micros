package com.serviceproduct.services;

import java.util.List;

import com.serviceproduct.entities.Category;
import com.serviceproduct.entities.Product;

public interface ProductServiceI {

	public List<Product> listAllProduct();

	public Product getProduct(int id);

	public Product createProduct(Product product);

	public Product updateProduct(Product product);

	public List<Product> findByCategory(Category category);

	public Product updateStock(int id, int cantidad);
	
	public void deleteProduct(int id);
}
