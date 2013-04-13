package com.jshop.test;

import com.jshop.action.backstage.tools.Validate;

public class dotest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=22.6325;
		String aa=String.valueOf(a);
		System.out.println(aa);
		System.out.println(Validate.StrNotNull(String.valueOf(a)));
	}

}
