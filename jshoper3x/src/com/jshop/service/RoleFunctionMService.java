package com.jshop.service;

import com.jshop.entity.RoleFunctionM;
import com.jshop.entity.RoleM;

public interface RoleFunctionMService extends BaseTService<RoleFunctionM> {

	
	public void addRoleFunctionM(RoleM rm,String functionids);
}
