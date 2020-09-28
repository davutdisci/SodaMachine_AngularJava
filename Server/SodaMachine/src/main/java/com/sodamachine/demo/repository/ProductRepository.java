package com.sodamachine.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sodamachine.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	 @Query("Select p from Product p where p.productCode = ?1")
	 Product findByProductCode(String productCode);
}
