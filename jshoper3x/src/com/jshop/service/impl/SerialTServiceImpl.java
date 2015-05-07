package com.jshop.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.SerialTDao;
import com.jshop.entity.SerialT;
import com.jshop.service.SerialTService;

@Service("serialTService")
@Scope("prototype")
public class SerialTServiceImpl extends BaseTServiceImpl<SerialT>implements SerialTService {
	@Resource
	private SerialTDao serialTDao;

	public SerialT findBybaseid(String biz) {
		return this.serialTDao.findBybaseid(biz);
	}

	public int updateBybaseid(SerialT transientInstance) {
		return this.serialTDao.updateBybaseid(transientInstance);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public SerialT SerialTlastId(String serialkey) {
		SerialT st = this.serialTDao.findBybaseid(serialkey);
		if (st != null) {
			this.serialTDao.updateBybaseid(st);
		}
		return st;

	}

}
