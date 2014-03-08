package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.DeliverAddressTDao;
import com.jshop.entity.DeliverAddressT;
import com.jshop.service.DeliverAddressTService;
@Service("deliverAddressTService")
@Scope("prototype")
public class DeliverAddressTServiceImpl extends BaseTServiceImpl<DeliverAddressT> implements DeliverAddressTService {
	@Resource
	private DeliverAddressTDao deliverAddressTDao;
	
	public DeliverAddressTDao getDeliverAddressTDao() {
		return deliverAddressTDao;
	}

	public void setDeliverAddressTDao(DeliverAddressTDao deliverAddressTDao) {
		this.deliverAddressTDao = deliverAddressTDao;
	}

	public int delDeliverAddress(String[] list) {
		return this.getDeliverAddressTDao().delDeliverAddress(list);
	}

	public int updateDeliverAddress(DeliverAddressT d) {
		return this.getDeliverAddressTDao().updateDeliverAddress(d);
	}

	public List<DeliverAddressT> findAllDeliverAddress() {
		return this.getDeliverAddressTDao().findAllDeliverAddress();
	}

	public List<DeliverAddressT> findDeliverAddressBymemberid(String memberid) {
		return this.getDeliverAddressTDao().findDeliverAddressBymemberid(memberid);
	}

	public DeliverAddressT findDeliverAddressById(String addressid) {
		return this.getDeliverAddressTDao().findDeliverAddressById(addressid);
	}
}
