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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kp.order.management.model.Product;
import com.kp.order.management.service.ProductService;

@Path("/products")
public class ProductResource {

	private ProductService service = new ProductService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{prodId}")
	public Product getProduct(@PathParam("prodId") Long prodId) {
		
		return service.getProduct(prodId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts(@QueryParam("sIndex") int sIndex,@QueryParam("size") int size) {
		
		if (sIndex >= 0 && size > 0) {
			return service.getPagedProducts(sIndex, size);
		}
		
		return service.getProducts();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product addProduct(Product product) {
		return service.addProduct(product);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{prodId}")
	public Product updateProduct(@PathParam("prodId") Long prodId, Product product) {
		product.setId(prodId);
		return service.addProduct(product);
	}
	
	@DELETE
	@Path("/{prodId}")
	public void  removeProduct(@PathParam("prodId") Long prodId) {
		service.removeProduct(prodId);
	}
	
}
