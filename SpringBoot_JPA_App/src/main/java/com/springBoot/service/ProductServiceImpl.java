package com.springBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.entities.Product;
import com.springBoot.entities.ProductDTO;
import com.springBoot.exceptions.ProductException;
import com.springBoot.repository.ProductJpaDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductJpaDao dao;
	
	// 1. Registering products
	
	@Override
	public Product registerProduct(Product p) throws ProductException {
		
		boolean flag= true;
		
		if(flag) {
			
			Product saveProduct= dao.save(p);
			
			return saveProduct;
			
		}else {
			
			throw new ProductException("Unable to register product");
		}
	}

	// 2. Getting all the products
	
	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		List<Product> productList= dao.findAll();
		
		if(productList.isEmpty()) {
			
			throw new ProductException("Unable to get all student details");
			
		}else {
			
			return productList;
		}
	}

	// 3. Updating product details
	
	@Override
	public Product updateProduct(Product p) throws ProductException {
		
		Optional<Product> opt = dao.findById(p.getProductId());
		
		if(opt.isPresent()) {
			
			//this save method perform 2 operation 1. insert 2 merge
			
			Product updatedProduct = dao.save(p);
			
			return updatedProduct;
			
		}else {
			
			throw new ProductException("Unable to update given product details");
		}
	}

	// 4. Delete product by its Id
	
	@Override
	public Product deleteProductById(Integer pid) throws ProductException {
		
		Optional<Product> opt= dao.findById(pid);
		
		if(opt.isPresent()) {
			
			Product existingProduct = opt.get();
			
			dao.delete(existingProduct);
			
			return existingProduct;
			
		}else {
			
			
			throw new ProductException("Unable to delete product details with given Id "+ pid);
		}
		
	}

	// 5. Get products by its category
	
	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {
		
		List<Product> allProductsWithThisCategory= dao.findByCategory(category);
		
		if(allProductsWithThisCategory.isEmpty()) {
			
			throw new ProductException("Unable to get product details by its category");
			
		}else {
			
			return allProductsWithThisCategory;
		}
	}

	// 6. get Product Name, Quantity, Price
	
	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		
		List<ProductDTO> productDTOs= new ArrayList<>();
		
		List<Product> productsList= dao.findAll();
		
		for(Product thisProduct : productsList) {
			
			ProductDTO pDto= new ProductDTO();
			
			pDto.setProductName(thisProduct.getProductName());
			pDto.setPquantity(thisProduct.getQuantity());
			pDto.setPrice(thisProduct.getPrice());
			
			productDTOs.add(pDto);
				
		}
		if(productDTOs.isEmpty()) {
			
			throw new ProductException("Product does not exist");
			
		}else {
			
			return productDTOs;
		}
	}
}
