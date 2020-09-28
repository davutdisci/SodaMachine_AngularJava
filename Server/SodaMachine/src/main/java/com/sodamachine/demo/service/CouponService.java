package com.sodamachine.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodamachine.demo.model.Coupon;
import com.sodamachine.demo.repository.CouponRepository;

@Service
public class CouponService {

	@Autowired
	CouponRepository couponRepository;

	public Coupon saveCoupon(Coupon newCoupon) {
		return this.couponRepository.save(newCoupon);
	}

	public List<Coupon> getCouponByCode(String couponCode) {
		return this.couponRepository.findByCouponCode(couponCode);

	}

	public void updateCoupon(String couponCode) {
		Coupon coupon = this.couponRepository.findByCouponCode(couponCode).get(0);
		coupon.setUsedAmount(coupon.getUsedAmount() + 1);
		this.couponRepository.save(coupon);

	}
}
