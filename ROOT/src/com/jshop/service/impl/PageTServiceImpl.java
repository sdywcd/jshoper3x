package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.PageTDao;
import com.jshop.entity.PageT;
import com.jshop.service.PageTService;

@Service("pageTService")
@Scope("prototype")
public class PageTServiceImpl implements PageTService {
	@Resource
	private PageTDao pageTDao;

	public PageTDao getPageTDao() {
		return pageTDao;
	}

	public void setPageTDao(PageTDao pageTDao) {
		this.pageTDao = pageTDao;
	}

	public int delPaget(String[] list) {
		return this.getPageTDao().delPaget(list);
	}

	public int updatePaget(PageT pt) {
		return this.getPageTDao().updatePaget(pt);
	}

	public int addPaget(PageT pt) {
		return this.getPageTDao().addPaget(pt);
	}

	public int countfindAllPaget() {
		return this.getPageTDao().countfindAllPaget();
	}

	public List<PageT> findAllPaget(int currentPage, int lineSize) {
		return this.getPageTDao().findAllPaget(currentPage, lineSize);
	}

	public PageT findPagetById(String pageid) {
		return this.getPageTDao().findPagetById(pageid);
	}

	public List<PageT> findAllPagetforPageEdit() {
		return this.getPageTDao().findAllPagetforPageEdit();
	}
}
