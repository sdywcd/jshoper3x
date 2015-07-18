package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the logisticsbusinessarea_t database table.
 * 
 */
@Entity
@Table(name="logisticsbusinessarea_t")
@NamedQuery(name="LogisticsbusinessareaT.findAll", query="SELECT l FROM LogisticsbusinessareaT l")
public class LogisticsbusinessareaT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String logbusareaid;
	private String costway;
	private String logisticsid;
	private String logisticsname;
	private double normalcost;
	private double normalvalue;
	private double overcost;
	private double overvalue;
	private String sendarea;
	private String state;

	public LogisticsbusinessareaT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getLogbusareaid() {
		return this.logbusareaid;
	}

	public void setLogbusareaid(String logbusareaid) {
		this.logbusareaid = logbusareaid;
	}


	@Column(length=1)
	public String getCostway() {
		return this.costway;
	}

	public void setCostway(String costway) {
		this.costway = costway;
	}


	@Column(nullable=false, length=20)
	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	@Column(length=45)
	public String getLogisticsname() {
		return this.logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}


	public double getNormalcost() {
		return this.normalcost;
	}

	public void setNormalcost(double normalcost) {
		this.normalcost = normalcost;
	}


	@Column(nullable=false)
	public double getNormalvalue() {
		return this.normalvalue;
	}

	public void setNormalvalue(double normalvalue) {
		this.normalvalue = normalvalue;
	}


	public double getOvercost() {
		return this.overcost;
	}

	public void setOvercost(double overcost) {
		this.overcost = overcost;
	}


	public double getOvervalue() {
		return this.overvalue;
	}

	public void setOvervalue(double overvalue) {
		this.overvalue = overvalue;
	}


	@Column(length=5000)
	public String getSendarea() {
		return this.sendarea;
	}

	public void setSendarea(String sendarea) {
		this.sendarea = sendarea;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}