package com.jshop.action.backstage.android.elecart;

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
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.entity.CouponT;
import com.jshop.service.CouponTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class CouponTAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	@Resource
	private CouponTService couponTService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String cid;
	private String ctitle;
	private String cimage;
	private String endtime;
	private String locate;
	private String des;
	private String createtime;
	private String modifytime;
	private String begintime;
	private String creatorid;
	private String jsonstring;
	private List<CouponT> beanlist = new ArrayList<CouponT>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private boolean sucflag;
	@JSON(serialize = false)
	public CouponTService getCouponTService() {
		return couponTService;
	}

	public void setCouponTService(CouponTService couponTService) {
		this.couponTService = couponTService;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCimage() {
		return cimage;
	}

	public void setCimage(String cimage) {
		this.cimage = cimage;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public List<CouponT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<CouponT> beanlist) {
		this.beanlist = beanlist;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getJsonstring() {
		return jsonstring;
	}

	public void setJsonstring(String jsonstring) {
		this.jsonstring = jsonstring;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取所有优惠券信息
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action(value="findAllCoupon" ,results = { 
			@Result(name = "success" ,type="dispatcher")
	})
	public String findAllCoupon() throws IOException {
		int currentPage = page;
		int lineSize = 10;
		beanlist = this.getCouponTService().findAllCoupon(currentPage, lineSize);
		if (beanlist != null) {
			StringBuilder json = new StringBuilder();
			json.append("[");
			for (Iterator it = beanlist.iterator(); it.hasNext();) {
				CouponT c = (CouponT) it.next();
				json.append("{");
				json.append("cid:").append(c.getCid()).append(",");
				json.append("ctitle:\"").append(c.getCtitle()).append("\",");
				json.append("cimage:\"").append(c.getCimage()).append("\",");
				json.append("endtime:\"").append(c.getEndtime().toString()).append("\",");
				json.append("lat:\"").append(String.valueOf(c.getLat())).append("\",");
				json.append("lng\"").append(String.valueOf(c.getLng())).append("\",");
				json.append("zoom:\"").append(String.valueOf(c.getZoom())).append("\",");
				json.append("details:\"").append(c.getDetails().toString()).append("\",");
				json.append("createtime:\"").append(c.getCreatetime().toString()).append("\",");
				json.append("modifytime:\"").append(c.getModifytime().toString()).append("\",");
				json.append("begintime:\"").append(c.getBegintime().toString()).append("\",");
				json.append("creatorid:").append(c.getCreatorid());
				json.append("}").append(",");
			}
			json.deleteCharAt(json.length() - 1);
			json.append("]");
			this.setJsonstring(json.toString());
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(this.getJsonstring());
			out.flush();
			out.close();
			return SUCCESS;
		}
		this.setSucflag(false);
		return SUCCESS;
	}
}
