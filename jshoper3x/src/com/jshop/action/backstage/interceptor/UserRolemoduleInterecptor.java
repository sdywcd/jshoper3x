package com.jshop.action.backstage.interceptor;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.service.FunctionMService;
import com.jshop.service.RoleFunctionMService;
import com.jshop.service.UserRoleMService;
@ParentPackage("jshop")
public class UserRolemoduleInterecptor {
	private FunctionMService functionMService;
	private UserRoleMService userRoleMService;
	private RoleFunctionMService roleFunctionMService;
	public FunctionMService getFunctionMService() {
		return functionMService;
	}
	public void setFunctionMService(FunctionMService functionMService) {
		this.functionMService = functionMService;
	}
	public UserRoleMService getUserRoleMService() {
		return userRoleMService;
	}
	public void setUserRoleMService(UserRoleMService userRoleMService) {
		this.userRoleMService = userRoleMService;
	}
	
	public RoleFunctionMService getRoleFunctionMService() {
		return roleFunctionMService;
	}
	public void setRoleFunctionMService(RoleFunctionMService roleFunctionMService) {
		this.roleFunctionMService = roleFunctionMService;
	}

	
	
	
	
}
