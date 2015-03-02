package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the invoice_printing_t database table.
 * 
 */
@Entity
@Table(name="invoice_printing_t")
@NamedQuery(name="InvoicePrintingT.findAll", query="SELECT i FROM InvoicePrintingT i")
public class InvoicePrintingT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String invoicePrintingId;
	private Date createPrintingTime;
	private String operatorname;
	private String orderid;

	public InvoicePrintingT() {
	}


	@Id
	@Column(name="INVOICE_PRINTING_ID")
	public String getInvoicePrintingId() {
		return this.invoicePrintingId;
	}

	public void setInvoicePrintingId(String invoicePrintingId) {
		this.invoicePrintingId = invoicePrintingId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_PRINTING_TIME")
	public Date getCreatePrintingTime() {
		return this.createPrintingTime;
	}

	public void setCreatePrintingTime(Date createPrintingTime) {
		this.createPrintingTime = createPrintingTime;
	}


	public String getOperatorname() {
		return this.operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}


	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

}