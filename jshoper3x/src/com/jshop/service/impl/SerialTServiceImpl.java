package com.jshop.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.SerialTDao;
import com.jshop.entity.SerialT;
import com.jshop.service.SerialTService;

@Service("serialTService")
@Scope("prototype")
public class SerialTServiceImpl extends BaseTServiceImpl<SerialT>implements SerialTService {
	@Resource
	private SerialTDao serialTDao;

	public SerialTDao getSerialTDao() {
		return serialTDao;
	}

	public void setSerialTDao(SerialTDao serialTDao) {
		this.serialTDao = serialTDao;
	}

	public SerialT findBybaseid(String biz) {
		return this.getSerialTDao().findBybaseid(biz);
	}

	public void save(SerialT transientInstance) {
		this.getSerialTDao().save(transientInstance);
	}

	public int updateBybaseid(SerialT transientInstance) {
		return this.getSerialTDao().updateBybaseid(transientInstance);
	}

	@Override
	public SerialT SerialTlastId(String serialkey) {
		SerialT st = this.getSerialTDao().findBybaseid(serialkey);
		if (st != null) {
			this.getSerialTDao().updateBybaseid(st);
		}
		return st;

	}

}
