package com.springBoot.service;

import java.util.List;

import com.springBoot.entities.Product;
import com.springBoot.entities.ProductDTO;
import com.springBoot.exceptions.ProductException;

public interface ProductService {

	public Product registerProduct(Product p)throws ProductException;
	public List<Product> getAllProducts()throws ProductException;
	public Product updateProduct(Product p)throws ProductException;
	public Product deleteProductById(Integer pid)throws ProductException;
	public List<Product> getsProductByCategory(String category)throws ProductException;
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException;
}
