package com.jshop.action.backstage.logistics;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.PrintExpressParam;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.ExpresstempleteT;
import com.jshop.entity.OrderT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.service.ExpresstempleteTService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.OrderTService;
import com.jshop.service.ShippingAddressTService;
@Namespace("")
@ParentPackage("jshop")
public class PrintExpressSingleTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private ExpresstempleteTService expresstempleteTService;
	private OrderTService orderTService;
	private JshopbasicInfoTService jshopbasicInfoTService;
	private ShippingAddressTService shippingAddressTService;
	private String orderid;
	private PrintExpressParam pe = new PrintExpressParam();
	private String logisticsid;
	private boolean sprintexpressflag = false;

	
	@JSON(serialize = false)
	public ExpresstempleteTService getExpresstempleteTService() {
		return expresstempleteTService;
	}

	public void setExpresstempleteTService(ExpresstempleteTService expresstempleteTService) {
		this.expresstempleteTService = expresstempleteTService;
	}
	@JSON(serialize = false)
	public OrderTService getOrderTService() {
		return orderTService;
	}

	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}
	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}

	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}
	@JSON(serialize = false)
	public ShippingAddressTService getShippingAddressTService() {
		return shippingAddressTService;
	}

	public void setShippingAddressTService(ShippingAddressTService shippingAddressTService) {
		this.shippingAddressTService = shippingAddressTService;
	}
	
	public PrintExpressParam getPe() {
		return pe;
	}

	public void setPe(PrintExpressParam pe) {
		this.pe = pe;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public boolean isSprintexpressflag() {
		return sprintexpressflag;
	}

	public void setSprintexpressflag(boolean sprintexpressflag) {
		this.sprintexpressflag = sprintexpressflag;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取商家信息作为快递单内容
	 */
	public void GetJshopSendInfo() {
		//		JshopbasicInfoT jbi=this.getJshopbasicinfotserviceimpl().findJshopbasicInfoSingleForExpress();
		//		if(jbi!=null){
		//			pe.setSendName(jbi.getSendName());
		//			pe.setSendCountry(jbi.getSendCountry());
		//			pe.setSendProvince(jbi.getSendProvince());
		//			pe.setSendCity(jbi.getSendCity());
		//			pe.setSendDistrict(jbi.getSendDistrict());
		//			pe.setSendStreet(jbi.getSendStreet());
		//			pe.setSendTelno(jbi.getSendTelno());
		//			pe.setSendMobile(jbi.getSendMobile());
		//			pe.setSendContactor(jbi.getSendContactor());
		//		}
	}

	/**
	 * 获取订单发货地址
	 * 
	 * @param orderid
	 */
	public void GetOrderShippingAddress(String orderid) {
		ShippingAddressT st = this.getShippingAddressTService().findShippingAddressByOrderid(orderid, "1");
		if (st != null) {
			pe.setRecipientName(st.getShippingusername());
			pe.setRecipientCountry(st.getCountry());
			pe.setRecipientProvince(st.getProvince());
			pe.setRecipientCity(st.getCity());
			pe.setRecipientDistrict(st.getDistrict());
			pe.setRecipientStreet(st.getStreet());
			pe.setRecipientTelno(st.getTelno());
			pe.setRecipientMobile(st.getMobile());
			pe.setRecipientPostcode(st.getPostcode());
			pe.setRecipientContactor(st.getShippingusername());//可能有问题要根据具体业务来
		}
	}

	public void GetChangeTime(Date t) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh-yy-ss");
		String time = formatter.format(t.getTime()).toString();
		String[] temptime = time.split("-");
		pe.setYear(temptime[0]);
		pe.setMonth(temptime[1]);
		pe.setDay(temptime[2]);
		pe.setHour(temptime[3]);
		pe.setMinutes(temptime[4]);
	}

	/**
	 *根据id获取订单详细
	 * 
	 * @param orderid
	 */
	public void GetOrderDetailByOrderId(String orderid) {
		OrderT o = this.getOrderTService().findOrderDetailByorderid(orderid);
		if (o != null) {
			pe.setQuantity(o.getNeedquantity()+"");
			pe.setNotes(o.getCustomerordernotes());
			pe.setLogisticsid(o.getLogisticsid());
			GetChangeTime(Date.valueOf(o.getPurchasetime().toString()));//这里修改了
		}
	}

	/**
	 * 读取快递单模板
	 */
	public void GetPrintExpressValue() {
		ExpresstempleteT et = this.getExpresstempleteTService().findExpresstempleteByLogisticsid(pe.getLogisticsid());
		if (et != null) {
			pe.setKindeditorCode(et.getKindeditorCode());
			pe.setRighttag("勾");//需要用图片代替勾符号
		}
	}

	/**
	 * 初始化快递单打印数据
	 * 
	 * @return
	 */
	@Action(value = "InitPrintExpress", results = { 
			@Result(name = "json",type="json")
	})
	public String InitPrintExpress() {
		if (Validate.StrNotNull(this.getOrderid())) {
			GetJshopSendInfo();
			GetOrderShippingAddress(this.getOrderid().trim());
			GetOrderDetailByOrderId(this.getOrderid().trim());
			this.setSprintexpressflag(true);
			//设定模板值
			GetPrintExpressValue();
			return "json";
		} else {
			this.setSprintexpressflag(false);
			return "json";
		}
	}
}
