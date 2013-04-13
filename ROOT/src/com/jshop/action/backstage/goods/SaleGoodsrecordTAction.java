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
import com.jshop.entity.SaleGoodsrecordT;
import com.jshop.service.SaleGoodsrecordService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class SaleGoodsrecordTAction extends ActionSupport {
	private SaleGoodsrecordService saleGoodsrecordService;
	private String salerecordid;
	private String username;
	private String realname;
	private String salegoodsnumber;
	private String salegoodsname;
	private String salestartingprice;
	private Date saletradetime;
	private String saleprice;
	private String salepeople;
	private String telno;
	private String mobile;
	private String sex;
	private String email;
	private String points;
	private String hiprice;
	private int total=0;
	private int page=1;
	private int rp;
	private SaleGoodsrecordT recordlist=new SaleGoodsrecordT();
	private boolean recordgoods=false;
	private String sortname;
	private String sortorder;
	private String qtype;
	private boolean flag;
	private Serial serial;
	private String joinnumber;
	private String marketprice;
	private String salegoodsid;
	private String salegoodspictureurl;
	private String salegoodsinformation;
	private Date begingtime;
	private Date endingtime;
	private String salegoodsmessage;
	private String lowprice;
	private String place;
	private String manufacturer;
	private List rows = new ArrayList();
	
	public String getJoinnumber() {
		return joinnumber;
	}
	public void setJoinnumber(String joinnumber) {
		this.joinnumber = joinnumber;
	}
	public String getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(String marketprice) {
		this.marketprice = marketprice;
	}
	public String getSalegoodsid() {
		return salegoodsid;
	}
	public void setSalegoodsid(String salegoodsid) {
		this.salegoodsid = salegoodsid;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	public String getSalerecordid() {
		return salerecordid;
	}
	@JSON(serialize=false)
	public SaleGoodsrecordService getSaleGoodsrecordService() {
		return saleGoodsrecordService;
	}
	public void setSaleGoodsrecordService(
			SaleGoodsrecordService saleGoodsrecordService) {
		this.saleGoodsrecordService = saleGoodsrecordService;
	}
	public void setSalerecordid(String salerecordid) {
		this.salerecordid = salerecordid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSalegoodsnumber() {
		return salegoodsnumber;
	}
	public void setSalegoodsnumber(String salegoodsnumber) {
		this.salegoodsnumber = salegoodsnumber;
	}
	public String getSalegoodsname() {
		return salegoodsname;
	}
	public void setSalegoodsname(String salegoodsname) {
		this.salegoodsname = salegoodsname;
	}
	public String getSalestartingprice() {
		return salestartingprice;
	}
	public void setSalestartingprice(String salestartingprice) {
		this.salestartingprice = salestartingprice;
	}
	public Date getSaletradetime() {
		return saletradetime;
	}
	public void setSaletradetime(Date saletradetime) {
		this.saletradetime = saletradetime;
	}
	public String getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}
	public String getSalepeople() {
		return salepeople;
	}
	public void setSalepeople(String salepeople) {
		this.salepeople = salepeople;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getHiprice() {
		return hiprice;
	}
	public void setHiprice(String hiprice) {
		this.hiprice = hiprice;
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
	public SaleGoodsrecordT getRecordlist() {
		return recordlist;
	}
	public void setRecordlist(SaleGoodsrecordT recordlist) {
		this.recordlist = recordlist;
	}
	public boolean isRecordgoods() {
		return recordgoods;
	}
	public void setRecordgoods(boolean recordgoods) {
		this.recordgoods = recordgoods;
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
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
/*	@Action(value="addsalegoodsrecordt",results={@Result(name="json",type="json")})
	public String addsalegoodsrecordt(){
		SaleGoodsrecordT salegoodsrecordt=new SaleGoodsrecordT();
		salegoodsrecordt.setSalerecordid(this.getSerial().Serialid(serial.SALEGOODSRECORDT));
		salegoodsrecordt.setUsername(this.getUsername());
		salegoodsrecordt.setRealname(this.getRealname());
		salegoodsrecordt.setSalegoodsnumber(this.getSalegoodsnumber());
		salegoodsrecordt.setSalegoodsname(this.getSalegoodsname());
		salegoodsrecordt.setSalestartingprice(Double.parseDouble(this.getSalestartingprice()));
	    salegoodsrecordt.setSaletradetime(this.getSaletradetime());
	    salegoodsrecordt.setSaleprice(Double.parseDouble(this.getSaleprice()));
	    salegoodsrecordt.setSalepeople(this.getSalepeople());
	    salegoodsrecordt.setTelno(this.getTelno());
	    salegoodsrecordt.setMobile(this.getMobile());
	    salegoodsrecordt.setSex(this.getSex());
	    salegoodsrecordt.setEmail(this.getEmail());
	    salegoodsrecordt.setPoints(this.getPoints());
	    salegoodsrecordt.setHiprice(Double.parseDouble(this.getHiprice()));	 
	    salegoodsrecordt.setJoinnumber(Integer.parseInt(this.getJoinnumber()));
	    salegoodsrecordt.setMarketprice(Double.parseDouble(this.getMarketprice()));
	    salegoodsrecordt.setSalegoodsid(this.getSalegoodsid());
	    salegoodsrecordt.setSalegoodspictureurl(this.getSalegoodspictureurl());
	    salegoodsrecordt.setSalegoodsinformation(this.getSalegoodsinformation());
	    salegoodsrecordt.setBegingtime(this.getBegingtime());
	    salegoodsrecordt.setEndingtime(this.getEndingtime());
	    salegoodsrecordt.setSalegoodsmessage(this.getSalegoodsmessage());
	    salegoodsrecordt.setLowprice(Double.parseDouble(this.getLowprice()));
	    salegoodsrecordt.setPlace(this.getPlace());
	    salegoodsrecordt.setManufacturer(this.getManufacturer());
	    if(this.getSaleGoodsrecordService().addSaleGoodsrecord(salegoodsrecordt)>0){
	    	this.setRecordgoods(true);
	    	return "json";
	    }
	    return "json";
	    
	}*/
	
	@Action(value="deletesalegoodsrecordt",results={@Result(name="json",type="json")})
	public String deletesalegoodsrecordt(){
		if(Validate.StrNotNull(this.getSalerecordid())){
			String[] s=this.getSalerecordid().trim().split(",");
			this.getSaleGoodsrecordService().deleteSaleGoodsrecord(s);
			this.setFlag(true);
			return "json";
		}
		return "json";
	}
	@Action(value="updatesalegoodsrecordt",results={@Result(name="json",type="json")})
	public String updatesalegoodsrecordt(){
		SaleGoodsrecordT salegoodsrecordt=new SaleGoodsrecordT();
		salegoodsrecordt.setSalerecordid(this.getSalerecordid());
		salegoodsrecordt.setUsername(this.getUsername());
		salegoodsrecordt.setRealname(this.getRealname());
		salegoodsrecordt.setSalegoodsnumber(this.getSalegoodsnumber());
		salegoodsrecordt.setSalestartingprice(Double.parseDouble(this.getSalestartingprice()));
	    salegoodsrecordt.setSaletradetime(this.getSaletradetime());
	    salegoodsrecordt.setSaleprice(Double.parseDouble(this.getSaleprice()));
	    salegoodsrecordt.setSalepeople(this.getSalepeople());
	    salegoodsrecordt.setTelno(this.getTelno());
	    salegoodsrecordt.setMobile(this.getMobile());
	    salegoodsrecordt.setSex(this.getSex());
	    salegoodsrecordt.setEmail(this.getEmail());
	    salegoodsrecordt.setPoints(this.getPoints());
	    salegoodsrecordt.setHiprice(Double.parseDouble(this.getHiprice()));
	    salegoodsrecordt.setJoinnumber(Integer.parseInt(this.getJoinnumber()));
	    salegoodsrecordt.setMarketprice(Double.parseDouble(this.getMarketprice()));
	    salegoodsrecordt.setSalegoodsname(this.getSalegoodsname());
	    salegoodsrecordt.setSalegoodspictureurl(this.getSalegoodspictureurl());
	    salegoodsrecordt.setSalegoodsinformation(this.getSalegoodsinformation());
	    salegoodsrecordt.setBegingtime(this.getBegingtime());
	    salegoodsrecordt.setEndingtime(this.getEndingtime());
	    salegoodsrecordt.setSalegoodsmessage(this.getSalegoodsmessage());
	    salegoodsrecordt.setLowprice(Double.parseDouble(this.getLowprice()));
	    salegoodsrecordt.setPlace(this.getPlace());
	    salegoodsrecordt.setSalegoodsid(this.getSalegoodsid());
	    salegoodsrecordt.setManufacturer(this.getManufacturer());
	    if(this.getSaleGoodsrecordService().updateSaleGoodsrecord(salegoodsrecordt)>0){
	    	this.setRecordgoods(true);
	    	return "json";
	    }
	    return "json";
	    
	}
	
	public void defaultFindAllSaleGoodsrecord(){
		int currentPage=page;
		int lineSize=rp;
		if(Validate.StrNotNull(sortname)&&Validate.StrNotNull(sortorder)){
			String queryString = "from SaleGoodsrecordT order by " + sortname + " "
			+ sortorder + "";
			List<SaleGoodsrecordT> list=this.getSaleGoodsrecordService().sortAllSaleGoodsrecord(currentPage, lineSize, queryString);
			if(!list.isEmpty()){
				System.out.println("not empty");
				ProcessSaleGoodsrecordTList(list);
			}
			
		} 
	}
	public void ProcessSaleGoodsrecordTList(List<SaleGoodsrecordT> recordList){
		total=this.getSaleGoodsrecordService().countAllSaleGoodsrecordT();
		rows.clear();
		for(Iterator it=recordList.iterator();it.hasNext();){
		SaleGoodsrecordT record=(SaleGoodsrecordT) it.next();
			Map<String,Object> cellMap=new HashMap<String,Object>();
			cellMap.put("id", record.getSalerecordid());
			cellMap.put("cell", new Object[]{
					record.getUsername(),
					record.getRealname(),
					record.getSalegoodsnumber(),
					record.getSalegoodsname(),
					record.getSalestartingprice(),
					BaseTools.formateDbDate(record.getSaletradetime()),
					record.getSaleprice(),
					record.getSalepeople(),
					record.getTelno(),
					record.getMobile(),
					record.getSex(),
					record.getEmail(),
					record.getPoints(),
					record.getHiprice(),
					record.getJoinnumber(),
					record.getMarketprice(),
					record.getSalegoodspictureurl(),
					record.getBegingtime(),
					record.getEndingtime(),
					record.getSalegoodsmessage(),
					record.getLowprice(),
					record.getPlace(),
					record.getManufacturer(),
					record.getSalegoodsid(),
					record.getSalegoodsinformation()});
			
			rows.add(cellMap);
		}
	}
	@Action(value="findallSaleGoodsrecord",results={@Result(name="json",type="json")})
	public String findallSaleGoodsrecord(){
		if(this.getQtype().equals("sc")){
			this.defaultFindAllSaleGoodsrecord();
		}else{
			if(Validate.StrisNull(this.getQtype())){
				return "json";
			}else{
				return "json";
			}
		}
		return "json";
		
	}
	@Action(value="findAllSaleGoodsrecordByid",results={@Result(name="json",type="json")})
	public String findAllSaleGoodsrecordByid(){
		if(Validate.StrNotNull(this.getSalerecordid())){
			recordlist=this.getSaleGoodsrecordService().findsalerecordid(this.getSalerecordid().trim());
			if(recordlist!=null){
				return "json";
			}
		}
		return "json";
	}
	public String updateSaleGoodsrecordByhiprice(){
		SaleGoodsrecordT salegoodsrecordt=new SaleGoodsrecordT();
		salegoodsrecordt.setSalerecordid(this.getSalerecordid());
		salegoodsrecordt.setHiprice(Double.parseDouble(this.getHiprice()));
		if(this.getSaleGoodsrecordService().updateSaleGoodsrecordByHiprice(salegoodsrecordt)>0){
			this.setRecordgoods(true);
	    	return "json";
	    }
	    return "json";
	}
}
