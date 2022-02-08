package com.serviceproduct.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceproduct.entities.Category;
import com.serviceproduct.entities.Product;
import com.serviceproduct.entities.repository.ProductoRepositoy;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductoRepositoy proRep;
	

	@Override
	public List<Product> listAllProduct() {

		return proRep.findAll();
	}

	@Override
	public Product getProduct(int id) {

		return proRep.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {

		Date date = new Date();

		product.setStatus("CREATED");
		product.setFecha(date);

		return proRep.save(product);
	}

	@Override
	public Product updateProduct(Product product) {

		Product p = getProduct(product.getId());

		if (p == null) {
			return null;
		}

		p.setNombre(product.getNombre());
		p.setDescripcion(product.getDescripcion());
		p.setCategory(product.getCategory());
		p.setPrecio(product.getPrecio());

		return proRep.save(p);
	}

	@Override
	public void deleteProduct(int id) {

		//Product p = getProduct(id);

		proRep.deleteById(id);
	}

	@Override
	public List<Product> findByCategory(Category category) {

		return proRep.findByCategory(category);
	}

	@Override
	public Product updateStock(int id, int cantidad) {
		Product p = getProduct(id);

		if (p == null) {
			return null;
		}

		int stock = p.getStock() + cantidad;

		p.setStock(stock);
		
		return proRep.save(p);
	}


}
