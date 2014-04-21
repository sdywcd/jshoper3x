package com.jshop.action.backstage.utils;

import java.io.File;

import org.apache.struts2.ServletActionContext;

public class ServerFileDel {

	private final static String FS=System.getProperty("file.separator");
	private final static String TOMACT_HOME=System.getProperty("catalina.home");
	private static String TEMP_PATH="";
	
	public static void Del(String PATH){
		String spath=ServletActionContext.getServletContext().getRealPath("");
		TEMP_PATH=spath+PATH.replace("\\", "//");
		File fileTemp=new File(TEMP_PATH);
		boolean flag=false;
		flag=fileTemp.exists();
		if(flag){
			if(true==fileTemp.isFile()){
				if(fileTemp.delete()){
				}
			}
		}
	}
}
