package com.jshop.action.backstage.utils.enums;

import com.jshop.action.backstage.utils.statickey.StaticKey.DataGrade;

/**
 * 用户账号类型枚举
 * @author sdywcd
 *
 */
public class UserEnum {
	/**
	 * 用户账号类型
	 * @author sdywcd
	 *
	 */
	public enum UserType{
		NORMAL("普通用户","1"),SHOPMANAGER("店铺管理员","2"),SUPERMANAGER("超级管理员","3");
		
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private UserType(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(DataGrade d:DataGrade.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 用户状态
	 * @author sdywcd
	 *
	 */
	public enum UserState{
		ACTIVE("激活","1"),UNACTIVE("未激活","0"),LOCK("锁定","2");
		
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private UserState(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(DataGrade d:DataGrade.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
}
