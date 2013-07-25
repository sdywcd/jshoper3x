package com.jshop.action.backstage.android.elecart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.Arith;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.ElectronicMenuCartT;
import com.jshop.entity.GoodsT;
import com.jshop.service.ElectronicMenuCartTService;
import com.jshop.service.GoodsTService;
import com.opensymphony.xwork2.ActionSupport;

import edu.emory.mathcs.backport.java.util.Collections;
import freemarker.template.utility.StringUtil;
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class AndroidJshopelectronicmenucartAction  extends ActionSupport implements
ServletRequestAware, ServletResponseAware{
	@Resource
	private Serial serial;
	@Resource
	private GoodsTService goodsTService;
	@Resource
	private ElectronicMenuCartTService electronicMenuCartTService;
	private String tableNumber;
	private String tablestate;
	private String goodsid;
	private String needquantity;
	private String taste;
	private String ispackaway;//堂吃，外带
	private Integer lunchbox;//打包盒
	private String cookingstate;//烹饪状态
	private String roomName;
	private String state;
	private Double totalmemberprice = 0.0;
	private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsejsonstr;
    
    @JSON(serialize = false)
    public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	@JSON(serialize = false)
    public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	@JSON(serialize = false)
	public ElectronicMenuCartTService getElectronicMenuCartTService() {
		return electronicMenuCartTService;
	}

	public void setElectronicMenuCartTService(
			ElectronicMenuCartTService electronicMenuCartTService) {
		this.electronicMenuCartTService = electronicMenuCartTService;
	}

    public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getResponsejsonstr() {
		return responsejsonstr;
	}
	public void setResponsejsonstr(String responsejsonstr) {
		this.responsejsonstr = responsejsonstr;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
		
	}
	
	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getTablestate() {
		return tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getNeedquantity() {
		return needquantity;
	}

	public void setNeedquantity(String needquantity) {
		this.needquantity = needquantity;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getIspackaway() {
		return ispackaway;
	}

	public void setIspackaway(String ispackaway) {
		this.ispackaway = ispackaway;
	}

	public Integer getLunchbox() {
		return lunchbox;
	}

	public void setLunchbox(Integer lunchbox) {
		this.lunchbox = lunchbox;
	}

	public String getCookingstate() {
		return cookingstate;
	}

	public void setCookingstate(String cookingstate) {
		this.cookingstate = cookingstate;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Double getTotalmemberprice() {
		return totalmemberprice;
	}

	public void setTotalmemberprice(Double totalmemberprice) {
		this.totalmemberprice = totalmemberprice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 根据餐桌号获取电子菜单信息
	 * @throws IOException 
	 */
	@Action(value="findAllElectronicMenuCartTBytableNumberforAndroid")
	public void findAllElectronicMenuCartTBytableNumberforAndroid() throws IOException{
		if(Validate.StrNotNull(this.getTableNumber())&&Validate.StrNotNull(this.getTablestate())){
			String tableNumber=this.getTableNumber().trim();
			String tablestate=this.getTablestate().trim();
			List<ElectronicMenuCartT>list=this.getElectronicMenuCartTService().findAllElectronicMenuCartTBytableNumber(tableNumber, tablestate);
			if(!list.isEmpty()){
				this.setTotalmemberprice(0.0);
				String temp=null;
				String []temparray=null;
				StringBuilder json=new StringBuilder();
				json.append("[");
				for(Iterator it=list.iterator();it.hasNext();){
					ElectronicMenuCartT emt=(ElectronicMenuCartT)it.next();
					this.setTotalmemberprice(Arith.add(this.getTotalmemberprice(), Arith.mul(emt.getMemberprice(), Double.parseDouble(String.valueOf(emt.getNeedquantity())))));
					temparray=StringUtil.split(emt.getPicture(), ',');
					temp=temparray[0];
					emt.setPicture(temp);
					json.append("{");
					json.append("\"id\":\"").append(emt.getId()).append("\",");
					json.append("\"electronicMenuOrderid\":\"").append(emt.getElectronicMenuOrderid()).append("\",");
					json.append("\"goodsid\":\"").append(emt.getGoodsid()).append("\",");
					json.append("\"goodsname\":\"").append(emt.getGoodsname()).append("\",");
					json.append("\"userid\":\"").append(emt.getUserid()).append("\",");
					json.append("\"username\":\"").append(emt.getUsername()).append("\",");
					json.append("\"needquantity\":\"").append(emt.getNeedquantity()).append("\",");
					json.append("\"price\":\"").append(emt.getPrice()).append("\",");
					json.append("\"memberprice\":\"").append(emt.getMemberprice()).append("\",");
					json.append("\"changeprice\":\"").append(emt.getChangeprice()).append("\",");
					json.append("\"points\":\"").append(emt.getPoints()).append("\",");
					json.append("\"subtotal\":\"").append(emt.getSubtotal()).append("\",");
					json.append("\"addtime\":\"").append(BaseTools.formateDbDate(emt.getAddtime())).append("\",");
					json.append("\"quantity\":\"").append(emt.getQuantity()).append("\",");
					json.append("\"picture\":\"").append(emt.getPicture()).append("\",");
					json.append("\"usersetnum\":\"").append(emt.getUsersetnum()).append("\",");
					json.append("\"weight\":\"").append(emt.getWeight()).append("\",");
					json.append("\"state\":\"").append(emt.getState()).append("\",");
					json.append("\"deliveryprice\":\"").append(emt.getDeliveryprice()).append("\",");
					json.append("\"taste\":\"").append(emt.getTaste()).append("\",");
					json.append("\"ispackaway\":\"").append(emt.getIspackaway()).append("\",");
					json.append("\"lunchbox\":\"").append(emt.getLunchbox()).append("\",");
					json.append("\"cookingstate\":\"").append(emt.getCookingstate()).append("\",");
					json.append("\"tableNumber\":\"").append(emt.getTableNumber()).append("\",");
					json.append("\"roomName\":\"").append(emt.getRoomName()).append("\",");
					json.append("\"tablestate\":\"").append(emt.getTablestate()).append("\",");
					json.append("\"electronicMenuCartid\":\"").append(emt.getElectronicMenuCartid()).append("\",");
					//总价格
					json.append("\"totalmemberprice\":\"").append(this.getTotalmemberprice()).append("\"");
					json.append("},");
				}
				json.deleteCharAt(json.length()-1);
				json.append("]");
				this.setResponsejsonstr(json.toString());
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.write(this.getResponsejsonstr());
				out.flush();
				out.close();
			}
		}
	}
	
	/**
	 * 增加电子菜单购物车商品
	 * @return
	 * @throws IOException 
	 */
	@Action(value="addelEctronicMenuCartforAndroid")
	public void addelEctronicMenuCartforAndroid() throws IOException{
		String goodsid=this.getGoodsid().trim();
		String tableNumber=this.getTableNumber().trim();
		String tablestate=this.getTablestate().trim();
		String state="1";//新增加的菜
		String sucflag = null;
		List<GoodsT>gtlist1=this.getElectronicMenuCartBygoodsidforcart();
		for(GoodsT gt:gtlist1){
			ElectronicMenuCartT elemcart=this.getElectronicMenuCartTService().findGoodsInElectronicMenuCartTOrNot(tableNumber, tablestate, goodsid, state);
			if(elemcart!=null){
				int i=this.getElectronicMenuCartTService().updateElectronicMenuCartTneedquantityBygoodsid(tableNumber, tablestate, goodsid, Integer.parseInt(this.getNeedquantity()), state);
				sucflag="success";
			}else{
				String[]temppicturl=StringUtils.split(gt.getPictureurl(),',');
				ElectronicMenuCartT emt=new ElectronicMenuCartT();
				emt.setId(this.getSerial().Serialid(Serial.ELECTRONICMENUCARTTINFO));
				emt.setElectronicMenuCartid("");
				emt.setElectronicMenuOrderid("");
				emt.setGoodsid(gt.getGoodsid());
				emt.setGoodsname(gt.getGoodsname());
				emt.setUserid("");
				emt.setUsername("");
				emt.setNeedquantity(Integer.parseInt(this.getNeedquantity()));
				emt.setPrice(gt.getPrice());
				emt.setMemberprice(gt.getMemberprice());
				emt.setChangeprice(0.0);
				emt.setPoints(gt.getPoints());
				emt.setSubtotal(Double.parseDouble(this.getNeedquantity())*gt.getMemberprice());
				emt.setAddtime(BaseTools.systemtime());
				emt.setQuantity(gt.getQuantity());
				emt.setPicture(temppicturl[0]);
				emt.setUsersetnum(gt.getUsersetnum());
				emt.setWeight(gt.getWeight());
				emt.setState("1");
				emt.setDeliveryprice(0.0);//外送费
				emt.setTaste(this.getTaste());//口味和配料
				emt.setIspackaway(this.getIspackaway());
				emt.setLunchbox(0);//0个打包盒
				emt.setCookingstate("0");//未烹饪
				emt.setTableNumber(tableNumber);
				emt.setRoomName(this.getRoomName());
				emt.setTablestate(tablestate);
				if(this.getElectronicMenuCartTService().addElectronicMenuCartT(emt)>0){
					sucflag="success";
				}
			}
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(sucflag);
		out.flush();
		out.close();
	}
	/**
	 * 在增加商品到电子菜单前先查询商品信息
	 * @return
	 */
	public List<GoodsT>getElectronicMenuCartBygoodsidforcart(){
		if(Validate.StrNotNull(this.getGoodsid())){
			List<GoodsT>list1=new ArrayList<GoodsT>();
			String[]tempgoodsid=StringUtils.split(this.getGoodsid(), ',');
			for(String s:tempgoodsid){
				GoodsT gt=this.getGoodsTService().findGoodsById(s);
				list1.add(gt);
			}
			return list1;
		}
		return Collections.emptyList();
	}
	

	/**
	 * 删除电子菜单商品
	 * @throws IOException 
	 */
	@Action(value="delElectronicMenuCartTGoodsforAndroid")
	public void delElectronicMenuCartTGoodsforAndroid() throws IOException{
		if(Validate.StrNotNull(this.getTableNumber())&&Validate.StrNotNull(this.getGoodsid())){
			//state从前台获取，控制菜单可删除的位置
			String tableNumber=this.getTableNumber().trim();
			String goodsid=this.getGoodsid().trim();
			String state=this.getState().trim();
			String tablestate="1";//使用中
			String sucflag=null;
			int i=this.getElectronicMenuCartTService().delElectronicMenuCartTGoods(tableNumber, tablestate, goodsid, state);
			sucflag="success";
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.write(sucflag);
			out.flush();
			out.close();
			
		}
			
	}
	
	
	
	
	

}
