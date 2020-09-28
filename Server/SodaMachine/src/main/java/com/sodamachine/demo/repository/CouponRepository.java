package com.sodamachine.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sodamachine.demo.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	@Query("Select c from Coupon c where c.couponCode = ?1")
	List<Coupon> findByCouponCode(String couponCode);
	
}
