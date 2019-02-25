package com.kp.order.management.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

	private Long id;
	private float total;
	private Date created;
	private Customer customer;
	private List<LineItem> lineItems = new ArrayList<>();
	
	
	
	public Order(Long id,Customer customer) {
		super();
		this.id = id;
		this.created = new Date();
		this.customer = customer;
	}
	
	
	public Order() {
		super();
		this.created = new Date();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addLineItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}
	
	public void removeLineItem(LineItem lineItem) {
		lineItems.remove(lineItem);
	}
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}
}
