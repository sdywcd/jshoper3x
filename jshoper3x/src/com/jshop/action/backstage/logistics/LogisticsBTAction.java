package com.jshop.action.backstage.logistics;

import java.sql.Date;
import java.util.ArrayList;
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
import com.jshop.action.backstage.utils.enums.BaseEnums.DataShowState;
import com.jshop.action.backstage.utils.enums.BaseEnums.LogisticsShowRange;
import com.jshop.action.backstage.utils.enums.BaseEnums.LogisticsSupportRange;
import com.jshop.action.backstage.utils.enums.BaseEnums.SupportType;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.service.LogisticsBTService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class LogisticsBTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private LogisticsBTService logisticsBTService;
	private String logisticsid;
	private String logisticsname;
	private String address;
	private String contractor;
	private String telno;
	private String faxno;
	private String email;
	private String receiver;
	private String bankaddress;
	private String bankaccount;
	private Date createtime;
	private String creatorid;
	private String des;
	private String insure;
	private String isCod;
	private String visible;
	private String state;
	private String city;
	private String website;
	private String sendrange;
	private String mobile;
	private String logisticsjson = null;
	private List<LogisticsBusinessT> logisticsbusiness = new ArrayList<LogisticsBusinessT>();
	private LogisticsBusinessT beanlist = new LogisticsBusinessT();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	public List<LogisticsBusinessT> getLogisticsbusiness() {
		return logisticsbusiness;
	}

	public void setLogisticsbusiness(List<LogisticsBusinessT> logisticsbusiness) {
		this.logisticsbusiness = logisticsbusiness;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getLogisticsname() {
		return logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getFaxno() {
		return faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getBankaddress() {
		return bankaddress;
	}

	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getInsure() {
		return insure;
	}

	public void setInsure(String insure) {
		this.insure = insure;
	}

	public String getIsCod() {
		return isCod;
	}

	public void setIsCod(String isCod) {
		this.isCod = isCod;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LogisticsBusinessT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(LogisticsBusinessT beanlist) {
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogisticsjson() {
		return logisticsjson;
	}

	public void setLogisticsjson(String logisticsjson) {
		this.logisticsjson = logisticsjson;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getSendrange() {
		return sendrange;
	}

	public void setSendrange(String sendrange) {
		this.sendrange = sendrange;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加物流商
	 * 
	 * @return
	 */
	@Action(value = "addLogisticsBusiness", results = { @Result(name = "json", type = "json") })
	public String addLogisticsBusiness() {
		LogisticsBusinessT lb = new LogisticsBusinessT();
		lb.setLogisticsid(this.getSerial().Serialid(Serial.LOGISTICSBUSINESS));
		lb.setLogisticsname(this.getLogisticsname().trim());
		lb.setAddress(this.getAddress());
		lb.setContractor(this.getContractor().trim());
		lb.setTelno(this.getTelno().trim());
		lb.setFaxno(this.getFaxno().trim());
		lb.setEmail(this.getEmail().trim());
		lb.setReceiver(this.getReceiver().trim());
		lb.setBankaddress(this.getBankaddress().trim());
		lb.setBankaccount(this.getBankaccount().trim());
		lb.setCreatetime(BaseTools.getSystemTime());
		lb.setCreatorid(BaseTools.getAdminCreateId());
		lb.setDes(this.getDes().trim());
		lb.setInsure(this.getInsure().trim());
		lb.setIsCod(this.getIsCod().trim());
		lb.setVisible(this.getVisible().trim());
		lb.setState(this.getState().trim());
		lb.setCity(this.getCity().trim());
		lb.setWebsite(this.getWebsite().trim());
		lb.setSendrange(this.getSendrange().trim());
		lb.setMobile(this.getMobile().trim());
		this.logisticsBTService.save(lb);
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 查询所有物流商
	 * 
	 * @return
	 */
	@Action(value = "findAllLogisticsBusiness", results = { @Result(name = "json", type = "json") })
	public String findAllLogisticsBusiness() {
		if (StringUtils.equals(StaticKey.SC, this.getQtype())) {
			findDefautlAllLogisticsBusiness();
		} else {
			if (StringUtils.isBlank(this.getQuery())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	public void findDefautlAllLogisticsBusiness() {
		int currentPage = page;
		int lineSize = rp;
		total = this.logisticsBTService.count(LogisticsBusinessT.class)
				.intValue();
		Order order = Order.desc("createtime");
		List<LogisticsBusinessT> list = this.logisticsBTService
				.findByCriteriaByPage(LogisticsBusinessT.class, order,
						currentPage, lineSize);
		this.processTemplatesetTlist(list);
	}

	public void processTemplatesetTlist(List<LogisticsBusinessT> list) {
		rows.clear();
		for (Iterator<LogisticsBusinessT> it = list.iterator(); it.hasNext();) {
			LogisticsBusinessT lb = (LogisticsBusinessT) it.next();
			if (StringUtils.equals(SupportType.SUPPORT.getState(),
					lb.getInsure())) {
				lb.setInsure(SupportType.SUPPORT.getName());
			} else {
				lb.setInsure(SupportType.UNSUPPORT.getName());
			}
			if (StringUtils.equals(SupportType.SUPPORT.getState(),
					lb.getIsCod())) {
				lb.setIsCod(SupportType.SUPPORT.getName());
			} else {
				lb.setIsCod(SupportType.UNSUPPORT.getName());
			}
			lb.setVisible(DataShowState.getName(lb.getVisible()));
			lb.setState(LogisticsShowRange.getName(lb.getState()));
			lb.setSendrange(LogisticsSupportRange.getName(lb.getSendrange()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", lb.getLogisticsid());
			cellMap.put(
					"cell",
					new Object[] {
							lb.getLogisticsname(),
							lb.getCity(),
							lb.getContractor(),
							lb.getTelno(),
							lb.getFaxno(),
							lb.getEmail(),
							lb.getAddress(),
							lb.getReceiver(),
							lb.getBankaccount(),
							lb.getBankaddress(),
							lb.getInsure(),
							lb.getIsCod(),
							lb.getVisible(),
							lb.getDes(),
							lb.getState(),
							BaseTools.formateDbDate(lb.getCreatetime()),
							lb.getCreatorid(),
							lb.getWebsite(),
							lb.getSendrange(),
							lb.getMobile(),
							"<a id='editlogistics' name='editlogistics' href='logistics.jsp?operate=edit&folder=setting&logisticsid="
									+ lb.getLogisticsid() + "'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 更新物流商
	 * 
	 * @return
	 */
	@Action(value = "updateLogisticsBusiness", results = { @Result(name = "json", type = "json") })
	public String updateLogisticsBusiness() {
		LogisticsBusinessT lb = this.logisticsBTService.findByPK(
				LogisticsBusinessT.class, this.getLogisticsid());
		if (lb != null) {
			lb.setLogisticsname(this.getLogisticsname().trim());
			lb.setAddress(this.getAddress());
			lb.setContractor(this.getContractor().trim());
			lb.setTelno(this.getTelno().trim());
			lb.setMobile(this.getMobile());
			lb.setFaxno(this.getFaxno().trim());
			lb.setEmail(this.getEmail().trim());
			lb.setReceiver(this.getReceiver().trim());
			lb.setBankaddress(this.getBankaddress().trim());
			lb.setBankaccount(this.getBankaccount().trim());
			lb.setCreatetime(BaseTools.getSystemTime());
			lb.setCreatorid(BaseTools.getAdminCreateId());
			lb.setDes(this.getDes());
			lb.setInsure(this.getInsure());
			lb.setIsCod(this.getIsCod());
			lb.setVisible(this.getVisible());
			lb.setState(this.getState());
			lb.setCity(this.getCity());
			lb.setWebsite(this.getWebsite());
			lb.setSendrange(this.getSendrange());
			this.logisticsBTService.update(lb);
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 根据id获取物流商
	 * 
	 * @return
	 */
	@Action(value = "findLogisticsBusinessById", results = { @Result(name = "json", type = "json") })
	public String findLogisticsBusinessById() {
		if (StringUtils.isNotBlank(this.getLogisticsid())) {
			beanlist = this.logisticsBTService.findByPK(LogisticsBusinessT.class, this.getLogisticsid());
			if (beanlist != null) {
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 删除物流商
	 * 
	 * @return
	 */
	@Action(value = "delLogisticsBusiness", results = { @Result(name = "json", type = "json") })
	public String delLogisticsBusiness() {
		if (StringUtils.isNotBlank(this.getLogisticsid())) {
			String[] strs = StringUtils.split(this.getLogisticsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				LogisticsBusinessT lb=this.logisticsBTService.findByPK(LogisticsBusinessT.class, s);
				if(lb!=null){
					this.logisticsBTService.delete(lb);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 获取物流商json方式
	 * 
	 * @return
	 */
	@Action(value = "findAllLogisticsBusinessTjson", results = { @Result(name = "json", type = "json") })
	public String findAllLogisticsBusinessTjson() {
		this.setLogisticsjson("");
		Criterion criterion=Restrictions.eq("state", LogisticsShowRange.BACKSTAGE.getState());
		this.logisticsbusiness = this.logisticsBTService.findByCriteria(LogisticsBusinessT.class, criterion);
		if (this.logisticsbusiness != null) {
			for (Iterator<LogisticsBusinessT> it = this.logisticsbusiness
					.iterator(); it.hasNext();) {
				LogisticsBusinessT l = (LogisticsBusinessT) it.next();
				this.logisticsjson += "<option value='" + l.getLogisticsid()
						+ "'>" + l.getLogisticsname() + "</option>";
			}
			this.setLogisticsjson(logisticsjson);
			return JSON;
		}
		return JSON;
	}

	/**
	 * 获取后台新增订单时所需要的物流商信息
	 * 
	 * @return
	 */
	@Action(value = "findAllLogisticsBusinessForbsOrder", results = { @Result(name = "json", type = "json") })
	public String findAllLogisticsBusinessForbsOrder() {
		Criterion criterion=Restrictions.eq("state", LogisticsShowRange.BACKSTAGE.getState());
		this.logisticsbusiness = this.logisticsBTService.findByCriteria(LogisticsBusinessT.class, criterion);
		if (!logisticsbusiness.isEmpty()) {
			this.setSucflag(true);
		}
		return JSON;
	}

}
