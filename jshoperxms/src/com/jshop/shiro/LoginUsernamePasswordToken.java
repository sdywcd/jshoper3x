package com.jshop.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class LoginUsernamePasswordToken extends UsernamePasswordToken {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public LoginUsernamePasswordToken(String username,String password){
		super(username,password);
		this.username=username;
		this.password=password;
	}

	public LoginUsernamePasswordToken()
	{
		super();
	}

}
