package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_role_m database table.
 * 
 */
@Entity
@Table(name="user_role_m")
@NamedQuery(name="UserRoleM.findAll", query="SELECT u FROM UserRoleM u")
public class UserRoleM implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String roleid;
	private String userid;

	public UserRoleM() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}


	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}