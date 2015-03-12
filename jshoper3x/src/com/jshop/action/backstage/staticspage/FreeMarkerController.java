package com.jshop.action.backstage.staticspage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerController extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String logmsg;
	

	public String getLogmsg() {
		return logmsg;
	}


	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}


	/**
	 * 初始化模板引擎数据
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public void init(String ftl,String folder,String fileName,Map<String,Object> data,String relativePath) throws IOException, TemplateException{
		Writer out = null;
		try{
			Configuration configuration=new Configuration();
			configuration.setServletContextForTemplateLoading(ServletActionContext.getServletContext(), "/"+relativePath);
			configuration.setEncoding(Locale.getDefault(), "utf-8");
			Template template=configuration.getTemplate(ftl);
			template.setEncoding("utf-8");
			String path=ServletActionContext.getServletContext().getRealPath("/");
			File dir=new File(path+folder);
			if(!dir.exists()){
				dir.mkdirs();
			}
			File htmlFile=new File(path+folder+fileName);
			out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile),"utf-8"));
			template.process(data, out);
			
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}finally{
			
			out.flush();
			out.close();
		}
		
	}
	
	/**
	 * 初始化邮件模板引擎数据
	 * @param ftl
	 * @param data
	 * @param relativePath
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String init(String ftl,Map<String,Object>data,String relativePath) throws IOException, TemplateException{
		String htmlText="";
		Configuration configuration=new Configuration();
		configuration.setServletContextForTemplateLoading(ServletActionContext.getServletContext(), "/"+relativePath);
		configuration.setEncoding(Locale.getDefault(), "utf-8");
		Template template=configuration.getTemplate(ftl);
		template.setEncoding("utf-8");
		htmlText=FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
		return htmlText;
	}
	
	public void init(String ftl,Map<String,Object>root) throws TemplateException, IOException{
		Configuration configuration=new Configuration();
		configuration.setServletContextForTemplateLoading(ServletActionContext.getServletContext(), "/");
		configuration.setEncoding(Locale.CHINA, "UTF-8");
		
		Template template=configuration.getTemplate(ftl);	
		template.setEncoding("UTF-8");
		ActionContext ctx = ActionContext.getContext();       
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);  
		
		response.setContentType("text/html;charset="+template.getEncoding());
		Writer out=response.getWriter();
		template.process(root, out);
		out.flush();
		
	}
	

}
