package com.jshop.action.backstage.authority;
import java.util.ArrayList;
import java.util.Date;
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

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.RoleFunctionM;
import com.jshop.entity.RoleM;
import com.jshop.service.RoleFunctionMService;
import com.jshop.service.RoleMService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class RoleMAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private RoleMService roleMService;
	private RoleFunctionMService roleFunctionMService;
	private String id;
	private String rolename;
	private String note;
	private Date createtime;
	private String roleid;
	private String functionid;
	private String rolestr;
	private RoleM bean=new RoleM();
	private List<RoleFunctionM> rfmbean=new ArrayList<RoleFunctionM>();
	private Map<String,Object>map=new HashMap<String,Object>();
	private List<Map<String, Object>> rows=new ArrayList<Map<String, Object>>();
	private int rp;
	private int page=1;
	private int total=0;
	private String query;
	private String qtype;
	private boolean sucflag;
	
	@JSON(serialize = false)
	public RoleFunctionMService getRoleFunctionMService() {
		return roleFunctionMService;
	}
	public void setRoleFunctionMService(RoleFunctionMService roleFunctionMService) {
		this.roleFunctionMService = roleFunctionMService;
	}
	@JSON(serialize = false)
	public RoleMService getRoleMService() {
		return roleMService;
	}
	public void setRoleMService(RoleMService roleMService) {
		this.roleMService = roleMService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public RoleM getBean() {
		return bean;
	}
	public void setBean(RoleM bean) {
		this.bean = bean;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
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
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getFunctionid() {
		return functionid;
	}
	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}
	
	
	public List<RoleFunctionM> getRfmbean() {
		return rfmbean;
	}
	public void setRfmbean(List<RoleFunctionM> rfmbean) {
		this.rfmbean = rfmbean;
	}
	
	public String getRolestr() {
		return rolestr;
	}
	public void setRolestr(String rolestr) {
		this.rolestr = rolestr;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 增加角色
	 * @return
	 */
	@Action(value = "addRoleM", results = { @Result(name = "json", type = "json") })
	public String addRoleM(){
		RoleM rm=new RoleM();
		rm.setId(this.getSerial().Serialid(Serial.ROLE));
		rm.setRolename(this.getRolename());
		rm.setNote(this.getNote());
		rm.setCreatetime(BaseTools.systemtime());
		this.getRoleMService().save(rm);
		this.getRoleFunctionMService().addRoleFunctionM(rm,this.getFunctionid().trim());
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 获取所有角色
	 * @return
	 */
	@Action(value = "findAllRoleM", results = { @Result(name = "json", type = "json") })	
	public String findAllRoleM(){
		if("sc".equals(this.getQtype())){
			this.findDefaultAllRoleM();
		}else{
			return "json";
		}
		return "json";
		
	}
	
	public void findDefaultAllRoleM(){
		List<RoleM>list=this.getRoleMService().findAllRoleM();
		if(!list.isEmpty()){
			total=list.size();
			this.ProcessRoleMList(list);
		}
	}
	
	public void ProcessRoleMList(List<RoleM>list){
		for(Iterator<RoleM> it=list.iterator();it.hasNext();){
			RoleM rm=(RoleM)it.next();
			Map<String,Object>cellMap=new HashMap<String,Object>();
			cellMap.put("id", rm.getId());
			cellMap.put("cell", new Object[]{
				rm.getRolename(),
				rm.getNote(),
				BaseTools.formateDbDate(rm.getCreatetime()),
				"<a id='editrole' name='editrole' href='role.jsp?operate=edit&folder=setting&id="+rm.getId()+"'>[编辑]</a>"
			});
			rows.add(cellMap);
		}
	}
	
	/**
	 * 删除角色
	 * @return
	 */
	@Action(value = "delRoleM", results = { @Result(name = "json", type = "json") })	
	public String delRoleM(){
		if(Validate.StrNotNull(this.getId())){
			String []strs=StringUtils.split(this.getId(),",");
			if(this.getRoleMService().delRoleM(strs)>0){
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 根据id获取角色
	 * @return
	 */
	@Action(value = "findRoleMById", results = { @Result(name = "json", type = "json") })	
	public String findRoleMById(){
		if(Validate.StrNotNull(this.getId())){
			bean=this.getRoleMService().findRoleMById(this.getId());
			if(bean!=null){
				this.findAllRoleFunctionMByroleid(id);
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 获取当前角色的权限列表
	 * @param roleid
	 */
	public void findAllRoleFunctionMByroleid(String roleid){
		List<RoleFunctionM>list=this.getRoleFunctionMService().findAllRoleFunctionMByroleid(roleid);
		if(!list.isEmpty()){
			rfmbean=list;
		}
	}
	
	/**
	 * 更新角色权限
	 * @return
	 */
	@Action(value = "updateRoleM", results = { @Result(name = "json", type = "json") })	
	public String updateRoleM(){
		RoleM rm=new RoleM();
		rm.setId(this.getId());
		rm.setRolename(this.getRolename());
		rm.setNote(this.getNote());
		rm.setCreatetime(BaseTools.systemtime());
		this.getRoleMService().updateRoleM(rm);
		this.getRoleFunctionMService().delRoleFunctionM(this.getId());
		this.getRoleFunctionMService().addRoleFunctionM(rm, this.getFunctionid().trim());
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 获取所有角色用于前台select控件显示
	 * @return
	 */
	@Action(value = "findAllRoleForSelect", results = { @Result(name = "json", type = "json") })
	public String findAllRoleForSelect(){
		this.setRolestr("");
		List<RoleM>list=this.getRoleMService().findAllRoleM();
		if(!list.isEmpty()){
			this.setRolestr("<option value='0'>---请选择---</option>");
			for(Iterator<RoleM> it=list.iterator();it.hasNext();){
				RoleM rm=(RoleM)it.next();
				this.rolestr+="<option value='"+rm.getId()+"'>"+rm.getRolename()+"</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(true);
		return "json";
	}
	
	
	
	
	
	
	
	
	
}
