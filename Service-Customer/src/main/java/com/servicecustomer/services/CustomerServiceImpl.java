package com.servicecustomer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecustomer.entities.Customer;
import com.servicecustomer.entities.Region;
import com.servicecustomer.entities.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> findCustomerAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findCustomersByRegion(Region region) {
		return customerRepository.findByRegion(region);
	}

	@Override
	public Customer createCustomer(Customer customer) {

		Customer customerDB = customerRepository.findByNumberID(customer.getNumberID());
		if (customerDB != null) {
			return customerDB;
		}

		customer.setState("CREATED");
		customerDB = customerRepository.save(customer);
		return customerDB;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer customerDB = getCustomer(customer.getId());
		if (customerDB == null) {
			return null;
		}
		customerDB.setFirstName(customer.getFirstName());
		customerDB.setLastName(customer.getLastName());
		customerDB.setEmail(customer.getEmail());

		return customerRepository.save(customerDB);
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		Customer customerDB = getCustomer(customer.getId());
		if (customerDB == null) {
			return null;
		}
		customer.setState("DELETED");
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

}
