package com.kp.order.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kp.order.management.database.OrderManagementDB;
import com.kp.order.management.model.Order;

public class OrderService {

	private Map<Long,Order> orders = OrderManagementDB.getOrders();
	
	public Order getOrder(Long id) {
		return orders.get(id);
	}

	public List<Order> getOrders() {
		return new ArrayList<Order>(orders.values());
	}
	
	public Order addOrder(Order order) {
		order.setId(Long.valueOf(orders.size()+1));
		orders.put(order.getId(), order);
		return order;
	}
	
	public Order updateOrder(Order order) {
		if (!orders.containsKey(order.getId())) {
			
			return null;
		}
		orders.put(order.getId(), order);
		return order;
	}
	
	public void removeOrder(Long id) {
		orders.remove(id);
	}
	
	public List<Order> getPagedOrders(int index, int size) {

		if ((size + index) > orders.size()) {
			return null;
		}

		List<Order> orderList = new ArrayList<Order>(orders.values());
		return orderList.subList(index, (size + index));
	}
}
