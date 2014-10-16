package com.jshop.action.backstage.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.UserT;
import com.opensymphony.xwork2.ActionContext;

public class BaseTools {
	


	/**
	 * 默认的用户ID，用于在没有登录的情况下生成静态页面，主要是在安装的时候使用
	 */
	public static String DEFAULTADMINID = "20100721001";
	/**
	 * 默认的用户名称，用于在没有登录的情况下生成静态页面，主要是在安装的时候使用
	 */
	public static final String DEFAULTADMINNAME = "sasasa";
	/**
	 * 默认shopid=0 0表示官方平台发布
	 */
	public static final String DEFAULTSHOPID="0";
	/**
	 * 默认的店铺名称 
	 */
	public static final String DEFAULTSHOPNAME="";

	// 默认时间
	public static String DEFAULTTIME = "2010-06-25 12:48:21";
	
	//日期格式化yyyyMMdd
	public static final String DATEFORMATEYMD = "yyyyMMdd";
	
	//日期格式化yyyyMMddHHmmss
	public static final String DATEFORMATEYMDHMS = "yyyyMMddHHmmss";

	/**
	 * 设置日期格式
	 * 
	 * @return
	 */
	public static String tagdate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String time = formatter.format(cal.getTime()).toString();
		return time;
	}

	public static Date defaulttime() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
			Date date = sdf.parse(DEFAULTTIME);
			return date;
		} catch (ParseException e) {

		}
		return null;

	}
	/**
	 * 转换用户填写的发货时间
	 * @param memberdelivertime
	 * @return
	 */
	public static Date getMemberDeliverTime(String memberdelivertime){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		Date date = null;
		try {
			date = formatter.parse(memberdelivertime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取系统时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date systemtime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		String dateString = formatter.format(date);
		ParsePosition pos = new ParsePosition(0);
		Date currenttime = formatter.parse(dateString, pos);
		return currenttime;
	}

	/**
	 * 转换数据库日期格式
	 * 
	 * @param object
	 * @return
	 */
	public static String formateDbDate(Date object) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		String dateString = formatter.format(object);
		return dateString;
	}
	
	public static Date string2Time(String dateString) throws java.text.ParseException {

		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yy-MM-dd", Locale.CHINA);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);
		Date dateTime = new Date(timeDate.getTime());
		return dateTime;
	}

	/**
	 *获取登录用户保存在session中的userid
	 * 
	 * @return
	 */
	public static String getAdminCreateId() {
		UserT userT = (UserT) ActionContext.getContext().getSession()
				.get(StaticKey.BACK_USER_SESSION_KEY);
		if (userT!=null) {
			return userT.getUserid();
		}
		return DEFAULTADMINID;
	}
	/**
	 *获取登录用户保存在session中的username
	 * 
	 * @return
	 */
	public static String getAdminCreateName() {
		UserT userT = (UserT) ActionContext.getContext().getSession()
				.get(StaticKey.BACK_USER_SESSION_KEY);
		if (userT!=null) {
			return userT.getUsername();
		}
		return DEFAULTADMINNAME;
	}
	
	/**
	 * 获取店铺ID
	 * @return
	 */
	public static String getShopId(){
		JshopbasicInfoT jbi=(JshopbasicInfoT) ActionContext.getContext().getSession().get(StaticKey.BASIC_SHOP_INFO);
		if(jbi!=null){
			return jbi.getBasicinfoid();
		}
		return DEFAULTSHOPID;
	}
	/**
	 * 获取店铺名称
	 * @return
	 */
	public static String getShopName(){
		JshopbasicInfoT jbi=(JshopbasicInfoT) ActionContext.getContext().getSession().get(StaticKey.BASIC_SHOP_INFO);
		if(jbi!=null){
			return jbi.getJshopname();
		}
		return DEFAULTSHOPNAME;
	}

	/**
	 * 获取默认的模板主题
	 * 
	 * @return
	 */
	public static String getApplicationthemesign() {
		String defaultthemesign = (String) ActionContext.getContext()
				.getApplication().get(FreeMarkervariable.DEFAULTTHEMESIGN);
		if (defaultthemesign != null) {
			return defaultthemesign;
		}
		return "default";
	}
	
	
	/**
	 * 获取网站根目录
	 * 
	 * @return
	 */
	public static String getBasePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		return path;
	}

}
