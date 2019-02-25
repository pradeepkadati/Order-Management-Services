package com.kp.order.management.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kp.order.management.model.Customer;
import com.kp.order.management.service.CustomerService;

@Path("/customers")
public class CustomerResource {
 
	CustomerService customerServcie = new CustomerService();
	
	@GET
	@Path("/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("custId") Long custId) {
		
		return customerServcie.getCustomer(custId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers() {
		return customerServcie.getCustomers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer addCustomer(Customer customer) {
		return customerServcie.addCustomer(customer);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{custId}")
	public Customer updateCustomer(@PathParam("custId") Long custId, Customer customer) {
		customer.setId(custId);
		return customerServcie.updateCustomer(customer);
	}
	
	@DELETE
	@Path("/{custId}")
	public void removeCustomer(@PathParam("custId") Long custId) {
		customerServcie.removeCustomer(custId);
	}
}
