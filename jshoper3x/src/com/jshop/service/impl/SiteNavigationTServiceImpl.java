package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.SiteNavigationTDao;
import com.jshop.dao.impl.SiteNavigationTDaoImpl;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.SiteNavigationTService;

@Service("siteNavigationTService")
@Scope("prototype")
public class SiteNavigationTServiceImpl extends BaseTServiceImpl<SiteNavigationT> implements SiteNavigationTService {
	@Resource
	private SiteNavigationTDao siteNavigationTDao;

	public SiteNavigationTDao getSiteNavigationTDao() {
		return siteNavigationTDao;
	}

	public void setSiteNavigationTDao(SiteNavigationTDao siteNavigationTDao) {
		this.siteNavigationTDao = siteNavigationTDao;
	}


	public int countfindAllSiteNavigationT(String creatorid) {
		return this.getSiteNavigationTDao().countfindAllSiteNavigationT(creatorid);
	}

	public int delSiteNavigationT(String[] list) {
		return this.getSiteNavigationTDao().delSiteNavigationT(list);
	}

	public List<SiteNavigationT> findAllSiteNavigationT(int currentPage, int lineSize, String creatorid) {
		return this.getSiteNavigationTDao().findAllSiteNavigationT(currentPage, lineSize, creatorid);
	}

	public int updateSiteNavigationT(SiteNavigationT sn) {
		return this.getSiteNavigationTDao().updateSiteNavigationT(sn);
	}

	public SiteNavigationT findSiteNavigationBysnid(String snid) {
		return this.getSiteNavigationTDao().findSiteNavigationBysnid(snid);
	}

	public List<SiteNavigationT> findSiteNavigationByposition(String isVisible, String position, String creatorid) {
		return this.getSiteNavigationTDao().findSiteNavigationByposition(isVisible, position, creatorid);
	}

	public List<SiteNavigationT> findSiteNavigationByisVisible(String isVisible, String creatorid) {
		return this.getSiteNavigationTDao().findSiteNavigationByisVisible(isVisible, creatorid);
	}

	public List<SiteNavigationT> findSiteNavigationByisVisible(String isVisible) {
		return this.getSiteNavigationTDao().findSiteNavigationByisVisible(isVisible);
	}

	public List<SiteNavigationT> sortAllSiteNavigationT(int currentPage, int lineSize, String creatorid, String queryString) {

		return this.getSiteNavigationTDao().sortAllSiteNavigationT(currentPage, lineSize, creatorid, queryString);
	}
}
