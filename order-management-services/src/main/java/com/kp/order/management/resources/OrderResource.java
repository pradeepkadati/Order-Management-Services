package com.kp.order.management.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.kp.order.management.bean.OrderBean;
import com.kp.order.management.model.Customer;
import com.kp.order.management.model.LineItem;
import com.kp.order.management.model.Order;
import com.kp.order.management.model.Product;
import com.kp.order.management.service.OrderService;

@Path("/orders")
public class OrderResource {

	@Context
	private ResourceContext recourceContext;
	private OrderService orderService = new OrderService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders(@QueryParam("sIndex") int sIndex,@QueryParam("size") int size) {
		
		if (sIndex >= 0 && size > 0) {
			return orderService.getPagedOrders(sIndex, size);
		}
		return orderService.getOrders();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{orderId}")
	public Order getOrder(@PathParam("orderId") Long orderId) {
		return orderService.getOrder(orderId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Order addOrder(OrderBean orderBean) {

		CustomerResource cr = recourceContext.getResource(CustomerResource.class);

		Customer customer = cr.getCustomer(orderBean.getCustId());
		Order order = new Order();
		order.setCustomer(customer);
		
		buildLineItems(order,orderBean);

		return orderService.addOrder(order);
	}
	
	@DELETE
	@Path("/{orderId}")
	public void removeOrder(@PathParam("orderId") Long orderId) {
		orderService.removeOrder(orderId);
	}

	private void buildLineItems(Order order, OrderBean orderBean) {
		
		
		if (!orderBean.getLineItems().isEmpty()) {
			
			ProductResource pr = recourceContext.getResource(ProductResource.class);
			
			orderBean.getLineItems().stream().forEach(itemBean->{
				
				Product product = pr.getProduct(itemBean.getProdId());
				LineItem lineItem = new LineItem(itemBean.getId(), itemBean.getQuantity(), product);
				order.addLineItem(lineItem);
				order.setTotal(order.getTotal() + (lineItem.getQuantity() * product.getCost()));
				
			});
		}
		
	}

}
