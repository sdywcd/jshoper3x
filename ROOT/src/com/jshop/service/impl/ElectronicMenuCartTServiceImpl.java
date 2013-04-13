package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ElectronicMenuCartTDao;
import com.jshop.entity.ElectronicMenuCartT;
import com.jshop.service.ElectronicMenuCartTService;

@Service("electronicMenuCartTService")
@Scope("prototype")
public class ElectronicMenuCartTServiceImpl implements ElectronicMenuCartTService {
	@Resource
	private ElectronicMenuCartTDao electronicMenuCartTDao;

	public ElectronicMenuCartTDao getElectronicMenuCartTDao() {
		return electronicMenuCartTDao;
	}

	public void setElectronicMenuCartTDao(ElectronicMenuCartTDao electronicMenuCartTDao) {
		this.electronicMenuCartTDao = electronicMenuCartTDao;
	}

	public int addElectronicMenuCartT(ElectronicMenuCartT ec) {
		return this.getElectronicMenuCartTDao().addElectronicMenuCartT(ec);
	}

	public int countfindAllElectronicMenuCartT() {
		return this.getElectronicMenuCartTDao().countfindAllElectronicMenuCartT();
	}

	public int delElectronicMenuCartTGoods(String tableNumber, String tablestate, String goodsid, String state) {
		return this.getElectronicMenuCartTDao().delElectronicMenuCartTGoods(tableNumber, tablestate, goodsid, state);
	}

	public List<ElectronicMenuCartT> findAllElectronicMenuCartT() {
		return this.getElectronicMenuCartTDao().findAllElectronicMenuCartT();
	}

	public List<ElectronicMenuCartT> findAllElectronicMenuCartTBytableNumber(String tableNumber, String tablestate) {
		return this.getElectronicMenuCartTDao().findAllElectronicMenuCartTBytableNumber(tableNumber, tablestate);
	}

	public List<ElectronicMenuCartT> findAllElectronicMenuCartTByusername(String username) {
		return this.getElectronicMenuCartTDao().findAllElectronicMenuCartTByusername(username);
	}

	public List<ElectronicMenuCartT> findElectronicMenuCartTByelectronicMenuOrderid(String electronicMenuOrderid, String state) {
		return this.getElectronicMenuCartTDao().findElectronicMenuCartTByelectronicMenuOrderid(electronicMenuOrderid, state);
	}

	public ElectronicMenuCartT findGoodsInElectronicMenuCartTOrNot(String tableNumber, String tablestate, String goodsid, String state) {
		return this.getElectronicMenuCartTDao().findGoodsInElectronicMenuCartTOrNot(tableNumber, tablestate, goodsid, state);
	}

	public int updateElectronicMenuCartTelectronicMenuCartid(String electronicMenuCartid, String state, String tableNumber, String tablestate) {
		return this.getElectronicMenuCartTDao().updateElectronicMenuCartTelectronicMenuCartid(electronicMenuCartid, state, tableNumber, tablestate);
	}

	public int updateElectronicMenuCartTneedquantityBygoodsid(String tableNumber, String tablestate, String goodsid, int needquantity, String state) {
		return this.getElectronicMenuCartTDao().updateElectronicMenuCartTneedquantityBygoodsid(tableNumber, tablestate, goodsid, needquantity, state);
	}

	public int updateElectronicMenuCartTstate(String tableNumber, String tablestate, String goodsid, String state) {
		return this.getElectronicMenuCartTDao().updateElectronicMenuCartTstate(tableNumber, tablestate, goodsid, state);
	}

	public int updateElectronicMenuCartTstate(String tableNumber, String tablestate, String electronicMenuOrderid, String state, String electronicMenuCartid) {
		return this.getElectronicMenuCartTDao().updateElectronicMenuCartTstate(tableNumber, tablestate, electronicMenuOrderid, state, electronicMenuCartid);
	}

	public int updateElectronicMenuCartTsubtotal(String tableNumber, String tablestate, String goodsid, double subtotal) {
		return this.getElectronicMenuCartTDao().updateElectronicMenuCartTsubtotal(tableNumber, tablestate, goodsid, subtotal);
	}

	public int updateElectronicMenuCartTtablestate(String electronicMenuOrderid, String tablestate) {
		return this.getElectronicMenuCartTDao().updateElectronicMenuCartTtablestate(electronicMenuOrderid, tablestate);
	}

	@Override
	public int updateElectroMenuCartCookingState(String cookingstate, String tableNumber) {
		return this.getElectronicMenuCartTDao().updateElectroMenuCartCookingState(cookingstate, tableNumber);
	}

	@Override
	public List<ElectronicMenuCartT> findElectronicCartByTableNumber(String tablenumber) {

		return this.getElectronicMenuCartTDao().findElectronicCartByTableNumber(tablenumber);
	}

}
