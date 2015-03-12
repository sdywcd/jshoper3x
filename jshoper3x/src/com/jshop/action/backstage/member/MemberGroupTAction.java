package com.jshop.action.backstage.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Order;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberGroupT;
import com.jshop.service.MemberGroupTService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class MemberGroupTAction extends BaseTAction{
	private static final long serialVersionUID = 1L;
	@Resource
	private MemberGroupTService memberGroupTService;
	private String id;
	private String name;
	private String status;
	private Date createtime;
	private String creatorid;
	private Date updatetime;
	private Integer versiont;
	private String attrs;
	private MemberGroupT bean=new MemberGroupT();
	private List<Map<String,Object>> rows=new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getVersiont() {
		return versiont;
	}
	public void setVersiont(Integer versiont) {
		this.versiont = versiont;
	}
	public String getAttrs() {
		return attrs;
	}
	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	public MemberGroupT getBean() {
		return bean;
	}
	public void setBean(MemberGroupT bean) {
		this.bean = bean;
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
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 增加会员分组
	 * @return
	 */
	@Action(value = "saveMemberGroupT", results = { @Result(name = "json", type = "json") })
	public String saveMemberGroupT(){
		if(StringUtils.isNotBlank(this.getName())){
			MemberGroupT mgt=new MemberGroupT();
			mgt.setId(this.getSerial().Serialid(Serial.MEMBERGROUP));
			mgt.setName(this.getName().trim());
			mgt.setStatus(this.getStatus());
			mgt.setAttrs(this.getAttrs());
			mgt.setCreatetime(BaseTools.getSystemTime());
			mgt.setCreatorid(BaseTools.getAdminCreateId());
			mgt.setUpdatetime(mgt.getCreatetime());
			mgt.setVersiont(0);
			mgt.setShopid(BaseTools.getShopId());
			mgt.setShopname(BaseTools.getShopName());
			this.memberGroupTService.save(mgt);
			this.setSucflag(true);
		}
		return JSON;
		
	}
	
	@Action(value = "findAllMemberGroupT", results = {@Result(name = "json",type="json")})
	public String findAllMemberGroupT(){
		if(StringUtils.equals(StaticKey.SC, this.getQtype())){
			this.findDefautlAllMemberGroup();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}else{
				//TODO what you want other search
				return JSON;
			}
		}
		return JSON;
	}
	
	
	private void findDefautlAllMemberGroup() {
		int currentPage=page;
		int lineSize=rp;
		total=this.memberGroupTService.count(MemberGroupT.class).intValue();
		Order order=Order.desc("createtime");
		List<MemberGroupT>list=this.memberGroupTService.findByCriteriaByPage(MemberGroupT.class, order, currentPage, lineSize);
		if(!list.isEmpty()){
			this.processMemberGroupList(list);
		}
		
	}
	private void processMemberGroupList(List<MemberGroupT> list) {
		for(Iterator<MemberGroupT> it=list.iterator();it.hasNext();){
			MemberGroupT mgt=(MemberGroupT)it.next();
			mgt.setStatus(DataUsingState.getName(mgt.getStatus()));
			Map<String, Object>cellMap=new HashMap<String, Object>();
			cellMap.put("id", mgt.getId());
			cellMap.put("cell", new Object[]{
				mgt.getShopname(),
				mgt.getName(),
				mgt.getStatus(),
				BaseTools.formateDbDate(mgt.getCreatetime()),
				mgt.getCreatorid(),
				"<a id='editmembergroup' href='membergroup.jsp?operate=edit&folder=member&id="+mgt.getId()+"' name='editmembergroup'>[编辑]</a>"
			});
			rows.add(cellMap);
		}
	}
	
	/**
	 * 根据主键id获取用户分组
	 * @return
	 */
	@Action(value = "findMemberGroupTById", results = {@Result(name = "json",type="json")})
	public String findMemberGroupTById(){
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		bean=this.memberGroupTService.findByPK(MemberGroupT.class, this.getId());
		if(bean!=null){
			this.setSucflag(true);
		}
		return JSON;
	}
	
	/**
	 * 更新会员分组
	 * @return
	 */
	@Action(value = "updateMemberGroupT", results = {@Result(name = "json",type="json")})
	public String updateMemberGroupT(){
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		bean=this.memberGroupTService.findByPK(MemberGroupT.class, this.getId());
		if(bean!=null){
			bean.setName(this.getName().trim());
			bean.setStatus(this.getStatus().trim());
			bean.setUpdatetime(BaseTools.getSystemTime());
			bean.setVersiont(bean.getVersiont()+1);
			bean.setAttrs(this.getAttrs());
			bean.setShopid(BaseTools.getShopId());
			bean.setShopname(BaseTools.getShopName());
			this.memberGroupTService.update(bean);
			this.setSucflag(true);
		}
		return JSON;
	}
	
	/**
	 * 批量删除会员分组
	 * @return
	 */
	@Action(value = "delMemberGroupT", results = {@Result(name = "json",type="json")})
	public String delMemberGroupT(){
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		String []strs=StringUtils.split(this.getId(), StaticKey.SPLITDOT);
		for(String s:strs){
			MemberGroupT mgt=this.memberGroupTService.findByPK(MemberGroupT.class, s);
			if(mgt!=null){
				this.memberGroupTService.delete(mgt);
			}
		}
		this.setSucflag(true);
		return JSON;
	}

	
}
