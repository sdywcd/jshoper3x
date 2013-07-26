package com.jshop.action.backstage.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.SalegoodsT;
import com.jshop.service.SaleGoodsTService;
import com.jshop.service.SaleGoodsrecordService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 郭建波
 * 
 */
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})

public class SaleGoodsTAction extends ActionSupport {
	private SaleGoodsTService saleGoodsTService;
	private SaleGoodsrecordService saleGoodsrecordService; 
	private Serial serial;
	private String salegoodsid;
	private String salegoodsname;
	private String salegoodsnumber;
	private String salegoodspictureurl;
	private String salegoodsinformation;
	private String salegoodsstate;
	private Date begingtime;
	private Date endingtime;
	private String salepeople;
	private String salestartingprice;
	private String salejoinpeople;
	private String salebudget;
	private String realname;
	private String userid;
	private String saleprice;
	private String marketprice;
	private String newornot;
	private String salegoodsmessage;
	private String lowprice;
	private String manufacturer;
	private String place;
	private int total = 0;
	private int page = 1;
	private int rp;
	private SalegoodsT salelist = new SalegoodsT();
	private boolean salegoods = false;
	private String sortname;
	private String sortorder;
	private String qtype;
	public boolean flag;
	private String htmlpath;
	private List rows = new ArrayList();
 

	@JSON(serialize=false)
	public SaleGoodsrecordService getSaleGoodsrecordService() {
		return saleGoodsrecordService;
	}

	public void setSaleGoodsrecordService(
			SaleGoodsrecordService saleGoodsrecordService) {
		this.saleGoodsrecordService = saleGoodsrecordService;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	

	public boolean isSalegoods() {
		return salegoods;
	}

	public void setSalegoods(boolean salegoods) {
		this.salegoods = salegoods;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	@JSON(serialize = false)
	public SaleGoodsTService getSaleGoodsTService() {
		return saleGoodsTService;
	}

	public void setSaleGoodsTService(SaleGoodsTService saleGoodsTService) {
		this.saleGoodsTService = saleGoodsTService;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getSalegoodsid() {
		return salegoodsid;
	}

	public void setSalegoodsid(String salegoodsid) {
		this.salegoodsid = salegoodsid;
	}

	public String getSalegoodsname() {
		return salegoodsname;
	}

	public void setSalegoodsname(String salegoodsname) {
		this.salegoodsname = salegoodsname;
	}

	public String getSalegoodsnumber() {
		return salegoodsnumber;
	}

	public void setSalegoodsnumber(String salegoodsnumber) {
		this.salegoodsnumber = salegoodsnumber;
	}

	public String getSalegoodspictureurl() {
		return salegoodspictureurl;
	}

	public void setSalegoodspictureurl(String salegoodspictureurl) {
		this.salegoodspictureurl = salegoodspictureurl;
	}

	public String getSalegoodsinformation() {
		return salegoodsinformation;
	}

	public void setSalegoodsinformation(String salegoodsinformation) {
		this.salegoodsinformation = salegoodsinformation;
	}

	public String getSalegoodsstate() {
		return salegoodsstate;
	}

	public void setSalegoodsstate(String salegoodsstate) {
		this.salegoodsstate = salegoodsstate;
	}

	public Date getBegingtime() {
		return begingtime;
	}

	public void setBegingtime(Date begingtime) {
		this.begingtime = begingtime;
	}

	public Date getEndingtime() {
		return endingtime;
	}

	public void setEndingtime(Date endingtime) {
		this.endingtime = endingtime;
	}

	public String getSalepeople() {
		return salepeople;
	}

	public void setSalepeople(String salepeople) {
		this.salepeople = salepeople;
	}

	public String getSalestartingprice() {
		return salestartingprice;
	}

	public void setSalestartingprice(String salestartingprice) {
		this.salestartingprice = salestartingprice;
	}

	public String getSalejoinpeople() {
		return salejoinpeople;
	}

	public void setSalejoinpeople(String salejoinpeople) {
		this.salejoinpeople = salejoinpeople;
	}

	public String getSalebudget() {
		return salebudget;
	}

	public void setSalebudget(String salebudget) {
		this.salebudget = salebudget;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public SalegoodsT getSalelist() {
		return salelist;
	}

	public void setSalelist(SalegoodsT salelist) {
		this.salelist = salelist;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public String getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(String marketprice) {
		this.marketprice = marketprice;
	}

	public String getNewornot() {
		return newornot;
	}

	public void setNewornot(String newornot) {
		this.newornot = newornot;
	}

	public String getSalegoodsmessage() {
		return salegoodsmessage;
	}

	public void setSalegoodsmessage(String salegoodsmessage) {
		this.salegoodsmessage = salegoodsmessage;
	}

	public String getLowprice() {
		return lowprice;
	}

	public void setLowprice(String lowprice) {
		this.lowprice = lowprice;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public void validate() {
		this.clearErrorsAndMessages();
	}

	@Action(value = "addSalegoodsT", results = { @Result(name = "json", type = "json") })
	public String addSalegoodsT() {
		
		SalegoodsT salelist = new SalegoodsT();
		 String salegood=this.getSerial().Serialid(serial.SALEGOODST);
		salelist.setSalegoodsid(salegood);
		salelist.setBegingtime(this.getBegingtime());
		salelist.setEndingtime(this.getEndingtime());
		salelist.setRealname("");
		salelist.setSalegoodsinformation(this.getSalegoodsinformation().trim());
		salelist.setSalegoodsname(this.getSalegoodsname().trim());
		salelist.setSalegoodsnumber(this.getSalegoodsnumber().trim());
		salelist.setSalegoodspictureurl(this.getSalegoodspictureurl().trim());
	/*	if(this.getSalegoodsstate().equals("1")){
			
			SaleGoodsrecordT rlist=new SaleGoodsrecordT();
			rlist.setBegingtime(this.getBegingtime());
			rlist.setEmail("");
			rlist.setEndingtime(this.getEndingtime());
			rlist.setHiprice(Double.parseDouble("1"));
			rlist.setJoinnumber(0);
			rlist.setLowprice(Double.parseDouble(this.getLowprice()));
			rlist.setManufacturer(this.getManufacturer());
			rlist.setMarketprice(Double.parseDouble(this.getMarketprice()));
			rlist.setMobile("");
			rlist.setPlace(this.getPlace());
			rlist.setPoints("");
			rlist.setRealname("");
			rlist.setSalegoodsid(salegood);
			rlist.setSalegoodsinformation(this.getSalegoodsinformation());
			rlist.setSalegoodsmessage(this.getSalegoodsmessage());
			rlist.setSalegoodsname(this.getSalegoodsname());
			rlist.setSalegoodsnumber(this.getSalegoodsnumber());
			rlist.setSalegoodspictureurl(this.getSalegoodspictureurl());
			rlist.setSalepeople(this.getSalepeople());
			rlist.setSaleprice(0);
			rlist.setSalerecordid(this.getSerial().Serialid(serial.SALEGOODSRECORDT));
			rlist.setSalestartingprice(Double.parseDouble(this.getSalestartingprice()));
			rlist.setSaletradetime(new Date());
			rlist.setSex("");
			rlist.setTelno("");
			rlist.setUsername("");
			this.getSaleGoodsrecordService().addSaleGoodsrecord(rlist);
		
		}*/
		salelist.setSalegoodsstate(this.getSalegoodsstate());
		salelist.setSalejoinpeople(Integer.parseInt(this.getSalejoinpeople()));
		salelist.setSalepeople(this.getSalepeople());
		salelist.setSaleprice(0.0);
		salelist.setSalestartingprice(Double.parseDouble(this
				.getSalestartingprice()));
		salelist.setUserid("");
		salelist.setSalebudget("");
		salelist.setHtmlpath("");
		salelist.setLowprice(Double.parseDouble(this.getLowprice()));
		salelist.setManufacturer(this.getManufacturer());
		salelist.setMarketprice(Double.parseDouble(this.getMarketprice()));
		salelist.setNewornot(this.getNewornot());
		salelist.setSalegoodsmessage(this.getSalegoodsmessage());
		salelist.setPlace(this.getPlace());
		if (this.getSaleGoodsTService().addsalegoods(salelist) > 0) {
			this.setSalegoods(true);
			return "json";
		}
		return "json";

	}



	/**
	 * 处理迭代商品信息
	 * */
	public void ProcessSalegoodsTList(List<SalegoodsT> sgtList) {
		total = this.getSaleGoodsTService().countAllSalegoodsT();
		rows.clear();
		for (Iterator it = sgtList.iterator(); it.hasNext();) {
			SalegoodsT sgt = (SalegoodsT) it.next();
			if (sgt.getSalegoodsstate().equals("1")) {
				sgt.setSalegoodsstate("开启");
			} else {
				sgt.setSalegoodsstate("关闭");
			}
		/*		 if(sgt.getNewornot().equals("1")){
			sgt.setNewornot("是");
		}else{
			sgt.setNewornot("不是");
		}*/
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sgt.getSalegoodsid());
			cellMap.put("cell",new Object[] {

					        sgt.getSalegoodsname(), 
					        sgt.getSalegoodsnumber(),
							sgt.getSalegoodsstate(), 
							BaseTools.formateDbDate(sgt.getBegingtime()),
							BaseTools.formateDbDate(sgt.getEndingtime()),
							sgt.getSalepeople(),
							sgt.getSalestartingprice(),
							sgt.getSalejoinpeople(),
							sgt.getSaleprice(),
							sgt.getSalegoodspictureurl(),
							sgt.getMarketprice(),
							sgt.getNewornot(),
							sgt.getLowprice(),
							sgt.getPlace(),
							sgt.getManufacturer(),
							
							
							/*,
							sgt.getSalegoodsmessage()*/

					});

			rows.add(cellMap);
		}

	}

	/**
	 * 
	 * 获取默认所有拍卖商品信息
	 * 
	 * */
	public void defaultFindAllSalegoodT() {
		int currentPage = page;
		int lineSize = rp;
		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
			String queryString = "from SalegoodsT order by " + sortname + " "
					+ sortorder + "";
			List<SalegoodsT> list = this.getSaleGoodsTService()
					.sortAllSalegoods(currentPage, lineSize, queryString);
			if (!list.isEmpty()) {

				ProcessSalegoodsTList(list);

			}

		}

	}

	/**
	 * 
	 * 获取所有拍卖商品的信息
	 * */
	@Action(value = "findAllSalegoodsT", results = { @Result(name = "json", type = "json") })
	public String findAllSalegoodsT() {
		if(this.getQtype().equals("sc")){
			this.defaultFindAllSalegoodT();
		}else{
			if(Validate.StrisNull(this.getQtype())){
				return "json";
			}else{
				return "json";
			}
			
		}
		return "json";
	/*	this.defaultFindAllSalegoodT();
		return "json";
*/
	}
	
	@Action(value="findAllSalegoodsById",results={@Result(name="json",type="json")})
	public String findAllSalegoodsTById(){
		if(Validate.StrNotNull(this.getSalegoodsid())){
			salelist=this.getSaleGoodsTService().findsalegoodsById(this.getSalegoodsid().trim());
			if(salelist!=null){
				return "json";
			}
			
		}
		return "json";
	}
	public String findSalegoodsByState(){
		if(Validate.StrNotNull((this.getSalegoodsstate()))){
			salelist=(SalegoodsT) this.getSaleGoodsTService().findBysalegoodsState(this.getSalegoodsstate());
			if(salelist!=null){
				return "json";
			}
		}
		return "json";
	}
	@Action(value="updatesalegoodsT",results={@Result(name="json",type="json")})
	public String updatesalegoodsT(){
		SalegoodsT salelist = new SalegoodsT();
		
		salelist.setSalegoodsid(this.getSalegoodsid());
		salelist.setBegingtime(this.getBegingtime());
		salelist.setEndingtime(this.getEndingtime());
		salelist.setRealname("");
		salelist.setSalegoodsinformation(this.getSalegoodsinformation().trim());
		salelist.setSalegoodsname(this.getSalegoodsname().trim());
		salelist.setSalegoodsnumber(this.getSalegoodsnumber().trim());
		salelist.setSalegoodspictureurl(this.getSalegoodspictureurl().trim());
	/*	if(this.getSalegoodsstate().equals("1")){
			SaleGoodsrecordT rlist=new SaleGoodsrecordT();
			rlist.setBegingtime(this.getBegingtime());
			rlist.setEmail("");
			rlist.setEndingtime(this.getEndingtime());
			rlist.setHiprice(Double.parseDouble("1"));
			rlist.setJoinnumber(0);
			rlist.setLowprice(Double.parseDouble(this.getLowprice()));
			rlist.setManufacturer(this.getManufacturer());
			rlist.setMarketprice(Double.parseDouble(this.getMarketprice()));
			rlist.setMobile("");
			rlist.setPlace(this.getPlace());
			rlist.setPoints("");
			rlist.setRealname("");
			rlist.setSalegoodsid(this.getSalegoodsid());
			rlist.setSalegoodsinformation(this.getSalegoodsinformation());
			rlist.setSalegoodsmessage(this.getSalegoodsmessage());
			rlist.setSalegoodsname(this.getSalegoodsname());
			rlist.setSalegoodsnumber(this.getSalegoodsnumber());
			rlist.setSalegoodspictureurl(this.getSalegoodspictureurl());
			rlist.setSalepeople(this.getSalepeople());
			rlist.setSaleprice(0);
			rlist.setSalerecordid(this.getSerial().Serialid(serial.SALEGOODSRECORDT));
			rlist.setSalestartingprice(Double.parseDouble(this.getSalestartingprice()));
			rlist.setSaletradetime(new Date());
			rlist.setSex("");
			rlist.setTelno("");
			rlist.setUsername("");
			this.getSaleGoodsrecordService().addSaleGoodsrecord(rlist);
		
		}*/
		salelist.setSalegoodsstate(this.getSalegoodsstate());
		salelist.setSalejoinpeople(Integer.parseInt(this.getSalejoinpeople()));
		salelist.setSalepeople(this.getSalepeople());
		salelist.setSaleprice(0.0);
		salelist.setSalestartingprice(Double.parseDouble(this
				.getSalestartingprice()));
		salelist.setUserid("");
		salelist.setSalebudget("");
		salelist.setHtmlpath("");
		salelist.setLowprice(Double.parseDouble(this.getLowprice()));
		salelist.setManufacturer(this.getManufacturer());
		salelist.setMarketprice(Double.parseDouble(this.getMarketprice()));
		salelist.setNewornot(this.getNewornot());
		salelist.setSalegoodsmessage(this.getSalegoodsmessage());
		salelist.setPlace(this.getPlace());
		if (this.getSaleGoodsTService().updatesalegoods(salelist) > 0) {
			this.setSalegoods(true);
			return "json";
		}
		return "json";

	}
	@Action(value="deletesalegoodsT",results={@Result(name="json",type="json")})
	public String deletesalegoodsT(){
		if(Validate.StrNotNull(this.getSalegoodsid())){
			String[] s=this.getSalegoodsid().trim().split(",");
			this.getSaleGoodsTService().deletesalegoodsT(s);
			this.setFlag(true);
			return "json";
			
		}
		return "json";
			
		
	}
	/*
	 * @Action(value = "findAllSalegoodsT", results = { @Result(name = "json",
	 * type = "json") }) public String findAllSalegoodsT() {
	 * this.getSaleGoodsTService().findallsalegoods(page, rp); return "json"; }
	 */

}
