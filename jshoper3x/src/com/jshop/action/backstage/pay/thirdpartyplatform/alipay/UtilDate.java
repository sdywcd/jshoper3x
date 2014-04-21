package com.jshop.action.backstage.pay.thirdpartyplatform.alipay;

import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class UtilDate {
	public  static String getOrderNum(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}

	public  static String getDateFormatter(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}
	

	public static String getThree(){
		Random rad=new Random();
		return rad.nextInt(1000)+"";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilDate date=new UtilDate();
		System.out.println(date.getOrderNum());
	}
	
}
