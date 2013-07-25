package com.jshop.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.OutsideGoodsTwocodeRelationshipTDao;
import com.jshop.entity.OutsidegoodsTwocodeRelationshipT;
import com.jshop.service.OutsideGoodsTwocodeRelationshipService;
@Service("outsideGoodsTwocodeRelationshipService")
@Scope("prototype")
public class OutsideGoodsTwocodeRelationshipServiceImpl implements
		OutsideGoodsTwocodeRelationshipService {
	@Resource
	private OutsideGoodsTwocodeRelationshipTDao outsideGoodsTwocodeRelationshipTDao;
	

	public OutsideGoodsTwocodeRelationshipTDao getOutsideGoodsTwocodeRelationshipTDao() {
		return outsideGoodsTwocodeRelationshipTDao;
	}

	public void setOutsideGoodsTwocodeRelationshipTDao(
			OutsideGoodsTwocodeRelationshipTDao outsideGoodsTwocodeRelationshipTDao) {
		this.outsideGoodsTwocodeRelationshipTDao = outsideGoodsTwocodeRelationshipTDao;
	}

	@Override
	public int addGoodsQRCode(OutsidegoodsTwocodeRelationshipT qrcode) {
		
		return this.getOutsideGoodsTwocodeRelationshipTDao().addGoodsQRCode(qrcode);
	}

	@Override
	public OutsidegoodsTwocodeRelationshipT findGoodsQRCodeByGoodsid(String id) {
		// TODO Auto-generated method stub
		return this.getOutsideGoodsTwocodeRelationshipTDao().findGoodsQRCodeByGoodsid(id);
	}

	@Override
	public int updateGoodsQRCode(String id, String twocodepath) {
		// TODO Auto-generated method stub
		return this.getOutsideGoodsTwocodeRelationshipTDao().updateGoodsQRCode(id, twocodepath);
	}

}
