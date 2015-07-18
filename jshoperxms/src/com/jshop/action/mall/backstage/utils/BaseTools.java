package com.jshop.action.mall.backstage.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jshop.action.mall.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.JshopbasicInfoT;
//import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.UserT;
import com.opensymphony.xwork2.ActionContext;

public class BaseTools {
	
	private static final Logger log = LoggerFactory.getLogger(BaseTools.class);

	
	/**
	 * 设置日期格式
	 * 
	 * @return
	 */
	public static String tagdate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(StaticKey.DF_YYYMMDD);
		String time = formatter.format(cal.getTime()).toString();
		return time;
	}

	public static Date defaulttime() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(StaticKey.DF_YYYY_MM_DD_HH_MM_SS,Locale.CHINA);
			Date date = sdf.parse(StaticKey.DEFAULTTIME);
			return date;
		} catch (ParseException e) {
			log.debug(BaseTools.class.getName() + "has thrown an exception: "
					+ e.getMessage());
		}
		return null;

	}
	/**
	 * 转换用户填写的发货时间
	 * @param memberdelivertime
	 * @return
	 */
	public static Date getMemberDeliverTime(String memberdelivertime){
		
		SimpleDateFormat formatter = new SimpleDateFormat(StaticKey.DF_YYYY_MM_DD,Locale.CHINA);
		Date date = null;
		try {
			date = formatter.parse(memberdelivertime);
		} catch (ParseException e) {
			log.debug(BaseTools.class.getName() + "has thrown an exception: "
					+ e.getMessage());
		}
		return date;
	}
	
	/**
	 * 获取系统时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getSystemTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(StaticKey.DF_YYYY_MM_DD_HH_MM_SS,Locale.CHINA);
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
		SimpleDateFormat formatter = new SimpleDateFormat(StaticKey.DF_YYYY_MM_DD_HH_MM_SS,Locale.CHINA);
		String dateString = formatter.format(object);
		return dateString;
	}
	
	public static Date string2Time(String dateString) throws java.text.ParseException {

		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(StaticKey.DF_FF_MM_DD, Locale.CHINA);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);
		Date dateTime = new Date(timeDate.getTime());
		return dateTime;
	}
	
	/**
	 * 格式化日期
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date formatString2DataYYYMMDDHHMMSS(String str) throws ParseException{
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(StaticKey.DF_YYYY_MM_DD_HH_MM_SS, Locale.CHINA);
		dateFormat.setLenient(false);
		String strs=StringUtils.replaceChars(str, "/", "-");
		Date timeDate = dateFormat.parse(strs);
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
		return StaticKey.DEFAULTADMINID;
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
		return StaticKey.DEFAULTADMINNAME;
	}
	
	/**
	 * 获取店铺ID
	 * @return
	 */
	public static String getShopId(){
		UserT userT = (UserT) ActionContext.getContext().getSession()
				.get(StaticKey.BACK_USER_SESSION_KEY);
		if (userT!=null) {
			return userT.getShopid();
		}
		return StaticKey.DEFAULTSHOPID;
	}
	/**
	 * 获取店铺名称
	 * @return
	 */
	public static String getShopName(){
		UserT userT = (UserT) ActionContext.getContext().getSession()
				.get(StaticKey.BACK_USER_SESSION_KEY);
		if (userT!=null) {
			return userT.getShopname();
		}
		return StaticKey.DEFAULTSHOPNAME;
	}

	/**
	 * 获取店铺信息
	 * @return
	 */
	public static JshopbasicInfoT getShopInfo(){
		JshopbasicInfoT jT = (JshopbasicInfoT) ActionContext.getContext().getSession()
				.get(StaticKey.BASIC_SHOP_INFO);
		if (jT!=null) {
			return jT;
		}
		return null;
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
		return StaticKey.DEFAULT_THEME;
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
