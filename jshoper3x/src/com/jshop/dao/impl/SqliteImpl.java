package com.jshop.dao.impl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;



import com.jshop.dao.sqlite.SQLiteDBHelper;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsTService;
import com.mysql.jdbc.Statement;

public class SqliteImpl  extends SQLiteDBHelper{
	private GoodsTService goodsTService;
	private GoodsCategoryTService goodsCategoryTService;
	
	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) { 
		this.goodsTService = goodsTService;
	}
	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}
	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}
	
	public void CreateTable() throws SQLException{
		try {
			conn=DriverManager.getConnection("jdbc:sqlite"+FILENAME);
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate("create table goods_category_tm(_id integer primary key autoincrement,goodsCategoryTid text,grade text,name text,goodsTypeId text,sort text)");
			st.executeUpdate("create table goods_tm(_id integer primary key autoincrement,goodsCategoryTid text,goodsid text,goodsname text,memberprice text,pictureurl text)");
			List<GoodsT> list = this.getGoodsTService().findAllGoods();
			List<GoodsCategoryT> l=this.getGoodsCategoryTService().findAllCategoryByNoTrem();
			for(GoodsT goods:list){
				st.executeUpdate("insert into goods_tm (goodsCategoryTid,goodsid,goodsname,memberprice,pictureurl)values("+goods.getNavid()+","+goods.getGoodsid()+","+goods.getGoodsname()+","+goods.getMemberprice()+","+goods.getPictureurl()+")");
			}
			for(GoodsCategoryT category :l){
				st.executeUpdate("insert into goods_category_tm(goodsCategoryTid,grade,name,goodsTypeId,sort)values("+category.getGoodsCategoryTid()+","+category.getGrade()+","+category.getName()+","+category.getGoodsTypeId()+","+category.getSort()+")");
			}
		} catch (SQLException e) {
			throw e;
		}
	}
}
