package com.sodamachine.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodamachine.demo.model.Transaction;
import com.sodamachine.demo.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public Transaction saveTransaction(Transaction newTransaction) {
		return this.transactionRepository.save(newTransaction);
	}
}
