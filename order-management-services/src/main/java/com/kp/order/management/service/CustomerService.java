package com.kp.order.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kp.order.management.database.OrderManagementDB;
import com.kp.order.management.model.Customer;

public class CustomerService {

	private Map<Long, Customer> customers = OrderManagementDB.getCustomers();

	public Customer addCustomer(Customer customer) {

		customer.setId(Long.valueOf(customers.size() + 1));
		customers.put(customer.getId(), customer);
		return customer;
	}

	public Customer updateCustomer(Customer customer) {

		if (customer.getId() <= 0) {
			return null;
		}
		customers.put(customer.getId(), customer);
		return customer;
	}

	public void removeCustomer(Long id) {

		customers.remove(id);

	}

	public Customer getCustomer(Long id) {
		return customers.get(id);
	}

	public List<Customer> getCustomers() {
		return new ArrayList<Customer>(customers.values());
	}

}
