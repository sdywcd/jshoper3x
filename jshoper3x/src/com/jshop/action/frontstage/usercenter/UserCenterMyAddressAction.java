package com.jshop.action.frontstage.usercenter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.template.DataCollectionTAction;
import com.jshop.action.backstage.template.FreeMarkervariable;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.MemberT;
import com.jshop.entity.UserT;
import com.jshop.service.DeliverAddressTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class UserCenterMyAddressAction extends ActionSupport {
	
	private Serial serial;
	private DeliverAddressTService deliverAddressTService;
	private DataCollectionTAction dataCollectionTAction;
	
	private String addressid;
	private String userid;
	private String username;
	private String province;
	private String city;
	private String district;
	private String street;
	private String postcode;
	private String telno;
	private String mobile;
	private String email;
	private Date createtime;
	private String state;
	private String country;
	private DeliverAddressT bean = new DeliverAddressT();
	private boolean sucflag;
	private boolean slogin;
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	
	@JSON(serialize = false)
	public DeliverAddressTService getDeliverAddressTService() {
		return deliverAddressTService;
	}
	public void setDeliverAddressTService(DeliverAddressTService deliverAddressTService) {
		this.deliverAddressTService = deliverAddressTService;
	}
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public DeliverAddressT getBean() {
		return bean;
	}
	public void setBean(DeliverAddressT bean) {
		this.bean = bean;
	}

	
	/**
	 *用户中心获取用户收货地址
	 * @return
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	@Action(value = "getMemberDeliverAddressForUserCenter", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/deliveraddress.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String getMemberDeliverAddressForUserCenter() throws TemplateException, IOException{
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if(memberT!=null){
			List<DeliverAddressT> list=this.getDeliverAddressTService().findDeliverAddressBymemberid(memberT.getId());
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取收货地址
			ActionContext.getContext().put("deliveraddress", list);
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
			return SUCCESS;
		
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 根据地址ID获取用户地址
	 * return 
	 */
	@Action(value = "findDeliverAddressByaddresid", results = { @Result(name = "json", type = "json") })
	public String findDeliverAddressByaddresid(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setSlogin(true);
			if(StringUtils.isNotBlank(this.getAddressid())){
				bean = this.getDeliverAddressTService().findDeliverAddressById(this.getAddressid());
				this.setSucflag(true);
				return "json";
			}else{
				this.setSucflag(false);
				return "json";
			}
	
		}
		this.setSucflag(false);
		return "json";
		
	}
	
	/**
	 * 根据地址ID更新用户地址
	 * 
	 */
	@Action(value = "updateDeliverAddress", results = { @Result(name = "json", type = "json") })
	public String updateDeliverAddress(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setSlogin(true);
			if(StringUtils.isNotBlank(this.getAddressid())){
				bean = this.getDeliverAddressTService().findDeliverAddressById(this.getAddressid());
				bean.setShippingusername(this.getUsername().trim());
				bean.setCountry(this.getCountry());
				bean.setProvince(this.getProvince());
				bean.setCity(this.getCity());
				bean.setDistrict(this.getDistrict());
				bean.setStreet(this.getStreet());
				bean.setTelno(this.getTelno());
				bean.setMobile(this.getMobile());
				bean.setPostcode(this.getPostcode());
				bean.setEmail(this.getEmail());
				this.getDeliverAddressTService().updateDeliverAddress(bean);
				this.setSucflag(true);
				return "json";
			}else{
				this.setSucflag(false);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}
}


