package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.LogisticsbusinessareaTDao;
import com.jshop.dao.impl.LogisticsbusinessareaTDaoImpl;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.service.LogisticsbusinessareaTService;

@Service("logisticsbusinessareaTService")
@Scope("prototype")
public class LogisticsbusinessareaTServiceImpl extends BaseTServiceImpl<LogisticsbusinessareaT>implements LogisticsbusinessareaTService {
	@Resource
	private LogisticsbusinessareaTDao logisticsbusinessareaTDao;

	public LogisticsbusinessareaTDao getLogisticsbusinessareaTDao() {
		return logisticsbusinessareaTDao;
	}

	public void setLogisticsbusinessareaTDao(LogisticsbusinessareaTDao logisticsbusinessareaTDao) {
		this.logisticsbusinessareaTDao = logisticsbusinessareaTDao;
	}


	public int countfindAllLogisticsbusinessareaT() {
		return this.getLogisticsbusinessareaTDao().countfindAllLogisticsbusinessareaT();
	}

	public int delLogisticsbusinessarea(String[] list) {
		return this.getLogisticsbusinessareaTDao().delLogisticsbusinessarea(list);
	}

	public List<LogisticsbusinessareaT> findAllLogisticsbusinessareaT(int currentPage, int lineSize) {
		return this.getLogisticsbusinessareaTDao().findAllLogisticsbusinessareaT(currentPage, lineSize);
	}

	public LogisticsbusinessareaT findLogisticsbusinessareaTById(String logbusareaid) {
		return this.getLogisticsbusinessareaTDao().findLogisticsbusinessareaTById(logbusareaid);
	}

	public int updateLogisticsbusinessarea(LogisticsbusinessareaT lba) {
		return this.getLogisticsbusinessareaTDao().updateLogisticsbusinessarea(lba);
	}

	public int updateLogisticsbusinessareaBystate(String[] list, String state) {
		return this.getLogisticsbusinessareaTDao().updateLogisticsbusinessareaBystate(list, state);
	}

	public List<LogisticsbusinessareaT> findAllLogisticsbusinessareaTBylogisticsid(String logisticsid) {
		return this.getLogisticsbusinessareaTDao().findAllLogisticsbusinessareaTBylogisticsid(logisticsid);
	}
}
