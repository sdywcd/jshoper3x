package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.TemplatesetTDao;
import com.jshop.dao.impl.TemplatesetTDaoImpl;
import com.jshop.entity.TemplatesetT;
import com.jshop.service.TemplatesetTService;
@Service("templatesetTService")
@Scope("prototype")
public class TemplatesetTServiceImpl extends BaseTServiceImpl<TemplatesetT>implements TemplatesetTService {
	@Resource
	private TemplatesetTDao templatesetTDao;

	public TemplatesetTDao getTemplatesetTDao() {
		return templatesetTDao;
	}

	public void setTemplatesetTDao(TemplatesetTDao templatesetTDao) {
		this.templatesetTDao = templatesetTDao;
	}



	public int countfindAllTemplatesetT(String creatorid) {
		return this.getTemplatesetTDao().countfindAllTemplatesetT(creatorid);
	}

	public int delTemplatesetT(String[] list) {
		return this.getTemplatesetTDao().delTemplatesetT(list);
	}

	public List<TemplatesetT> findAllTemplatesetT(int currentPage, int lineSize, String creatorid) {
		return this.getTemplatesetTDao().findAllTemplatesetT(currentPage, lineSize, creatorid);
	}

	public TemplatesetT findTemplatesetTBytsid(String tsid) {
		return this.getTemplatesetTDao().findTemplatesetTBytsid(tsid);
	}

	public int updateTemplatesetT(TemplatesetT tst) {
		return this.getTemplatesetTDao().updateTemplatesetT(tst);
	}

	public List<TemplatesetT> findAllTemplatesetWithNoParam(String creatorid) {
		return this.getTemplatesetTDao().findAllTemplatesetWithNoParam(creatorid);
	}

	public TemplatesetT findTemplatesetTBysystemcontent(String systemcontent, String creatorid) {
		return this.getTemplatesetTDao().findTemplatesetTBysystemcontent(systemcontent, creatorid);
	}

	public TemplatesetT findTemplatesetTBysign(String sign, String creatorid) {
		return this.getTemplatesetTDao().findTemplatesetTBysign(sign, creatorid);
	}

	public int updateTemplatesetBystatus(String themeid, String status) {
		return this.getTemplatesetTDao().updateTemplatesetBystatus(themeid, status);
	}

	public TemplatesetT findTemplatesetTBysign(String sign) {
		return this.getTemplatesetTDao().findTemplatesetTBysign(sign);
	}

	public List<TemplatesetT> findTemplatesetTBystatus(String status) {
		return this.getTemplatesetTDao().findTemplatesetTBystatus(status);
	}
	
	
	
}
