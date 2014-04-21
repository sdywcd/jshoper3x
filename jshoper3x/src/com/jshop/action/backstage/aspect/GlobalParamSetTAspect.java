package com.jshop.action.backstage.aspect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.jshop.action.backstage.user.UserTAction;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GlobalParamM;
import com.opensymphony.xwork2.ActionContext;
/**
 * 系统配置信息
 * @author sdywcd
 *
 */
@Aspect
public class GlobalParamSetTAspect {
	/**
	 * 在后台登陆后读取jshoper配置信息
	 * @param joinPoint
	 * @throws IOException 
	 */
	@After("execution(String com.jshop.action.backstage.user.UserTAction.adminlogin())")
	public void afterAdminLogin(JoinPoint joinPoint) throws IOException{
		Map<String,Object> config=new HashMap<String, Object>();
		String filePath="";
		ActionContext ac=ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		filePath=sc.getRealPath("/")+"admin/jshoperconfig.properties";
		InputStream inputStream = new FileInputStream(filePath);
		Properties p = new Properties();
		p.load(inputStream);
		Enumeration en = p.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
            String value = p.getProperty (key);
            config.put(key, value);
        }
		ActionContext.getContext().getSession().remove(StaticKey.GLOBALPARAMS);
		ActionContext.getContext().getSession().put(StaticKey.GLOBALPARAMS, config);
	}
	
}
