package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the global_param_m database table.
 * 
 */
@Entity
@Table(name="global_param_m")
@NamedQuery(name="GlobalParamM.findAll", query="SELECT g FROM GlobalParamM g")
public class GlobalParamM implements Serializable {
	private static final long serialVersionUID = 1L;
	private String gkey;
	private String gvalue;

	public GlobalParamM() {
	}


	@Id
	@Column(unique=true, nullable=false, length=45)
	public String getGkey() {
		return this.gkey;
	}

	public void setGkey(String gkey) {
		this.gkey = gkey;
	}


	@Column(nullable=false, length=500)
	public String getGvalue() {
		return this.gvalue;
	}

	public void setGvalue(String gvalue) {
		this.gvalue = gvalue;
	}

}