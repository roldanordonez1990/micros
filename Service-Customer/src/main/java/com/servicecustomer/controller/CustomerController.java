package com.servicecustomer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.servicecustomer.entities.Customer;
import com.servicecustomer.entities.Region;
import com.servicecustomer.services.CustomerServiceI;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
    CustomerServiceI customerService;
	
	 @GetMapping(value = "/all")
	    public ResponseEntity<List<Customer>> listAllCustomers(@RequestParam(name = "regionId" , required = false) Long regionId ) {
	        List<Customer> customerss =  new ArrayList<>();
	        if (null ==  regionId) {
	            customerss = customerService.findCustomerAll();
	            if (customerss.isEmpty()) {
	                return ResponseEntity.noContent().build();
	            }
	        }else{
	            Region Region= new Region();
	            Region.setId(regionId);
	            customerss = customerService.findCustomersByRegion(Region);
	            if ( null == customerss ) {
	                //log.error("Customers with Region id {} not found.", regionId);
	                return  ResponseEntity.notFound().build();
	            }
	        }

	        return  ResponseEntity.ok(customerss);
	    }

	    // -------------------Retrieve Single Customer------------------------------------------

	    @GetMapping(value = "/customer/{id}")
	    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
	        //log.info("Fetching Customer with id {}", id);
	        Customer customer = customerService.getCustomer(id);
	        if (  null == customer) {
	            //log.error("Customer with id {} not found.", id);
	            return  ResponseEntity.notFound().build();
	        }
	        return  ResponseEntity.ok(customer); 
	    }

	    // -------------------Create a Customer-------------------------------------------

	    @PostMapping
	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, BindingResult result) {
	        //log.info("Creating Customer : {}", customer);

	       Customer customerDB = customerService.createCustomer (customer);

	        return  ResponseEntity.status( HttpStatus.CREATED).body(customerDB);
	    }

	    // ------------------- Update a Customer ------------------------------------------------

	    @PutMapping(value = "/{id}")
	    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
	        //log.info("Updating Customer with id {}", id);

	        Customer currentCustomer = customerService.getCustomer(id);

	        if ( null == currentCustomer ) {
	            //log.error("Unable to update. Customer with id {} not found.", id);
	            return  ResponseEntity.notFound().build();
	        }
	        customer.setId(id);
	        currentCustomer=customerService.updateCustomer(customer);
	        return  ResponseEntity.ok(currentCustomer);
	    }

	    // ------------------- Delete a Customer-----------------------------------------

	    @DeleteMapping(value = "/{id}")
	    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
	        //log.info("Fetching & Deleting Customer with id {}", id);

	        Customer customer = customerService.getCustomer(id);
	        if ( null == customer ) {
	            //log.error("Unable to delete. Customer with id {} not found.", id);
	            return  ResponseEntity.notFound().build();
	        }
	        customer = customerService.deleteCustomer(customer);
	        return  ResponseEntity.ok(customer);
	    }

	   

}
