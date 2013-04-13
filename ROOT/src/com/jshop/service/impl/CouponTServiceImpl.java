package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.CouponTDao;
import com.jshop.entity.CouponT;
import com.jshop.service.CouponTService;

@Service("couponTService")
@Scope("prototype")
public class CouponTServiceImpl implements CouponTService {
	@Resource
	private CouponTDao couponTDao;

	public CouponTDao getCouponTDao() {
		return couponTDao;
	}

	public void setCouponTDao(CouponTDao couponTDao) {
		this.couponTDao = couponTDao;
	}

	public int countfindAllCoupon() {
		return this.getCouponTDao().countfindAllCoupon();
	}

	public List<CouponT> findAllCoupon(int currentPage, int lineSize) {
		return this.getCouponTDao().findAllCoupon(currentPage, lineSize);
	}

	public void addCouponT(CouponT ct) {
		this.getCouponTDao().addCouponT(ct);
	}
}
