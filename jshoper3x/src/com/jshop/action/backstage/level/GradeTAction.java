package com.jshop.action.backstage.level;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.GradeT;
import com.jshop.service.GradeTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class GradeTAction extends ActionSupport {
	private GradeTService gradeTService;
	private Serial serial;
	private String gradeid;
	private String gradevalue;
	private String gradename;
	private String needcost;
	private String discount;
	private Date createttime;
	private String creatorid;
	private GradeT bean = new GradeT();
	private List<GradeT>beanlist=new ArrayList<GradeT>();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private String usession;
	private boolean sucflag;
	@JSON(serialize = false)
	public GradeTService getGradeTService() {
		return gradeTService;
	}

	public void setGradeTService(GradeTService gradeTService) {
		this.gradeTService = gradeTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getGradeid() {
		return gradeid;
	}

	public void setGradeid(String gradeid) {
		this.gradeid = gradeid;
	}

	public String getGradevalue() {
		return gradevalue;
	}

	public void setGradevalue(String gradevalue) {
		this.gradevalue = gradevalue;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public String getNeedcost() {
		return needcost;
	}

	public void setNeedcost(String needcost) {
		this.needcost = needcost;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Date getCreatettime() {
		return createttime;
	}

	public void setCreatettime(Date createttime) {
		this.createttime = createttime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
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

	public GradeT getBean() {
		return bean;
	}

	public void setBean(GradeT bean) {
		this.bean = bean;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getUsession() {
		return usession;
	}

	public void setUsession(String usession) {
		this.usession = usession;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public List<GradeT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<GradeT> beanlist) {
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
	 * 增加用户等级信息
	 * 
	 * @return
	 */
	@Action(value = "addGradet", results = { @Result(name = "json", type = "json") })
	public String addGradet() {
		GradeT gt = new GradeT();
//		gt.setGradeid(this.getSerial().Serialid(Serial.GRADE));
//		gt.setGradevalue("0");
//		gt.setGradename(this.getGradename().trim());
//		gt.setNeedcost(Double.parseDouble(this.getNeedcost().trim()));
//		gt.setDiscount(Double.parseDouble(this.getDiscount().trim()));
//		gt.setCreatetime(BaseTools.systemtime());
//		gt.setCreatorid(BaseTools.adminCreateId());
		if (this.getGradeTService().addGradet(gt) > 0) {
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 查询所有用户等级设定信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "findAllGrade", results = { @Result(name = "json", type = "json") })
	public String findAllGrade() {
		int currentPage = page;
//		int lineSize = rp;
//		List<GradeT> list = this.getGradeTService().findAllGrade(currentPage,lineSize);
//		if (!list.isEmpty()) {
//			total = this.getGradeTService().countfindAllGrade();
//			rows.clear();
//			for (Iterator it = list.iterator(); it.hasNext();) {
//				GradeT gt = (GradeT) it.next();
//				Map cellMap = new HashMap();
//				cellMap.put("id", gt.getGradeid());
//				cellMap.put("cell",new Object[] {
//						gt.getGradename(), 
//						gt.getNeedcost(),
//						gt.getDiscount(),
//						BaseTools.formateDbDate(gt.getCreatetime()),
//						gt.getCreatorid() });
//				rows.add(cellMap);
//			}
//			return "json";
//		}
//		this.setTotal(0);
//		rows.clear();
		return "json";
	}

	/**
	 * 根据用户等级id获取用户等级设置信息
	 * 
	 * @return
	 */
	@Action(value = "findGradeById", results = { @Result(name = "json", type = "json") })
	public String findGradeById() {
		if (Validate.StrNotNull(this.getGradeid())) {
			bean = this.getGradeTService().findGradeById(this.getGradeid().trim());
			if (bean!= null) {
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 更新会员等级设置
	 * 
	 * @return
	 */
	@Action(value = "UpdateGradeById", results = { @Result(name = "json", type = "json") })
	public String UpdateGradeById() {
		GradeT gt = new GradeT();
//		gt.setGradeid(this.getGradeid().trim());
//		gt.setGradevalue("0");
//		gt.setGradename(this.getGradename().trim());
//		gt.setNeedcost(Double.parseDouble(this.getNeedcost().trim()));
//		gt.setDiscount(Double.parseDouble(this.getDiscount().trim()));
//		gt.setCreatetime(BaseTools.systemtime());
//		gt.setCreatorid(BaseTools.adminCreateId());
//		if(this.getGradeTService().updateGradeById(gt)>0){
//			this.setSucflag(true);
//			return "json";
//		}
		this.setSucflag(false);
		return "json";

	}
	/**
	 * 批量删除用户等级设置
	 * @return
	 */
	@Action(value = "delGradet", results = { @Result(name = "json", type = "json") })
	public String delGradet(){
		if(Validate.StrNotNull(this.getGradeid())){
			String []strs=StringUtils.split(this.getGradeid().trim(),',');
			if(this.getGradeTService().delGradet(strs)>0){
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
	 * 获取所有等级信息用于select控件
	 * @return
	 */
	@Action(value = "findAllGradeForselect", results = { @Result(name = "json", type = "json") })
	public String findAllGradeForselect(){
		List<GradeT>list=this.getGradeTService().findAllGrade();
		if(!list.isEmpty()){
			this.setSucflag(true);
			this.setBeanlist(list);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	
}
