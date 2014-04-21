package com.jshop.action.backstage.utils;

import java.io.Serializable;

public class ServerFileInfo implements Serializable {

	private String directoryname;
	private String createtime;
	private int count;
	private int size;
	private String imgfilepath;
	private String modifytime;
	public String getDirectoryname() {
		return directoryname;
	}
	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	
	
	public String getImgfilepath() {
		return imgfilepath;
	}
	public void setImgfilepath(String imgfilepath) {
		this.imgfilepath = imgfilepath;
	}
	public ServerFileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServerFileInfo(String directoryname, String createtime, int count,
			int size, String imgfilepath, String modifytime) {
		super();
		this.directoryname = directoryname;
		this.createtime = createtime;
		this.count = count;
		this.size = size;
		this.imgfilepath = imgfilepath;
		this.modifytime = modifytime;
	}
	
	
	
	
}
