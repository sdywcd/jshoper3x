package com.jshop.test;

import com.jshop.action.backstage.activity.EcouponTAction;
import com.jshop.action.backstage.tools.Validate;

public class testValidate {
	private  int age;
	private  String neme="";
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNeme() {
		return neme;
	}
	public void setNeme(String neme) {
		this.neme = neme;
	}
public   boolean dovalidate(){
	String name2="fsdf";
	if(Validate.StrNotNull(name2)==false){
		System.out.println("false");
		return false;
	}
		System.out.println("pass");
	System.out.println("true");
	return true;
}
public static void main(String[] args) {
	testValidate test=new testValidate();
	test.dovalidate();
}
	
}
