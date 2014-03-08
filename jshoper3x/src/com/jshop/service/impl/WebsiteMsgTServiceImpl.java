package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.WebsiteMsgTDao;
import com.jshop.dao.impl.WebsiteMsgTDaoImpl;
import com.jshop.entity.WebsiteMsgT;
import com.jshop.service.WebsiteMsgTService;
@Service("websiteMsgTService")
@Scope("prototype")
public class WebsiteMsgTServiceImpl extends BaseTServiceImpl<WebsiteMsgT>implements WebsiteMsgTService {
	@Resource
	private WebsiteMsgTDao websiteMsgTDao;

	public WebsiteMsgTDao getWebsiteMsgTDao() {
		return websiteMsgTDao;
	}

	public void setWebsiteMsgTDao(WebsiteMsgTDao websiteMsgTDao) {
		this.websiteMsgTDao = websiteMsgTDao;
	}

	public int delWebsiteMsgT(String[] list) {
		return this.getWebsiteMsgTDao().delWebsiteMsgT(list);
	}

	

	public int countfindAllWebsiteMsgByFromUserid(String userid) {
		return this.getWebsiteMsgTDao().countfindAllWebsiteMsgByFromUserid(userid);
	}

	public int countfindAllWebsiteMsgByToUsername(String msgtousername) {
		return this.getWebsiteMsgTDao().countfindAllWebsiteMsgByToUsername(msgtousername);
	}

	public List<WebsiteMsgT> findAllWebsiteMsgByFromUserid(int currentPage, int lineSize, String userid) {
		return this.getWebsiteMsgTDao().findAllWebsiteMsgByFromUserid(currentPage, lineSize, userid);
	}

	public List<WebsiteMsgT> findAllWebsiteMsgByToUsername(int currentPage, int lineSize, String msgtousername) {
		return this.getWebsiteMsgTDao().findAllWebsiteMsgByToUsername(currentPage, lineSize, msgtousername);
	}

	public int updateWebsiteMsgstate(String[] list, String state) {
		return this.getWebsiteMsgTDao().updateWebsiteMsgstate(list, state);
	}

	@Override
	public int countfindAllWebsitemsgOfStateByToUsername(String msgtousername,
			String state) {
		
		return this.getWebsiteMsgTDao().countfindAllWebsitemsgOfStateByToUsername(msgtousername, state);
	}

	@Override
	public WebsiteMsgT findMsgtextById(String id) {
		
		return this.getWebsiteMsgTDao().findMsgtextById(id);
	}

}
