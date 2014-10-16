package com.jshop.action.backstage.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class JshopbasicInfoTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
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
	private String skypeservice;
	private String weixinservice;
	private String sinaweiboservice;
	private String emailservice;
	private String phoneservice;
	private String openstate;
	private String siteclosenotes;
	private String sitelogo;
	private String licensed;
	private String icpnum;
	private String state;
	private String district;
	private String creatorid;
	private Date createtime;
	private String metaKeywords;
	private String metaDes;
	private JshopbasicInfoT beanlist = new JshopbasicInfoT();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
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
	public String getSkypeservice() {
		return skypeservice;
	}

	public void setSkypeservice(String skypeservice) {
		this.skypeservice = skypeservice;
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


	public String getIcpnum() {
		return icpnum;
	}

	public void setIcpnum(String icpnum) {
		this.icpnum = icpnum;
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

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
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

	
	public String getWeixinservice() {
		return weixinservice;
	}

	public void setWeixinservice(String weixinservice) {
		this.weixinservice = weixinservice;
	}

	public String getSinaweiboservice() {
		return sinaweiboservice;
	}

	public void setSinaweiboservice(String sinaweiboservice) {
		this.sinaweiboservice = sinaweiboservice;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
		jbi.setSkypeservice(this.getSkypeservice().trim());
		jbi.setWeixinservice(this.getWeixinservice().trim());
		jbi.setSinaweiboservice(this.getSinaweiboservice().trim());
		jbi.setEmailservice(this.getEmailservice().trim());
		jbi.setPhoneservice(this.getPhoneservice().trim());
		jbi.setOpenstate(this.getOpenstate().trim());
		jbi.setSiteclosenotes(this.getSiteclosenotes());
		jbi.setSitelogo(this.getSitelogo().trim());
		jbi.setLicensed(this.getLicensed().trim());
		jbi.setIcpnum(this.getIcpnum());
		jbi.setState(this.getState());
		jbi.setDistrict(this.getDistrict());
		jbi.setCreatorid(BaseTools.getAdminCreateId());
		jbi.setCreatetime(BaseTools.systemtime());
		jbi.setMetaDes(this.getMetaDes());
		jbi.setMetaKeywords(this.getMetaKeywords());
		this.getJshopbasicInfoTService().save(jbi);
		this.setSucflag(true);
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
		List<JshopbasicInfoT> list = this.getJshopbasicInfoTService().findAllJshopbasicInfo(currentPage, lineSize, BaseTools.getAdminCreateId());
		if (list != null) {
			total = this.getJshopbasicInfoTService().countfindAllJshopbasicInfo(BaseTools.getAdminCreateId());
			rows.clear();
			for (Iterator<JshopbasicInfoT> it = list.iterator(); it.hasNext();) {
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
				Map<String, Object> cellMap = new HashMap<String, Object>();
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
	@Action(value = "updateJshopbasicInfo", results = { @Result(name = "json", type = "json") })
	public String updateJshopbasicInfo() {
		JshopbasicInfoT jbi = new JshopbasicInfoT();
		jbi=this.getJshopbasicInfoTService().findJshopbasicInfoTById(this.getBasicinfoid());
		jbi.setBasicinfoid(this.getBasicinfoid());
		jbi.setJshopname(this.getJshopname().trim());
		jbi.setJshopslogan(this.getJshopslogan().trim());
		jbi.setCountry(this.getCountry().trim());
		jbi.setProvince(this.getProvince().trim());
		jbi.setCity(this.getCity().trim());
		jbi.setStreet(this.getStreet().trim());
		jbi.setQqservice(this.getQqservice().trim());
		jbi.setSkypeservice(this.getSkypeservice().trim());
		jbi.setWeixinservice(this.getWeixinservice().trim());
		jbi.setSinaweiboservice(this.getSinaweiboservice().trim());
		jbi.setEmailservice(this.getEmailservice().trim());
		jbi.setPhoneservice(this.getPhoneservice().trim());
		jbi.setOpenstate(this.getOpenstate().trim());
		jbi.setSiteclosenotes(this.getSiteclosenotes());
		jbi.setSitelogo(this.getSitelogo().trim());
		jbi.setLicensed(this.getLicensed().trim());
		jbi.setIcpnum(this.getIcpnum());
		jbi.setState(this.getState());
		jbi.setDistrict(this.getDistrict());
		jbi.setMetaDes(this.getMetaDes());
		jbi.setMetaKeywords(this.getMetaKeywords());
		this.getJshopbasicInfoTService().updateJshopbasicInfo(jbi);
		this.setSucflag(true);
		return "json";

	}

	/**
	 * 根据creatorid获取商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "findJshopbasicInfoTById", results = { @Result(name = "json", type = "json") })
	public String findJshopbasicInfoTById() {
		String creatorid=BaseTools.getAdminCreateId();
		beanlist = this.getJshopbasicInfoTService().findAllJshopbasicInfo(creatorid);
		if (beanlist != null) {
			this.setSucflag(true);
			return "json";
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
			if (this.getJshopbasicInfoTService().delJshopbasicInfo(array, BaseTools.getAdminCreateId()) > 0) {
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
