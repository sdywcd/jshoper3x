package com.jshop.action.app.vo;

import com.jshop.entity.MemberT;

public class RequestMemberTMsg {
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public MemberT getM() {
		return m;
	}
	public void setM(MemberT m) {
		this.m = m;
	}
	private String msg;
	private boolean sucflag;
	private MemberT m;
	
	
}
