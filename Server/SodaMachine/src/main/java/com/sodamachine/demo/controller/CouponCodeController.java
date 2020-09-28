package com.sodamachine.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sodamachine.demo.model.Coupon;
import com.sodamachine.demo.service.CouponService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CouponCodeController {

	@Autowired
	private CouponService couponService;

	@GetMapping("/api/get-coupon-code")
	public List<Coupon> getCoupon(@RequestParam String couponCode) {
		return this.couponService.getCouponByCode(couponCode);
	}

}
