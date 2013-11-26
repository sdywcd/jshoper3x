package com.jshop.action.backstage.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.user.UserTAction;
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
	 */
	@After("execution(String com.jshop.action.backstage.user.UserTAction.adminlogin())")
	public void afterAdminLogin(JoinPoint joinPoint){
		UserTAction userTAction=(UserTAction) joinPoint.getThis();
		List<GlobalParamM>list=userTAction.getGlobalParamService().findAllGlobalParam();
		if(!list.isEmpty()){
			ActionContext.getContext().getSession().put(StaticString.GLOBALPARAMS, list);
		}
	}
	
}
