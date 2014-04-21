package com.jshop.action.backstage.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	/**
	 * MD5加密工具类
	 * 
	 */

	/**
	 * 根据输入的字符串生成固定的32位MD5码
	 * 
	 * @param str
	 *            输入的字符串
	 * @return MD5码
	 */
	public final static String getMd5(String str) {
		MessageDigest mdInst = null;
		try {
			mdInst = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		mdInst.update(str.getBytes());// 使用指定的字节更新摘要
		byte[] md = mdInst.digest();// 获得密文
		return StrConvertUtil.byteArrToHexStr(md);
	}

}
