package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.BrandTDao;
import com.jshop.entity.BrandT;
import com.jshop.service.BrandTService;

@Service("brandTService")
@Scope("prototype")
public class BrandTServiceImpl implements BrandTService {
	@Resource
	private BrandTDao brandTDao;

	public BrandTDao getBrandTDao() {
		return brandTDao;
	}

	public void setBrandTDao(BrandTDao brandTDao) {
		this.brandTDao = brandTDao;
	}

	public int delBrandt(String[] list, String creatorid) {
		return this.getBrandTDao().delBrandt(list, creatorid);
	}

	public void updateBrandt(BrandT bt) {
		this.getBrandTDao().updateBrandt(bt);
	}

	public int addBrandt(BrandT bt) {
		return this.getBrandTDao().addBrandt(bt);
	}

	public int countfindAllBrandt(String creatorid) {
		return this.getBrandTDao().countfindAllBrandt(creatorid);
	}

	public List<BrandT> findAllBrandt(int currentPage, int lineSize, String creatorid) {
		return this.getBrandTDao().findAllBrandt(currentPage, lineSize, creatorid);
	}

	public BrandT findBrandById(String brandid) {
		return this.getBrandTDao().findBrandById(brandid);
	}

	public List<BrandT> findAllBrandt() {
		return this.getBrandTDao().findAllBrandt();
	}

	public List<BrandT> sortAllBrandt(int currentPage, int lineSize, String creatorid, String queryString) {

		return this.getBrandTDao().sortAllBrandt(currentPage, lineSize, creatorid, queryString);
	}
}
