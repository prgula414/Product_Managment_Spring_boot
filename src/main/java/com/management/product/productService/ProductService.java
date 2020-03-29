package com.management.product.productService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.management.product.entity.Product;
import com.management.product.exceptions.ProductNotFoundException;

public class ProductService {
	private static Map<Integer, Product> productMap = new HashMap<>();
	private static Map<Integer,Product> removedProductMap = new HashMap<>();

	static {
		productMap.put(1, new Product(1, "TV", 12000, "10:43:12"));
		productMap.put(2, new Product(2, "Laptop", 8000, "10:43:12"));
	}

	public static List<Product> getProductList() {
		return new ArrayList<>(productMap.values());
	}

	public static Product addProduct(Product newProduct) {
		int inc = productMap.size();
		inc++;
		newProduct.setId(inc);
		newProduct.setCreated_time(getTime());
		productMap.put(inc, newProduct);
		return newProduct;
	}

	public static Product getProductList(int id) {
		if (!productMap.containsKey(id))
			throw new ProductNotFoundException();
		return productMap.get(id);
	}

	public static Product updateProduct(int id, Product updateProduct) {
		if (!productMap.containsKey(id))
			throw new ProductNotFoundException(id);
		updateProduct.setId(id);
		updateProduct.setCreated_time(getTime());
		productMap.put(id, updateProduct);
		return updateProduct;
	}

	public static Product deleteProduct(int id) {
		removedProductMap.put(id, productMap.get(id));
		return productMap.remove(id);
	}

	public static String getTime() {
		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		String timeValue = now.format(formatter);
		return timeValue;
	}

	public static List<Product> getProductDate(int timeInhours) {
		LocalTime currentTime = LocalTime.parse(getTime());
		LocalTime productTime = null;
		List<Product> productTimeList = new ArrayList<>();
		long hoursBetween = 0L;
		List<Product> productList = getProductList();
		for (Product prod : productList) {
			productTime = LocalTime.parse(prod.getCreated_time());
			hoursBetween = ChronoUnit.HOURS.between(currentTime, productTime);
			if (hoursBetween <= timeInhours) {
				productTimeList.add(prod);
			}
		}
		return productTimeList;

	}
	
	public static List<Product> getRemovedProductList(int hr) {
		List<Product> productList = new ArrayList<>(removedProductMap.values());
		LocalTime currentTime = LocalTime.parse(getTime());
		LocalTime productTime = null;
		List<Product> productTimeList = new ArrayList<>();
		long hoursBetween = 0L;
		for (Product prod : productList) {
			productTime = LocalTime.parse(prod.getCreated_time());
			hoursBetween = ChronoUnit.HOURS.between(currentTime, productTime);
			if (hoursBetween <= hr) {
				productTimeList.add(prod);
			}
		}
		return productTimeList;
	}
}
