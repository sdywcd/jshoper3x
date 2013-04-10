package com.jshop.action.backstage.tools;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jshop.action.backstage.template.FreeMarkervariable;
import com.opensymphony.xwork2.ActionContext;

public class BaseTools {
	/**
	 * 前台用户登录创建的session名称
	 */
	public static String USER_SESSION_KEY = "user";
	/**
	 * 后台用户登录创建的session名称
	 */
	public static String BACK_USER_SESSION_KEY = "admin";
	/**
	 * 后台用户登录创建的session用户名称
	 */
	public static String BACK_USER_NAME_SESSION_KEY = "username";
	/**
	 * 后台用户登录创建的session_key
	 */
	public static String BACK_SESSION_KEY = "sessionKey";

	/**
	 * 默认的用户ID，用于在没有登录的情况下生成静态页面，主要是在安装的时候使用
	 */
	public static String DEFAULTADMINID = "20100721001";
	/**
	 * 默认的用户名称，用于在没有登录的情况下生成静态页面，主要是在安装的时候使用
	 */
	public static String DEFAULTADMINNAME = "sasasa";

	/**
	 * 用户的可操作的方法权限
	 */
	public static String USERROLEFUNCTION = "userrolefunction";
	/**
	 * 所有定义的权限
	 */
	public static String ALLROLEFUNCTION = "allrolefunction";

	public static String KEYFORAUTHORITY = "keyforauthority";

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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(DEFAULTTIME);
			return date;
		} catch (ParseException e) {

		}
		return null;

	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date systemtime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = formatter.format(object);
		return time;
	}

	/**
	 *获取登录用户保存在session中的userid
	 * 
	 * @return
	 */
	public static String adminCreateId() {
		String adminid = (String) ActionContext.getContext().getSession()
				.get(BACK_USER_SESSION_KEY);
		if (!adminid.isEmpty()) {
			return adminid;
		}
		return DEFAULTADMINID;
	}
	/**
	 * 获取登录用户保存在session中的username
	 * 
	 * @return
	 */
	public static String adminCreatename(){
		String username=(String) ActionContext.getContext().getSession().get(BACK_USER_NAME_SESSION_KEY);
		if(!username.isEmpty()){
			return username;
		}
		return DEFAULTADMINNAME;
	}
	

	/**
	 * 获取默认的模板主题
	 * 
	 * @return
	 */
	public static String getApplicationthemesig() {
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
