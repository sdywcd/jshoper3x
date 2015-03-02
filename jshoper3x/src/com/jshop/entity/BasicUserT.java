package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the basic_user_t database table.
 * 
 */
@Entity
@Table(name="basic_user_t")
@NamedQuery(name="BasicUserT.findAll", query="SELECT b FROM BasicUserT b")
public class BasicUserT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String department;
	private String email;
	private String groupid;
	private String ip;
	private String istemp;
	private String password;
	private String rank;
	private Date registertime;
	private String teamid;
	private int type;
	private String uid;
	private Date updatetime;
	private String username;
	private String userstate;

	public BasicUserT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}


	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getIstemp() {
		return this.istemp;
	}

	public void setIstemp(String istemp) {
		this.istemp = istemp;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}


	public String getTeamid() {
		return this.teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserstate() {
		return this.userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

}