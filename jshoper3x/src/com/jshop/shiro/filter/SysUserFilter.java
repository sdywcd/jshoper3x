package com.jshop.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;

public class SysUserFilter extends PathMatchingFilter {

    private UsertService usertService;

    public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	@Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        ActionContext.getContext().getSession().put(StaticKey.BACK_USER_SESSION_KEY, usertService.findByUserName(username));
        return true;
    }
}
