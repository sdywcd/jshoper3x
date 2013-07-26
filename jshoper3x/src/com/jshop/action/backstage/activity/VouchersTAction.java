package com.jshop.action.backstage.activity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.entity.VouchersT;
import com.jshop.service.VouchersTService;
import com.jshop.service.impl.VouchersTServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
public class VouchersTAction extends ActionSupport {
	@Resource
	private VouchersTService vouchersTService;
	@Resource
	private Serial serial;
	private String vouchersid;
	private String vouchersname;
	private String begintime;
	private String endtime;
	private String voucherscontent;
	private String limitprice;
	private String givenuserid;
	private String voucherstate;
	private String voucheruseway;
	private String state;
	private Date createtime;
	private String creatorid;
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean addvoucherflag = false;
	@JSON(serialize = false)
	public VouchersTService getVouchersTService() {
		return vouchersTService;
	}

	public void setVouchersTService(VouchersTService vouchersTService) {
		this.vouchersTService = vouchersTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getVouchersid() {
		return vouchersid;
	}

	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}

	public String getVouchersname() {
		return vouchersname;
	}

	public void setVouchersname(String vouchersname) {
		this.vouchersname = vouchersname;
	}

	public String getVoucherscontent() {
		return voucherscontent;
	}

	public void setVoucherscontent(String voucherscontent) {
		this.voucherscontent = voucherscontent;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getLimitprice() {
		return limitprice;
	}

	public void setLimitprice(String limitprice) {
		this.limitprice = limitprice;
	}

	public String getGivenuserid() {
		return givenuserid;
	}

	public void setGivenuserid(String givenuserid) {
		this.givenuserid = givenuserid;
	}

	public String getVoucherstate() {
		return voucherstate;
	}

	public void setVoucherstate(String voucherstate) {
		this.voucherstate = voucherstate;
	}

	public String getVoucheruseway() {
		return voucheruseway;
	}

	public void setVoucheruseway(String voucheruseway) {
		this.voucheruseway = voucheruseway;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	@JSON(name = "rows")
	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
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

	public boolean isAddvoucherflag() {
		return addvoucherflag;
	}

	public void setAddvoucherflag(boolean addvoucherflag) {
		this.addvoucherflag = addvoucherflag;
	}

	
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	public final static Date string2Time(String dateString) throws java.text.ParseException {

		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yy-MM-dd", Locale.CHINESE);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);
		Date dateTime = new Date(timeDate.getTime());
		return dateTime;
	}

	/**
	 * 增加抵用券
	 * 
	 * @return
	 * @throws ParseException
	 */
	@Action(value = "addVoucherst", results = { 
			@Result(name = "json",type="json")
	})
	public String addVoucherst() throws ParseException {
		String adminid = (String) ActionContext.getContext().getSession().get("adminid");
		if (adminid != null) {
			List<VouchersT> vlist = this.getVouchersTService().findVoucherstByName(this.getVouchersname().trim());
			if (vlist.size() > 0) {
				return "json";
			}
			VouchersT vt = new VouchersT();
			vt.setVouchersid(this.getSerial().Serialid(Serial.VOUCHERS));
			vt.setVouchersname(this.getVouchersname().trim());
			vt.setBegintime(this.getBegintime());
			vt.setEndtime(this.getEndtime());
			vt.setVoucherscontent(this.getVoucherscontent());
			vt.setLimitprice(Double.parseDouble(this.getLimitprice()));
			vt.setGivenuserid("");
			vt.setVoucherstate(this.getVoucherstate());
			vt.setVoucheruseway(this.getVoucheruseway());
			vt.setState("0");
			vt.setCreatetime(BaseTools.systemtime());
			vt.setCreatorid(adminid);
			if (this.getVouchersTService().addVoucherst(vt) > 0) {
				this.addvoucherflag = true;
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 查询所有优惠券
	 * 
	 * @return
	 */
	@Action(value = "findAllVoucherst", results = { 
			@Result(name = "json",type="json")
	})
	public String findAllVoucherst() {
		int currentPage = page;
		int lineSize = rp;
		List<VouchersT> list = this.getVouchersTService().findAllVoucherst(currentPage, lineSize);
		if (list != null) {
			total = this.getVouchersTService().countfindAllVoucherst();
			rows.clear();
			for (Iterator it = list.iterator(); it.hasNext();) {
				VouchersT vt = (VouchersT) it.next();
				if (vt.getState().equals("1")) {
					vt.setState("已使用");
				} else {
					vt.setState("未使用");
				}
				if (vt.getVoucherstate().equals("1")) {
					vt.setVoucherstate("金额");
				} else {
					vt.setVoucherstate("商品编号");
				}
				if (vt.getVoucheruseway().equals("1")) {
					vt.setVoucheruseway("赠送");
				} else {
					vt.setVoucheruseway("绑定商品编号");
				}
				if (vt.getGivenuserid().equals("")) {
					vt.setGivenuserid("未分配");
				}
				Map cellMap = new HashMap();
				cellMap.put("id", vt.getVouchersid());
				cellMap.put("cell", new Object[] { "<input id='id' name='firstcol' class='firstvouchersid' type='checkbox' value='" + vt.getVouchersid() + "'></input>", vt.getVouchersname(), vt.getBegintime(), vt.getEndtime(), vt.getVoucherscontent(), vt.getLimitprice(), vt.getVoucherstate(), vt.getVoucheruseway(), vt.getState(), vt.getGivenuserid(), vt.getCreatetime(), vt.getCreatorid() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 * 删除抵用券
	 * 
	 * @return
	 */
	@Action(value = "DelVoucherst", results = { 
			@Result(name = "json",type="json")
	})
	public String DelVoucherst() {
		if (this.getVouchersid() != null) {
			String[] array = this.getVouchersid().trim().split(",");
			if (this.getVouchersTService().delVoucherst(array) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	}
}
