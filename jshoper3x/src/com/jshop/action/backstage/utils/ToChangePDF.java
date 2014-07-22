package com.jshop.action.backstage.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.jshop.entity.ArticleT;
import com.jshop.service.ArticleTService;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class ToChangePDF {
	private String articleid;
	private ArticleT articlet = new ArticleT();
	private ArticleTService articleTService;
	
	
	
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
	/**
	 * 生成文章PDF文件
	 * @return
	 * @throws Exception
	 */
	@Action(value="PDF", results = { @Result(name = "json", type = "json")})
	public  String PDF() throws Exception{		
		Document d = new Document();
		try {
			articlet=this.getArticleTService().findArticleByarticleid(this.getArticleid());
			String path=ServletActionContext.getServletContext().getRealPath("");//获取根目录
			String savePath=isexistdir();
			savePath=savePath+path;
			String savePDF= savePath+articlet.getTitle();
			PdfWriter.getInstance(d, new FileOutputStream(savePDF+".PDF"));
			BaseFont bf = BaseFont.createFont( "c:\\windows\\fonts\\simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			d.addAuthor("作者-alextao");
			d.open();
			d.add(new Paragraph(articlet.getContentvalue(),new Font(bf)));
			d.close();
		} catch (Exception e) {
			throw e;
		} 
		return "json";
		
	}
	/**
	 * 检测目录是否存在
	 * 
	 * @return
	 */

	public static String isexistdir() {
		String nowTimeStr = "";
		String savedir = "/PDF/";
		String realpath = "";
		SimpleDateFormat sDateFormat;
		sDateFormat = new SimpleDateFormat("yyyyMMdd");
		nowTimeStr = sDateFormat.format(new Date());
		String savePath = ServletActionContext.getServletContext().getRealPath("");
		savePath = savePath + savedir + nowTimeStr + "/";
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
			realpath = savedir + nowTimeStr + "/";
			return realpath;
		} else {
			realpath = savedir + nowTimeStr + "/";
			return realpath;
		}
	}

}
