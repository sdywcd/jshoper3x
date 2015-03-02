package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the keyword_t database table.
 * 
 */
@Entity
@Table(name="keyword_t")
@NamedQuery(name="KeywordT.findAll", query="SELECT k FROM KeywordT k")
public class KeywordT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String keywordid;
	private Date createtime;
	private String creatorid;
	private String keywordname;
	private int searchCount;
	private int sort;
	private String state;
	private String type;

	public KeywordT() {
	}


	@Id
	public String getKeywordid() {
		return this.keywordid;
	}

	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	public String getKeywordname() {
		return this.keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}


	@Column(name="SEARCH_COUNT")
	public int getSearchCount() {
		return this.searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}