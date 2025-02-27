package com.src.SpringBootEcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.src.SpringBootEcom.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	
	@Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyWord, '%'))")
	List<Product> searchproducts(String keyWord);

}
