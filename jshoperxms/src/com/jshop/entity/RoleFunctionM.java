package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_function_m database table.
 * 
 */
@Entity
@Table(name="role_function_m")
@NamedQuery(name="RoleFunctionM.findAll", query="SELECT r FROM RoleFunctionM r")
public class RoleFunctionM implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String functionid;
	private String roleid;

	public RoleFunctionM() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(nullable=false, length=20)
	public String getFunctionid() {
		return this.functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}


	@Column(nullable=false, length=20)
	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}