package com.jshop.shiro;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.mall.backstage.authority.UserRoleMAction;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.FunctionM;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
/**
 * 系统权限基础
* @ClassName: BaseShiroRealm 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年4月9日 下午4:38:59 
*
 */
public class BaseShiroRealm extends AuthorizingRealm {
	public static final String SHIRO_USER= "shiroUser";
	@Resource
	private UsertService usertService;
	@Resource
	private UserRoleMAction userRoleMAction;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser susert=(ShiroUser) principals.fromRealm(getName()).iterator().next();
		String username=susert.getAccount();
		if(username!=null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			
			if(StaticKey.DEFAULTADMINNAME.equals(username)){
				
			}else{
				List<FunctionM> userrolelist = this.userRoleMAction
						.findUserRoleFunctionList(susert.getUserId());
				if(userrolelist!=null&&userrolelist.size()>0){
					List<String> urls=new LinkedList<String>();
					for(FunctionM fm:userrolelist){
						urls.add(fm.getVisitmethodname());
					}
					info.addStringPermissions(urls);
				}
				return info;
			}
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {
		LoginUsernamePasswordToken token=(LoginUsernamePasswordToken) authToken;
		String username=token.getUsername();
		if(StringUtils.isNotBlank(username)){
			Criterion criterion = Restrictions.and(Restrictions.eq("username", username));
			UserT user= this.usertService.findOneByCriteria(UserT.class, criterion);
			if(user!=null){
				Subject subject=SecurityUtils.getSubject();
				subject.getSession().setAttribute(SHIRO_USER, new ShiroUser(user.getUserid(), user.getUsername()));
				return new SimpleAuthenticationInfo(new ShiroUser(user.getUserid(), user.getUsername()),user.getPassword(),getName());
			}
		}
		return null;
	}


	/**
	 * 更新用户授权信息缓存.
	 */

	public void clearCachedAuthorizationInfo(String principal){
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
		principal, getName());
		clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 清除所有用户授权信息缓存.
	 */

	public void clearAllCachedAuthorizationInfo(){
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null)
		{
			for (Object key : cache.keys())
			{
				cache.remove(key);
			}
		}
	}
	
}
