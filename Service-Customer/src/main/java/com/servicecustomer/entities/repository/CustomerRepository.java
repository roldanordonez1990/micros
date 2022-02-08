package com.servicecustomer.entities.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicecustomer.entities.Customer;
import com.servicecustomer.entities.Region;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	 public Customer findByNumberID(String numberID);
     public List<Customer> findByLastName(String lastName);
     public List<Customer> findByRegion(Region region);	

}
