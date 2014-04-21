package com.jshop.action.frontstage.goods;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.entity.GoodsCommentT;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsCommentTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class GoodsdetailAction extends ActionSupport {
	private GoodsTService goodsTService;
	private GoodsCommentTService goodsCommentTService;
	private Serial serial;

	private String hidurl;
	private String goodsid;
	private String goodsname;
	private String commentcontent;
	private String score;
	private String replyorcomment;
	private String replyorcommentuserid;
	private String pictureurl;
	private String price;
	private String memberprice;
	private String htmlPath;
	private List<GoodsCommentT>beanlist=new ArrayList<GoodsCommentT>();
	private boolean sucflag;
	private List<GoodsT>cookielist=new ArrayList<GoodsT>();
	private String cp;
	
	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	@JSON(serialize = false)
	public GoodsCommentTService getGoodsCommentTService() {
		return goodsCommentTService;
	}
	public void setGoodsCommentTService(GoodsCommentTService goodsCommentTService) {
		this.goodsCommentTService = goodsCommentTService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getHidurl() {
		return hidurl;
	}
	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getReplyorcomment() {
		return replyorcomment;
	}
	public void setReplyorcomment(String replyorcomment) {
		this.replyorcomment = replyorcomment;
	}
	public String getReplyorcommentuserid() {
		return replyorcommentuserid;
	}
	public void setReplyorcommentuserid(String replyorcommentuserid) {
		this.replyorcommentuserid = replyorcommentuserid;
	}

	public List<GoodsCommentT> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<GoodsCommentT> beanlist) {
		this.beanlist = beanlist;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMemberprice() {
		return memberprice;
	}
	public void setMemberprice(String memberprice) {
		this.memberprice = memberprice;
	}
	
	
	public String getHtmlPath() {
		return htmlPath;
	}
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	public List<GoodsT> getCookielist() {
		return cookielist;
	}
	public void setCookielist(List<GoodsT> cookielist) {
		this.cookielist = cookielist;
	}

	
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 *  更新商品点击数
	 * @param goodsid
	 */
	public void UpdateGoodsReadCount(String goodsid){
		@SuppressWarnings("unused")
		int i=this.getGoodsTService().updateGoodsreadcount(goodsid);
	}

	/**
	 * 获取商品cookie
	 * @throws UnsupportedEncodingException 
	 */
	@Action(value = "getGoodsCookie", results = { 
			@Result(name = "json",type="json")
	})
	public String getGoodsCookie() throws UnsupportedEncodingException{
		String picturestrs[]=this.getPictureurl().split(",");
		String goodscookiestr=this.getGoodsid()+","+URLEncoder.encode(this.getGoodsname(),"UTF-8")+","+picturestrs[0]+","+this.getPrice()+","+this.getMemberprice()+","+this.getHtmlPath();
		Cookie cook=new Cookie("cookgoods",goodscookiestr);
		cook.setMaxAge(60*60*24*365);
		ServletActionContext.getResponse().addCookie(cook);
		HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        GoodsT gt=new GoodsT();
        boolean flag=false;
        for(Cookie cookie : cookies)
        {
            if(cookie.getName().equals("cookgoods"))
            {
                String []goodsstr=cookie.getValue().split(",");
                gt.setGoodsid(goodsstr[0]);
                gt.setGoodsname(URLDecoder.decode(goodsstr[1],"UTF-8"));
                gt.setPictureurl(goodsstr[2]);
                gt.setPrice(Double.parseDouble(goodsstr[3]));
                gt.setMemberprice(Double.parseDouble(goodsstr[4]));
                gt.setHtmlPath(goodsstr[5]);
                if(cookielist!=null||cookielist.size()<=7){
                	for(Iterator it=cookielist.iterator();it.hasNext();){
                		GoodsT g=(GoodsT)it.next();
                		if(g.getGoodsid().equals(goodsstr[0])){
                			flag=true;
                		}
                	}
                	if(!flag){
                		cookielist.add(gt);
                	}
                }else{
                	cookielist.remove(0);
                	cookielist.add(gt);
                }
            }
        }
		return "json";
	}
	
	
	
	
	
	/**
	 * 获取同价位商品
	 * @param limit
	 * @param minprice
	 * @param maxprice
	 * @param goodsid
	 */
	public void GetSamepriceGoods(int limit,double minprice,double maxprice,String goodsid){
		List<GoodsT>list=this.getGoodsTService().findSamepriceGoods(limit, minprice, maxprice,goodsid);
		if(list!=null){
			List<String>list1=new ArrayList<String>();
			String []temp=null;
			for(Iterator it=list.iterator();it.hasNext();){
				GoodsT gt=(GoodsT)it.next();
				temp=gt.getPictureurl().split(",");
				gt.setPictureurl(temp[0]);
			}
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("sameprice", list);
			ActionContext.getContext().put("samepricegoods", map);
		}
	}

	
	/**
	 * 获取商品评论
	 * @return
	 */
	@Action(value = "GetGoodsCommentById", results = { 
			@Result(name = "json",type="json")
	})
	public String GetGoodsCommentById(){
		int currentPage=1;
		int lineSize=10;
		beanlist=this.getGoodsCommentTService().findGoodsCommentByGoodsid(this.getGoodsid().trim(), currentPage, lineSize);
		if(beanlist!=null){
			this.setSucflag(true);
			return "json";
		}else{
			this.setSucflag(false);
			return "json";
		}
	}
	
	
	

	
}
