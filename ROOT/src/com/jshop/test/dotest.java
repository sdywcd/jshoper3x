package com.jshop.test;

import java.util.Scanner;

import com.jshop.action.backstage.tools.Validate;

public class dotest {
	private String age;
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		dotest dotest=new dotest();
		String a="1dfd2";
boolean b=Validate.isAge(a);
if(b==true){
	System.out.println(a);
}else{
	System.out.println("cuowu");
}

	}

}
