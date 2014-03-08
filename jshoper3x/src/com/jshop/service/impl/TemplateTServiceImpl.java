package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.TemplateTDao;
import com.jshop.dao.impl.TemplateTDaoImpl;
import com.jshop.entity.TemplateT;
import com.jshop.service.TemplateTService;
@Service("templateTService")
@Scope("prototype")
public class TemplateTServiceImpl extends BaseTServiceImpl<TemplateT> implements TemplateTService {
	@Resource
	private TemplateTDao templateTDao;

	public TemplateTDao getTemplateTDao() {
		return templateTDao;
	}

	public void setTemplateTDao(TemplateTDao templateTDao) {
		this.templateTDao = templateTDao;
	}


	public int countfindAllTemplate(String creatorid) {
		return this.getTemplateTDao().countfindAllTemplate(creatorid);
	}

	public List<TemplateT> findAllTemplate(int currentPage, int lineSize, final String creatorid) {
		return this.getTemplateTDao().findAllTemplate(currentPage, lineSize, creatorid);
	}

	public int delTemplate(String[] list) {
		return this.getTemplateTDao().delTemplate(list);
	}

	
	public List<TemplateT> findAllTemplateWithNoParam(String creatorid,String status) {
		return this.getTemplateTDao().findAllTemplateWithNoParam(creatorid,status);
	}

	public int findTemplateBynameandnote(String creatorid, String note, String name) {
		return this.getTemplateTDao().findTemplateBynameandnote(creatorid, note, name);
	}

	public TemplateT findTemplateByname(String creatorid, String name) {
		return this.getTemplateTDao().findTemplateByname(creatorid, name);
	}

	public TemplateT findTemplateBytype(String type) {
		return this.getTemplateTDao().findTemplateBytype(type);
	}

	public TemplateT checkTemplatetheme(String themeid) {
		return this.getTemplateTDao().checkTemplatetheme(themeid);
	}

	public int updateTemplatetBystatus(String themeid, String status) {
		return this.getTemplateTDao().updateTemplatetBystatus(themeid, status);
	}

	public TemplateT findTemplateBysign(String sign, String status) {
		return this.getTemplateTDao().findTemplateBysign(sign, status);
	}

	@Override
	public List<TemplateT> findTemplateTByLikeName(int currentPage,
			int lineSize, String name) {
		
		return this.getTemplateTDao().findTemplateTByLikeName(currentPage, lineSize, name);
	}

	@Override
	public int countTemplateTBYLikeNmae(String name) {
		
		return this.getTemplateTDao().countTemplateTBYLikeNmae(name);
	}
	
}
