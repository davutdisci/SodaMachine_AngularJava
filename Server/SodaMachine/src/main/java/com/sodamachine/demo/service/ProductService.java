package com.sodamachine.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodamachine.demo.model.Product;
import com.sodamachine.demo.model.Transaction;
import com.sodamachine.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TransactionService transactionService;

	public Product saveWord(Product newSoda) {
		return this.productRepository.save(newSoda);
	}

	public List<Product> listProducts() {
		return this.productRepository.findAll();
	}

	public Product updateProductInventory(String productCode) throws Exception {
		
		Product product = productRepository.findByProductCode(productCode);
		
		if (product.getInventory() < 1) {
			throw new Exception();
		} else {
			product.setInventory(product.getInventory() - 1);
			Transaction newTransaction = new Transaction();
			newTransaction.setProduct(product);
			this.transactionService.saveTransaction(newTransaction);
			return this.productRepository.save(product);
		}

	}

}
