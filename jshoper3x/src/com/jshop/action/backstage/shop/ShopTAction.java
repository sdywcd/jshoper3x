package com.jshop.action.backstage.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.backstage.utils.enums.BaseEnums.JshopOpenState;
import com.jshop.action.backstage.utils.enums.BaseEnums.UserType;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.UserT;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.UsertService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class ShopTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	@Resource
	private UsertService usertService;
	private String userid;
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
	private UserT userbean=new UserT();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	private String basepath;

	public UserT getUserbean() {
		return userbean;
	}

	public void setUserbean(UserT userbean) {
		this.userbean = userbean;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
		jbi.setCreatetime(BaseTools.getSystemTime());
		jbi.setMetaDes(this.getMetaDes());
		jbi.setMetaKeywords(this.getMetaKeywords());
		this.jshopbasicInfoTService.save(jbi);
		this.setSucflag(true);
		return JSON;

	}

	/**
	 * 查询所有商铺信息
	 * 
	 * @return
	 */
	@Action(value = "findAllShop", results = { @Result(name = "json", type = "json") })
	public String findAllShop() {
		if (StringUtils.equals(StaticKey.SC, this.getQtype())) {
			findDefaultAllShop();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {

			}
		}
		return JSON;
	}

	private void findDefaultAllShop() {
		int currentPage = page;
		int lineSize = rp;
		total = this.jshopbasicInfoTService.count(JshopbasicInfoT.class)
				.intValue();
		Order order = Order.desc("createtime");
		List<JshopbasicInfoT> list = this.jshopbasicInfoTService
				.findByCriteriaByPage(JshopbasicInfoT.class, order,
						currentPage, lineSize);
		if (!list.isEmpty()) {
			processList(list);
		}
	}

	private void processList(List<JshopbasicInfoT> list) {
		for (Iterator<JshopbasicInfoT> it = list.iterator(); it.hasNext();) {
			JshopbasicInfoT jbi = (JshopbasicInfoT) it.next();
			if (StringUtils.equals(jbi.getOpenstate(),
					JshopOpenState.OPEN.getOpenstate())) {
				jbi.setOpenstate(JshopOpenState.OPEN.getName());
			}
			if (StringUtils.equals(jbi.getOpenstate(),
					JshopOpenState.CLOSE.getOpenstate())) {
				jbi.setOpenstate(JshopOpenState.CLOSE.getName());
			}
			if (StringUtils.equals(jbi.getState(),
					DataUsingState.USING.getState())) {
				jbi.setState(DataUsingState.USING.getName());
			}
			if (StringUtils.equals(jbi.getState(),
					DataUsingState.UNUSING.getState())) {
				jbi.setState(DataUsingState.UNUSING.getName());
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", jbi.getBasicinfoid());
			cellMap.put(
					"cell",
					new Object[] { jbi.getJshopname(), jbi.getMetaKeywords(),
							jbi.getOpenstate(), jbi.getState(),
							BaseTools.formateDbDate(jbi.getCreatetime()) });
			rows.add(cellMap);
		}
	}

	/**
	 * 更新商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "updateJshopbasicInfo", results = { @Result(name = "json", type = "json") })
	public String updateJshopbasicInfo() {
		JshopbasicInfoT jbi = new JshopbasicInfoT();
		jbi = this.jshopbasicInfoTService.findByPK(JshopbasicInfoT.class,
				this.getBasicinfoid());
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
		this.jshopbasicInfoTService.update(jbi);
		this.setSucflag(true);
		return JSON;

	}

	/**
	 * 根据creatorid获取商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "findJshopbasicInfoTById", results = { @Result(name = "json", type = "json") })
	public String findJshopbasicInfoTById() {
		Criterion criterion = Restrictions.eq("creatorid",
				BaseTools.getAdminCreateId());
		beanlist = this.jshopbasicInfoTService.findOneByCriteria(
				JshopbasicInfoT.class, criterion);
		if (beanlist != null) {
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 根据店铺id查询店铺信息
	 * @return
	 */
	@Action(value = "findShopById", results = { @Result(name = "json", type = "json") })
	public String findShopById() {
		if (StringUtils.isNotBlank(this.getBasicinfoid())) {
			Criterion criterion = Restrictions.eq("basicinfoid",
					this.getBasicinfoid());
			beanlist=this.jshopbasicInfoTService.findOneByCriteria(JshopbasicInfoT.class, criterion);
			if(beanlist!=null){
				this.setBasepath(BaseTools.getBasePath());
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 删除商城基本信息
	 * 
	 * @return
	 */
	@Action(value = "delJshopbasicInfo", results = { @Result(name = "json", type = "json") })
	public String delJshopbasicInfo() {
		if (StringUtils.isNotBlank(this.getBasicinfoid())) {
			String strs[] = StringUtils.split(this.getBasicinfoid(),
					StaticKey.SPLITDOT);
			for (String s : strs) {
				JshopbasicInfoT j = this.jshopbasicInfoTService.findByPK(
						JshopbasicInfoT.class, s);
				if (j != null) {
					this.jshopbasicInfoTService.delete(j);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}

	@Action(value = "updateJshopbasicInfostate", results = { @Result(name = "json", type = "json") })
	public String updateJshopbasicInfostate() {
		if (StringUtils.isNotBlank(this.getBasicinfoid())) {
			JshopbasicInfoT j = this.jshopbasicInfoTService.findByPK(
					JshopbasicInfoT.class, this.getBasicinfoid());
			if (j != null) {
				j.setOpenstate(this.getOpenstate());
				this.jshopbasicInfoTService.update(j);
			}
		}
		return JSON;
	}
	
	
	
	/**
	 * 绑定店铺掌柜
	 * @return
	 */
	@Action(value = "bindShopAdmin", results = { @Result(name = "json", type = "json") })
	public String bindShopAdmin(){
		if(StringUtils.isNotBlank(this.getUserid())&&StringUtils.isNotBlank(this.getBasicinfoid())){
			UserT user=this.usertService.findByPK(UserT.class, this.getUserid());
			JshopbasicInfoT jt=this.jshopbasicInfoTService.findByPK(JshopbasicInfoT.class, this.getBasicinfoid());
			if(user!=null&&jt!=null){
				user.setShopid(this.getBasicinfoid());
				user.setShopname(jt.getJshopname());
				this.usertService.update(user);
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 查询店铺掌柜
	 * @return
	 */
	@Action(value = "findShopAdmin", results = { @Result(name = "json", type = "json") })
	public String findShopAdmin(){
		if(StringUtils.isNotBlank(this.getBasicinfoid())){
			Criterion criterion=Restrictions.eq("shopid", this.getBasicinfoid());
			UserT userT=this.usertService.findOneByCriteria(UserT.class, criterion);
			if(userT!=null){
				this.setUserbean(userT);
				this.setSucflag(true);
			}
		}
		return JSON;
	}
	/**
	 * 解绑店铺掌柜
	 * @return
	 */
	@Action(value = "unBindShopAdmin", results = { @Result(name = "json", type = "json") })
	public String unBindShopAdmin(){
		if(StringUtils.isNotBlank(this.getBasicinfoid())){
			JshopbasicInfoT jshopbasicInfoT=this.jshopbasicInfoTService.findByPK(JshopbasicInfoT.class, this.getBasicinfoid());
			if(jshopbasicInfoT!=null){
				Criterion criterion=Restrictions.eq("shopid", jshopbasicInfoT.getBasicinfoid());
				List<UserT>userList=this.usertService.findByCriteria(UserT.class, criterion);
				for(UserT u:userList){
					if(StringUtils.equals(u.getState(), UserType.SHOPMANAGER.getState())){
						u.setShopid(StaticKey.ZERO);
						u.setShopname(StaticKey.ZERO);
						this.usertService.update(u);
					}
				}
				this.setSucflag(true);
			}
		}
		return JSON;
	}
}
