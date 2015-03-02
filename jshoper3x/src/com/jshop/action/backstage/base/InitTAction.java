package com.jshop.action.backstage.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.OrderT;
import com.jshop.entity.TemplatethemeT;
import com.jshop.service.OrderTService;
import com.jshop.service.TemplatethemeTService;
import com.opensymphony.xwork2.ActionContext;

@Namespace("")
@ParentPackage("jshop")
@Controller
public class InitTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private TemplatethemeTService templatethemeTService;
	@Resource
	private OrderTService orderTService;
	private TemplatethemeT tt;
	private boolean sucflag;
	private String logmsg;

	public TemplatethemeT getTt() {
		return tt;
	}

	public void setTt(TemplatethemeT tt) {
		this.tt = tt;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	public InitTAction() {
		tt = new TemplatethemeT();
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 初始化后台所需要的数据
	 * 
	 * @return
	 */
	public void InitDefaultThemeT() {
		try {
			String status =StaticKey.ONE;// 标示默认主题
			Criterion criterion=Restrictions.eq("status", status);
			tt=this.templatethemeTService.findOneByCriteria(TemplatethemeT.class, criterion);
			if (tt != null) {
				// 将启用的模板主题标示加入到服务器内存中
				if (!tt.getSign().isEmpty()) {
					ActionContext
							.getContext()
							.getApplication()
							.put(FreeMarkervariable.DEFAULTTHEMESIGN,
									tt.getSign());
				} else {
					// 如果没有默认的模板，那么启用默认主题模板
					tt.setSign("default");
					ActionContext
							.getContext()
							.getApplication()
							.put(FreeMarkervariable.DEFAULTTHEMESIGN,
									tt.getSign());
				}
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		} finally {
			this.setLogmsg("<p>默认主题获取成功</p>");
		}

	}

	/**
	 * 获取前5条需要发货的订单
	 * 
	 * @return
	 */
	public List<OrderT> findNewestOrders() {
		int currentPage = 1;
		int lineSize = 5;
		String shippingstate = StaticKey.SHIPPINGSTATE_NOT_DELIVER_ZERO_NUM;// 配货中未发货
		String orderstate = StaticKey.ORDERSTATE_ONE_NUM;// 订单状态已确认
		String paystate = StaticKey.PAYSTATE_ONE_NUM;// 付款状态已支付
		Map<String,Object>params=new HashMap<String, Object>();
		params.put("paystate", paystate);
		params.put("orderstate", orderstate);
		params.put("shippingstate", shippingstate);
		Criterion criterion=Restrictions.allEq(params);
		Order order=Order.desc("purchasetime");
		List<OrderT> list = this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		return list;
	}

}
