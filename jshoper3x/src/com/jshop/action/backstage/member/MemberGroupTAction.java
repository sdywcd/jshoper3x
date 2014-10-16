package com.jshop.action.backstage.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberGroupT;
import com.jshop.service.MemberGroupTService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class MemberGroupTAction extends BaseTAction{
	private static final long serialVersionUID = 1L;
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
	
	@JSON(serialize = false)
	public MemberGroupTService getMemberGroupTService() {
		return memberGroupTService;
	}
	public void setMemberGroupTService(MemberGroupTService memberGroupTService) {
		this.memberGroupTService = memberGroupTService;
	}
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
			mgt.setCreatetime(BaseTools.systemtime());
			mgt.setCreatorid(BaseTools.getAdminCreateId());
			mgt.setUpdatetime(mgt.getCreatetime());
			mgt.setVersiont(0);
			this.getMemberGroupTService().save(mgt);
			this.setSucflag(true);
			return "json";
		}
		return "json";
		
	}
	
	@Action(value = "findAllMemberGroupT", results = {@Result(name = "json",type="json")})
	public String findAllMemberGroupT(){
		if(StaticKey.SC.equals(this.getQtype())){
			this.findDefautlAllMemberGroup();
		
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return "json";
			}else{
				//TODO what you want other search
				return "json";
			}
		}
		return "json";
	}
	
	
	private void findDefautlAllMemberGroup() {
		int currentPage=page;
		int lineSize=rp;
		total=this.getMemberGroupTService().countfindAllMemberGroupT();
		List<MemberGroupT>list=this.getMemberGroupTService().findAllMemberGroupT(currentPage, lineSize);
		if(!list.isEmpty()){
			this.ProcessMemberGroupList(list);
		}
		
	}
	private void ProcessMemberGroupList(List<MemberGroupT> list) {
		for(Iterator<MemberGroupT> it=list.iterator();it.hasNext();){
			MemberGroupT mgt=(MemberGroupT)it.next();
			mgt.setStatus(StaticKey.DataUsingState.getName(mgt.getStatus()));
			Map<String, Object>cellMap=new HashMap<String, Object>();
			cellMap.put("id", mgt.getId());
			cellMap.put("cell", new Object[]{
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
			return "json";
		}
		bean=this.getMemberGroupTService().findMemberGroupTById(this.getId().trim());
		if(bean!=null){
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	/**
	 * 更新会员分组
	 * @return
	 */
	@Action(value = "updateMemberGroupT", results = {@Result(name = "json",type="json")})
	public String updateMemberGroupT(){
		if(StringUtils.isBlank(this.getId())){
			return "json";
		}
		bean=this.getMemberGroupTService().findMemberGroupTById(this.getId().trim());
		if(bean!=null){
			bean.setName(this.getName().trim());
			bean.setStatus(this.getStatus().trim());
			bean.setUpdatetime(BaseTools.systemtime());
			bean.setVersiont(bean.getVersiont()+1);
			bean.setAttrs(this.getAttrs());
			this.getMemberGroupTService().updateMemberGroupT(bean);
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	/**
	 * 批量删除会员分组
	 * @return
	 */
	@Action(value = "delMemberGroupT", results = {@Result(name = "json",type="json")})
	public String delMemberGroupT(){
		if(StringUtils.isBlank(this.getId())){
			return "json";
		}
		String []strs=StringUtils.split(this.getId(), ",");
		if(this.getMemberGroupTService().delMemberGroupT(strs)>0){
			this.setSucflag(true);
			return "json";
		}
		return "json";
		
	}
//	/**
//	 * 获取所有可用会员分组
//	 * @return
//	 */
//	@Action(value = "delMemberGroupT", results = {@Result(name = "json",type="json")})
//	public String findAllMemberGroupT4Select(){
//		
//	}
//	
	
	
	
	
}
