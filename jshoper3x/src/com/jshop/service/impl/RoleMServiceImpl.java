package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.RoleMDao;
import com.jshop.dao.impl.RoleMDaoImpl;
import com.jshop.entity.RoleM;
import com.jshop.service.RoleMService;

@Service("roleMService")
@Scope("prototype")
public class RoleMServiceImpl extends BaseTServiceImpl<RoleM>implements RoleMService {
	@Resource
	private RoleMDao roleMDao;

	public RoleMDao getRoleMDao() {
		return roleMDao;
	}

	public void setRoleMDao(RoleMDao roleMDao) {
		this.roleMDao = roleMDao;
	}

	public int delRoleM(String[] strs) {
		return this.getRoleMDao().delRoleM(strs);
	}

	public List<RoleM> findAllRoleM() {
		return this.getRoleMDao().findAllRoleM();
	}

	public RoleM findRoleMById(String id) {
		return this.getRoleMDao().findRoleMById(id);
	}

	public void updateRoleM(RoleM rm) {
		this.getRoleMDao().updateRoleM(rm);

	}

}
