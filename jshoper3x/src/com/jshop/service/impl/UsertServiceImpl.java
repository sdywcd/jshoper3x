package com.jshop.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.UserTDao;
import com.jshop.entity.RoleFunctionM;
import com.jshop.entity.UserRoleM;
import com.jshop.entity.UserT;
import com.jshop.service.RoleFunctionMService;
import com.jshop.service.UserRoleMService;
import com.jshop.service.UsertService;

@Service("usertService")
@Scope("prototype")
public class UsertServiceImpl extends BaseTServiceImpl<UserT>implements UsertService {
	@Resource
	private UserTDao userTDao;
	private UserRoleMService userRoleMService;
	private RoleFunctionMService roleFunctionMService;
	public UserTDao getUserTDao() {
		return userTDao;
	}

	public void setUserTDao(UserTDao userTDao) {
		this.userTDao = userTDao;
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

	public UserT findById(String id) {
		return this.getUserTDao().findById(id);
	}

	public UserT login(UserT transientInstance) {
	
		return this.getUserTDao().login(transientInstance);
	}

	public List<UserT> findAllUsert(int currentPage, int lineSize) {
		return this.getUserTDao().findAllUsert(currentPage, lineSize);
	}

	public int countfindAllUsert() {
		return this.getUserTDao().countfindAllUsert();
	}

	public UserT checkUserByUsername(UserT transientInstance) {
		return this.getUserTDao().checkUserByUsername(transientInstance);
	}

	public int updateUserTunpwd(UserT u) {
		return this.getUserTDao().updateUserTunpwd(u);
	}

	public int delUser(String[] list) {
		return this.getUserTDao().delUser(list);
	}

	public int updateUserforMyInfo(UserT u) {
		return this.getUserTDao().updateUserforMyInfo(u);
	}

	public UserT checkUserByEmail(UserT u) {
		return this.getUserTDao().checkUserByEmail(u);
	}

	public UserT findByUserName(String name) {
		return this.getUserTDao().findByUserName(name);
	}

	public int updateUserMember(UserT user) {
		return this.getUserTDao().updateUserMember(user);
	}

	public UserT usert(UserT user) {
		return this.getUserTDao().usert(user);
	}

	public int updateUserstate(UserT user) {
		return this.getUserTDao().updateUserstate(user);
	}

	public UserT finduserByuid(String uid) {
		return this.getUserTDao().finduserByuid(uid);
	}

	public List<UserT> sortAllUsert(int currentPage, int lineSize, String queryString) {

		return this.getUserTDao().sortAllUsert(currentPage, lineSize, queryString);
	}

	public String[] findEmailByUser() {

		return this.getUserTDao().findEmailByUser();
	}

	public UserT checkUserByAnswer(String username, String question, String answer) {

		return this.getUserTDao().checkUserByAnswer(username, question, answer);

	}

	public int updateUserPasswordProtection(String userid, String question, String answer) {
		return this.getUserTDao().updateUserPasswordProtection(userid, question, answer);
	}

	@Override
	public int updateUserRoleMByuserid(String userid, String rolemid,
			String rolemname) {
		return this.getUserTDao().updateUserRoleMByuserid(userid, rolemid, rolemname);
	}

	@Override
	public int updateUserHeadPathByUserId(UserT user) {
		
		return this.getUserTDao().updateUserHeadPathByUserId(user);
	}

	@Override
	public void updateUserT(UserT usert) {
		this.getUserTDao().updateUserT(usert);
		
	}

	@Override
	public Set<String> findUserRoleFunctions(String userid) {
		List<UserRoleM>umlist=this.getUserRoleMService().findUserRoleMByuserid(userid);
		List<RoleFunctionM>list=null;
		Set<String>functions=new HashSet<String>();
		for(Iterator<UserRoleM> it=umlist.iterator();it.hasNext();){
			UserRoleM urm=it.next();
			list=this.getRoleFunctionMService().findAllRoleFunctionMByroleid(urm.getRoleid());
			for(Iterator<RoleFunctionM> itt=list.iterator();itt.hasNext();){
				RoleFunctionM rfm=itt.next();
				functions.add(rfm.getFunctionid());
			}
		}
		return functions;
	}

	@Override
	public Set<String> findUserRole(String userid) {
		List<UserRoleM>umlist=this.getUserRoleMService().findUserRoleMByuserid(userid);
		Set<String>userRoles=new HashSet<String>();
		for(Iterator<UserRoleM> it=umlist.iterator();it.hasNext();){
			UserRoleM rom=(UserRoleM)it.next();
			userRoles.add(rom.getRoleid());
		}
		return userRoles;
	}

}
