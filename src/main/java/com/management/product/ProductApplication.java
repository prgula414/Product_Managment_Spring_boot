package com.management.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		System.out.println("PrdouctApplication main() method : START");
		
		SpringApplication.run(ProductApplication.class, args);
		
		System.out.println("PrdouctApplication main() method : STOP");
	}
}
