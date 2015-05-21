package com.jshop.action.mall.backstage.order;

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
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderCreateTag;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderDeliverMode;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderIsInvoice;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderPayState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderShippingState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderState;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.OrderGroupT;
import com.jshop.entity.OrderT;
import com.jshop.service.OrderGroupTService;

@Namespace("")
@ParentPackage("jshop")
public class OrderGroupTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private OrderGroupTService orderGroupTService;
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String formateDeliveryTime;//格式化的发货时间
	
	private boolean sucflag;
	
	public String getFormateDeliveryTime() {
		return formateDeliveryTime;
	}
	public void setFormateDeliveryTime(String formateDeliveryTime) {
		this.formateDeliveryTime = formateDeliveryTime;
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
	 * 获取所有团购订单
	 * @return
	 */
	@Action(value="findAllOrderGroup",results={
			@Result(name="json",type="json")
	})
	public String findAllOrderGroup(){
		if(StringUtils.equals(StaticKey.SC, this.getQtype())){
			this.findDefaultAllOrderGroup();
		}else{
			if(StringUtils.equals("orderid", this.getQtype())){
				//根据订单id查询订单数据
				this.findOrderGroupByOrderid(this.getQuery());
			}
			if(StringUtils.equals("shippingusername", this.getQtype())){
				//根据收货人姓名查询订单数据
				this.findOrderGroupByShippingUsername(this.getQuery());
			}
		}
		return JSON;
	}
	
	/**
	 * 根据收货人查询订单数据
	 * @param query
	 */
	private void findOrderGroupByShippingUsername(String shippingusername) {
		int currentPage=page;
		int lineSize=rp;
		Criterion criterion=Restrictions.eq("shippingusername", shippingusername);
		Order order=Order.desc("createtime");
		total = this.orderGroupTService.count(OrderGroupT.class, criterion).intValue();
		List<OrderGroupT> list = this.orderGroupTService.findByCriteriaByPage(OrderGroupT.class, criterion, order, currentPage, lineSize);
		this.processOrderGroupList(list);
	}
	/**
	 * 根据订单号查询订单
	 * @param query
	 */
	private void findOrderGroupByOrderid(String orderid) {
		int currentPage=page;
		int lineSize=rp;
		Criterion criterion=Restrictions.eq("orderid", orderid);
		Order order=Order.desc("createtime");
		total=this.orderGroupTService.count(OrderGroupT.class, criterion).intValue();
		List<OrderGroupT>list=this.orderGroupTService.findByCriteriaByPage(OrderGroupT.class, criterion, order, currentPage, lineSize);
		this.processOrderGroupList(list);
	}
	
	/**
	 * 查询所有订单没有任何搜索条件
	 */
	private void findDefaultAllOrderGroup() {
		int currentPage=page;
		int lineSize=rp;
		total=this.orderGroupTService.count(OrderGroupT.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(),StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<OrderGroupT>list=this.orderGroupTService.findByCriteriaByPage(OrderGroupT.class, order, currentPage, lineSize);
			this.processOrderGroupList(list);
		}
	}
	private void processOrderGroupList(List<OrderGroupT> order) {
		for(Iterator<OrderGroupT>it=order.iterator();it.hasNext();){
			OrderGroupT o=it.next();
			//订单状态
			o.setOrderstate(OrderState.getName(o.getOrderstate()));
			//支付状态
			o.setPaystate(OrderPayState.getName(o.getPaystate()));
			//配送状态
			o.setShippingstate(OrderShippingState.getName(o.getShippingstate()));
			//订单开票状态
			o.setIsinvoice(OrderIsInvoice.getName(o.getIsinvoice()));
			//配送方式
			o.setDelivermode(OrderDeliverMode.getName(o.getDelivermode()));
			//订单类型
			o.setOrderTag(OrderCreateTag.getName(o.getOrderTag()));
			if(o.getDeliverytime()!=null){
				this.setFormateDeliveryTime(BaseTools.formateDbDate(o.getDeliverytime()));
			}else{
				this.setFormateDeliveryTime(StaticKey.EMPTY);
			}
			Map<String,Object> cellMap = new HashMap<String,Object>();
			cellMap.put("id", o.getOrderid());
			cellMap.put("cell", new Object[] {
					o.getOrderid(),
					"<a id='orderdetial' href='findOrderGroupDetail.action?orderid=" + o.getOrderid() + "' name='orderdetail'>" + o.getOrdername() + "</a>",
					o.getAmount(), 
					o.getNeedquantity(), 
					o.getMembername(), 
					o.getShippingusername(), 
					o.getPaymentname(), 
					o.getDelivermode(), 
					o.getOrderstate(), 
					o.getPaystate(), 
					o.getShippingstate(), 
					BaseTools.formateDbDate(o.getPurchasetime()), 
					this.getFormateDeliveryTime(), 
					o.getOrderTag(),
					o.getIsinvoice() });
			rows.add(cellMap);
		}
	}
	
	
	/**
	 * 获取已经付款切为发货的团购订单
	 * @return
	 */
	@Action(value="findAllTobeShippedOrderGroupHavapay",results={
			@Result(name="json",type="json")
	})
	public String findAllTobeShippedOrderGroupHavapay(){
		if(StringUtils.equals(StaticKey.SC, this.getQtype())){
			this.findDefaultAllHavaPayTobeShippedOrderGroup();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}
		}
		return JSON;
	}
	private void findDefaultAllHavaPayTobeShippedOrderGroup() {
		int currentPage=page;
		int lineSize=rp;
		String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM.getState();//配货中未发货
		String orderstate=OrderState.ORDERSTATE_CONFIRMED_ONE_NUM.getState();//订单状态已确认
		String paystate=OrderPayState.ORDERPAYSTATE_HAVEPAY_ONE_NUM.getState();//付款状态已支付
		Map<String, String>params=new HashMap<String,String>();
		params.put("orderstate", orderstate);
		params.put("shippingstate", shippingstate);
		params.put("paystate", paystate);
		Criterion criterion=Restrictions.allEq(params);
		Order order=Order.desc("updatetime");
		total=this.orderGroupTService.count(OrderGroupT.class, criterion).intValue();
		List<OrderGroupT>list=this.orderGroupTService.findByCriteriaByPage(OrderGroupT.class, criterion, order, currentPage, lineSize);
		this.processOrderGroupList(list);
	}
	
	
	
	
	
}
