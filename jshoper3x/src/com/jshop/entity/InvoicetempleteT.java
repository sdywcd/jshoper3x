package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invoicetemplete_t database table.
 * 
 */
@Entity
@Table(name="invoicetemplete_t")
@NamedQuery(name="InvoicetempleteT.findAll", query="SELECT i FROM InvoicetempleteT i")
public class InvoicetempleteT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String invoicetempleteid;
	private String code;
	private String logisticsid;
	private String state;

	public InvoicetempleteT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getInvoicetempleteid() {
		return this.invoicetempleteid;
	}

	public void setInvoicetempleteid(String invoicetempleteid) {
		this.invoicetempleteid = invoicetempleteid;
	}


	@Lob
	@Column(nullable=false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Column(length=20)
	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}