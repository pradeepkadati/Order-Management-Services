package com.kp.order.management.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private Long id;
	private String name;
	private float cost;
	
	public Product(Long id, String name, float cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	
	
	public Product() {
		super();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
