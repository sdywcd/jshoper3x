package com.jshop.action.backstage.activity;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.entity.VouchersT;
import com.jshop.service.VouchersTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class VouchersTAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private VouchersTService vouchersTService;
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
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

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
		vt.setGivenmemberid(StaticString.EMPTY);
		vt.setVoucherstate(this.getVoucherstate());
		vt.setVoucheruseway(this.getVoucheruseway());
		vt.setState(StaticString.ZERO);
		vt.setCreatetime(BaseTools.systemtime());
		vt.setCreatorid(BaseTools.adminCreateId());
		this.getVouchersTService().save(vt);
		this.setSucflag(true);
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
				if (vt.getGivenmemberid().equals("")) {
					vt.setGivenmemberid("未分配");
				}
				Map cellMap = new HashMap();
				cellMap.put("id", vt.getVouchersid());
				cellMap.put("cell", new Object[] { "<input id='id' name='firstcol' class='firstvouchersid' type='checkbox' value='" + vt.getVouchersid() + "'></input>", vt.getVouchersname(), vt.getBegintime(), vt.getEndtime(), vt.getVoucherscontent(), vt.getLimitprice(), vt.getVoucherstate(), vt.getVoucheruseway(), vt.getState(), vt.getGivenmemberid(), vt.getCreatetime(), vt.getCreatorid() });
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
