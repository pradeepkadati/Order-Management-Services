package com.kp.order.management.database;

import java.util.HashMap;
import java.util.Map;

import com.kp.order.management.model.Customer;
import com.kp.order.management.model.LineItem;
import com.kp.order.management.model.Order;
import com.kp.order.management.model.Product;

public class OrderManagementDB {

	private static final Map<Long, Customer> customers = new HashMap<>();
	private static final Map<Long,Product> products = new HashMap<>();
	private static final Map<Long,Order> orders = new HashMap<>();
	
	static {
	
		Customer c1 = new Customer(Long.valueOf(1),"Pradeep","Kadati","leslie st","Fremont","CA","94538","USA");
		Customer c2 = new Customer(Long.valueOf(2),"Pradeep Reddy","Kadati","leslie st","Fremont","CA","94538","USA");
		Customer c3 = new Customer(Long.valueOf(3),"Pradeep Kumar","Kadati","leslie st","Fremont","CA","94538","USA");
		customers.put(c1.getId(), c1);
		customers.put(c2.getId(), c2);
		customers.put(c3.getId(), c3);
		
		Product p1 = new Product(Long.valueOf(1), "Creta", 15.5f);
		Product p2 = new Product(Long.valueOf(2), "i10", 5.5f);
		Product p3 = new Product(Long.valueOf(3), "i20", 7.5f);
		Product p4 = new Product(Long.valueOf(4), "Verna", 11.5f);
		
		products.put(p1.getId(), p1);
		products.put(p2.getId(), p2);
		products.put(p3.getId(), p3);
		products.put(p4.getId(), p4);
		
		Order order = new Order(Long.valueOf(1),c1);
		order.addLineItem(new LineItem(Long.valueOf(1),1.0f,p1));
		order.addLineItem(new LineItem(Long.valueOf(2),2.0f,p2));
		order.setTotal(3.0f);
		
		orders.put(order.getId(), order);
	}
	
	public static Map<Long, Customer> getCustomers() {
		return customers;
	}
	public static Map<Long, Product> getProducts() {
		return products;
	}
	public static Map<Long, Order> getOrders() {
		return orders;
	}
	
	
}
