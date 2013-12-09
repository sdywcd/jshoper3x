package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.UserTDao;
import com.jshop.dao.impl.UserTDaoImpl;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;

@Service("usertService")
@Scope("prototype")
public class UsertServiceImpl implements UsertService {
	@Resource
	private UserTDao userTDao;

	public UserTDao getUserTDao() {
		return userTDao;
	}

	public void setUserTDao(UserTDao userTDao) {
		this.userTDao = userTDao;
	}

	public int delete(UserT transientInstance) {
		return this.getUserTDao().delete(transientInstance);
	}

	public UserT findById(String id) {
		return this.getUserTDao().findById(id);
	}

	public UserT login(UserT transientInstance) {
		return this.getUserTDao().login(transientInstance);
	}

	public int save(UserT transientInstance) {
		return this.getUserTDao().save(transientInstance);
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

}
