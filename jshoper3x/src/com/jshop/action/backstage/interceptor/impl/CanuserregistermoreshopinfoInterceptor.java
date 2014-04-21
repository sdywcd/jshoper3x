package com.jshop.action.backstage.interceptor.impl;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.backstage.interceptor.AuthorityInterceptor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@ParentPackage("jshop")
public class CanuserregistermoreshopinfoInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	public static final String MSG ="您还没有开通注册多个商城功能";
	private AuthorityInterceptor authorityInterceptor;
	
	public AuthorityInterceptor getAuthorityInterceptor() {
		return authorityInterceptor;
	}
	public void setAuthorityInterceptor(AuthorityInterceptor authorityInterceptor) {
		this.authorityInterceptor = authorityInterceptor;
	}
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ctx=ai.getInvocationContext();
		boolean flag=true;//this.getAuthorityinterceptor().canuserregistermoreshopinfoIntercept();
		if(flag){
			return ai.invoke();
		}else{
			ctx.getSession().put("msg", MSG);
			return "canuserregistermoreshopinfo";
		}
	}

}
