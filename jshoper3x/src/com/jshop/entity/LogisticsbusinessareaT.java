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
	public String getLogbusareaid() {
		return this.logbusareaid;
	}

	public void setLogbusareaid(String logbusareaid) {
		this.logbusareaid = logbusareaid;
	}


	public String getCostway() {
		return this.costway;
	}

	public void setCostway(String costway) {
		this.costway = costway;
	}


	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


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


	public String getSendarea() {
		return this.sendarea;
	}

	public void setSendarea(String sendarea) {
		this.sendarea = sendarea;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}