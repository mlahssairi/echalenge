package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
//Class
public class ProductController {

 @Autowired private ProductService productService;

 // Save operation
 @PostMapping("products")

 public Product saveProduct(
     @Validated @RequestBody Product product)
 {
     return productService.saveProduct(product);
 }

 // Read operation
 @GetMapping("products")

 public List<Product> fetchProductList()
 {
     return productService.fetchProductList();
 }

 // Update operation
 @PutMapping("products/{id}")

 public Product
 updateProduct(@RequestBody Product product,
                  @PathVariable("id") Long productId)
 {
     return productService.updateProduct(
    		 product, productId);
 }

 // Delete operation
 @DeleteMapping("products/{id}")

 public String deleteProductIdById(@PathVariable("id")
                                    Long productId)
 {
	 productService.deleteProductById(
			 productId);
     return "Deleted Successfully";
 }
}