package com.jshop.action.backstage.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jshop.action.backstage.aspect.ImgTAspect;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.opensymphony.xwork2.ActionContext;

/**
 * 读取jshoper系统配置文件
* @ClassName: ReadSysConfig 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年3月23日 下午1:03:28 
*
 */
public class ReadSysConfig {
	private static final Logger log = LoggerFactory.getLogger(ReadSysConfig.class);

	/**
	 * 读取jshoper系统配置文件信息
	 * @return
	 */
	public static Properties getJConfig(){
		String filePath = StaticKey.EMPTY;
		Properties p = new Properties();
		ActionContext ac = ActionContext.getContext();
		ServletContext sc = (ServletContext) ac
				.get(ServletActionContext.SERVLET_CONTEXT);
		filePath = sc.getRealPath("/") + StaticKey.SYSTEM_CONFIG_FILE;
		try {
			p.load(new FileInputStream(filePath));
		} catch (IOException e) {
			log.debug("IOException");
		}
		return p;
	}
}
