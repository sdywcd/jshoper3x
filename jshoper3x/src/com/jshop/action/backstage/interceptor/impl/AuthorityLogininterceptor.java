package com.jshop.action.backstage.interceptor.impl;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.backstage.interceptor.UserRolemoduleInterecptor;
import com.jshop.action.backstage.user.UserTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.FunctionM;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@ParentPackage("jshop")
public class AuthorityLogininterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;
	public static final String COOKIE_REMEMBER_KEY = "cookieadminid";
	public static final String GOING_TO_URL_KEY = "going_to";
	public boolean authority;
	public boolean authorityflag;
	private UsertService usertService;
	private UserRolemoduleInterecptor userRolemoduleInterecptor;
	private UserTAction userTAction;
	
	public UserTAction getUserTAction() {
		return userTAction;
	}

	public void setUserTAction(UserTAction userTAction) {
		this.userTAction = userTAction;
	}

	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	public UserRolemoduleInterecptor getUserRolemoduleInterecptor() {
		return userRolemoduleInterecptor;
	}

	public void setUserRolemoduleInterecptor(UserRolemoduleInterecptor userRolemoduleInterecptor) {
		this.userRolemoduleInterecptor = userRolemoduleInterecptor;
	}


	public boolean isAuthority() {
		return authority;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response=(HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);
		Map session = actionContext.getSession();
		if ((session != null) && (session.get(StaticKey.BACK_USER_SESSION_KEY) != null)) {
			UserT admin = (UserT) ActionContext.getContext().getSession().get(StaticKey.BACK_USER_SESSION_KEY);
			//如果是超级管理员就不验证权限state=3表示超级管理员
			if(StaticKey.THREE.equals(admin.getState())){
				return invocation.invoke();
			}
			//获取post过来的url和actionname
			
			String actionname = invocation.getInvocationContext().getName();
			String referer = request.getHeader("Referer");
			String ref=referer.substring(referer.lastIndexOf("/"));
			String spref[]=StringUtils.split(ref, "?");
			
			//去读取内存中的权限信息和上下文在url和action上做判断
			List<FunctionM> userfunctionlist = (List<FunctionM>) ActionContext.getContext().getSession().get(StaticKey.USERROLEFUNCTION);
			if(!userfunctionlist.isEmpty()){
				for (Iterator<FunctionM> it = userfunctionlist.iterator(); it.hasNext();) {
					
					FunctionM fm = (FunctionM) it.next();
					if(fm!=null){
						if(StringUtils.isNotBlank(fm.getVisiturl())){
							if(spref[0].toString().equals(fm.getVisiturl())){
								return invocation.invoke();
							}
						}else{
							if(StringUtils.isNotBlank(fm.getVisitmethodname())){
								if(fm.getVisitmethodname().equals(actionname)){
									return invocation.invoke();
								}
							}
						}
					}
				}
			}
			//权限异常标记
			ActionContext.getContext().getSession().put(StaticKey.AUTHORITYEXCEPTION, StaticKey.ONE);
			return "authorityfalied";
		} else {
			return "adminloginfailed";
		}
		//setGoingToUrl(session,invocation);
	}

	//	private void setGoingToUrl(Map session,ActionInvocation invocation){
	//		String url="";
	//		String namespace=invocation.getProxy().getNamespace();
	//		if(StringUtils.isNotEmpty(namespace)&&!namespace.equals("/")){
	//			url=url+namespace;
	//		}
	//		String actionName=invocation.getProxy().getActionName();
	//		if(StringUtils.isNotEmpty(actionName)){
	//			url=url+"/"+actionName+".action";
	//		}
	//		session.put(GOING_TO_URL_KEY, url);
	//	}

}
