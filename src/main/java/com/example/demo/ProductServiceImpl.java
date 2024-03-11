package com.example.demo;

import java.util.List;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//Class implementing DepartmentService class
public class ProductServiceImpl implements ProductService {

	 @Autowired
	 private ProductRepository productRepository;
	
	 // Save operation
	 @Override
	 public Product saveProduct(Product product)
	 {
	     return productRepository.save(product);
	 }
	
	 // Read operation
	 @Override public List<Product> fetchProductList()
	 {
	     return (List<Product>)
	    		 productRepository.findAll();
	 }
	
	 // Update operation
	 @Override
	 public Product updateProduct(Product product,
	                  Long productId)
	 {
	
		 Product depDB
	         = productRepository.findById(productId)
	               .get();
	
	     
	
	     return productRepository.save(depDB);
	 }
	
	 // Delete operation
	 @Override
	 public void deleteProductById(Long departmentId)
	 {
		 productRepository.deleteById(departmentId);
	 }
}