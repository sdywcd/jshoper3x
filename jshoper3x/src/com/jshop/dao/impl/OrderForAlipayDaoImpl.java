package com.jshop.dao.impl;

import java.sql.SQLException;

import com.jshop.action.backstage.utils.DBConnection;
import com.jshop.dao.OrderForAlipayDao;

public class OrderForAlipayDaoImpl extends DBConnection implements OrderForAlipayDao {

	public int updateOrderPaystateByorderid(final String orderid, final String paystate) {
		int i = 0;
		final String queryString = "update order_t as o set o.paystate='" + paystate + "' where o.orderid='" + orderid + "'";
		this.openConn(false);
		try {
			this.stmt = conn.createStatement();
			i = this.stmt.executeUpdate(queryString);
			//this.rs.close();
			this.stmt.close();
		} catch (SQLException e) {
		}
		this.closeConn();
		return i;
	}

	public int updateOrderShippingstateByorderid(final String orderid, final String shippingstate) {
		int i = 0;
		final String queryString = "update order_t as o set o.shippingstate='" + shippingstate + "' where o.orderid='" + orderid + "'";
		this.openConn(false);
		try {
			this.stmt = conn.createStatement();
			i = this.stmt.executeUpdate(queryString);
			//this.rs.close();
			this.stmt.close();
		} catch (SQLException e) {
		}
		this.closeConn();
		return i;
	}

	public int updateOrderStateByorderid(final String orderid, final String orderstate) {
		int i = 0;
		final String queryString = "update order_t as o set o.orderstate='" + orderstate + "' where o.orderid='" + orderid + "'";
		this.openConn(false);
		try {
			this.stmt = conn.createStatement();
			i = this.stmt.executeUpdate(queryString);
			//this.rs.close();
			this.stmt.close();
		} catch (SQLException e) {
		}
		this.closeConn();
		return i;
	}

	public int callBackToChangeOrderTradeNo(final String tradeno, final String orderid) {
		int i = 0;
		final String queryString = "update order_t as o set o.TRADE_NO='" + tradeno + "' where o.orderid='" + orderid + "'";
		this.openConn(false);
		try {
			this.stmt = conn.createStatement();
			i = this.stmt.executeUpdate(queryString);
			//this.rs.close();
			this.stmt.close();
		} catch (SQLException e) {
		}
		this.closeConn();
		return i;
	}
}
