package com.src.SpringBootEcom.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.src.SpringBootEcom.model.Product;
import com.src.SpringBootEcom.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController()
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
/*	@GetMapping("/products")
	public List<Product> product() {
		System.out.println("In product");
		return productService.getAllProducts();
	}*/
	
	
	
	/*
	 * ResponseEntity is used to show status for the responses, it we successfully fetched data then we will get status as 202(ACCEPTED) in Postman
	 */
	@GetMapping("/products")
	public ResponseEntity<List<Product>> product(){
		return new ResponseEntity(productService.getAllProducts(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){	
		Product product = productService.getProductById(id);
		
		if(product.getId()>0)
			return new ResponseEntity(product, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> getProductImage(@RequestPart Product product, @RequestPart MultipartFile image){
		Product savedProduct = null;
		
		try {
			 savedProduct  = productService.addProduct(product, image);
			return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
		}catch(IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	
	@GetMapping("/products/search/{keyWord}")
	public ResponseEntity<List<Product>> searchProductByKeyWord(@PathVariable String keyWord){
		
		List<Product> products = productService.searchProductByKeyword(keyWord);
		
		if(products != null)
		  return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

}
