package com.jshop.action.frontstage.order;


import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderInvoiceT;
import com.jshop.entity.UserT;
import com.jshop.service.OrderInvoiceTService;
import com.jshop.service.OrderTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class OrderInvoiceAction extends ActionSupport {
	private OrderInvoiceTService orderInvoiceTService;
	private Serial serial;
	private OrderTService orderTService;
	private String orderInvoiceid;
	private String orderid;
	private String invType;
	private String invPayee;
	private String amount;
	private String userid;
	private String state;
	private String username;
	private String invContent;
	private Date createtime;
	
	private boolean slogin;
	private boolean saddflag;
	@JSON(serialize = false)
	public OrderInvoiceTService getOrderInvoiceTService() {
		return orderInvoiceTService;
	}
	public void setOrderInvoiceTService(OrderInvoiceTService orderInvoiceTService) {
		this.orderInvoiceTService = orderInvoiceTService;
	}
	@JSON(serialize = false)
	public OrderTService getOrderTService() {
		return orderTService;
	}
	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public boolean isSaddflag() {
		return saddflag;
	}
	public void setSaddflag(boolean saddflag) {
		this.saddflag = saddflag;
	}

	/**
	 *清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	
	/**
	 *增加订单发票
	 * @return
	 */
	@Action(value = "addOrderInvoice", results = { 
			@Result(name = "json",type="json")
	})
	public String addOrderInvoice(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			OrderInvoiceT oi=new OrderInvoiceT();
			oi.setOrderInvoiceid(this.getSerial().Serialid(Serial.ORDERINVOICE));
			oi.setOrderid(this.getOrderid().trim());
			oi.setInvType(this.getInvType());
			oi.setInvPayee(this.getInvPayee().trim());
			oi.setAmount(this.getAmount());
			oi.setMemberid(memberT.getId());
			oi.setMembername(memberT.getLoginname());
			oi.setState("0");
			oi.setInvContent(this.getInvContent());
			oi.setCreatetime(BaseTools.systemtime());
			this.getOrderInvoiceTService().save(oi);
				UpdateInvoiceByOrderId(this.getOrderid().trim(),"1");
				this.setSaddflag(true);
				return "json";
			
		}
		return "json";
	}
	
	/**
	 * 更新订单是否要开票标记
	 */
	private void UpdateInvoiceByOrderId(String orderid,String invoice){
		@SuppressWarnings("unused")
		int i=this.getOrderTService().updateInvoiceByOrderId(orderid, invoice);
	}
	
	
	
}
