package com.jshop.action.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.entity.JshopbasicInfoT;
import com.jshop.service.JshopbasicInfoTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class AndroidJshopbasicInfoAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	private HttpServletRequest request;
    private HttpServletResponse response;
    private List<JshopbasicInfoT> beanlist=new ArrayList<JshopbasicInfoT>();
	private int rp;
	private int page=1;
	private int total=0;
	private String jsonstr;
    private boolean sucflag;
    @JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}
	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	public List<JshopbasicInfoT> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<JshopbasicInfoT> beanlist) {
		this.beanlist = beanlist;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;

	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 查询所有商城数据
	 * @return
	 * @throws IOException
	 */
	@Action(value="findAllJshopbasicInfoLogoforAndroid")
	public void  findAllJshopbasicInfoLogoforAndroid() throws IOException{
		int currentPage=page;
		int lineSize=12;
		String state="1";
		String url="http://192.168.1.105/Uploads/";//这个地址以后需要在后台设置出来
		beanlist=this.getJshopbasicInfoTService().findAllJshopbasicInfoNoParam(currentPage, lineSize, state);
		if(beanlist!=null){
			StringBuilder json=new StringBuilder();
			json.append("[");
			for(Iterator it=beanlist.iterator();it.hasNext();){
				JshopbasicInfoT jbi=(JshopbasicInfoT)it.next();
				String []strs=jbi.getSitelogo().split(",");
				jbi.setSitelogo(url+strs[0]);
				json.append("{");
				json.append("\"sitelogo\":\"").append(jbi.getSitelogo()).append("\",");
				json.append("\"creatorid\":\"").append(jbi.getCreatorid()).append("\"");
				json.append("},");
			}
			json.deleteCharAt(json.length()-1);
			json.append("]");
			this.setJsonstr(json.toString());
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.write(this.getJsonstr());
			out.flush();
			out.close();
		}
	}
	
    
    
}
