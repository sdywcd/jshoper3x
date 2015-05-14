package com.jshop.action.mall.backstage.authority;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import com.jshop.action.mall.backstage.base.BaseTAction;
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
	@Resource
	private UserRoleMService userRoleMService;
	@Resource
	private FunctionMService functionMService;
	@Resource
	private RoleFunctionMService roleFunctionMService;
	@Resource
	private RoleMService roleMService;
	private String userid;
	private String roleid;
	private UserRoleM urm=new UserRoleM();
	private RoleM bean=new RoleM();
	private boolean sucflag;
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
		if(StringUtils.isNotBlank(this.getUserid())){
			UserRoleM urm=new UserRoleM();
			urm.setId(this.getUserid());
			urm.setRoleid(this.getRoleid());
			urm.setUserid(this.getUserid());
			this.userRoleMService.saveOrUpdate(urm);
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
		if(StringUtils.isNotBlank(this.getUserid())){
			Criterion criterion=Restrictions.eq("userid", this.getUserid());
			Order order=Order.asc("userid");
			List<UserRoleM>list=this.userRoleMService.findByCriteria(UserRoleM.class, criterion,order);
			if(!list.isEmpty()){
				urm=list.get(0);
				Criterion criterion2=Restrictions.eq("roleid", urm.getRoleid());
				Order order2=Order.asc("roleid");
				List<RoleM>uList=this.roleMService.findByCriteria(RoleM.class, criterion2,order2);
				if(!uList.isEmpty()){
					bean=uList.get(0);
					this.setSucflag(true);
					return "json";
				}
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
		Criterion criterion=Restrictions.eq("userid", this.getUserid());
		Order order=Order.asc("userid");
		List<UserRoleM>umlist=this.userRoleMService.findByCriteria(UserRoleM.class, criterion,order);
		Criterion criterion2=Restrictions.eq("roleid", urm.getRoleid());
		Order order2=Order.asc("roleid");
		List<RoleFunctionM>list=this.roleFunctionMService.findByCriteria(RoleFunctionM.class, criterion2,order2);
		List<FunctionM>userfunctionlist=new ArrayList<FunctionM>();
		for(Iterator<RoleFunctionM> it=list.iterator();it.hasNext();){
			FunctionM fm=new FunctionM();
			RoleFunctionM rfm=(RoleFunctionM)it.next();
			Criterion criterion3=Restrictions.eq("functionid", rfm.getFunctionid());
			Order order3=Order.asc("functionid");
			List<FunctionM>fmlist=this.functionMService.findByCriteria(FunctionM.class, criterion3,order3);
			if(fmlist!=null&&fmlist.size()>0){
				fm=fmlist.get(0);
			}
			userfunctionlist.add(fm);
		}
		return userfunctionlist;
	}
	
}
