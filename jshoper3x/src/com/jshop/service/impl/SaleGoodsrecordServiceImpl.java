package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.SaleGoodsrecordTDao;
import com.jshop.entity.SaleGoodsrecordT;
import com.jshop.service.SaleGoodsrecordService;

@Service("saleGoodsrecordService")
@Scope("prototype")
public class SaleGoodsrecordServiceImpl implements SaleGoodsrecordService {
	@Resource
	private SaleGoodsrecordTDao saleGoodsrecordTDao;

	public SaleGoodsrecordTDao getSaleGoodsrecordTDao() {
		return saleGoodsrecordTDao;
	}

	public void setSaleGoodsrecordTDao(SaleGoodsrecordTDao saleGoodsrecordTDao) {
		this.saleGoodsrecordTDao = saleGoodsrecordTDao;
	}

	@Override
	public int addSaleGoodsrecord(SaleGoodsrecordT salegoodsrecordt) {
		return this.getSaleGoodsrecordTDao().addSaleGoodsrecord(salegoodsrecordt);
	}

	@Override
	public int updateSaleGoodsrecord(SaleGoodsrecordT salegoodsrecordt) {
		return this.getSaleGoodsrecordTDao().updateSaleGoodsrecord(salegoodsrecordt);
	}

	@Override
	public int deleteSaleGoodsrecord(String[] list) {

		return this.getSaleGoodsrecordTDao().deleteSaleGoodsrecord(list);
	}

	@Override
	public List<SaleGoodsrecordT> findallSaleGoodsrecord(int currentPage, int lineSize) {
		return this.getSaleGoodsrecordTDao().findallSaleGoodsrecord(currentPage, lineSize);
	}

	@Override
	public List<SaleGoodsrecordT> sortAllSaleGoodsrecord(int currentPage, int lineSize, String queryString) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsrecordTDao().sortAllSaleGoodsrecord(currentPage, lineSize, queryString);
	}

	@Override
	public int countAllSaleGoodsrecordT() {
		// TODO Auto-generated method stub
		return this.getSaleGoodsrecordTDao().countAllSaleGoodsrecordT();
	}

	@Override
	public int updateSaleGoodsrecordByHiprice(SaleGoodsrecordT salegoodsrecordt) {
		return this.getSaleGoodsrecordTDao().updateSaleGoodsrecordByHiprice(salegoodsrecordt);
	}

	@Override
	public int updateSaleGoodsrecordHtmlPath(String htmlpath, String salerecordid) {
		return this.getSaleGoodsrecordTDao().updateSaleGoodsrecordHtmlPath(htmlpath, salerecordid);
	}

	@Override
	public SaleGoodsrecordT findrecordbysalegoodsid(String salegoodsid) {
		return this.getSaleGoodsrecordTDao().findrecordbysalegoodsid(salegoodsid);
	}

	@Override
	public int addrecordByhiprice(SaleGoodsrecordT salegoodsrecordt) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsrecordTDao().addrecordByhiprice(salegoodsrecordt);
	}

	@Override
	public double hiprice(String salegoodsid) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsrecordTDao().hiprice(salegoodsid);
	}

	@Override
	public SaleGoodsrecordT findsalerecordid(String salerecordid) {
		return this.getSaleGoodsrecordTDao().findSaleGoodsrecordByid(salerecordid);
	}

	@Override
	public List<SaleGoodsrecordT> findAllSaleGoodsrecordT() {
		return this.getSaleGoodsrecordTDao().findAllSaleGoodsrecordT();
	}

	@Override
	public int findjoinnumber(String salegoodsid) {
		return this.getSaleGoodsrecordTDao().findjoinnumber(salegoodsid);
	}

	@Override
	public List<SaleGoodsrecordT> findbyEndingtime(Date endingtime) {
		return this.getSaleGoodsrecordTDao().findbyEndingtime(endingtime);
	}

}
