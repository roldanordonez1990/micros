package com.servicecustomer.services;

import java.util.List;

import com.servicecustomer.entities.Customer;
import com.servicecustomer.entities.Region;

public interface CustomerServiceI {
	
	public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByRegion(Region region);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public  Customer getCustomer(Long id);

}
