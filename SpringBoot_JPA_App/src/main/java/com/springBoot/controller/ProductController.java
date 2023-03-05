package com.springBoot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entities.Product;
import com.springBoot.entities.ProductDTO;
import com.springBoot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	// 1. Registering Products
	
	@PostMapping(value = "/products")
	public ResponseEntity<Product> registerProductHandler(@Valid @RequestBody Product product){
		
		Product registerProduct = pService.registerProduct(product);
		
		return new ResponseEntity<Product>(registerProduct, HttpStatus.OK);
	}
	
	// 2. Getting all the products
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getAllProductsHandler(){
		
		List<Product> gettingList= pService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(gettingList, HttpStatus.ACCEPTED);
	}
	
	// 3. Updating product details
	
	@PutMapping(value = "/products")
	public ResponseEntity<Product> updateProductHandler(@Valid @RequestBody Product product){
		
		Product updateProductDetails = pService.updateProduct(product);
		
		return new ResponseEntity<Product>(updateProductDetails, HttpStatus.CREATED);
	}
	
	// 4. Delete product by its Id
	
	@DeleteMapping(value = "/products/{Id}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("Id") Integer pid){
		
		Product deletedProduct = pService.deleteProductById(pid);
		
		return new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);
	}
	
	// 5. Get products by its category
	
	@GetMapping("/products/{cat}")
	public ResponseEntity<List<Product>> getProductsByCategoryHandler(@PathVariable("cat") String category){
		
		List<Product> productsByCategoryList= pService.getsProductByCategory(category);
		
		return new ResponseEntity<List<Product>>(productsByCategoryList, HttpStatus.CREATED);
	}
	
	// 6. get Product Name, Quantity, Price
	
	@GetMapping(value = "/productdtos")
	public ResponseEntity<List<ProductDTO>> getProductNameQtyPriceHandler(){
		
		List<ProductDTO> productNameQuantityPrice= pService.getProductNameQtyPrice();
		
		return new ResponseEntity<List<ProductDTO>>(productNameQuantityPrice, HttpStatus.ACCEPTED);
		
	}
}
