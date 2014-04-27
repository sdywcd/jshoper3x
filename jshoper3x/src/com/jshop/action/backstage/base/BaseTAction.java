package com.jshop.action.backstage.base;

import org.apache.struts2.json.annotations.JSON;

import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionSupport;

public class BaseTAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Serial serial;
	private String query;//text
	private String qtype;//select
	private String sortname;//排序字段
	private String sortorder;//排序方式
	/**
	 * action 返回类型
	 */
	public final static String JSON="json";

	
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
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

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	
	
}
