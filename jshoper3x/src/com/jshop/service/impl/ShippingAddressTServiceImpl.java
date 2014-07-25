package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ShippingAddressTDao;
import com.jshop.dao.impl.ShippingAddressTDaoImpl;
import com.jshop.entity.ShippingAddressT;
import com.jshop.service.ShippingAddressTService;

@Service("shippingAddressTService")
@Scope("prototype")
public class ShippingAddressTServiceImpl extends BaseTServiceImpl<ShippingAddressT>implements ShippingAddressTService {
	@Resource
	private ShippingAddressTDao shippingAddressTDao;

	public ShippingAddressTDao getShippingAddressTDao() {
		return shippingAddressTDao;
	}

	public void setShippingAddressTDao(ShippingAddressTDao shippingAddressTDao) {
		this.shippingAddressTDao = shippingAddressTDao;
	}



	public List<ShippingAddressT> findShippingAddressByDeliveraddressidAndstate(String deliveraddressid, String state, String orderid) {
		return this.getShippingAddressTDao().findShippingAddressByDeliveraddressidAndstate(deliveraddressid, state, orderid);
	}

	public List<ShippingAddressT> findShippingAddressByIdAndState(String shippingaddressid, String state) {
		return this.getShippingAddressTDao().findShippingAddressByIdAndState(shippingaddressid, state);
	}

	public int updateShippingAddressByorderandstate(String orderid, String state) {
		return this.getShippingAddressTDao().updateShippingAddressByorderandstate(orderid, state);
	}

	public ShippingAddressT findShippingAddressByOrderid(String orderid, String state) {
		return this.getShippingAddressTDao().findShippingAddressByOrderid(orderid, state);
	}

	@Override
	public List<ShippingAddressT> findShippingAddressByOrderId(String orderid) {
		return this.getShippingAddressTDao().findShippingAddressByOrderId(orderid);
	}
}
