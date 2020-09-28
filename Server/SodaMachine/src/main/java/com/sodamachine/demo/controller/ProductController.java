package com.sodamachine.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sodamachine.demo.model.Product;
import com.sodamachine.demo.service.CouponService;
import com.sodamachine.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CouponService couponService;

	@GetMapping("/api/get-all-products")
	public List<Product> getAllProducts() {
		List<Product> results = this.productService.listProducts();
		return results;
	}

	@PutMapping("/api/dispense-product")
	public Product updateProduct(@RequestBody Product dispensedProduct, @RequestParam String couponCode) {

		try {
			Product result = this.productService.updateProductInventory(dispensedProduct.getProductCode());
			if (couponCode != null) {
				this.couponService.updateCoupon(couponCode);
			}
			return result;

		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product is out of inventory", ex);
		}

	}

}
