package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.JshopbasicInfoTDao;
import com.jshop.dao.impl.JshopbasicInfoTDaoImpl;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.service.JshopbasicInfoTService;

@Service("jshopbasicInfoTService")
@Scope("prototype")
public class JshopbasicInfoTServiceImpl extends BaseTServiceImpl<JshopbasicInfoT> implements JshopbasicInfoTService {
	@Resource
	private JshopbasicInfoTDao jshopbasicInfoTDao;

	public JshopbasicInfoTDao getJshopbasicInfoTDao() {
		return jshopbasicInfoTDao;
	}

	public void setJshopbasicInfoTDao(JshopbasicInfoTDao jshopbasicInfoTDao) {
		this.jshopbasicInfoTDao = jshopbasicInfoTDao;
	}

	public int delJshopbasicInfo(String[] list, String creatorid) {
		return this.getJshopbasicInfoTDao().delJshopbasicInfo(list, creatorid);
	}

	public void updateJshopbasicInfo(JshopbasicInfoT jbit) {
		this.getJshopbasicInfoTDao().updateJshopbasicInfo(jbit);
	}

	public int countfindAllJshopbasicInfo(String creatorid) {
		return this.getJshopbasicInfoTDao().countfindAllJshopbasicInfo(creatorid);
	}

	public List<JshopbasicInfoT> findAllJshopbasicInfo(int currentPage, int lineSize, String creatorid) {
		return this.getJshopbasicInfoTDao().findAllJshopbasicInfo(currentPage, lineSize, creatorid);
	}

	public JshopbasicInfoT findJshopbasicInfoTById(String basicinfoid) {
		return this.getJshopbasicInfoTDao().findJshopbasicInfoTById(basicinfoid);
	}

	public int updateJshopbasicInfostate(String basicinfoid, String state) {
		return this.getJshopbasicInfoTDao().updateJshopbasicInfostate(basicinfoid, state);
	}

	public JshopbasicInfoT findJshopbasicInfoSingleForExpress(String creatorid) {
		return this.getJshopbasicInfoTDao().findJshopbasicInfoSingleForExpress(creatorid);
	}

	public List<JshopbasicInfoT> findJshopbasicInfoBycreatorid(String creatorid) {
		return this.getJshopbasicInfoTDao().findJshopbasicInfoBycreatorid(creatorid);
	}

	public List<JshopbasicInfoT> findAllJshopbasicInfoNoParam(int currentPage, int lineSize, String state) {
		return this.getJshopbasicInfoTDao().findAllJshopbasicInfoNoParam(currentPage, lineSize, state);
	}

	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(String creatorid, String state, String openstate) {
		return this.getJshopbasicInfoTDao().findJshopbasicInfoBystateandopstate(creatorid, state, openstate);
	}

	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(String state, String openstate) {
		return this.getJshopbasicInfoTDao().findJshopbasicInfoBystateandopstate(state, openstate);
	}

	@Override
	public JshopbasicInfoT findAllJshopbasicInfo(String creatorid) {
		return this.getJshopbasicInfoTDao().findAllJshopbasicInfo(creatorid);
	}
	
}
