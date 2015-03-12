package com.jshop.action.backstage.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.UserT;


/**
 * 密码加密工具
 * @author sdywcd
 *
 */
public class PasswordHelper {
	private RandomNumberGenerator rNumberGenerator=new SecureRandomNumberGenerator();
	private final int hashIterations=2;
	public void encrypPassword(UserT user){
		user.setSalt(rNumberGenerator.nextBytes().toHex());//随机加密盐
		user.setCredentialsalt(user.getUsername()+rNumberGenerator.nextBytes().toHex());//用户名+随机hash
		//uid 
		user.setUid(rNumberGenerator.nextBytes().toHex());
		String npwd=new SimpleHash(StaticKey.ALGORITHMNAME,user.getPassword(),ByteSource.Util.bytes(user.getCredentialsalt()),hashIterations).toHex();
		user.setPassword(npwd);
	}
}
