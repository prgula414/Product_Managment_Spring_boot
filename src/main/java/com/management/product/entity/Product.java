package com.management.product.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Product {

	@ApiModelProperty(name = "id", required = false, value = "1", notes ="unique id of product")
	private int id;
	
	@ApiModelProperty(name = "productName", required = true, value = "Laptop", notes ="name of the product")
	private @NonNull String productName;
	
	@ApiModelProperty(name = "productPrice", required = true, value = "20000", notes ="price of the product")
	private  int productPrice;
	
	@ApiModelProperty(name = "created_time", required = false, value = "17:09:25", notes = "created time of the product")
	private String created_time;
	
}
