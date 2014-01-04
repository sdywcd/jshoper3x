package com.jshop.action.backstage.aspect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.jshop.action.backstage.image.ImgTAction;
import com.jshop.action.backstage.tools.GlobalParam;
import com.jshop.action.backstage.tools.ImgCutTools;
import com.jshop.action.backstage.tools.StaticString;
import com.opensymphony.xwork2.ActionContext;
/**
 * 图片上传切片
 * @author sdywcd
 *
 */
@Aspect
public class ImgTAspect {
	/**
	 * 保存图片缩略图
	 * @param joinPoint
	 */
	@After("execution(String com.jshop.action.backstage.image.ImgTAction.ajaxFileUploads())")
	public void saveDifferentSizeImg(JoinPoint joinPoint){
		ImgTAction imgTAction=(ImgTAction) joinPoint.getThis();
		String needCutImgPath=imgTAction.getmNewImgPath();
		String targetSavePath=imgTAction.getTargetSavePath();
		String filePath="";
		Properties p=new Properties();
		ActionContext ac=ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		filePath=sc.getRealPath("/")+StaticString.SYSTEM_CONFIG_FILE;
		try {
			p.load(new FileInputStream(filePath));
			String isimagecompression=p.getProperty(GlobalParam.ISIMAGECOMPRESSION, "0");
			if(isimagecompression.equals(StaticString.ONE)){
				//只有当开启压缩时才执行压缩方法并保存缩略图
				int width=Integer.parseInt(p.getProperty(GlobalParam.THUMBNAILWIDTH, "0"));
				int height=Integer.parseInt(p.getProperty(GlobalParam.THUMBNAILHEIGHT,"0"));
				ImgCutTools.compressImages(needCutImgPath, targetSavePath, width, height);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
