package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.VirtualShippingAddressTDao;
import com.jshop.entity.VirtualShippingAddressT;
import com.jshop.service.VirtualShippingAddressTService;
@Service("virtualShippingAddressTService")
@Scope("prototype")
public class VirtualShippingAddressTServiceImpl extends BaseTServiceImpl<VirtualShippingAddressT>implements
		VirtualShippingAddressTService {
	@Resource
	private VirtualShippingAddressTDao virtualShippingAddressTDao;
	
	public VirtualShippingAddressTDao getVirtualShippingAddressTDao() {
		return virtualShippingAddressTDao;
	}

	public void setVirtualShippingAddressTDao(
			VirtualShippingAddressTDao virtualShippingAddressTDao) {
		this.virtualShippingAddressTDao = virtualShippingAddressTDao;
	}



	@Override
	public List<VirtualShippingAddressT> findVirtualShippingAddressTByIdAndState(
			String virtualshippingaddressid, String state) {
		return this.getVirtualShippingAddressTDao().findVirtualShippingAddressTByIdAndState(virtualshippingaddressid, state);
	}

	@Override
	public List<VirtualShippingAddressT> findVirtualShippingAddressTByStateAndOrderid(
			String state, String orderid) {
		return this.getVirtualShippingAddressTDao().findVirtualShippingAddressTByStateAndOrderid(state, orderid);
	}

	@Override
	public int updateVirtualShippingAddressTByorderandstate(String orderid,
			String state) {
		return this.getVirtualShippingAddressTDao().updateVirtualShippingAddressTByorderandstate(orderid, state);
	}

	@Override
	public VirtualShippingAddressT findVirtualShippingAddressTByOrderidandstate(
			String orderid, String state) {
		return this.getVirtualShippingAddressTDao().findVirtualShippingAddressTByOrderidandstate(orderid, state);
	}

	@Override
	public int delVirtualShippingAddressT(String[] strs) {
		return this.getVirtualShippingAddressTDao().delVirtualShippingAddressT(strs);
	}

	@Override
	public int updateVirtualShippingAddressT(VirtualShippingAddressT vsa) {
		return this.getVirtualShippingAddressTDao().updateVirtualShippingAddressT(vsa);
	}

	@Override
	public List<VirtualShippingAddressT> findAllVirtualShippingAddressT() {
		return this.getVirtualShippingAddressTDao().findAllVirtualShippingAddressT();
	}

}
