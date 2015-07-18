package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the questionnaire_t database table.
 * 
 */
@Entity
@Table(name="questionnaire_t")
@NamedQuery(name="QuestionnaireT.findAll", query="SELECT q FROM QuestionnaireT q")
public class QuestionnaireT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String qid;
	private String answer;
	private String choosetag;
	private Date createtime;
	private String creatorid;
	private String goodsid;
	private String inputtype;
	private String question;
	private String state;
	private int statistics;
	private String title;
	private int versiont;

	public QuestionnaireT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getQid() {
		return this.qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}


	@Column(nullable=false, length=255)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Column(nullable=false, length=10)
	public String getChoosetag() {
		return this.choosetag;
	}

	public void setChoosetag(String choosetag) {
		this.choosetag = choosetag;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(nullable=false, length=20)
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(nullable=false, length=45)
	public String getInputtype() {
		return this.inputtype;
	}

	public void setInputtype(String inputtype) {
		this.inputtype = inputtype;
	}


	@Column(nullable=false, length=255)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(nullable=false)
	public int getStatistics() {
		return this.statistics;
	}

	public void setStatistics(int statistics) {
		this.statistics = statistics;
	}


	@Column(nullable=false, length=255)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}