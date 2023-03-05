package com.springBoot.entities;

public class ProductDTO {

	private String productName;
	private Integer pquantity;
	private Double price;
	
	public ProductDTO() {
		super();
	}

	public ProductDTO(String productName, Integer pquantity, Double price) {
		super();
		this.productName = productName;
		this.pquantity = pquantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [productName=" + productName + ", pquantity=" + pquantity + ", price=" + price + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPquantity() {
		return pquantity;
	}

	public void setPquantity(Integer pquantity) {
		this.pquantity = pquantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
