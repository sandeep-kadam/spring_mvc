package com.sk.spring.dao;

import java.util.List;

import com.sk.spring.entity.Customer;

public interface ICustomerDAO {

	
	public List<Customer> getCustomers(String customerName);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);
}
