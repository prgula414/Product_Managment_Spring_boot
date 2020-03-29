package com.management.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.management.product.entity.Product;
import com.management.product.productService.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("productmanagement/v1/")
public class ProductController {

	@ApiOperation(value = "View list of available products", response = ArrayList.class, tags = "Get Product List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Product list"),
			@ApiResponse(code = 404, message = "Product you were trying to reach is not found") })
	@GetMapping(value = "/productsList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProductList() {
		return ProductService.getProductList();
	}

	@ApiOperation(value = "View the product details", response = Product.class, tags = "Get Product Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Product details"),
			@ApiResponse(code = 404, message = "Product is not available") })
	@GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductDetails(@PathVariable int id) {
		return ProductService.getProductList(id);
	}

	@ApiOperation(value = "Create a product", response = Product.class, tags = "Create product")
	@ApiResponse(code = 200, message = "Successfully created a new product")
	@PostMapping(value = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody Product newProduct) {
		return ProductService.addProduct(newProduct);

	}

	@ApiOperation(value = "Update the product", response = Product.class, tags = "Update product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully product updated"),
			@ApiResponse(code = 404, message = "Product not available") })
	@PatchMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@PathVariable int id, @RequestBody Product updateProduct) {
		return ProductService.updateProduct(id, updateProduct);
	}

	@ApiOperation(value = "Delete the product", response = Product.class, tags = "Delete product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully product deleted"),
			@ApiResponse(code = 404, message = "Product not available") })
	@DeleteMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product deleteProduct(@PathVariable int id) {
		return ProductService.deleteProduct(id);
	}

	@ApiOperation(value = "View the list of product based on creation time", response = ArrayList.class, tags = "Get Products Based on Time")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved product list within given time"),
			@ApiResponse(code = 404, message = "Products are not available in the given time") })
	@RequestMapping(value = "/product/hours/{hr}", method = RequestMethod.GET)
	public List<Product> getProductBasedTime(@PathVariable int hr) {
		return ProductService.getProductDate(hr);
	}
	
	@ApiOperation(value = "View the list of removed product", response = ArrayList.class, tags = "Get Removed Products list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved removed product list within given time"),
			@ApiResponse(code = 404, message = "Products are not available in the given time") })
	@RequestMapping(value = "/product/removedhours/{hr}", method = RequestMethod.GET)
	public List<Product> revomedProductListOnTime(@PathVariable int hr) {
		return ProductService.getRemovedProductList(hr);
	}

}
