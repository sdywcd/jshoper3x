package com.jshop.dao;

import java.util.List;

import com.jshop.entity.UserT;

public interface UserTDao extends BaseTDao<UserT>{

	

	/**
	 * 用户登录
	 * 
	 * @param transientInstance
	 * @return
	 */
	public UserT login(UserT transientInstance);

	/**
	 * 根据用户名称获取用户信息
	 */
	public UserT findByUserName(String name);

	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public UserT findById(String id);

	/**
	 * 查询所有用户包括管理员
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<UserT> findAllUsert(final int currentPage, final int lineSize);

	/**
	 * 统计查询所有用户包括管理员
	 * 
	 * @return
	 */
	public int countfindAllUsert();

	/**
	 * 检测用户是否已经注册（用户名）
	 * 
	 * @param transientInstance
	 * @return
	 */
	public UserT checkUserByUsername(UserT transientInstance);

	/**
	 * 更新用户信息，不更新密码和涉及到保密的用户资料
	 * 
	 * @param u
	 * @return
	 */
	public int updateUserTunpwd(UserT u);

	/**
	 * 批量删除用户管理员操作
	 * 
	 * @param list
	 * @return
	 */
	public int delUser(String[] list);

	/**
	 * 用户自己更新
	 * 
	 * @return
	 */
	public int updateUserforMyInfo(UserT u);

	/**
	 * 修改管理员密码时检测账号密码是否正确
	 * 
	 */
	public UserT usert(UserT user);

	/**
	 * 修改管理员密码
	 * 
	 */
	public int updateUserMember(UserT user);

	/**
	 * 更新用户状态，激活用户
	 * 
	 * @param user
	 */
	public int updateUserstate(UserT user);

	/**
	 * 通过uid获取用户数据
	 * 
	 * @param uid
	 * @return
	 */
	public UserT finduserByuid(String uid);

	/**
	 * 根据排序方式排序所有
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public List<UserT> sortAllUsert(final int currentPage, final int lineSize,
			String queryString);

	/**
	 * 查询所有email
	 * 
	 * @param eamil
	 * @return
	 */
	public String[] findEmailByUser();

	/**
	 * 根据email检查用户信息
	 * 
	 * @param u
	 * @return
	 */
	public UserT checkUserByEmail(UserT u);

	/**
	 * 根据username,question,answer检查用户
	 * 
	 * @param username
	 * @param question
	 * @param answer
	 * @return
	 */
	public UserT checkUserByAnswer(String username, String question,
			String answer);

	/**
	 * 设置用户密码保护
	 * 
	 * @param username
	 * @param question
	 * @param answer
	 * @return
	 */
	public int updateUserPasswordProtection(String userid, String question,
			String answer);

	/**
	 * 管理员赋值管理用户权限标记
	 * 
	 * @param userid
	 * @param rolemid
	 * @param rolemname
	 * @return
	 */
	public int updateUserRoleMByuserid(String userid, String rolemid,
			String rolemname);

	/**
	 * 上传用户的头像路径
	 * 
	 * @param userid
	 * @param headpath
	 * @return
	 */
	public int updateUserHeadPathByUserId(UserT user);
	/**
	 * 更新系统用户
	 * @param usert
	 */
	public void updateUserT(UserT usert);
	
}
