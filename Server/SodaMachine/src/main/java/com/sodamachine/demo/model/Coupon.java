package com.sodamachine.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coupons")
public class Coupon {

	@Id
	@GeneratedValue
	@Column(name = "coupon_id")
	private Integer couponId;

	@Column(name = "coupon_code")
	private String couponCode;

	@Column(name = "end_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	@Column(name = "coupon_amount")
	private Integer couponAmount;

	@Column(name = "used_amount")
	private Integer usedAmount;

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(Integer couponAmount) {
		this.couponAmount = couponAmount;
	}

	public Integer getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(Integer usedAmount) {
		this.usedAmount = usedAmount;
	}

	public Coupon() {
	}

}
