package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.OutsideGoodsTDao;
import com.jshop.entity.OutsideGoodsT;
import com.jshop.service.OutsideGoodsTService;
@Service("outsideGoodsTService")
@Scope("prototype")
public class OutsideGoodsTServiceImpl implements OutsideGoodsTService {
	@Resource
	private OutsideGoodsTDao outsideGoodsTDao;
	
	public OutsideGoodsTDao getOutsideGoodsTDao() {
		return outsideGoodsTDao;
	}

	public void setOutsideGoodsTDao(OutsideGoodsTDao outsideGoodsTDao) {
		this.outsideGoodsTDao = outsideGoodsTDao;
	}

	@Override
	public List<OutsideGoodsT> findAllOutsideGoodsT(int lineSize,
			int currentPage) {
		
		return this.getOutsideGoodsTDao().findAllOutsideGoodsT(lineSize, currentPage);
	}

	@Override
	public int countAllOutsideGoodsT() {
		
		return this.getOutsideGoodsTDao().countAllOutsideGoodsT();
	}

	@Override
	public int addOutsideGoodsT(OutsideGoodsT ogt) {
		
		return this.getOutsideGoodsTDao().addOutsideGoodsT(ogt);
	}

	@Override
	public int updateOutsideGoodsT(OutsideGoodsT ogt) {
		
		return this.getOutsideGoodsTDao().updateOutsideGoodsT(ogt);
	}

	@Override
	public OutsideGoodsT findOutsideGoodsTById(String id) {
		
		return this.getOutsideGoodsTDao().findOutsideGoodsTById(id);
	}

	@Override
	public int delOutsideGoodsT(String[] id) {
		
		return this.getOutsideGoodsTDao().delOutsideGoodsT(id);
	}

}
