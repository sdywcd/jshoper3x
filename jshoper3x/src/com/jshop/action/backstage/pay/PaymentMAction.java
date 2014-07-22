package com.jshop.action.backstage.pay;

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

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.PaymentM;
import com.jshop.service.PaymentMService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class PaymentMAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private PaymentMService paymentMService;
	private String paymentid;
	private String paymentname;
	private String paymentCode;
	private String paymentFree;
	private String paymentInterface;
	private String account;
	private String safecode;
	private String partnerid;
	private String des;
	private String isFast;
	private String state;
	private PaymentM bean = new PaymentM();
	private List<PaymentM>beanlist=new ArrayList<PaymentM>();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	@JSON(serialize = false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}

	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentname() {
		return paymentname;
	}

	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getPaymentFree() {
		return paymentFree;
	}

	public void setPaymentFree(String paymentFree) {
		this.paymentFree = paymentFree;
	}

	public String getPaymentInterface() {
		return paymentInterface;
	}

	public void setPaymentInterface(String paymentInterface) {
		this.paymentInterface = paymentInterface;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSafecode() {
		return safecode;
	}

	public void setSafecode(String safecode) {
		this.safecode = safecode;
	}

	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Map<String,Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String,Object>> rows) {
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

	public PaymentM getBean() {
		return bean;
	}

	public void setBean(PaymentM bean) {
		this.bean = bean;
	}

	public String getIsFast() {
		return isFast;
	}

	public void setIsFast(String isFast) {
		this.isFast = isFast;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public List<PaymentM> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<PaymentM> beanlist) {
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
	 * 增加支付方式
	 * 
	 * @return
	 */
	@Action(value = "addPayment", results = { @Result(name = "json", type = "json") })
	public String addPayment() {
		PaymentM pm = new PaymentM();
		pm.setPaymentid(this.getSerial().Serialid(Serial.PAYMENT));
		pm.setPaymentname(this.getPaymentname().trim());
		pm.setPaymentCode(this.getPaymentCode().trim());
		pm.setPaymentFree(this.getPaymentFree());
		pm.setPaymentInterface(this.getPaymentInterface());
		pm.setAccount(this.getAccount().trim());
		pm.setSafecode(this.getSafecode().trim());
		pm.setPartnerid(this.getPartnerid().trim());
		pm.setDes(this.getDes().trim());
		pm.setIsFast(this.getIsFast().trim());
		pm.setState(this.getState().trim());
		this.getPaymentMService().save(pm);
		this.setSucflag(true);
		return "json";
	}
	/**
	 * 增加支付方式
	 * 
	 * @return
	 */
	@Action(value = "updatePayment", results = { @Result(name = "json", type = "json") })
	public String updatePayment() {
		PaymentM pm = new PaymentM();
		pm.setPaymentid(this.getPaymentid());
		pm.setPaymentname(this.getPaymentname().trim());
		pm.setPaymentCode(this.getPaymentCode().trim());
		pm.setPaymentFree(this.getPaymentFree());
		pm.setPaymentInterface(this.getPaymentInterface());
		pm.setAccount(this.getAccount().trim());
		pm.setSafecode(this.getSafecode().trim());
		pm.setPartnerid(this.getPartnerid().trim());
		pm.setDes(this.getDes().trim());
		pm.setIsFast(this.getIsFast().trim());
		pm.setState(this.getState().trim());
		if (this.getPaymentMService().updatePayment(pm) > 0) {
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

	/**
	 *查询所有支付方式
	 * 
	 * @return
	 */
	@Action(value = "findAllPayment", results = { @Result(name = "json", type = "json") })
	public String findAllPayment() {
		if(StaticKey.SC.equals(this.getQtype())){
			this.findDefaultAllPayment();
		}else{
			if(Validate.StrisNull(this.getQuery())){
				return "json";
			}else{
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllPayment(){
		int currentPage=page;
		int lineSize=rp;
		total=this.getPaymentMService().countfindAllPayment();
		List<PaymentM> list = this.getPaymentMService().findAllPayment(currentPage, lineSize);
		this.ProcessPayment(list);
	}
	
	public void ProcessPayment(List<PaymentM>list){
		rows.clear();
		for (Iterator<PaymentM> it = list.iterator(); it.hasNext();) {
			PaymentM pm = (PaymentM) it.next();
			if (StaticKey.ONE.equals(pm.getPaymentInterface())) {
				pm.setPaymentInterface(StaticKey.INSTANTINTERFACE);
			} else if (StaticKey.TWO.equals(pm.getPaymentInterface())) {
				pm.setPaymentInterface(StaticKey.SECUREDINTERFACE);
			} else {
				pm.setPaymentInterface(StaticKey.STANDARD);
			}
			if(StaticKey.ONE.equals(pm.getIsFast())){
				pm.setIsFast(StaticKey.SUPPORT);
			}else{
				pm.setIsFast(StaticKey.UNSUPPORT);
			}
			pm.setState(StaticKey.DataUsingState.getName(pm.getState()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", pm.getPaymentid());
			cellMap.put("cell", new Object[] { pm.getPaymentname(), pm.getPaymentCode(), pm.getPaymentFree(), pm.getPaymentInterface(), pm.getDes(),pm.getIsFast(), pm.getState() });
			rows.add(cellMap);
		}
	}
	/**
	 * 开启支付方式
	 * 
	 * @return
	 */
	@Action(value = "openPayment", results = { @Result(name = "json", type = "json") })
	public String openPayment() {

		if (Validate.StrNotNull(this.getPaymentid())) {
			String[] strs = StringUtils.split(this.getPaymentid(), ",");
			if (this.getPaymentMService().openPayment(strs) > 0) {
				this.setSucflag(true);
				return "json";
			}
			return "json";
		}
		return "json";

	}

	/**
	 * 禁止支付方式
	 * 
	 * @return
	 */
	@Action(value = "closePayment", results = { @Result(name = "json", type = "json") })
	public String closePayment() {

		if (Validate.StrNotNull(this.getPaymentid())) {
			String[] strs = StringUtils.split(this.getPaymentid(), ",");
			if (this.getPaymentMService().closePayment(strs) > 0) {
				this.setSucflag(true);
				return "json";
			}
			return "json";
		}
		return "json";

	}

	/**
	 * 根据支付方式id获取支付方式
	 * 
	 * @return
	 */
	@Action(value = "findPaymentbyId", results = { @Result(name = "json", type = "json") })
	public String findPaymentbyId() {
		if (Validate.StrNotNull(this.getPaymentid())) {
			bean = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
			if (bean != null) {
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";

	}
	
	
	/**
	 * 禁止支付方式
	 * 
	 * @return
	 */
	@Action(value = "delPaymentByid", results = { @Result(name = "json", type = "json") })
	public String delPaymentByid() {

		if (Validate.StrNotNull(this.getPaymentid())) {
			String[] strs = StringUtils.split(this.getPaymentid(), ",");
			if (this.getPaymentMService().delPaymentByid(strs) > 0) {
				this.setSucflag(true);
				return "json";
			}
			return "json";
		}
		return "json";

	}
	
	
	/**
	 *  获取后台新增订单时所需要的支付方式信息
	 */
	@Action(value = "findAllPaymentForbsOrder", results = { @Result(name = "json", type = "json") })
	public String findAllPaymentForbsOrder(){
		beanlist=this.getPaymentMService().findAllPayment(StaticKey.ONE);
		if(!beanlist.isEmpty()){
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	
	
	
}
