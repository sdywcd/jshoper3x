package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.dao.RoleFunctionMDao;
import com.jshop.entity.RoleFunctionM;
import com.jshop.entity.RoleM;
import com.jshop.service.RoleFunctionMService;
@Service("roleFunctionMService")
@Scope("prototype")
public class RoleFunctionMServiceImpl implements RoleFunctionMService {

	private Serial serial;

	private RoleFunctionMDao roleFunctionMDao;
	
	public RoleFunctionMDao getRoleFunctionMDao() {
		return roleFunctionMDao;
	}
	public void setRoleFunctionMDao(RoleFunctionMDao roleFunctionMDao) {
		this.roleFunctionMDao = roleFunctionMDao;
	}
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public void addRoleFunctionM(RoleFunctionM rfm) {
		
		this.getRoleFunctionMDao().addRoleFunctionM(rfm);

	}
	
	/**
	 * 增加角色权限
	 * @param rm
	 */
	public void addRoleFunctionM(RoleM rm,String functionids){
		if(Validate.StrNotNull(functionids)){
			String []strs=StringUtils.split(functionids,",");
			RoleFunctionM rfm=new RoleFunctionM();
			for(String functionid :strs){
				rfm.setId(this.getSerial().Serialid(Serial.ROLEFUNCTION));
				rfm.setRoleid(rm.getId());
				rfm.setFunctionid(functionid);
				this.getRoleFunctionMDao().addRoleFunctionM(rfm);
			}
		}
	}
	public List<RoleFunctionM> findAllRoleFunctionMByroleid(String roleid) {
		return this.getRoleFunctionMDao().findAllRoleFunctionMByroleid(roleid);
	}
	public void delRoleFunctionM(String roleid) {
		this.getRoleFunctionMDao().delRoleFunctionM(roleid);
	}


	
}
