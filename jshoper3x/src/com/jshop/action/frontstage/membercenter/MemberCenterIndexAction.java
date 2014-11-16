package com.jshop.action.frontstage.membercenter;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.PageModel;
import com.jshop.action.backstage.utils.order.AllOrderState;
import com.jshop.action.backstage.utils.statickey.StaticKey;

import com.jshop.entity.GoodsT;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderT;
import com.jshop.entity.UserT;
import com.jshop.service.GoodsTService;
import com.jshop.service.OrderTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.emory.mathcs.backport.java.util.Collections;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({
    @InterceptorRef("defaultStack")  
})
public class MemberCenterIndexAction extends ActionSupport {

	private String hidurl;
	private DataCollectionTAction dataCollectionTAction;
	private MemberCenterOrderAction userCenterMyorderAction;
	private OrderTService orderTService;
	private GoodsTService goodsTService;
	private int rp=8;//每页显示数量
	private int page=1;
	private int total=0;
	private int totalpage=1;
	
	
	private boolean slogin;
	@JSON(serialize=false) 
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	@JSON(serialize=false) 
	public OrderTService getOrderTService() {
		return orderTService;
	}

	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}
	@JSON(serialize=false) 
	public MemberCenterOrderAction getUserCenterMyorderAction() {
		return userCenterMyorderAction;
	}

	public void setUserCenterMyorderAction(MemberCenterOrderAction userCenterMyorderAction) {
		this.userCenterMyorderAction = userCenterMyorderAction;
	}
	@JSON(serialize=false) 
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
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

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 初始化用户中心
	 * 
	 * @return
	 */
	@Action(value = "initMcIndex", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/memberindex.ftl"),
			@Result(name = "input",location = "/html/default/shop/user/login.html")
	})
	public String InitMemberCenterIndex() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取最近的订单信息
			this.findAllUserOrderOn(memberT.getId());
			
			//乱序获取推荐商品
			//this.shuffleGoods();
			this.getDataCollectionTAction().putBaseInfoToContext();
			return SUCCESS;
		}
		return INPUT;
	}
	
	/**
	 * 获取用户未处理的订单只获取前30条
	 */
	public void findAllUserOrderOn(String memberid){
		int currentPage=page;
		int lineSize=rp;
		List<OrderT>list=this.getOrderTService().findAllOrderByorderstateForOn(currentPage, lineSize, memberid, AllOrderState.ORDERSTATE_EIGHT_NUM, AllOrderState.PAYSTATE_TWO_NUM, AllOrderState.SHIPPINGSTATE_TWO_NUM);
	
		total=this.getOrderTService().countfindAllOrderByorderstateForOn(memberid, AllOrderState.ORDERSTATE_EIGHT, AllOrderState.PAYSTATE_TWO_NUM, AllOrderState.SHIPPINGSTATE_TWO_NUM);
		PageModel<OrderT>pm=new PageModel<>(currentPage, lineSize, list, total);
		String action=this.getDataCollectionTAction().getBasePath()+"/initMcIndex.action?";
		ActionContext.getContext().put("actionlink", action);
		ActionContext.getContext().put("sign", "disstatic");
		ActionContext.getContext().put("goods", pm);
		ActionContext.getContext().put(FreeMarkervariable.MEMBERORDERON,list);
		ActionContext.getContext().put("totalgoods",pm.getTotalRecord());
		ActionContext.getContext().put("totalpage",pm.getTotalpage());
	

		
	}
	
	/**
	 * 乱序获取商品
	 */
	public void shuffleGoods(){
		int currentPage=1;
		int lineSize=8;
		String salestate="1";
		String recommended="1";
		List<GoodsT>list=this.getGoodsTService().findshuffleGoods(currentPage, lineSize, salestate, recommended);
		Collections.shuffle(list);
		ActionContext.getContext().put("shufflerecommendgoods", list);
	}

	
	

}
