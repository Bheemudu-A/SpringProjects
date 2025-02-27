package com.src.SpringBootEcom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.src.SpringBootEcom.model.Product;
import com.src.SpringBootEcom.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public List<Product> getAllProducts() {	
	//	System.out.println("repo : "+repo.findAll());
		return repo.findAll();
	}
	

	public Product getProductById(int id) {		
		return repo.findById(id).orElse(new Product(-1));
	}


	public Product addProduct(Product product, MultipartFile image) throws IOException {
		
		//setting image data to product obj
		product.setImageType(image.getContentType());
		product.setImageName(image.getName());
		product.setImageData(image.getBytes());
		
		return repo.save(product);
	}


	public List<Product> searchProductByKeyword(String keyWord) {		
		return repo.searchproducts(keyWord);
	}

}
