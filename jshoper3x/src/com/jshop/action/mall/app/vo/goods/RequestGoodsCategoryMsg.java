package com.jshop.action.mall.app.vo.goods;

import java.util.List;

import com.jshop.entity.GoodsCategoryT;

/**
 * app商品分类对象
* @ClassName: GoodsCategoryVo 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年3月24日 下午5:45:10 
*
 */
public class RequestGoodsCategoryMsg {
	/**
	 * gct 商品分类信息集合
	 */
	private List<GoodsCategoryT>gct;
	private String msg;
	private boolean sucflag;
	public List<GoodsCategoryT> getGct() {
		return gct;
	}
	public void setGct(List<GoodsCategoryT> gct) {
		this.gct = gct;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	
}
