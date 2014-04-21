package com.jshop.action.backstage.base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.ExpresstempleteT;
import com.jshop.service.ExpresstempleteTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")

public class ExpresstempleteTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private ExpresstempleteTService expresstempleteTService;
	public static final String SENDNAME = "sendname";
	public static final String SENDCOUNTRY = "sendcountry";
	public static final String SENDPROVINCE = "sendprovince";
	public static final String SENDCITY = "sendcity";
	public static final String SENDDISTRICT = "senddistrict";
	public static final String SENDSTREET = "sendstreet";
	public static final String SENDTELNO = "sendtelno";
	public static final String SENDMOBILE = "sendmobile";
	public static final String SENDCONTACTOR = "sendcontactor";
	public static final String RECIPIENTNAME = "recipientname";
	public static final String RECIPIENTCOUNTRY = "recipientcountry";
	public static final String RECIPIENTPROVINCE = "recipientprovince";
	public static final String RECIPIENTCITY = "recipientcity";
	public static final String RECIPIENTDISTRICT = "recipientdistrict";
	public static final String RECIPIENTSTREET = "recipientstreet";
	public static final String RECIPIENTTELNO = "recipienttelno";
	public static final String RECIPIENTMOBILE = "recipientmobile";
	public static final String RECIPIENTPOSTCODE = "recipientpostcode";
	public static final String RECIPIENTCONTACTOR = "recipientcontactor";
	public static final String YEAR = "year";
	public static final String MONTH = "month";
	public static final String DAY = "day";
	public static final String HOUR = "hour";
	public static final String MINUTES = "minutes";
	public static final String ORDERID = "orderid";
	public static final String NOTES = "notes";
	public static final String SENDTIME = "sendtime";
	public static final String RIGHTTAG = "righttag";
	public static final String QUANTITY = "quantity";
	private String expresstempleteid;
	private String sendName;
	private String sendCountry;
	private String sendProvince;
	private String sendCity;
	private String sendDistrict;
	private String sendStreet;
	private String sendTelno;
	private String sendMobile;
	private String recipientName;
	private String recipientCountry;
	private String recipientProvince;
	private String recipientCity;
	private String recipientDistrict;
	private String recipientStreet;
	private String recipientTelno;
	private String recipientMobile;
	private String recipientPostcode;
	private String year;
	private String month;
	private String day;
	private String orderid;
	private String notes;
	private String sendTime;
	private String rightTag;
	private String logisticsid;
	private String state;
	private String expressCss;
	private String expressImg;
	private String kindeditorCode;
	private List<Map<String, Object>>rows =new ArrayList<Map<String, Object>>();
	private ExpresstempleteT beanlist=new ExpresstempleteT();
	private int rp;
	private int page = 1;
	private int total = 0;
	@JSON(serialize = false)
	public ExpresstempleteTService getExpresstempleteTService() {
		return expresstempleteTService;
	}

	public void setExpresstempleteTService(ExpresstempleteTService expresstempleteTService) {
		this.expresstempleteTService = expresstempleteTService;
	}

	public String getExpresstempleteid() {
		return expresstempleteid;
	}

	public void setExpresstempleteid(String expresstempleteid) {
		this.expresstempleteid = expresstempleteid;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendCountry() {
		return sendCountry;
	}

	public void setSendCountry(String sendCountry) {
		this.sendCountry = sendCountry;
	}

	public String getSendProvince() {
		return sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}

	public String getSendCity() {
		return sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	public String getSendDistrict() {
		return sendDistrict;
	}

	public void setSendDistrict(String sendDistrict) {
		this.sendDistrict = sendDistrict;
	}

	public String getSendStreet() {
		return sendStreet;
	}

	public void setSendStreet(String sendStreet) {
		this.sendStreet = sendStreet;
	}

	public String getSendTelno() {
		return sendTelno;
	}

	public void setSendTelno(String sendTelno) {
		this.sendTelno = sendTelno;
	}

	public String getSendMobile() {
		return sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientCountry() {
		return recipientCountry;
	}

	public void setRecipientCountry(String recipientCountry) {
		this.recipientCountry = recipientCountry;
	}

	public String getRecipientProvince() {
		return recipientProvince;
	}

	public void setRecipientProvince(String recipientProvince) {
		this.recipientProvince = recipientProvince;
	}

	public String getRecipientCity() {
		return recipientCity;
	}

	public void setRecipientCity(String recipientCity) {
		this.recipientCity = recipientCity;
	}

	public String getRecipientDistrict() {
		return recipientDistrict;
	}

	public void setRecipientDistrict(String recipientDistrict) {
		this.recipientDistrict = recipientDistrict;
	}

	public String getRecipientStreet() {
		return recipientStreet;
	}

	public void setRecipientStreet(String recipientStreet) {
		this.recipientStreet = recipientStreet;
	}

	public String getRecipientTelno() {
		return recipientTelno;
	}

	public void setRecipientTelno(String recipientTelno) {
		this.recipientTelno = recipientTelno;
	}

	public String getRecipientMobile() {
		return recipientMobile;
	}

	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}

	public String getRecipientPostcode() {
		return recipientPostcode;
	}

	public void setRecipientPostcode(String recipientPostcode) {
		this.recipientPostcode = recipientPostcode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getRightTag() {
		return rightTag;
	}

	public void setRightTag(String rightTag) {
		this.rightTag = rightTag;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getExpressCss() {
		return expressCss;
	}

	public void setExpressCss(String expressCss) {
		this.expressCss = expressCss;
	}

	public String getExpressImg() {
		return expressImg;
	}

	public void setExpressImg(String expressImg) {
		this.expressImg = expressImg;
	}

	public String getKindeditorCode() {
		return kindeditorCode;
	}

	public void setKindeditorCode(String kindeditorCode) {
		this.kindeditorCode = kindeditorCode;
	}

	public List<Map<String,Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String,Object>> rows) {
		this.rows = rows;
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
	public ExpresstempleteT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(ExpresstempleteT beanlist) {
		this.beanlist = beanlist;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	
	/**
	 * 增加快递单模板
	 * 
	 * @return
	 */
	@Action(value = "addExpresstemplete", results = { 
			@Result(name = "success", type="redirect",location = "/jshop/admin/order/expresstempleteset.jsp?session=${param}"),
			@Result(name = "input", type="redirect",location = "/jshop/admin/order/expresstempleteset.jsp?session=${param}")
	})
	public String addExpresstemplete() {
			ExpresstempleteT et = new ExpresstempleteT();
			et.setExpresstempleteid(this.getSerial().Serialid(Serial.EXPRESSTEMPLATE));
			et.setSendName(ExpresstempleteTAction.SENDNAME);
			et.setSendCountry(ExpresstempleteTAction.SENDCOUNTRY);
			et.setSendProvince(ExpresstempleteTAction.SENDPROVINCE);
			et.setSendCity(ExpresstempleteTAction.SENDCITY);
			et.setSendDistrict(ExpresstempleteTAction.SENDDISTRICT);
			et.setSendStreet(ExpresstempleteTAction.SENDSTREET);
			et.setSendTelno(ExpresstempleteTAction.SENDTELNO);
			et.setSendMobile(ExpresstempleteTAction.SENDMOBILE);
			et.setSendContactor(ExpresstempleteTAction.SENDCONTACTOR);
			et.setRecipientName(ExpresstempleteTAction.RECIPIENTNAME);
			et.setRecipientCountry(ExpresstempleteTAction.RECIPIENTCOUNTRY);
			et.setRecipientProvince(ExpresstempleteTAction.RECIPIENTPROVINCE);
			et.setRecipientCity(ExpresstempleteTAction.RECIPIENTCITY);
			et.setRecipientDistrict(ExpresstempleteTAction.RECIPIENTDISTRICT);
			et.setRecipientStreet(ExpresstempleteTAction.RECIPIENTSTREET);
			et.setRecipientTelno(ExpresstempleteTAction.RECIPIENTTELNO);
			et.setRecipientMobile(ExpresstempleteTAction.RECIPIENTMOBILE);
			et.setRecipientPostcode(ExpresstempleteTAction.RECIPIENTPOSTCODE);
			et.setRecipientContactor(ExpresstempleteTAction.RECIPIENTCONTACTOR);
			et.setYear(ExpresstempleteTAction.YEAR);
			et.setMonth(ExpresstempleteTAction.MONTH);
			et.setDay(ExpresstempleteTAction.DAY);
			et.setHour(ExpresstempleteTAction.HOUR);
			et.setMinutes(ExpresstempleteTAction.MINUTES);
			et.setOrderid(ExpresstempleteTAction.ORDERID);
			et.setNotes(ExpresstempleteTAction.NOTES);
			et.setSendTime(ExpresstempleteTAction.SENDTIME);
			et.setRightTag(ExpresstempleteTAction.RIGHTTAG);
			et.setLogisticsid(this.getLogisticsid().trim());
			et.setQuantity(ExpresstempleteTAction.QUANTITY);
			et.setState("1");
			et.setExpressCss(null);
			et.setExpressImg(null);
			et.setKindeditorCode(this.getKindeditorCode());
			this.getExpresstempleteTService().save(et);
			return SUCCESS;
			
	}

	/**
	 * 获取所有快递单模板
	 * 
	 * @return
	 */
	@Action(value = "findAllExpresstempleteT", results = { 
			@Result(name = "json",type="json")
	})
	public String findAllExpresstempleteT() {
		int currentPage = page;
		int lineSize = rp;
		List<ExpresstempleteT> list = this.getExpresstempleteTService().findAllExpresstempleteT(currentPage, lineSize);
		if (list != null) {
			total = this.getExpresstempleteTService().countfindAllExpresstempleteT();
			rows.clear();
			for (Iterator<ExpresstempleteT> it = list.iterator(); it.hasNext();) {
				ExpresstempleteT et = (ExpresstempleteT) it.next();
				if (et.getState().equals("1")) {
					et.setState("启用");
				}
				if (et.getState().equals("0")) {
					et.setState("禁用");
				}
				Map<String, Object> cellMap = new HashMap<String, Object>();
				cellMap.put("id", et.getExpresstempleteid());
				cellMap.put("cell", new Object[] {et.getLogisticsid(), et.getState() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 *更新模板
	 * 
	 * @return
	 */
	@Action(value = "UpdateExpresstemplete", results = { 
			@Result(name = "success", type="redirect",location = "/jshop/admin/order/expresstempletemanagement.jsp?session=${param}"),
			@Result(name = "input", type="redirect",location = "/jshop/admin/order/expresstempletemanagement.jsp?session=${param}")
	})
	public String UpdateExpresstemplete() {
			ExpresstempleteT et = new ExpresstempleteT();
			et.setExpresstempleteid(this.getExpresstempleteid().trim());
			et.setSendName(ExpresstempleteTAction.SENDNAME);
			et.setSendCountry(ExpresstempleteTAction.SENDCOUNTRY);
			et.setSendProvince(ExpresstempleteTAction.SENDPROVINCE);
			et.setSendCity(ExpresstempleteTAction.SENDCITY);
			et.setSendDistrict(ExpresstempleteTAction.SENDDISTRICT);
			et.setSendStreet(ExpresstempleteTAction.SENDSTREET);
			et.setSendTelno(ExpresstempleteTAction.SENDTELNO);
			et.setSendMobile(ExpresstempleteTAction.SENDMOBILE);
			et.setSendContactor(ExpresstempleteTAction.SENDCONTACTOR);
			et.setRecipientName(ExpresstempleteTAction.RECIPIENTNAME);
			et.setRecipientCountry(ExpresstempleteTAction.RECIPIENTCOUNTRY);
			et.setRecipientProvince(ExpresstempleteTAction.RECIPIENTPROVINCE);
			et.setRecipientCity(ExpresstempleteTAction.RECIPIENTCITY);
			et.setRecipientDistrict(ExpresstempleteTAction.RECIPIENTDISTRICT);
			et.setRecipientStreet(ExpresstempleteTAction.RECIPIENTSTREET);
			et.setRecipientTelno(ExpresstempleteTAction.RECIPIENTTELNO);
			et.setRecipientMobile(ExpresstempleteTAction.RECIPIENTMOBILE);
			et.setRecipientPostcode(ExpresstempleteTAction.RECIPIENTPOSTCODE);
			et.setRecipientContactor(ExpresstempleteTAction.RECIPIENTCONTACTOR);
			et.setYear(ExpresstempleteTAction.YEAR);
			et.setMonth(ExpresstempleteTAction.MONTH);
			et.setDay(ExpresstempleteTAction.DAY);
			et.setHour(ExpresstempleteTAction.HOUR);
			et.setMinutes(ExpresstempleteTAction.MINUTES);
			et.setOrderid(ExpresstempleteTAction.ORDERID);
			et.setNotes(ExpresstempleteTAction.NOTES);
			et.setSendTime(ExpresstempleteTAction.SENDTIME);
			et.setRightTag(ExpresstempleteTAction.RIGHTTAG);
			et.setLogisticsid(this.getLogisticsid().trim());
			et.setQuantity(ExpresstempleteTAction.QUANTITY);
			et.setState("1");
			et.setExpressCss(null);
			et.setExpressImg(null);
			et.setKindeditorCode(this.getKindeditorCode());
			@SuppressWarnings("unused")
			int i = this.getExpresstempleteTService().updateExpresstemplete(et);
			return SUCCESS;
	}

	/**
	 * 根据模板id获取快递单模板信息
	 * 
	 * @return
	 */
	@Action(value = "findExpresstempleteBytempleteid", results = { 
			@Result(name = "json",type="json")
	})
	public String findExpresstempleteBytempleteid() {
		if (Validate.StrNotNull(this.getExpresstempleteid())) {
			beanlist = this.getExpresstempleteTService().findExpresstempleteBytempleteid(this.getExpresstempleteid().trim());
			if (beanlist != null) {
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 批量删除模板
	 * 
	 * @return
	 */
	@Action(value = "DelExpresstemplete", results = { 
			@Result(name = "json",type="json")
	})
	public String DelExpresstemplete() {
		if (Validate.StrNotNull(this.getExpresstempleteid())) {
			String[] strs = this.getExpresstempleteid().trim().split(",");
			if (this.getExpresstempleteTService().delExpresstemplete(strs) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	}
}
