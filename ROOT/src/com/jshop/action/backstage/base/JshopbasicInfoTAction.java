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
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.service.JshopbasicInfoTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")

public class JshopbasicInfoTAction extends ActionSupport {
	private Serial serial;
	private JshopbasicInfoTService jshopbasicInfoTService;
	private String basicinfoid;
	private String jshopname;
	private String jshopslogan;
	private String country;
	private String province;
	private String city;
	private String street;
	private String qqservice;
	private String taobaowwservice;
	private String skypeservice;
	private String yahooservice;
	private String msnservice;
	private String emailservice;
	private String phoneservice;
	private String openstate;
	private String siteclosenotes;
	private String sitelogo;
	private String licensed;
	private String usercenternote;
	private String jshopnotice;
	private String registerclose;
	private String icpnum;
	private String sendName;
	private String sendCountry;
	private String sendProvince;
	private String sendCity;
	private String sendDistrict;
	private String sendStreet;
	private String sendTelno;
	private String sendMobile;
	private String sendContactor;
	private String state;
	private String district;
	private String creatorid;
	private String metaKeywords;
	private String metaDes;
	private JshopbasicInfoT beanlist = new JshopbasicInfoT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private boolean sucflag;
	private String basepath;
	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}

	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}



	public String getBasicinfoid() {
		return basicinfoid;
	}

	public void setBasicinfoid(String basicinfoid) {
		this.basicinfoid = basicinfoid;
	}

	public String getJshopname() {
		return jshopname;
	}

	public void setJshopname(String jshopname) {
		this.jshopname = jshopname;
	}

	public String getJshopslogan() {
		return jshopslogan;
	}

	public void setJshopslogan(String jshopslogan) {
		this.jshopslogan = jshopslogan;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getQqservice() {
		return qqservice;
	}

	public void setQqservice(String qqservice) {
		this.qqservice = qqservice;
	}

	public String getTaobaowwservice() {
		return taobaowwservice;
	}

	public void setTaobaowwservice(String taobaowwservice) {
		this.taobaowwservice = taobaowwservice;
	}

	public String getSkypeservice() {
		return skypeservice;
	}

	public void setSkypeservice(String skypeservice) {
		this.skypeservice = skypeservice;
	}

	public String getYahooservice() {
		return yahooservice;
	}

	public void setYahooservice(String yahooservice) {
		this.yahooservice = yahooservice;
	}

	public String getMsnservice() {
		return msnservice;
	}

	public void setMsnservice(String msnservice) {
		this.msnservice = msnservice;
	}

	public String getEmailservice() {
		return emailservice;
	}

	public void setEmailservice(String emailservice) {
		this.emailservice = emailservice;
	}

	public String getPhoneservice() {
		return phoneservice;
	}

	public void setPhoneservice(String phoneservice) {
		this.phoneservice = phoneservice;
	}

	public String getOpenstate() {
		return openstate;
	}

	public void setOpenstate(String openstate) {
		this.openstate = openstate;
	}

	public String getSiteclosenotes() {
		return siteclosenotes;
	}

	public void setSiteclosenotes(String siteclosenotes) {
		this.siteclosenotes = siteclosenotes;
	}

	public String getSitelogo() {
		return sitelogo;
	}

	public void setSitelogo(String sitelogo) {
		this.sitelogo = sitelogo;
	}

	public String getLicensed() {
		return licensed;
	}

	public void setLicensed(String licensed) {
		this.licensed = licensed;
	}

	public String getUsercenternote() {
		return usercenternote;
	}

	public void setUsercenternote(String usercenternote) {
		this.usercenternote = usercenternote;
	}

	public String getJshopnotice() {
		return jshopnotice;
	}

	public void setJshopnotice(String jshopnotice) {
		this.jshopnotice = jshopnotice;
	}

	public String getRegisterclose() {
		return registerclose;
	}

	public void setRegisterclose(String registerclose) {
		this.registerclose = registerclose;
	}

	public String getIcpnum() {
		return icpnum;
	}

	public void setIcpnum(String icpnum) {
		this.icpnum = icpnum;
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

	public String getSendContactor() {
		return sendContactor;
	}

	public void setSendContactor(String sendContactor) {
		this.sendContactor = sendContactor;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public JshopbasicInfoT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(JshopbasicInfoT beanlist) {
		this.beanlist = beanlist;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
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

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDes() {
		return metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "addJshopbasicInfoT", results = { @Result(name = "json", type = "json") })
	public String addJshopbasicInfoT() {
		JshopbasicInfoT jbi = new JshopbasicInfoT();
		jbi.setBasicinfoid(this.getSerial().Serialid(Serial.JSHOPBASICINFO));
		jbi.setJshopname(this.getJshopname().trim());
		jbi.setJshopslogan(this.getJshopslogan().trim());
		jbi.setCountry(this.getCountry().trim());
		jbi.setProvince(this.getProvince().trim());
		jbi.setCity(this.getCity().trim());
		jbi.setStreet(this.getStreet().trim());
		jbi.setQqservice(this.getQqservice().trim());
		jbi.setTaobaowwservice(this.getTaobaowwservice().trim());
		jbi.setSkypeservice(this.getSkypeservice().trim());
		jbi.setYahooservice(this.getYahooservice().trim());
		jbi.setMsnservice(this.getMsnservice().trim());
		jbi.setEmailservice(this.getEmailservice().trim());
		jbi.setPhoneservice(this.getPhoneservice().trim());
		jbi.setOpenstate(this.getOpenstate().trim());
		jbi.setSiteclosenotes(this.getSiteclosenotes());
		jbi.setSitelogo(this.getSitelogo().trim());
		jbi.setLicensed(this.getLicensed().trim());
		jbi.setUsercenternote(this.getUsercenternote());
		jbi.setJshopnotice(this.getJshopnotice());
		jbi.setRegisterclose(this.getRegisterclose());
		jbi.setIcpnum(this.getIcpnum());
		jbi.setSendName(this.getSendName().trim());
		jbi.setSendCountry(this.getSendCountry());
		jbi.setSendProvince(this.getSendProvince());
		jbi.setSendCity(this.getSendCity());
		jbi.setSendDistrict(this.getSendDistrict());
		jbi.setSendStreet(this.getSendStreet());
		jbi.setSendTelno(this.getSendTelno());
		jbi.setSendMobile(this.getSendMobile());
		jbi.setSendContactor(this.getSendContactor());
		jbi.setState(this.getState());
		jbi.setDistrict(this.getDistrict());
		jbi.setCreatorid(BaseTools.adminCreateId());
		jbi.setCreatetime(BaseTools.systemtime());
		jbi.setMetaDes(this.getMetaDes());
		jbi.setMetaKeywords(this.getMetaKeywords());
		if (this.getJshopbasicInfoTService().addJshopbasicInfoT(jbi) > 0) {
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 查询所有商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "findAllJshopbasicInfo", results = { @Result(name = "json", type = "json") })
	@SuppressWarnings("unchecked")
	public String findAllJshopbasicInfo() {

		int currentPage = page;
		int lineSize = rp;
		List<JshopbasicInfoT> list = this.getJshopbasicInfoTService().findAllJshopbasicInfo(currentPage, lineSize, BaseTools.adminCreateId());
		if (list != null) {
			total = this.getJshopbasicInfoTService().countfindAllJshopbasicInfo(BaseTools.adminCreateId());
			rows.clear();
			for (Iterator it = list.iterator(); it.hasNext();) {
				JshopbasicInfoT jbi = (JshopbasicInfoT) it.next();
				if (jbi.getOpenstate().equals("1")) {
					jbi.setOpenstate("开启");
				}
				if (jbi.getOpenstate().equals("0")) {
					jbi.setOpenstate("关闭");
				}
				if (jbi.getState().equals("1")) {
					jbi.setState("开启");
				}
				if (jbi.getState().equals("0")) {
					jbi.setState("关闭");
				}
				Map cellMap = new HashMap();
				cellMap.put("id", jbi.getBasicinfoid());
				cellMap.put("cell", new Object[] { jbi.getJshopname(), jbi.getMetaKeywords(), jbi.getOpenstate(), jbi.getState() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";

	}

	/**
	 * 更新商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "UpdateJshopbasicInfo", results = { @Result(name = "json", type = "json") })
	public String UpdateJshopbasicInfo() {

		JshopbasicInfoT jbi = new JshopbasicInfoT();
		jbi.setBasicinfoid(this.getBasicinfoid());
		jbi.setJshopname(this.getJshopname().trim());
		jbi.setJshopslogan(this.getJshopslogan().trim());
		jbi.setCountry(this.getCountry().trim());
		jbi.setProvince(this.getProvince().trim());
		jbi.setCity(this.getCity().trim());
		jbi.setStreet(this.getStreet().trim());
		jbi.setQqservice(this.getQqservice().trim());
		jbi.setTaobaowwservice(this.getTaobaowwservice().trim());
		jbi.setSkypeservice(this.getSkypeservice().trim());
		jbi.setYahooservice(this.getYahooservice().trim());
		jbi.setMsnservice(this.getMsnservice().trim());
		jbi.setEmailservice(this.getEmailservice().trim());
		jbi.setPhoneservice(this.getPhoneservice().trim());
		jbi.setOpenstate(this.getOpenstate().trim());
		jbi.setSiteclosenotes(this.getSiteclosenotes());
		jbi.setSitelogo(this.getSitelogo().trim());
		jbi.setLicensed(this.getLicensed().trim());
		jbi.setUsercenternote(this.getUsercenternote());
		jbi.setJshopnotice(this.getJshopnotice());
		jbi.setRegisterclose(this.getRegisterclose());
		jbi.setIcpnum(this.getIcpnum());
		jbi.setSendName(this.getSendName().trim());
		jbi.setSendCountry(this.getSendCountry());
		jbi.setSendProvince(this.getSendProvince());
		jbi.setSendCity(this.getSendCity());
		jbi.setSendDistrict(this.getSendDistrict());
		jbi.setSendStreet(this.getSendStreet());
		jbi.setSendTelno(this.getSendTelno());
		jbi.setSendMobile(this.getSendMobile());
		jbi.setSendContactor(this.getSendContactor());
		jbi.setState(this.getState());
		jbi.setDistrict(this.getDistrict());
		jbi.setCreatetime(BaseTools.systemtime());
		jbi.setMetaDes(this.getMetaDes());
		jbi.setMetaKeywords(this.getMetaKeywords());
		@SuppressWarnings("unused")
		int i = this.getJshopbasicInfoTService().updateJshopbasicInfo(jbi);
		this.setSucflag(true);
		return "json";

	}

	/**
	 * 根据id获取商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "findJshopbasicInfoTById", results = { @Result(name = "json", type = "json") })
	public String findJshopbasicInfoTById() {
		if (Validate.StrNotNull(this.getBasicinfoid())) {
			beanlist = this.getJshopbasicInfoTService().findJshopbasicInfoTById(this.getBasicinfoid().trim());
			if (beanlist != null) {
				beanlist.setSitelogo(BaseTools.getBasePath()+beanlist.getSitelogo());
				return "json";
			}
		}
		return "json";
	}

	/**
	 *删除商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "delJshopbasicInfo", results = { @Result(name = "json", type = "json") })
	public String delJshopbasicInfo() {

		if (this.getBasicinfoid() != null) {
			String[] array = this.getBasicinfoid().trim().split(",");
			if (this.getJshopbasicInfoTService().delJshopbasicInfo(array, BaseTools.adminCreateId()) > 0) {
				return "json";
			}
		}
		return "json";

	}

	@Action(value = "updateJshopbasicInfostate", results = { @Result(name = "json", type = "json") })
	public String updateJshopbasicInfostate() {
		if (this.getBasicinfoid() != null) {
			@SuppressWarnings("unused")
			int i = this.getJshopbasicInfoTService().updateJshopbasicInfostate(this.getBasicinfoid(), this.getOpenstate());
			return "json";
		}
		return "json";
	}
}
