package com.jshop.action.backstage.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.OrderInvoiceT;
import com.jshop.service.OrderInvoiceTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class OrderInvoiceTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private OrderInvoiceTService orderInvoiceTService;
	private String orderInvoiceid;
	private String orderid;
	private String invType;
	private String invPayee;
	private String amount;
	private String userid;
	private String state;
	private String username;
	private String invContent;
	private String query;
	private String qtype;
	private List<OrderInvoiceT> orderinvoice = new ArrayList<OrderInvoiceT>();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	@JSON(serialize = false)
	public OrderInvoiceTService getOrderInvoiceTService() {
		return orderInvoiceTService;
	}

	public void setOrderInvoiceTService(OrderInvoiceTService orderInvoiceTService) {
		this.orderInvoiceTService = orderInvoiceTService;
	}

	public String getOrderInvoiceid() {
		return orderInvoiceid;
	}

	public void setOrderInvoiceid(String orderInvoiceid) {
		this.orderInvoiceid = orderInvoiceid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public String getInvPayee() {
		return invPayee;
	}

	public void setInvPayee(String invPayee) {
		this.invPayee = invPayee;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInvContent() {
		return invContent;
	}

	public void setInvContent(String invContent) {
		this.invContent = invContent;
	}

	public List<OrderInvoiceT> getOrderinvoice() {
		return orderinvoice;
	}

	public void setOrderinvoice(List<OrderInvoiceT> orderinvoice) {
		this.orderinvoice = orderinvoice;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 查询所有订单发票
	 * 
	 * @return
	 */
	@Action(value="findAllOrderIvoice",results={
			@Result(name="json",type="json")
	})
	public String findAllOrderIvoice() {
		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultAllOrderInvoice();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void finddefaultAllOrderInvoice() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getOrderInvoiceTService().countfindAllOrderIvoice();
		List<OrderInvoiceT> list = this.getOrderInvoiceTService().findAllOrderIvoice(currentPage, lineSize);
		if (list != null) {
			this.ProcessOrderInvoice(list);
		}
	}

	public void ProcessOrderInvoice(List<OrderInvoiceT> list) {
		rows.clear();
		for (Iterator<OrderInvoiceT> it = list.iterator(); it.hasNext();) {
			OrderInvoiceT oi = (OrderInvoiceT) it.next();
			if (oi.getInvType().equals("1")) {
				oi.setInvType("个人");
			}
			if (oi.getInvType().equals("2")) {
				oi.setInvType("公司");
			}
			if (oi.getState().equals("1")) {
				oi.setState("开");
			}
			if (oi.getState().equals("0")) {
				oi.setState("未开");
			}

			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", oi.getOrderInvoiceid());
			cellMap.put("cell", new Object[] {
					oi.getOrderid(), 
					oi.getInvType(), 
					oi.getInvPayee(), 
					oi.getInvContent(), 
					oi.getAmount(), 
					oi.getState(), 
					oi.getMembername(), 
					BaseTools.formateDbDate(oi.getCreatetime()) 
					});
			rows.add(cellMap);
		}
	}

	/**
	 * 删除订单发票
	 * 
	 * @return
	 */
	@Action(value="DelOrderInvoice",results={
			@Result(name="json",type="json")
	})
	public String DelOrderInvoice() {
		if (Validate.StrNotNull(this.getOrderInvoiceid())) {
			String[] strs = this.getOrderInvoiceid().trim().split(",");
			@SuppressWarnings("unused")
			int i = this.getOrderInvoiceTService().delOrderInvoice(strs);
			return "json";
		}
		return "json";
	}

	/**
	 * 更新是否已经开过发票
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderInvoiceState",results={
			@Result(name="json",type="json")
	})
	public String UpdateOrderInvoiceState() {
		if (Validate.StrNotNull(this.getOrderInvoiceid())) {
			String[] strs = this.getOrderInvoiceid().trim().split(",");
			int i = this.getOrderInvoiceTService().updateOrderInvoiceState(strs, this.getState());
			return "json";
		}
		return "json";
	}
}
