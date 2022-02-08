package com.serviceshopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.serviceshopping.models.Customer;

@FeignClient(name = "customer-service")
public interface CustomerClientI {
	
	@GetMapping(value = "/customers/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

}
//byeeee