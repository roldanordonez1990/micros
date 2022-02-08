package com.serviceshopping.models;

import lombok.Data;

@Data
public class Product {

	private int id;
	private String descripcion;

	private String nombre;

	private double precio;

	private String status;

	private int stock;

	private Category category;

}