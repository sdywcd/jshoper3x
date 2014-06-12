package com.jshop.action.backstage.utils;


import java.io.FileInputStream;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.ServletActionContext;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.entity.ArticleT;
import com.jshop.service.ArticleTService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@Action(value="download",results={@Result(name = "success", type = "stream", params = { "contentType",  
        "application/pdf", "inputName",  
        "inputStream", "contentDisposition",  
        "attachment;filename=${downloadFileName}", "bufferSize", "4096" })})
        
public class FileDownloadAction extends ActionSupport  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DOWNLOADPATH="PDF";
//	private String fileName;// 初始的通过param指定的文件名属性   
	private ArticleTService articleTService;
	private String articleid;
	private String contentvalue;
	private ArticleT bean = new ArticleT();
	private String fileName;
	public String getContentvalue() {
		return contentvalue;
	}

	public void setContentvalue(String contentvalue) {
		this.contentvalue = contentvalue;
	}

	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}

	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}

	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	 public void setFileName(String fileName) {   		  
	        this.fileName = fileName;   
	  
	}   
    public InputStream getInputStream() throws Exception { 
    	this.setArticleid("201205060069");
    	if(Validate.StrNotNull(this.getArticleid())){
    		bean=this.getArticleTService().findArticleByarticleid(this.getArticleid().trim());
        	fileName="201205060069.pdf";//文件名
            return new FileInputStream(ServletActionContext.getServletContext().getRealPath("")+"/PDF/"+fileName);
    	}
    	return null;
    }   
  
    public String execute() throws Exception {     	
  
        return SUCCESS;   
  
    }   
  
  
  
    /** 提供转换编码后的供下载用的文件名 */   
  
    public String getDownloadFileName() {   
  
        String downFileName = fileName;   
  
        try {   
  
            downFileName = new String(downFileName.getBytes(), "ISO8859-1");   
  
        } catch (UnsupportedEncodingException e) {   
  
            e.printStackTrace();   
  
        }   
  
        return downFileName;   
  
    }   

}
