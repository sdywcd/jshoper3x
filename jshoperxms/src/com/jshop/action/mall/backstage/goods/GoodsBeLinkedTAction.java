package com.jshop.action.mall.backstage.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.ProductT;
import com.jshop.service.GoodsBelinkedTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.ProductTService;
import com.jshop.service.impl.Serial;
import com.jshop.vo.GoodsBelinkedProductInfo;
@Namespace("")
@ParentPackage("jshop")
public class GoodsBeLinkedTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsBelinkedTService goodsBelinkedTService;
	@Resource
	private ProductTService productTService;
	@Resource
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
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

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
		if(StringUtils.isNotBlank(this.getMaingoodsid())){
			Criterion criterion=Restrictions.eq("maingoodsid", this.getMaingoodsid());
			List<GoodsBelinkedT>list=this.goodsBelinkedTService.findByCriteria(GoodsBelinkedT.class, criterion);
			if(!list.isEmpty()){
				this.setBean(list.get(0));
				this.setSucflag(true);
			}
		}
		return JSON;
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
			return JSON;
		}
		ProductT pt=null;
		GoodsT gt=null;
		//组装关联商品的json数据
		//这里的关联商品id可以是商品id，或者是productid，默认的逻辑是选择了商品并默认获取期货物id
		String []belinkedgoodsid=StringUtils.split(this.getBelinkedproductinfo().trim(),StaticKey.SPLITDOT);
		Gson gson=new Gson();
		List<GoodsBelinkedProductInfo>jsonlist=new ArrayList<GoodsBelinkedProductInfo>();
		
//		StringBuilder belinkedstr=new StringBuilder();
//		belinkedstr.append("[");
		//belinkproductinfo带有商品id或者是货物id需要处理
		for(String s:belinkedgoodsid){
			GoodsBelinkedProductInfo gbp=new GoodsBelinkedProductInfo();
			//如果用goodsid和默认货物查到了product信息那么就是说明前台是传递的goods信息
			//如果没查到则用goodsid查询product，默认就是传递的货物信息信息
			Criterion criterion=Restrictions.eq("goodsid", s);
			List<ProductT>ptList=this.productTService.findByCriteria(ProductT.class, criterion);
			if(ptList.size()==1){//默认目前只处理1号情况
				pt=ptList.get(0);
				gt=this.goodsTService.findByPK(GoodsT.class, pt.getGoodsid());
				String temp[]=StringUtils.split(gt.getPictureurl(),StaticKey.SPLITDOT);
				gbp.setGoodsid(pt.getGoodsid());
				gbp.setGoodsName(gt.getGoodsname());
				gbp.setProductid(pt.getProductid());
				gbp.setProductName(pt.getProductName());
				gbp.setHtmlpath(gt.getHtmlPath());
				gbp.setMemberprice(String.valueOf(pt.getMemberprice()));
				gbp.setPrice(String.valueOf(pt.getPrice()));
				if(temp.length>0){
					gbp.setPictureurl(temp[0]);
				}else{
					gbp.setPictureurl(gt.getPictureurl());
				}
				jsonlist.add(gbp);
			}
		}
		String belinkedproductinfo=gson.toJson(jsonlist);
		//获取主商品名称
		GoodsT gst=this.goodsTService.findByPK(GoodsT.class, this.getMaingoodsid());
		GoodsBelinkedT gbl=new GoodsBelinkedT();
		Criterion criterion=Restrictions.eq("maingoodsid", this.getMaingoodsid());
		List<GoodsBelinkedT>list=this.goodsBelinkedTService.findByCriteria(GoodsBelinkedT.class, criterion);
		if(!list.isEmpty()){
			gbl.setId(list.get(0).getId());
			gbl.setMaingoodsid(this.getMaingoodsid());
			gbl.setMaingoodsname(gst.getGoodsname());
			gbl.setBelinkedproductinfo(belinkedproductinfo);
			gbl.setMode(StaticKey.ONE);//单向模式
			gbl.setState(StaticKey.ONE);//开启关联
			gbl.setMainproductid(pt.getProductid());
			gbl.setCreatorid(BaseTools.getAdminCreateId());
			gbl.setCreatetime(list.get(0).getCreatetime());
			gbl.setUpdatetime(BaseTools.getSystemTime());
			gbl.setVersiont(0);
			gbl.setSxlinkedgoodsid(StaticKey.ONE);//单向关联模式时设置成0
			this.goodsBelinkedTService.update(gbl);
		}else{
			gbl.setId(this.getSerial().Serialid(Serial.GOODSBELINKED));
			gbl.setMaingoodsid(this.getMaingoodsid());
			gbl.setMaingoodsname(gst.getGoodsname());
			gbl.setBelinkedproductinfo(belinkedproductinfo);
			gbl.setMode(StaticKey.ONE);//单向模式
			gbl.setState(StaticKey.ONE);//开启关联
			gbl.setMainproductid(pt.getProductid());
			gbl.setCreatorid(BaseTools.getAdminCreateId());
			gbl.setCreatetime(BaseTools.getSystemTime());
			gbl.setUpdatetime(BaseTools.getSystemTime());
			gbl.setVersiont(0);
			gbl.setSxlinkedgoodsid(StaticKey.ONE);//单向关联模式时设置成0
			this.goodsBelinkedTService.save(gbl);
		}
		this.setSucflag(true);
		return JSON;
	}
	
	/**
	 * 查询所有的关联商品
	 * @return
	 */
	@Action(value = "findAllGoodsBelinked", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findAllGoodsBelinked(){
		if(StaticKey.SC.equals(this.getQtype())){
			finddefaultAllGoodsBelinked();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}
		}
		return JSON;
	}
	private void finddefaultAllGoodsBelinked() {
		int currentPage=page;
		int lineSize=rp;
		total=this.goodsBelinkedTService.count(GoodsBelinkedT.class).intValue();
		Order order=Order.desc("updatetime");
		List<GoodsBelinkedT>list=this.goodsBelinkedTService.findByCriteriaByPage(GoodsBelinkedT.class, order, currentPage, lineSize);
		processGoodsBelinkedList(list);
	}
	private void processGoodsBelinkedList(List<GoodsBelinkedT> list) {
		List<GoodsBelinkedProductInfo>gbpinfo=new ArrayList<GoodsBelinkedProductInfo>();
		Gson gson=new Gson();
		String productinfo="";
		for(Iterator<GoodsBelinkedT> it=list.iterator();it.hasNext();){
			GoodsBelinkedT gbt=(GoodsBelinkedT) it.next();
			gbpinfo=gson.fromJson(gbt.getBelinkedproductinfo(), new TypeToken<List<GoodsBelinkedProductInfo>>(){}.getType());
			for(GoodsBelinkedProductInfo g:gbpinfo){
				productinfo+=g.getProductName()+"["+g.getMemberprice()+"]";
			}
			Map<String,Object> cellMap=new HashMap<String,Object>();
			cellMap.put("id", gbt.getId());
			cellMap.put("cell", new Object[]{
					gbt.getMaingoodsname(),
					productinfo,
					BaseTools.formateDbDate(gbt.getCreatetime())
			});
			rows.add(cellMap);
			productinfo="";
		}
		
	}
	/**
	 * 删除关联商品
	 * @return
	 */
	@Action(value = "delGoodsBelinked", results = {@Result(name = "json",type="json")})
	public String delGoodsBelinked(){
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		String []strs=StringUtils.split(this.getId(),StaticKey.SPLITDOT);
		for(String s:strs){
			GoodsBelinkedT gbt=this.goodsBelinkedTService.findByPK(GoodsBelinkedT.class, s);
			if(gbt!=null){
				this.goodsBelinkedTService.delete(gbt);
			}
		}
		this.setSucflag(true);
		return JSON;
	}
	
	
	
	
}
