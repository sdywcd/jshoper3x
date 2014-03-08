package com.jshop.action.app;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.dao.sqlite.SQLiteDBHelper;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsTService;
@Namespace("")
@ParentPackage("jshop")
public class SqliteAction extends SQLiteDBHelper {
	@Resource
	private GoodsTService goodsTService;
	@Resource
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
	
	
	@Action(value="createTable",results={@Result(name="json",type="json")})
	public String createTable() throws SQLException{
		try {
			conn=DriverManager.getConnection("jdbc:sqlite:"+FILENAME);
			Statement st =  conn.createStatement();
			//创建商品分类表
			st.executeUpdate("drop table if exists goods_category_tm");			
			st.executeUpdate("create table goods_category_tm(_id integer primary key autoincrement,goodsCategoryTid text,grade text,name text,goodsTypeId text,sort text)");
			//创建商品表
			st.executeUpdate("drop table if exists goods_tm");
			st.executeUpdate("create table goods_tm(_id integer primary key autoincrement,goodsCategoryTid text,goodsid text,goodsname text,memberprice text,pictureurl text,weight text,detail text,nname text,unitname text)");
			//
			st.executeUpdate("drop table if exists table_tm");
			st.executeUpdate("create table table_tm(_id integer primary key autoincrement,tableid text,tableNumber text,roomName text,androidDevicesCount text,note text,createtime text,nop text,tablestate text,floor text,rnop text)");
			
			List<GoodsT> list = this.getGoodsTService().findAllGoods();
			List<GoodsCategoryT> l=this.getGoodsCategoryTService().findAllCategoryByNoTrem();
			for(GoodsT goods:list){
				//st.executeUpdate("insert into goods_tm (goodsCategoryTid,goodsid,goodsname,memberprice,pictureurl,weight,detail,nname,unitname)values('"+goods.getNavid()+"','"+goods.getGoodsid()+"','"+goods.getGoodsname()+"','"+goods.getMemberprice()+"','"+goods.getPictureurl()+"','"+goods.getWeight()+"','"+goods.getDetail()+"','"+goods.getNname()+"','"+goods.getUnitname()+"')");
			}
			for(GoodsCategoryT category :l){
				st.executeUpdate("insert into goods_category_tm(goodsCategoryTid,grade,name,goodsTypeId,sort)values('"+category.getGoodsCategoryTid()+"','"+category.getGrade()+"','"+category.getName()+"','"+category.getGoodsTypeId()+"','"+category.getSort()+"')");
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw e;
		}
		return "json";
	}
}
