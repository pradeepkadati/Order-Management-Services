package com.kp.order.management.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LineItem {

	private Long id;
	private float quantity;
	private Product product;

	public LineItem(Long id, float quantity, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}

	public LineItem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
