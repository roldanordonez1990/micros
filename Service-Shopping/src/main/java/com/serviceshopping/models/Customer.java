package com.serviceshopping.models;

import lombok.Data;

@Data
public class Customer {

	private Long id;

	private String numberID;

	private String firstName;

	private String lastName;

	private String email;

	private Region region;

	private String state;

}