package com.jshop.action.backstage.aspect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.jshop.action.backstage.image.ImgTAction;
import com.jshop.action.backstage.utils.ImgCutTools;
import com.jshop.action.backstage.utils.statickey.GlobalParam;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.opensymphony.xwork2.ActionContext;
/**
 * 图片上传切片
 * @author sdywcd
 *
 */
@Aspect
public class ImgTAspect {
	
	private static String[]imgExts=new String[]{"jpeg","jpg","gif","png"};
	/**
	 * 保存图片缩略图
	 * @param joinPoint
	 */
	@After("execution(String com.jshop.action.backstage.image.ImgTAction.ajaxFileUploads())")
	public void saveDifferentSizeImg(JoinPoint joinPoint){
		boolean doCut=false;
		ImgTAction imgTAction=(ImgTAction) joinPoint.getThis();
		String extName=imgTAction.getExtName();
		for(int i=0;i<imgExts.length;i++){
			if(extName.equalsIgnoreCase(imgExts[i])){
				doCut=true;
				break;
			}
		}
		if(doCut){
			String needCutImgPath=imgTAction.getmNewImgPath();
			String targetSavePath=imgTAction.getTargetSavePath();
			String filePath="";
			Properties p=new Properties();
			ActionContext ac=ActionContext.getContext();
			ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
			filePath=sc.getRealPath("/")+StaticKey.SYSTEM_CONFIG_FILE;
			try {
				p.load(new FileInputStream(filePath));
				String isimagecompression=p.getProperty(GlobalParam.ISIMAGECOMPRESSION, "0");
				if(isimagecompression.equals(StaticKey.ONE)){
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
	
}
