package com.jshop.action.backstage.goods;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.ProductT;
import com.jshop.service.GoodsBelinkedTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.ProductTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class GoodsBeLinkedTAction extends ActionSupport {
	private Serial serial;
	private GoodsBelinkedTService goodsBelinkedTService;
	private ProductTService productTService;
	private GoodsTService goodsTService;
	private String id;
	private String maingoodsid;
	private String belinkedproductinfo;
	private String mode;
	private String state;
	private String creatorid;
	private Date createtime;
	private Date updatetime;
	private int versiont;
	private String sxlinkedgoodsid;
	private String mainproductid;
	private GoodsBelinkedT bean=new GoodsBelinkedT();
	
	private boolean sucflag;
	
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize = false)
	public ProductTService getProductTService() {
		return productTService;
	}
	public void setProductTService(ProductTService productTService) {
		this.productTService = productTService;
	}
	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	@JSON(serialize = false)
	public GoodsBelinkedTService getGoodsBelinkedTService() {
		return goodsBelinkedTService;
	}
	public void setGoodsBelinkedTService(GoodsBelinkedTService goodsBelinkedTService) {
		this.goodsBelinkedTService = goodsBelinkedTService;
	}
	
	public String getMaingoodsid() {
		return maingoodsid;
	}
	public void setMaingoodsid(String maingoodsid) {
		this.maingoodsid = maingoodsid;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public int getVersiont() {
		return versiont;
	}
	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}
	public String getSxlinkedgoodsid() {
		return sxlinkedgoodsid;
	}
	public void setSxlinkedgoodsid(String sxlinkedgoodsid) {
		this.sxlinkedgoodsid = sxlinkedgoodsid;
	}
	
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBelinkedproductinfo() {
		return belinkedproductinfo;
	}
	public void setBelinkedproductinfo(String belinkedproductinfo) {
		this.belinkedproductinfo = belinkedproductinfo;
	}
	public String getMainproductid() {
		return mainproductid;
	}
	public void setMainproductid(String mainproductid) {
		this.mainproductid = mainproductid;
	}
	public GoodsBelinkedT getBean() {
		return bean;
	}
	public void setBean(GoodsBelinkedT bean) {
		this.bean = bean;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 根据goodsid获取关联商品
	 * @return
	 */
	@Action(value = "findGoodsBelinkedBymaingoodsid", results = { @Result(name = "json", type = "json") })
	public String findGoodsBelinkedBymaingoodsid(){
		List<GoodsBelinkedT>list=this.getGoodsBelinkedTService().findGoodsBelinkedBymaingoodsid(this.getMaingoodsid());
		if(!list.isEmpty()){
			this.setBean(list.get(0));
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	/**
	 * 增加关联商品
	 * 关联商品存在2个情况
	 * 1，前端只选择商品作为主商品
	 * 2，前端选择货物作为主商品(该模式暂时不考虑，通过前端决定时候在选择关联商品时出现可选择货物的选项，默认就和没有规格值得货物绑定)
	 * 1中的逻辑是选择的主商品会获取他的默认货物
	 * 2中的逻辑是选择了货物
	 * @return
	 */
	@Action(value = "saveOrUpdateGoodsBelinkedT", results = { @Result(name = "json", type = "json") })
	public String saveOrUpdateGoodsBelinkedT(){
		if(StringUtils.isBlank(this.getBelinkedproductinfo())){
			return "json";
		}
		ProductT pt=null;
		GoodsT gt=null;
		//组装关联商品的json数据
		//这里的关联商品id可以是商品id，或者是productid，默认的逻辑是选择了商品并默认获取期货物id
		String []belinkedgoodsid=StringUtils.split(this.getBelinkedproductinfo().trim(),",");
		StringBuilder belinkedstr=new StringBuilder();
		belinkedstr.append("[");
		//belinkproductinfo带有商品id或者是货物id需要处理
		for(String s:belinkedgoodsid){
			//如果用goodsid和默认货物查到了product信息那么就是说明前台是传递的goods信息
			//如果没查到则用goodsid查询product，默认就是传递的货物信息信息
			List<ProductT>ptList=this.getProductTService().findProductTByGoodsid(s);
			if(ptList.size()==1){//默认目前只处理1号情况
				pt=ptList.get(0);
				gt=this.getGoodsTService().findGoodsById(pt.getGoodsid());
				String temp[]=StringUtils.split(gt.getPictureurl(), ',');
				belinkedstr.append("{");
				belinkedstr.append("\"goodsid\":\"").append(pt.getGoodsid()).append("\",");
				belinkedstr.append("\"goodsName\":\"").append(gt.getGoodsname()).append("\",");
				belinkedstr.append("\"productid\":\"").append(pt.getProductid()).append("\",");
				belinkedstr.append("\"productName\":\"").append(pt.getProductName()).append("\",");
				belinkedstr.append("\"htmlpath\":\"").append(gt.getHtmlPath()).append("\",");
				belinkedstr.append("\"memberprice\":\"").append(pt.getMemberprice()).append("\",");
				belinkedstr.append("\"price\":\"").append(pt.getPrice()).append("\",");
				belinkedstr.append("\"pictureurl\":\"").append(temp[0]).append("\"");
				belinkedstr.append("},");
			}
			belinkedstr.deleteCharAt(belinkedstr.length()-1);
			belinkedstr.append("]");
			GoodsBelinkedT gbl=new GoodsBelinkedT();
			List<GoodsBelinkedT>list=this.getGoodsBelinkedTService().findGoodsBelinkedBymaingoodsid(pt.getGoodsid());
			if(!list.isEmpty()){
				gbl.setId(list.get(0).getId());
				gbl.setMaingoodsid(pt.getGoodsid());
				gbl.setBelinkedproductinfo(belinkedstr.toString());
				gbl.setMode(StaticString.ONE);//单向模式
				gbl.setState(StaticString.ONE);//开启关联
				gbl.setMainproductid(pt.getProductid());
				gbl.setCreatorid(BaseTools.adminCreateId());
				gbl.setCreatetime(list.get(0).getCreatetime());
				gbl.setUpdatetime(BaseTools.systemtime());
				gbl.setVersiont(0);
				gbl.setSxlinkedgoodsid(StaticString.ONE);//单向关联模式时设置成0
				this.getGoodsBelinkedTService().updateGoodsBelinked(gbl);
			}else{
				gbl.setId(this.getSerial().Serialid(Serial.GOODSBELINKED));
				gbl.setMaingoodsid(pt.getGoodsid());
				gbl.setBelinkedproductinfo(belinkedstr.toString());
				gbl.setMode(StaticString.ONE);//单向模式
				gbl.setState(StaticString.ONE);//开启关联
				gbl.setMainproductid(pt.getProductid());
				gbl.setCreatorid(BaseTools.adminCreateId());
				gbl.setCreatetime(BaseTools.systemtime());
				gbl.setUpdatetime(BaseTools.systemtime());
				gbl.setVersiont(0);
				gbl.setSxlinkedgoodsid(StaticString.ONE);//单向关联模式时设置成0
				this.getGoodsBelinkedTService().addGoodsBelinkedT(gbl);
			}
			
		}
		this.setSucflag(true);
		return "json";
	}
	
	
	
}
