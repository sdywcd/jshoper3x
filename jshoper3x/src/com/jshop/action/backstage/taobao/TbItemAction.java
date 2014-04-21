package com.jshop.action.backstage.taobao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.utils.Validate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.TradeRate;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.request.TraderatesSearchRequest;
import com.taobao.api.request.UserGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import com.taobao.api.response.TraderatesSearchResponse;
import com.taobao.api.response.UserGetResponse;
@Namespace("")
@ParentPackage("jshop")
public class TbItemAction extends ActionSupport {
	
	
    private String numIid;
    private String nick;
    private String params;
    private List rows=new ArrayList();
	private int rp;
	private Long page=1L;
	private int total=0;
	private String query;
	private String qtype;
	//报表数据集合
	private List chartsrows=new ArrayList();
	
	
	private boolean slogin;
	
	private boolean sucflag;
    
    public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNumIid() {
		return numIid;
	}

	public void setNumIid(String numIid) {
		this.numIid = numIid;
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

	
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
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

	
	public List getChartsrows() {
		return chartsrows;
	}

	public void setChartsrows(List chartsrows) {
		this.chartsrows = chartsrows;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 根据当前页和每页大小拿到分页数据
	 * 
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页大小
	 * @param lstArticle
	 *            数据
	 * @return List<Article>
	 */
	public static List getDataByPageNo(int pageNo, int pageSize, List list) {
		int totalpage = pageNo * pageSize > list.size() ? list.size() : pageNo * pageSize;
		return list.subList((pageNo - 1) * pageSize, totalpage);
	}
	
	/**
	 * 获取淘宝用户上架商品信息
	 * @throws ApiException 
	 * @throws ApiException 
	 */
	@Action(value = "findAllTaobaoOnsaleItem", results = { 
			@Result(name = "json",type="json")
	})
    public String findAllTaobaoOnsaleItem() throws ApiException{
    	String taobao_user_nick=(String) ActionContext.getContext().getSession().get("taobao_user_nick");
    	TaobaoClient client=new DefaultTaobaoClient(Util.URL, Util.APP_KEY, Util.APP_SERCET);
    	UserGetRequest req=new UserGetRequest();
    	req.setFields("user_id,nick,seller_credit");
    	req.setNick(taobao_user_nick);

    	UserGetResponse response = client.execute(req , Util.sessionKey);
    	System.out.print(response);
    	if(this.getQtype().equals("sc")){
			this.setTotal(0);
			rows.clear();
			this.findDefaultAllTaobaoOnsaleItem();
		}else{
			if(Validate.StrisNull(this.getQuery())){
				return "json";
			}else{
				return "json";
			}
		}
    	return "json";
    }
    public void findDefaultAllTaobaoOnsaleItem() throws ApiException{
    	String sessionKey=(String) ActionContext.getContext().getSession().get("sessionKey");
    	int currentPage=(int) page.longValue();
		int lineSize=rp;
    	TaobaoClient client=new DefaultTaobaoClient(Util.URL, Util.APP_KEY, Util.APP_SERCET);
   	    ItemsOnsaleGetRequest req=new ItemsOnsaleGetRequest();
   	    req.setFields("num_iid,title,nick");
   	    ItemsOnsaleGetResponse response = client.execute(req ,sessionKey);
   	    //System.out.println(response);
   	    List list=response.getItems();
   	    if(list!=null){
   	     total=list.size();
    	    List list1=getDataByPageNo(currentPage,lineSize,list);
    	    if(list1!=null){
    	    	this.ProcessTaobaoOnsaleItem(list1);
    	    }
   	    }
   	   
    }
    public void ProcessTaobaoOnsaleItem(List list){
    	rows.clear();
    	for(Iterator it=list.iterator();it.hasNext();){
    		Item  tbi=(Item)it.next();
    	    Map<String,Object>cellMap=new HashMap<String,Object>();
			cellMap.put("id", tbi.getNumIid());
			cellMap.put("cell", new Object[]{
				"<input id='id' name='firstcol' class='firsttaobaoonsaleitem' type='checkbox' value='"+tbi.getNumIid()+"'></input>",
				tbi.getTitle(),
				tbi.getNick(),
				"<a  id='editgoods' href='jshop/admin/taobao/tbtradermanagement.jsp?params="+tbi.getNumIid()+","+tbi.getNick()+"' name='editgoods'>[查看评论]</a>"
			});
			rows.add(cellMap);
    	}
    }
    
    /**
     * 根据商品的数字ID获取评论
     * @return
     * @throws ApiException 
     */
    @Action(value = "findAlltraderatessearchById", results = { 
			@Result(name = "json",type="json")
	})
    public String findAlltraderatessearchById() throws ApiException{
    	if(Validate.StrNotNull(this.getParams())){
    		String []strs=this.getParams().split(",");
    		this.setNumIid(strs[0]);
    		this.setNick(strs[1]);
    	}
    	
    	TaobaoClient client=new DefaultTaobaoClient(Util.URL, Util.APP_KEY, Util.APP_SERCET);
    	TraderatesSearchRequest req=new TraderatesSearchRequest();
    	req.setNumIid(Long.parseLong(this.getNumIid()));
    	req.setSellerNick(this.getNick());
    	req.setPageNo(page);
    	req.setPageSize(40L);
    	TraderatesSearchResponse response = client.execute(req);
    	List<TradeRate> list=response.getTradeRates();
    	if(list!=null){
    		total=response.getTotalResults().intValue();
        	rows.clear();
        	for(Iterator it=list.iterator();it.hasNext();){
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
     			cellMap.put("id", tr.getNick());
     			cellMap.put("cell", new Object[]{
     				"<input id='id' name='firstcol' class='firsttaobaoonsaleitem' type='checkbox' value='"+tr.getNick()+"'></input>",
     				tr.getNick(),
     				tr.getItemTitle(),
     				tr.getResult(),
     				tr.getCreated(),
     				tr.getContent(),
     				tr.getReply(),
     				"<a  id='editgoods' href='#'>[发送回馈邮件]</a>"
     			});
     			rows.add(cellMap);
        	}
    	}else{
    		this.setTotal(0);
    		rows.clear();
    		return "json";
    	}
    	
    	return "json";
    }
    
    
   

}
