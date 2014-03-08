package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.TemplatethemeTDao;
import com.jshop.dao.impl.TemplatethemeTDaoImpl;
import com.jshop.entity.TemplatethemeT;
import com.jshop.service.TemplatethemeTService;
@Service("templatethemeTService")
@Scope("prototype")
public class TemplatethemeTServiceImpl extends BaseTServiceImpl<TemplatethemeT> implements TemplatethemeTService {
	@Resource
	private TemplatethemeTDao templatethemeTDao;

	public TemplatethemeTDao getTemplatethemeTDao() {
		return templatethemeTDao;
	}

	public void setTemplatethemeTDao(TemplatethemeTDao templatethemeTDao) {
		this.templatethemeTDao = templatethemeTDao;
	}

	public int checkTemplatethemeBythemenameandsign(String themename,String sign) {
		return this.getTemplatethemeTDao().checkTemplatethemeBythemenameandsign(themename,sign);
	}

	public int countfindAllTemplatetheme(String creatorid) {
		return this.getTemplatethemeTDao().countfindAllTemplatetheme(creatorid);
	}

	public int delTemplatetheme(String[] str) {
		return this.getTemplatethemeTDao().delTemplatetheme(str);
	}

	public List<TemplatethemeT> findAllTemplatetheme(int currentPage, int lineSize, String creatorid) {
		return this.getTemplatethemeTDao().findAllTemplatetheme(currentPage, lineSize, creatorid);
	}

	public List<TemplatethemeT> sortAllTemplatetheme(int currentPage, int lineSize, String creatorid, String queryString) {
		return this.getTemplatethemeTDao().sortAllTemplatetheme(currentPage, lineSize, creatorid, queryString);
	}


	public List<TemplatethemeT> findAllTemplatethemeWithNoParam(String creatorid) {
		return this.getTemplatethemeTDao().findAllTemplatethemeWithNoParam(creatorid);
	}

	public int updateTemplatethemestatus(String ttid, String status) {
		return this.getTemplatethemeTDao().updateTemplatethemestatus(ttid, status);
	}

	public int checkTemplatethemeBythemenameandsign(String themename, String sign, String ttid) {
		return this.getTemplatethemeTDao().checkTemplatethemeBythemenameandsign(themename, sign, ttid);
	}

	public int delTemplatetheme(String ttid) {
		return this.getTemplatethemeTDao().delTemplatetheme(ttid);
	}

	public TemplatethemeT findTemplatethemeBystatus(String status) {
		return this.getTemplatethemeTDao().findTemplatethemeBystatus(status);
	}

}
