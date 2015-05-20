package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the invoice_print_t database table.
 * 
 */
@Entity
@Table(name="invoice_print_t")
@NamedQuery(name="InvoicePrintT.findAll", query="SELECT i FROM InvoicePrintT i")
public class InvoicePrintT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String invoiceprintid;
	private String invoicenumber;
	private Date invoiceprinttime;
	private String logisticsid;
	private String logisticsnumber;
	private String name;
	private String operatorname;
	private String orderid;
	private String ordername;
	private String shippingaddressid;
	private String state;

	public InvoicePrintT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getInvoiceprintid() {
		return this.invoiceprintid;
	}

	public void setInvoiceprintid(String invoiceprintid) {
		this.invoiceprintid = invoiceprintid;
	}


	@Column(length=45)
	public String getInvoicenumber() {
		return this.invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getInvoiceprinttime() {
		return this.invoiceprinttime;
	}

	public void setInvoiceprinttime(Date invoiceprinttime) {
		this.invoiceprinttime = invoiceprinttime;
	}


	@Column(nullable=false, length=20)
	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	@Column(length=45)
	public String getLogisticsnumber() {
		return this.logisticsnumber;
	}

	public void setLogisticsnumber(String logisticsnumber) {
		this.logisticsnumber = logisticsnumber;
	}


	@Column(nullable=false, length=45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=45)
	public String getOperatorname() {
		return this.operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}


	@Column(nullable=false, length=20)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	@Column(nullable=false, length=1000)
	public String getOrdername() {
		return this.ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}


	@Column(nullable=false, length=20)
	public String getShippingaddressid() {
		return this.shippingaddressid;
	}

	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}