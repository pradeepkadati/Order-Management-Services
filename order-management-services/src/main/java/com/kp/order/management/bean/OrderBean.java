package com.kp.order.management.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderBean {

	private Long custId;
	private List<LineItemBean> lineItems = new ArrayList<>();

	public OrderBean() {
		super();
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public List<LineItemBean> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemBean> lineItems) {
		this.lineItems = lineItems;
	}

}
