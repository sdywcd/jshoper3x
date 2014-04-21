package com.jshop.action.backstage.taobao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.utils.Arith;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.TradeRate;
import com.taobao.api.request.TraderatesGetRequest;
import com.taobao.api.response.TraderatesGetResponse;
@Namespace("")
@ParentPackage("jshop")
public class TbtraderatesAction extends ActionSupport{
	private List rows=new ArrayList();
	private List chartsrows=new ArrayList();
	private int rp;
	private Long page=1L;
	private int total=0;
	private String query;
	private String qtype;
	private boolean slogin;
	
	private boolean sucflag;
	
	private List<TradeRate> traderatelist=new ArrayList<TradeRate>();
	public List getChartsrows() {
		return chartsrows;
	}

	public void setChartsrows(List chartsrows) {
		this.chartsrows = chartsrows;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public List<TradeRate> getTraderatelist() {
		return traderatelist;
	}

	public void setTraderatelist(List<TradeRate> traderatelist) {
		this.traderatelist = traderatelist;
	}


	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	@Action(value = "findAllTraderates", results = { 
			@Result(name = "json",type="json")
	})
	public String findAllTraderates() throws ParseException, ApiException{
		
		String sessionKey=(String) ActionContext.getContext().getSession().get("sessionKey");
		TaobaoClient client=new DefaultTaobaoClient(Util.URL, Util.APP_KEY, Util.APP_SERCET);
		TraderatesGetRequest req=new TraderatesGetRequest();
		req.setFields("tid,oid,role,nick,result,created,rated_nick,item_title,item_price,content,reply");
		req.setRateType("get");
		req.setPageNo(1L);
		req.setPageSize(100L);
		Date date=new Date();
		req.setEndDate(date);
		req.setRole("buyer");
		//req.setTid(123456L);
		TraderatesGetResponse response = client.execute(req ,sessionKey);
		traderatelist=response.getTradeRates();
		rows.clear();
		this.setTotal(0);
		if(traderatelist!=null){
			total=response.getTotalResults().intValue();
			rows.clear();
			for(Iterator it=traderatelist.iterator();it.hasNext();){
				TradeRate tr=(TradeRate)it.next();
				if(tr.getRole().equals("seller")){
					tr.setRole("卖家");
				}else{
					tr.setRole("买家");
				}
				if(tr.getResult().equals("good")){
					tr.setResult("好评");
				}else if(tr.getResult().equals("neutral")){
					tr.setResult("中评");
				}else{
					tr.setResult("差评");
				}
				Map<String,Object>cellMap=new HashMap<String,Object>();
				cellMap.put("id", tr.getTid());
				cellMap.put("cell", new Object[]{
					"<input id='id' name='firstcol' class='firsttaobaoontraderdate' type='checkbox' value='"+tr.getTid()+"'></input>",
	 				tr.getContent(),
	 				tr.getReply(),
	 				tr.getRole(),
	 				tr.getResult(),
	 				tr.getCreated(),
	 				tr.getNick(),
	 				tr.getItemTitle()
				});
				rows.add(cellMap);
			}
		}
		return "json";
	}
	
	/**
	 * 获取报表内容
	 * @return
	 * @throws ParseException
	 * @throws ApiException
	 */
	@Action(value = "makeTraderdateChart", results = { 
			@Result(name = "json",type="json")
	})
	public String makeTraderdateChart() throws ParseException, ApiException{
		chartsrows.clear();
		if(traderatelist!=null){
			double totalsum=total;
			double goodssum=0;
			double neutralsum=0;
			double badsum=0;
			for(Iterator it=traderatelist.iterator();it.hasNext();){
				TradeRate tr=(TradeRate)it.next();
				if(tr.getResult().equals("好评")){
					goodssum++;
				}else if(tr.getResult().equals("中评")){
					neutralsum++;
				}else{
					badsum++;
				}
				
			}
			int hp=Arith.div(goodssum, totalsum).intValue();
			int zp=Arith.div(neutralsum, totalsum).intValue();
			int cp=Arith.div(badsum, totalsum).intValue();
			Object []str1={"好评",hp};
			Object []str2={"中评",zp};
			Object []str3={"差评",cp};
			chartsrows.add(str1);
			chartsrows.add(str2);
			chartsrows.add(str3);
			
		
			
			
		}
		return "json";
	}
	
}
