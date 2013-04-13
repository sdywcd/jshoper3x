package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.PageEditareaTDao;
import com.jshop.entity.PageEditareaT;
import com.jshop.service.PageEditareaTService;

@Service("pageEditareaTService")
@Scope("prototype")
public class PageEditareaTServiceImpl implements PageEditareaTService {
	@Resource
	private PageEditareaTDao pageEditareaTDao;

	public PageEditareaTDao getPageEditareaTDao() {
		return pageEditareaTDao;
	}

	public void setPageEditareaTDao(PageEditareaTDao pageEditareaTDao) {
		this.pageEditareaTDao = pageEditareaTDao;
	}

	public int updatePageEditareaT(PageEditareaT pea) {
		return this.getPageEditareaTDao().updatePageEditareaT(pea);
	}

	public int addPageEditareaT(PageEditareaT pea) {
		return this.getPageEditareaTDao().addPageEditareaT(pea);
	}

	public List<PageEditareaT> findPageEditareaTByPageidandTypeid(String pageid, String typeid) {
		return this.getPageEditareaTDao().findPageEditareaTByPageidandTypeid(pageid, typeid);
	}

	public List<PageEditareaT> findAllPageEditareaT(int currentPage, int lineSize, String creatorid) {
		return this.getPageEditareaTDao().findAllPageEditareaT(currentPage, lineSize, creatorid);
	}

	public int countfindAllPageEditareaT(String creatorid) {
		return this.getPageEditareaTDao().countfindAllPageEditareaT(creatorid);
	}

	public int updatePageEditareaTBystate(String[] list, String state, String creatorid) {
		return this.getPageEditareaTDao().updatePageEditareaTBystate(list, state, creatorid);
	}

	public PageEditareaT findPageEditareaById(String pageeditareaid) {
		return this.getPageEditareaTDao().findPageEditareaById(pageeditareaid);
	}

	public List<PageEditareaT> findPageEditareaTByPageidandTypeidandState(String pageid, String typeid, String state) {
		return this.getPageEditareaTDao().findPageEditareaTByPageidandTypeidandState(pageid, typeid, state);
	}

	public List<PageEditareaT> findPageEditareaTBySign(String sign, String state, String creatorid) {
		return this.getPageEditareaTDao().findPageEditareaTBySign(sign, state, creatorid);
	}

	public List<PageEditareaT> findPageEditareaTByTid(String tid, String creatorid) {
		return this.getPageEditareaTDao().findPageEditareaTByTid(tid, creatorid);
	}

	public int delPageEditareaTBypageeditareaid(String[] strs, String state) {
		return this.getPageEditareaTDao().delPageEditareaTBypageeditareaid(strs, state);
	}

}
