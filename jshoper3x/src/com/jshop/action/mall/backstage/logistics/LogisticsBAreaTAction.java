package com.jshop.action.mall.backstage.logistics;

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

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.service.LogisticsBAreaTService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class LogisticsBAreaTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private LogisticsBAreaTService logisticsBAreaTService;
	private String logbusareaid;
	private String logisticsid;
	private String logisticsname;
	private String areaname;
	private String costway;
	private String normalcost;
	private String overcost;
	private String sendarea;
	private String state;
	private String overvalue;
	private String normalvalue;
	private LogisticsbusinessareaT beanlist = new LogisticsbusinessareaT();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	public String getLogbusareaid() {
		return logbusareaid;
	}

	public void setLogbusareaid(String logbusareaid) {
		this.logbusareaid = logbusareaid;
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

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getCostway() {
		return costway;
	}

	public void setCostway(String costway) {
		this.costway = costway;
	}

	public String getNormalcost() {
		return normalcost;
	}

	public void setNormalcost(String normalcost) {
		this.normalcost = normalcost;
	}

	public String getSendarea() {
		return sendarea;
	}

	public void setSendarea(String sendarea) {
		this.sendarea = sendarea;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LogisticsbusinessareaT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(LogisticsbusinessareaT beanlist) {
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

	public String getOvercost() {
		return overcost;
	}

	public void setOvercost(String overcost) {
		this.overcost = overcost;
	}

	public String getOvervalue() {
		return overvalue;
	}

	public void setOvervalue(String overvalue) {
		this.overvalue = overvalue;
	}

	public String getNormalvalue() {
		return normalvalue;
	}

	public void setNormalvalue(String normalvalue) {
		this.normalvalue = normalvalue;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "addLogisticsbusinessarea", results = { @Result(name = "json", type = "json") })
	public String addLogisticsbusinessarea() {
		LogisticsbusinessareaT lba = new LogisticsbusinessareaT();
		lba.setLogbusareaid(this.getSerial().Serialid(
				Serial.LOGISTICSBUSINESSAREA));
		lba.setLogisticsid(this.getLogisticsid().trim());
		// lba.setLogisticsname(this.getLogisticsname().trim());
		lba.setCostway(this.getCostway().trim());
		lba.setNormalcost(Double.parseDouble(this.getNormalcost()));
		lba.setNormalvalue(Double.parseDouble(this.getNormalvalue()));
		lba.setOvervalue(Double.parseDouble(this.getOvervalue()));
		lba.setOvercost(Double.parseDouble(this.getOvercost()));
		lba.setSendarea(this.getSendarea().trim());
		lba.setState(this.getState());
		this.logisticsBAreaTService.save(lba);
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 查询所有物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "findAllLogisticsbusinessareaT", results = { @Result(name = "json", type = "json") })
	public String findAllLogisticsbusinessareaT() {
		if (StringUtils.equals(StaticKey.SC, this.getQtype())) {
			if (StringUtils.isNotBlank(this.getLogisticsid())) {
				this.findDefaultAllLogisticsbusinessarea(this.getLogisticsid());
			}
		} else {
			if (StringUtils.isBlank(this.getQuery())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;

	}

	public void findDefaultAllLogisticsbusinessarea(String logisticsid) {
		int currentPage = page;
		int lineSize = rp;
		Criterion criterion = Restrictions.eq("logisticsid", logisticsid);
		Order order = Order.desc("logisticsid");
		total = this.logisticsBAreaTService.count(LogisticsbusinessareaT.class,
				criterion).intValue();
		List<LogisticsbusinessareaT> list = this.logisticsBAreaTService
				.findByCriteriaByPage(LogisticsbusinessareaT.class, order,
						currentPage, lineSize);
		this.processLogisticsbusinessarea(list);
	}

	public void processLogisticsbusinessarea(List<LogisticsbusinessareaT> list) {
		rows.clear();
		for (Iterator<LogisticsbusinessareaT> it = list.iterator(); it
				.hasNext();) {
			LogisticsbusinessareaT lba = (LogisticsbusinessareaT) it.next();
			lba.setCostway(StaticKey.WEIGHTMODEL);
			lba.setState(DataUsingState.getName(lba.getState()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", lba.getLogbusareaid());
			cellMap.put(
					"cell",
					new Object[] {
							lba.getSendarea(),
							lba.getCostway(),
							lba.getNormalcost(),
							lba.getNormalvalue(),
							lba.getOvercost(),
							lba.getOvervalue(),
							lba.getState(),
							"<a id='editlogicticsbusinessarea' name='editlogicticsbusinessarea' href='logisticsarea.jsp?operate=edit&folder=setting&logbusareaid="
									+ lba.getLogbusareaid() + "'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 更新物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "updateLogisticsbusinessarea", results = { @Result(name = "json", type = "json") })
	public String updateLogisticsbusinessarea() {
		LogisticsbusinessareaT lba = this.logisticsBAreaTService.findByPK(
				LogisticsbusinessareaT.class, this.getLogbusareaid());
		if (lba != null) {
			// lba.setLogisticsname(this.getLogisticsname().trim());
			lba.setCostway(this.getCostway().trim());
			lba.setNormalvalue(Double.parseDouble(this.getNormalvalue()));
			lba.setNormalcost(Double.parseDouble(this.getNormalcost()));
			lba.setOvervalue(Double.parseDouble(this.getOvervalue()));
			lba.setOvercost(Double.parseDouble(this.getOvercost()));
			lba.setSendarea(this.getSendarea().trim());
			lba.setState(this.getState());
			this.logisticsBAreaTService.update(lba);
			this.setSucflag(true);
		}
		return JSON;

	}

	/**
	 * 根据id获取物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "findLogisticsbusinessareaTById", results = { @Result(name = "json", type = "json") })
	public String findLogisticsbusinessareaTById() {
		if (StringUtils.isNotBlank(this.getLogbusareaid())) {
			beanlist = this.logisticsBAreaTService.findByPK(LogisticsbusinessareaT.class, this.getLogbusareaid());
			if (beanlist != null) {
				return JSON;
			}
		}
		return JSON;
	}

	/**
	 * 删除物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "delLogisticsbusinessarea", results = { @Result(name = "json", type = "json") })
	public String delLogisticsbusinessarea() {
		if (StringUtils.isNotBlank(this.getLogbusareaid())) {
			String[] strs = StringUtils.split(this.getLogbusareaid().trim(),
					StaticKey.SPLITDOT);
			for(String s:strs){
				LogisticsbusinessareaT lbt=this.logisticsBAreaTService.findByPK(LogisticsbusinessareaT.class, s);
				if(lbt!=null){
					this.logisticsBAreaTService.delete(lbt);
				}
			}
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}

	/**
	 * 禁止和开启物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "updateLogisticsbusinessareaBystate", results = { @Result(name = "json", type = "json") })
	public String updateLogisticsbusinessareaBystate() {
		if(StringUtils.isNotBlank(this.getLogbusareaid())&&StringUtils.isNotBlank(this.getState())){
			String[] strs = StringUtils.split(this.getLogbusareaid(), StaticKey.SPLITDOT);
			for(String s:strs){
				LogisticsbusinessareaT lbt=this.logisticsBAreaTService.findByPK(LogisticsbusinessareaT.class, s);
				if(lbt!=null){
					lbt.setState(this.getState());
					this.logisticsBAreaTService.update(lbt);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}
}
