package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.LogisticsBTDao;
import com.jshop.dao.impl.LogisticsBTDaoImpl;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.service.LogisticsBTService;

@Service("logisticsBTService")
@Scope("prototype")
public class LogisticsBTServiceImpl extends BaseTServiceImpl<LogisticsBusinessT>implements LogisticsBTService {
//	@Resource
//	private LogisticsBusinessTDao logisticsBusinessTDao;
//
//	public LogisticsBusinessTDao getLogisticsBusinessTDao() {
//		return logisticsBusinessTDao;
//	}
//
//	public void setLogisticsBusinessTDao(LogisticsBusinessTDao logisticsBusinessTDao) {
//		this.logisticsBusinessTDao = logisticsBusinessTDao;
//	}
//
//	public int delLogisticsBusiness(String[] list) {
//		return this.getLogisticsBusinessTDao().delLogisticsBusiness(list);
//	}
//
//	public int updateLogisticsBusiness(LogisticsBusinessT lb) {
//		return this.getLogisticsBusinessTDao().updateLogisticsBusiness(lb);
//	}
//
//
//	public int countfindAllLogisticsBusiness() {
//		return this.getLogisticsBusinessTDao().countfindAllLogisticsBusiness();
//	}
//
//	public List<LogisticsBusinessT> findAllLogisticsBusiness(int currentPage, int lineSize) {
//		return this.getLogisticsBusinessTDao().findAllLogisticsBusiness(currentPage, lineSize);
//	}
//
//	public LogisticsBusinessT findLogisticsBusinessById(String logisticsid) {
//		return this.getLogisticsBusinessTDao().findLogisticsBusinessById(logisticsid);
//	}
//
//	public List<LogisticsBusinessT> findAllLogisticsBusiness(String state) {
//		return this.getLogisticsBusinessTDao().findAllLogisticsBusiness(state);
//	}
//
//	public List<LogisticsBusinessT> findAllLogisticsBusinessTjson() {
//		return this.getLogisticsBusinessTDao().findAllLogisticsBusinessTjson();
//	}
//
//	@Override
//	public List<LogisticsBusinessT> findLogisticsBusiness(String visible) {
//		return this.getLogisticsBusinessTDao().findLogisticsBusiness(visible);
//	}
}
