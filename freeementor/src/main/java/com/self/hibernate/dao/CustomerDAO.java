package com.self.hibernate.dao;

import java.util.List;

import com.self.hibernate.model.Customer;

public interface CustomerDAO {
	public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
