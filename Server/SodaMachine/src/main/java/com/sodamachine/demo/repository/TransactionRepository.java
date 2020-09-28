package com.sodamachine.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sodamachine.demo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
