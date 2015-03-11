package com.jshop.action.backstage.goods;

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

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsCardsPasswordT;
import com.jshop.service.GoodsCardsPasswordTService;
@Namespace("")
@ParentPackage("jshop")
public class GoodsCardsPasswordTAction extends BaseTAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 745894177072927974L;
	@Resource
	private GoodsCardsPasswordTService goodsCardsPasswordTService;
	private String id;
	private String goodsCardsId;
	private String password;
	private String status;
	private Date createtime;
	private Date updatetime;
	private String memberid;
	private GoodsCardsPasswordT bean=new GoodsCardsPasswordT();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsCardsId() {
		return goodsCardsId;
	}
	public void setGoodsCardsId(String goodsCardsId) {
		this.goodsCardsId = goodsCardsId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public GoodsCardsPasswordT getBean() {
		return bean;
	}
	public void setBean(GoodsCardsPasswordT bean) {
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
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	/**
	 * 查看指定购物卡的密钥
	 * @return
	 */
	@Action(value = "findAllGoodsCardsPassword", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findAllGoodsCardsPassword(){
		if(StaticKey.SC.equals(this.getQtype())){
			finddefaultAllGoodsCardsPassword();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}
		}
		return JSON;
	}
	private void finddefaultAllGoodsCardsPassword() {
		int currentPage=page;
		int lineSize=rp;
		String goodsCradsId=this.getGoodsCardsId();
		total=goodsCardsPasswordTService.countfindGoodsCardsPasswordByGoodsCardsId(goodsCradsId);
		List<GoodsCardsPasswordT>list=goodsCardsPasswordTService.findGoodsCardsPasswordByGoodsCardsId(currentPage, lineSize, goodsCradsId);
		processGoodsCardsPassword(list);
	}
	private void processGoodsCardsPassword(List<GoodsCardsPasswordT> list) {
		for(Iterator<GoodsCardsPasswordT>it=list.iterator();it.hasNext();){
			GoodsCardsPasswordT gcp=it.next();
			if(gcp.getStatus().equals(StaticKey.ZERO)){
				gcp.setStatus("未绑定");
			}else if(gcp.getStatus().equals(StaticKey.ONE)){
				gcp.setStatus("已绑定");
			}else if(gcp.getStatus().equals(StaticKey.TWO)){
				gcp.setStatus("未使用");
			}else if(gcp.getStatus().equals(StaticKey.THREE)){
				gcp.setStatus("已使用");
			}else{
				gcp.setStatus("无效");
			}
			Map<String,Object>cellMap=new HashMap<String, Object>();
			cellMap.put("id",gcp.getId());
			cellMap.put("cell", new Object[]{
				gcp.getPassword(),
				gcp.getStatus(),
				BaseTools.formateDbDate(gcp.getCreatetime())
			});
			rows.add(cellMap);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
