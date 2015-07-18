package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the order_invoice_t database table.
 * 
 */
@Entity
@Table(name="order_invoice_t")
@NamedQuery(name="OrderInvoiceT.findAll", query="SELECT o FROM OrderInvoiceT o")
public class OrderInvoiceT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderInvoiceid;
	private String amount;
	private Date createtime;
	private String invContent;
	private String invPayee;
	private String invType;
	private String memberid;
	private String membername;
	private String orderid;
	private String shopid;
	private String shopname;
	private String state;
	private Date updatetime;
	private int versiont;

	public OrderInvoiceT() {
	}


	@Id
	@Column(name="ORDER_INVOICEID", unique=true, nullable=false, length=20)
	public String getOrderInvoiceid() {
		return this.orderInvoiceid;
	}

	public void setOrderInvoiceid(String orderInvoiceid) {
		this.orderInvoiceid = orderInvoiceid;
	}


	@Column(nullable=false, length=20)
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(name="INV_CONTENT", length=45)
	public String getInvContent() {
		return this.invContent;
	}

	public void setInvContent(String invContent) {
		this.invContent = invContent;
	}


	@Column(name="INV_PAYEE", nullable=false, length=45)
	public String getInvPayee() {
		return this.invPayee;
	}

	public void setInvPayee(String invPayee) {
		this.invPayee = invPayee;
	}


	@Column(name="INV_TYPE", nullable=false, length=10)
	public String getInvType() {
		return this.invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}


	@Column(nullable=false, length=20)
	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	@Column(nullable=false, length=50)
	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}


	@Column(nullable=false, length=20)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}