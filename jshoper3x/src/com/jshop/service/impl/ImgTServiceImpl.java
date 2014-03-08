package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ImgTDao;
import com.jshop.entity.ImgT;
import com.jshop.service.ImgTService;

@Service("imgTService")
@Scope("prototype")
public class ImgTServiceImpl extends BaseTServiceImpl<ImgT>implements ImgTService {
	@Resource
	private ImgTDao imgTDao;

	public ImgTDao getImgTDao() {
		return imgTDao;
	}

	public void setImgTDao(ImgTDao imgTDao) {
		this.imgTDao = imgTDao;
	}


	public int countfindAllImgT() {
		return this.getImgTDao().countfindAllImgT();
	}

	public int delImgT(String[] list) {
		return this.getImgTDao().delImgT(list);
	}

	public List<ImgT> findAllImgT(int currentPage, int lineSize) {
		return this.getImgTDao().findAllImgT(currentPage, lineSize);
	}

	public int updateImgT(ImgT i) {
		return this.getImgTDao().updateImgT(i);
	}

	public ImgT findImgTByImgName(String imgName) {
		return this.getImgTDao().findImgTByImgName(imgName);
	}

	public List<ImgT> findImgTByusedGoodsidandusedPositionId(String imgId) {
		return this.getImgTDao().findImgTByusedGoodsidandusedPositionId(imgId);
	}

	public List<ImgT> findImgTByusedGoodsid(String usedGoodsid) {
		return this.getImgTDao().findImgTByusedGoodsid(usedGoodsid);
	}

	public List<ImgT> findImgTByusedGoodsidandPositionIdisNull(String usedGoodsid) {
		return this.getImgTDao().findImgTByusedGoodsidandPositionIdisNull(usedGoodsid);
	}

	public int updateImgState(String imgId, String state) {
		return this.getImgTDao().updateImgState(imgId, state);
	}

	public int countfindAllImgTByImgName(String imgName) {
		return this.getImgTDao().countfindAllImgTByImgName(imgName);
	}

	public List<ImgT> findAllImgTByImgName(int currentPage, int lineSize, String imgName) {
		return this.getImgTDao().findAllImgTByImgName(currentPage, lineSize, imgName);
	}

	public List<ImgT> sortAllImgT(int currentPage, int lineSize, String queryString) {

		return this.getImgTDao().sortAllImgT(currentPage, lineSize, queryString);
	}
}
