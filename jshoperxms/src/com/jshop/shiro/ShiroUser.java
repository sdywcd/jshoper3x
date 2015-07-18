package com.jshop.shiro;

import java.io.Serializable;

public class ShiroUser implements Serializable{

	private String userId;
	private String account;
	
	public ShiroUser(String userId,String account){
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
