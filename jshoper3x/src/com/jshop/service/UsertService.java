package com.jshop.service;

import java.util.List;

import com.jshop.entity.UserT;

public interface UsertService {

	/**
	 * 用户注册
	 * @param transientInstance
	 */
	public abstract int save(UserT transientInstance);
	
	/**
	 * 用户登录
	 * @param transientInstance
	 * @return
	 */
	public abstract UserT login(UserT transientInstance);

	/**
	 * 删除用户
	 * @param transientInstance
	 * @return
	 */
	public abstract int delete(UserT transientInstance);

	/**
	 * 根据用户ID获取用户信息
	 * @param id
	 * @return
	 */
	public abstract UserT findById(String id);
	/**
	 * 查询所有用户包括管理员
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<UserT>findAllUsert(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有用户包括管理员
	 * @return
	 */
	public abstract int countfindAllUsert();
	/**
	 * 检测用户是否已经注册（用户名）
	 * @param transientInstance
	 * @return
	 */
	public abstract UserT checkUserByUsername(UserT transientInstance);
	/**
	 * 更新用户信息，不更新密码和涉及到保密的用户资料
	 * @param u
	 * @return
	 */
	public abstract int updateUserTunpwd(UserT u);
	/**
	 * 批量删除用户管理员操作
	 * @param list
	 * @return
	 */
	public abstract int delUser(String []list);
	/**
	 * 用户自己更新
	 * @return
	 */
	public abstract int updateUserforMyInfo(UserT u);
	/**
	 * 根据用户名称获取用户信息
	 */
	public abstract UserT findByUserName(String name);
	
	/**
	 * 修改管理员密码时检测账号密码是否正确
	 * 
	 */
	public abstract UserT usert(UserT user);
	/**
	 * 修改管理员密码
	 * 
	 */
	public abstract  int updateUserMember(UserT user);
	/**
	 * 更新用户状态，激活用户
	 * @param user
	 */
	public abstract int updateUserstate(UserT user);
	/**
	 * 通过uid获取用户数据
	 * @param uid
	 * @return
	 */
	public abstract UserT finduserByuid(String uid);
	/**
	 * 根据排序方式排序所有
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<UserT>sortAllUsert(final int currentPage,final int lineSize,String queryString);
	
	/**
	 * 查询所有email
	 * @param eamil
	 * @return
	 */
	public String[] findEmailByUser();
	/**
	 *  根据email检查用户信息
	 * @param u
	 * @return
	 */
	public abstract UserT checkUserByEmail(UserT u);
	/**
	 * 核对密码保护
	 * @param username
	 * @param question
	 * @param anwser
	 * @return
	 */
	public abstract UserT checkUserByAnswer(String username,String question,String answer);
	
	/**
	 * 设置用户密码保护
	 * @param userid
	 * @param question
	 * @param answer
	 * @return
	 */
	public abstract int updateUserPasswordProtection(String userid,String question,String answer);
	
	/**
	 * 管理员赋值管理用户权限标记
	 * @param userid
	 * @param rolemid
	 * @param rolemname
	 * @return
	 */
	public abstract int updateUserRoleMByuserid(String userid,String rolemid,String rolemname);
	/**
	 * 上传用户的头像的路径
	 * @param userid
	 * @param headpath
	 * @return
	 */
	public abstract int updateUserHeadPathByUserId(UserT user);
	
	
}
