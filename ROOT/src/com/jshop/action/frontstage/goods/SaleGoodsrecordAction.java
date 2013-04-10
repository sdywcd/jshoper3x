/**
 * 
 */
package com.jshop.action.frontstage.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.template.DataCollectionTAction;
import com.jshop.action.backstage.template.FreeMarkervariable;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.entity.SaleGoodsrecordT;
import com.jshop.entity.SalegoodsT;
import com.jshop.entity.UserT;
import com.jshop.service.SaleGoodsTService;
import com.jshop.service.SaleGoodsrecordService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({
	@InterceptorRef("defaultStack")
})
public class SaleGoodsrecordAction extends ActionSupport {
	private SaleGoodsTService saleGoodsTService;
	private SaleGoodsrecordService saleGoodsrecordService;
	private DataCollectionTAction dataCollectionTAction;
	private Serial serial;
	private String salegoodsid;
	private String salegoodsname;
	private String salegoodsnumber;
	private String salegoodspictureurl;
	private String salegoodsinformation;
	private String salegoodsstate;
	private String salepeople;
	private String salestartingprice;
	private String salejoinpeople;
	private String salerecordid;
	private Double hiprice;
	private Date endgingtime;
	
	
	
	public Date getEndgingtime() {
		return endgingtime;
	}
	public void setEndgingtime(Date endgingtime) {
		this.endgingtime = endgingtime;
	}
	public Double getHiprice() {
		return hiprice;
	}
	public void setHiprice(Double hiprice) {
		this.hiprice = hiprice;
	}
	public String getSalerecordid() {
		return salerecordid;
	}
	public void setSalerecordid(String salerecordid) {
		this.salerecordid = salerecordid;
	}

	private boolean salegoods=false;
	private SalegoodsT goodsList=new SalegoodsT();
	private List rows=new ArrayList();
	
	public SaleGoodsTService getSaleGoodsTService() {
		return saleGoodsTService;
	}
	public void setSaleGoodsTService(SaleGoodsTService saleGoodsTService) {
		this.saleGoodsTService = saleGoodsTService;
	}
	
	public SaleGoodsrecordService getSaleGoodsrecordService() {
		return saleGoodsrecordService;
	}
	public void setSaleGoodsrecordService(
			SaleGoodsrecordService saleGoodsrecordService) {
		this.saleGoodsrecordService = saleGoodsrecordService;
	}
	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	public Serial getSerial() {
		return serial;
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
	public boolean isSalegoods() {
		return salegoods;
	}
	public void setSalegoods(boolean salegoods) {
		this.salegoods = salegoods ;
	}
	public SalegoodsT getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(SalegoodsT goodsList) {
		this.goodsList = goodsList;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	@Override
	public void validate() {
		this.clearErrorsAndMessages();
	}
	
	
	/**
	 *拍卖品集合
	 * @return
	 */
	@Action(value="SalegoodsList",results={
			@Result(name="success",type="freemarker",location="/WEB-INF/theme/default/shop/salegoodsrecordt.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	
	public String SalegoodsList(){ 
		List<SalegoodsT> list=(List<SalegoodsT>)this.getSaleGoodsTService().findAllSalegoods("1");
		List<SaleGoodsrecordT> list2=this.getSaleGoodsrecordService().findAllSaleGoodsrecordT();
	
		
		//路径获取
		ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		ActionContext.getContext().put("salegoodslist", list);
		ActionContext.getContext().put("recordt", list2);
	
		
		//获取导航数据
		ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
		//获取商城基本数据
		ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
		//获取页脚分类数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
		//获取页脚文章数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());

		return SUCCESS;
			
		}

	@Action(value="Salegoods",results={
			@Result(name="success",type="freemarker",location="/WEB-INF/theme/default/shop/salegoodst.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	
	public String Salegoods(){
		SalegoodsT list2=this.getSaleGoodsTService().findsalegoodsById(this.getSalegoodsid());
		SalegoodsT list=this.getSaleGoodsTService().findsalegoodsById(this.getSalegoodsid());
		//当拍卖结束时间到的时候
		
		List<SaleGoodsrecordT> ending=this.getSaleGoodsrecordService().findbyEndingtime(this.getEndgingtime());
		
		//查询有多少人参加拍卖
		int i=this.getSaleGoodsrecordService().findjoinnumber(this.getSalegoodsid());
		//查询当前id商品最高价
		Double hiprice=this.getSaleGoodsrecordService().hiprice(this.getSalegoodsid());
		
		
		if(new Date()==this.getEndgingtime()){
			ActionContext.getContext().put("ending", ending);	
		}
			ActionContext.getContext().put("salegoodst", list);
			ActionContext.getContext().put("rehiprice", hiprice);
			ActionContext.getContext().put("salegoodsrecord", list2);
			ActionContext.getContext().put("salejoinnumber", i);
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());

			return SUCCESS;
		}

	@Action(value="AddSaleGoodsrecordByHiprice",results={
			@Result(name="success",type="redirect",location="Salegoods.action?salegoodsid=${salegoodsid}"),
			@Result(name = "error",type="redirect",location = "/html/default/shop/user/login.html?redirecturl=Salegoods.action?salegoodsid=${salegoodsid}")
	})
	public String AddSaleGoodsrecordByHiprice(){
		SaleGoodsrecordT re=new SaleGoodsrecordT();
		/*SaleGoodsrecordT list=this.getSaleGoodsrecordService().findbysalerecordid(this.getSalerecordid());*/
		SalegoodsT list=this.getSaleGoodsTService().findsalegoodsById(this.getSalegoodsid());
		//查询当前id商品最高价
		Double hiprice=this.getSaleGoodsrecordService().hiprice(this.getSalegoodsid());
		
		UserT user=(UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(this.getHiprice()<hiprice){
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");  
			try {
				PrintWriter  out = ServletActionContext.getResponse().getWriter();
				out.print("<script>alert('输入的价格已过期或小请重新输入');history.go(-1);</script>");
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else{
		if(user!=null){
			re.setBegingtime(list.getBegingtime());
			re.setEmail(user.getEmail());
			re.setEndingtime(list.getEndingtime());
			re.setHiprice(this.getHiprice());
			re.setHtmlpath("");
			re.setJoinnumber(1);
			re.setLowprice(list.getLowprice());
			re.setManufacturer(list.getManufacturer());
			re.setMarketprice(list.getMarketprice());
			re.setMobile(user.getMobile());
			re.setPlace(list.getPlace());
			re.setPoints(String.valueOf(user.getPoints()));
			re.setRealname(user.getRealname());
			re.setSalegoodsid(list.getSalegoodsid());
			re.setSalegoodsinformation(list.getSalegoodsinformation());
			re.setSalegoodsmessage(list.getSalegoodsmessage());
			re.setSalegoodsname(list.getSalegoodsname());
			re.setSalegoodsnumber(list.getSalegoodsnumber());
			re.setSalegoodspictureurl(list.getSalegoodspictureurl());
			re.setSalepeople(list.getSalepeople());
			re.setSaleprice(0.0);
			re.setSalerecordid(this.getSerial().Serialid(Serial.SALEGOODSRECORDT));
			re.setSalestartingprice(list.getSalestartingprice());
			re.setSaletradetime(new Date());
			re.setSex(user.getSex());
			re.setTelno(user.getTelno());
			re.setUsername(user.getUsername());	
		this.getSaleGoodsrecordService().addrecordByhiprice(re);

			return SUCCESS;
		}
		
	}
		return ERROR;
	}
}	
	
	
	
