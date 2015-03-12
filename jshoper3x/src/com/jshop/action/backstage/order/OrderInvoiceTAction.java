package com.jshop.action.backstage.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Order;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.enums.BaseEnums.InvState;
import com.jshop.action.backstage.utils.enums.BaseEnums.InvType;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.OrderInvoiceT;
import com.jshop.service.OrderInvoiceTService;
@Namespace("")
@ParentPackage("jshop")
public class OrderInvoiceTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
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
	private List<OrderInvoiceT> beanlist = new ArrayList<OrderInvoiceT>();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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



	public List<OrderInvoiceT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<OrderInvoiceT> beanlist) {
		this.beanlist = beanlist;
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
		if (StaticKey.SC.equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultAllOrderInvoice();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	public void finddefaultAllOrderInvoice() {
		int currentPage = page;
		int lineSize = rp;
		Order order=Order.desc("createtime");
		total = this.orderInvoiceTService.count(OrderInvoiceT.class).intValue();
		List<OrderInvoiceT> list = this.orderInvoiceTService.findByCriteriaByPage(OrderInvoiceT.class, order, currentPage, lineSize);
		this.processOrderInvoice(list);
		
	}

	public void processOrderInvoice(List<OrderInvoiceT> list) {
		rows.clear();
		for (Iterator<OrderInvoiceT> it = list.iterator(); it.hasNext();) {
			OrderInvoiceT oi = (OrderInvoiceT) it.next();
			oi.setInvType(InvType.getName(oi.getInvType()));
			oi.setState(InvState.getName(oi.getState()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", oi.getOrderInvoiceid());
			cellMap.put("cell", new Object[] {
					oi.getShopname(),
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
		if (StringUtils.isNotBlank(this.getOrderInvoiceid())) {
			String[] strs =StringUtils.split(this.getOrderInvoiceid(), StaticKey.SPLITDOT);
			for(String s:strs){
				OrderInvoiceT oi=this.orderInvoiceTService.findByPK(OrderInvoiceT.class,s);
				if(oi!=null){
					this.orderInvoiceTService.delete(oi);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
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
		if (StringUtils.isNotBlank(this.getOrderInvoiceid())) {
			String[] strs = StringUtils.split(this.getOrderInvoiceid(), StaticKey.SPLITDOT);
			for(String s:strs){
				OrderInvoiceT oi=this.orderInvoiceTService.findByPK(OrderInvoiceT.class, s);
				if(oi!=null){
					this.orderInvoiceTService.delete(oi);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}
}
