package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.SystemMailTDao;
import com.jshop.entity.SystemMailT;
import com.jshop.service.SystemMailTService;

@Service("systemMailTService")
@Scope("prototype")
public class SystemMailTServiceImpl extends BaseTServiceImpl<SystemMailT>implements SystemMailTService {
	@Resource
	private SystemMailTDao systemMailTDao;

	public SystemMailTDao getSystemMailTDao() {
		return systemMailTDao;
	}

	public void setSystemMailTDao(SystemMailTDao systemMailTDao) {
		this.systemMailTDao = systemMailTDao;
	}

	@Override
	public void updateSystemMail(SystemMailT sm) {
		this.getSystemMailTDao().updateSystemMail(sm);
	}

	@Override
	public List<SystemMailT> findAllSystemMail() {
		return this.getSystemMailTDao().findAllSystemMail();
	}

	@Override
	public SystemMailT findSysmailByid(String id) {
		return this.getSystemMailTDao().findSysmailByid(id);
	}

	@Override
	public int countfindAllSystemMail() {
		return this.getSystemMailTDao().countfindAllSystemMail();
	}

	@Override
	public int delSystemMail(String id) {
		return this.getSystemMailTDao().delSystemMail(id);
	}


}
