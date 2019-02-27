package com.kp.order.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kp.order.management.database.OrderManagementDB;
import com.kp.order.management.model.Product;

public class ProductService {

	private Map<Long, Product> products = OrderManagementDB.getProducts();

	public Product addProduct(Product product) {

		product.setId(Long.valueOf(products.size() + 1));
		products.put(product.getId(), product);
		return product;
	}

	public Product updateProduct(Product product) {

		if (product.getId() <= 0) {
			return null;
		}
		products.put(product.getId(), product);
		return product;
	}

	public void removeProduct(Long id) {

		products.remove(id);

	}

	public Product getProduct(Long id) {
		return products.get(id);
	}

	public List<Product> getProducts() {
		return new ArrayList<Product>(products.values());
	}
	
	public List<Product> getPagedProducts(int index, int size) {

		if ((size + index) > products.size()) {
			return null;
		}

		List<Product> productList = new ArrayList<Product>(products.values());
		return productList.subList(index, (size + index));
	}


}
