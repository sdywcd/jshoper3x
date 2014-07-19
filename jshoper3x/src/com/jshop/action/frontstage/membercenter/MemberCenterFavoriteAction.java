package com.jshop.action.frontstage.membercenter;

import java.net.UnknownHostException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.PageModel;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.FavoriteT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.MemberT;
import com.jshop.service.FavoriteTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({
    @InterceptorRef("defaultStack")  
})
public class MemberCenterFavoriteAction extends ActionSupport {

	private Serial serial;
	private FavoriteTService favoriteTService;
	private GoodsTService goodsTService;
	private DataCollectionTAction dataCollectionTAction;
	private String hidurl;
	private String title;
	private String goodsid;
	private String readcount;
	private String memberprice;
	private String favoriteid;
	private String cp;
	private int rp=1;//每页显示数量
	private int page=1;
	private int total=0;
	private int totalpage=1;
	private boolean slogin;
	private boolean sucflag;
	@JSON(serialize=false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize=false)
	public FavoriteTService getFavoriteTService() {
		return favoriteTService;
	}
	public void setFavoriteTService(FavoriteTService favoriteTService) {
		this.favoriteTService = favoriteTService;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public String getGoodsid() {
		return goodsid;
	}


	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	public String getReadcount() {
		return readcount;
	}


	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}


	public String getMemberprice() {
		return memberprice;
	}


	public void setMemberprice(String memberprice) {
		this.memberprice = memberprice;
	}


	public boolean isSlogin() {
		return slogin;
	}


	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	
	
	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getHidurl() {
		return hidurl;
	}


	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}


	public String getFavoriteid() {
		return favoriteid;
	}


	public void setFavoriteid(String favoriteid) {
		this.favoriteid = favoriteid;
	}


	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 增加我的收藏
	 * @return
	 */
	@Action(value = "saveFavorite", results = { 
			@Result(name = "json",type="json")
	})
	public String saveFavorite(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setSlogin(true);
			GoodsT gt=this.getGoodsTService().findByPK(GoodsT.class, this.getGoodsid().trim());
			if(gt!=null){
				FavoriteT f=new FavoriteT();
				f.setFavoriteid(this.getSerial().Serialid(Serial.FAVORITE));
				f.setTitle(gt.getGoodsname());
				f.setGoodsid(this.getGoodsid().trim());
				f.setTag(StaticKey.EMPTY);
				f.setDescript(StaticKey.EMPTY);
				f.setMemberid(memberT.getId());
				f.setState(StaticKey.ONE);
				f.setAddtime(BaseTools.systemtime());
				f.setReadcount(gt.getReadcount());
				f.setMemberprice(String.valueOf(gt.getMemberprice()));
				f.setHtmlpath(gt.getHtmlPath());
				this.getFavoriteTService().save(f);
				this.setSucflag(true);
				return "json";
			}
			return "json";
			
		}else{
			return "json";
		}
	}
	
	/**
	 * 查询收藏夹
	 * @return
	 * @throws UnknownHostException 
	 */
	@Action(value = "findMyFavorite", results = { 
			@Result(name = "success",type="freemarker",location = "WEB-INF/theme/default/shop/favorite.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String findMyFavoriteBymemberId(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			int currentPage=page;
			int lineSize=rp;
			List<FavoriteT>list=this.getFavoriteTService().findAllFavoriteByUserid(memberT.getId(), currentPage, lineSize);
		
			total=this.getFavoriteTService().countfindAllFavoriteByUserid(memberT.getId());
			PageModel<FavoriteT>pm=new PageModel<>(currentPage, lineSize, list, total);
			String action=this.getDataCollectionTAction().getBasePath()+"/findMyFavorite.action?";
			ActionContext.getContext().put("actionlink", action);
			ActionContext.getContext().put("sign", "disstatic");
			ActionContext.getContext().put("goods", pm);
			ActionContext.getContext().put("totalgoods",pm.getTotalRecord());
			ActionContext.getContext().put("totalpage",pm.getTotalpage());
			//获取我的收藏
			ActionContext.getContext().put(FreeMarkervariable.FAVORITE, list);
		
			this.getDataCollectionTAction().putBaseInfoToContext();
			return SUCCESS;
		}
		return INPUT;
	}
	
	/**
	 * 删除用户收藏
	 * @return
	 */
	@Action(value = "delMyFavorite", results = {
			@Result(name = "success",type="chain",location = "findMyFavorite"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String delMyFavoriteByid(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setSlogin(true);
			if(StringUtils.isNotBlank(this.getFavoriteid())){
				String[]strs=StringUtils.split(this.getFavoriteid(), StaticKey.SPLITDOT);
				for(String s:strs){
					FavoriteT f=this.getFavoriteTService().findByPK(FavoriteT.class, s);
					if(f!=null){
						this.getFavoriteTService().delete(f);
					}
				}
				return SUCCESS;
			}
		}
		return INPUT;
	}
	
	
	
}
