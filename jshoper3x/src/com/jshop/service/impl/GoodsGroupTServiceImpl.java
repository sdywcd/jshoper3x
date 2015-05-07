package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.dao.GoodsGroupAttributeRpTDao;
import com.jshop.dao.GoodsGroupDetailRpTDao;
import com.jshop.dao.GoodsGroupTDao;
import com.jshop.entity.GoodsGroupAttributeRpT;
import com.jshop.entity.GoodsGroupDetailRpT;
import com.jshop.entity.GoodsGroupT;
import com.jshop.service.GoodsGroupTService;

@Service("goodsGroupTService")
@Scope("prototype")
public class GoodsGroupTServiceImpl extends BaseTServiceImpl<GoodsGroupT> implements GoodsGroupTService {
	@Resource
	private GoodsGroupTDao goodsGroupTDao;
	@Resource
	private GoodsGroupDetailRpTDao goodsGroupDetailRpTDao;
	@Resource
	private GoodsGroupAttributeRpTDao goodsGroupAttributeRpTDao;
	@Resource
	private Serial serial;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveGoodsGroupProcess(GoodsGroupT ggt,
			GoodsGroupDetailRpT ggdt, String goodsAttrsVals) {
		JSONArray ja=(JSONArray)JSONValue.parse(goodsAttrsVals);
		int jsonsize=ja.size();
		for(int i=0;i<jsonsize;i++){
			GoodsGroupAttributeRpT gart=new GoodsGroupAttributeRpT();
			gart.setId(this.serial.Serialid(Serial.GOODSGROUPATTRIBUTERPT));
			gart.setGroupid(ggt.getGroupid());
			JSONObject jo=(JSONObject) ja.get(i);
			gart.setAttrval(jo.get(StaticKey.ATTRVAL).toString());
			this.goodsGroupAttributeRpTDao.save(gart);
		}
		this.goodsGroupDetailRpTDao.save(ggdt);
		this.goodsGroupTDao.save(ggt);
	}


	@Override
	public void updateGoodsGroupProcess(GoodsGroupT ggt, String detail,
			String goodsAttrsVals) {
		//更新商品团购表
		this.goodsGroupTDao.update(ggt);
		//更新商品团购介绍
		Criterion criterion=Restrictions.eq("groupid", ggt.getGroupid());
		GoodsGroupDetailRpT ggrt=this.goodsGroupDetailRpTDao.findOneByCriteria(GoodsGroupDetailRpT.class, criterion);
		if(ggrt!=null){
			ggrt.setDetail(detail);
			this.goodsGroupDetailRpTDao.update(ggrt);
		}else{
			ggrt=new GoodsGroupDetailRpT();
			ggrt.setGroupid(ggt.getGroupid());
			ggrt.setDetail(detail);
			ggrt.setId(this.serial.Serialid(Serial.GOODSGROUPDETAILRPT));
			this.goodsGroupDetailRpTDao.save(ggrt);
		}
		List<GoodsGroupAttributeRpT>list=this.goodsGroupAttributeRpTDao.findByCriteria(GoodsGroupAttributeRpT.class, criterion);
		this.goodsGroupAttributeRpTDao.deleteAll(list);
		JSONArray ja=(JSONArray)JSONValue.parse(goodsAttrsVals);
		int jsonsize=ja.size();
		GoodsGroupAttributeRpT gart=new GoodsGroupAttributeRpT();
		for(int i=0;i<jsonsize;i++){
			gart.setId(this.serial.Serialid(Serial.GOODSGROUPATTRIBUTERPT));
			gart.setGroupid(ggt.getGroupid());
			JSONObject jo=(JSONObject) ja.get(i);
			gart.setAttrval(jo.get(StaticKey.ATTRVAL).toString());
			this.goodsGroupAttributeRpTDao.save(gart);
		}
	}


}
