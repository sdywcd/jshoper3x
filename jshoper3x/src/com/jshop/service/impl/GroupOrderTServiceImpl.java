package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GroupOrderTDao;
import com.jshop.entity.GroupOrderT;
import com.jshop.service.GroupOrderTService;

@Service("groupOrderTService")
@Scope("prototype")
public class GroupOrderTServiceImpl extends BaseTServiceImpl<GroupOrderT>implements GroupOrderTService {
	@Resource
	private GroupOrderTDao groupOrderTDao;

	public GroupOrderTDao getGroupOrderTDao() {
		return groupOrderTDao;
	}

	public void setGroupOrderTDao(GroupOrderTDao groupOrderTDao) {
		this.groupOrderTDao = groupOrderTDao;
	}

	@Override
	public List<GroupOrderT> findAllGroupOrderT(int currentPage, int lineSize) {

		return this.getGroupOrderTDao().findAllGroupOrderT(currentPage, lineSize);
	}

	@Override
	public int countfindAllGroupOrderT() {

		return this.getGroupOrderTDao().countfindAllGroupOrderT();
	}

	@Override
	public List<GroupOrderT> sortAllGroupOrderT(int currentPage, int lineSize, String queryString) {

		return this.getGroupOrderTDao().sortAllGroupOrderT(currentPage, lineSize, queryString);
	}

	@Override
	public GroupOrderT findgroupOrderDetailByorderid(String orderid) {

		return this.getGroupOrderTDao().findgroupOrderDetailByorderid(orderid);
	}

	@Override
	public int updateGroupOrderPayShippingState(String orderid, String orderstate, String paystate, String shippingstate) {

		return this.getGroupOrderTDao().updateGroupOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
	}

	@Override
	public int updateExpressnumberByGroupOrderId(String orderid, String expressnumber) {

		return this.getGroupOrderTDao().updateExpressnumberByGroupOrderId(orderid, expressnumber);
	}

	@Override
	public int updateInvoicenumberByOrderId(String orderid, String invoicenumber, Date deliverytime) {

		return this.getGroupOrderTDao().updateInvoicenumberByOrderId(orderid, invoicenumber, deliverytime);
	}

}
