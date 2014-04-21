package com.jshop.action.backstage.authority;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.FunctionM;
import com.jshop.entity.RoleFunctionM;
import com.jshop.entity.RoleM;
import com.jshop.entity.UserRoleM;
import com.jshop.service.FunctionMService;
import com.jshop.service.RoleFunctionMService;
import com.jshop.service.RoleMService;
import com.jshop.service.UserRoleMService;
@Namespace("")
@ParentPackage("jshop")  
@Controller("userRoleMAction")
public class UserRoleMAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private UserRoleMService userRoleMService;
	private FunctionMService functionMService;
	private RoleFunctionMService roleFunctionMService;
	private RoleMService roleMService;
	private String userid;
	private String roleid;
	private UserRoleM urm=new UserRoleM();
	private RoleM bean=new RoleM();
	private boolean sucflag;
	
	@JSON(serialize = false)
	public FunctionMService getFunctionMService() {
		return functionMService;
	}
	public void setFunctionMService(FunctionMService functionMService) {
		this.functionMService = functionMService;
	}
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
	@JSON(serialize = false)
	public UserRoleMService getUserRoleMService() {
		return userRoleMService;
	}
	public void setUserRoleMService(UserRoleMService userRoleMService) {
		this.userRoleMService = userRoleMService;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	
	public UserRoleM getUrm() {
		return urm;
	}
	public void setUrm(UserRoleM urm) {
		this.urm = urm;
	}
	
	
	public RoleM getBean() {
		return bean;
	}
	public void setBean(RoleM bean) {
		this.bean = bean;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 增加用户的角色
	 * @return
	 */
	@Action(value = "addUserRoleM", results = { 
			@Result(name = "json",type="json")
	})
	public String addUserRoleM(){
		if(Validate.StrNotNull(this.getUserid())){
			UserRoleM urm=new UserRoleM();
			urm.setId(this.getUserid());
			urm.setRoleid(this.getRoleid());
			urm.setUserid(this.getUserid());
			this.getUserRoleMService().save(urm);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 根据用户id获取角色列表，用于查看用户角色
	 * @return
	 */
	@Action(value = "findUserRoleMByuserid", results = { 
			@Result(name = "json",type="json")
	})
	public String findUserRoleMByuserid(){
		if(Validate.StrNotNull(this.getUserid())){
			List<UserRoleM>list=this.getUserRoleMService().findUserRoleMByuserid(this.getUserid().trim());
			if(!list.isEmpty()){
				urm=list.get(0);
				bean=this.getRoleMService().findRoleMById(urm.getRoleid());
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
	 * 获取用户可操作的权限
	 * @param userid
	 * @return
	 */
	public List<FunctionM> findUserRoleFunctionList(String userid){
		List<UserRoleM>umlist=this.getUserRoleMService().findUserRoleMByuserid(userid);
		List<RoleFunctionM>list=this.getRoleFunctionMService().findAllRoleFunctionMByroleid(umlist.get(0).getRoleid());
		FunctionM fm=new FunctionM();
		List<FunctionM>userfunctionlist=new ArrayList<FunctionM>();
		for(Iterator<RoleFunctionM> it=list.iterator();it.hasNext();){
			RoleFunctionM rfm=(RoleFunctionM)it.next();
			fm=this.getFunctionMService().findFunctionMById(rfm.getFunctionid());
			userfunctionlist.add(fm);
		}
		return userfunctionlist;
	}
	
}
