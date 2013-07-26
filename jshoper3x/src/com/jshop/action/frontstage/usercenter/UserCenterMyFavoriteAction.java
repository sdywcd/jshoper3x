package com.jshop.action.frontstage.usercenter;

import java.net.UnknownHostException;
import java.util.List;

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
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.FavoriteT;
import com.jshop.entity.UserT;
import com.jshop.service.FavoriteTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({
    @InterceptorRef("defaultStack")  
})
public class UserCenterMyFavoriteAction extends ActionSupport {

	private Serial serial;
	private FavoriteTService favoriteTService;
	private DataCollectionTAction dataCollectionTAction;
	private String hidurl;
	private String title;
	private String goodsid;
	private String readcount;
	private String memberprice;
	private String favoriteid;
	private String cp;
	private boolean slogin=false;
	private boolean sucflag;
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
	@Action(value = "addFavorite", results = { 
			@Result(name = "json",type="json")
	})
	public String addFavorite(){
		UserT user=(UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(user!=null){
			this.setSlogin(true);
			FavoriteT f=new FavoriteT();
			f.setFavoriteid(this.getSerial().Serialid(Serial.FAVORITE));
			f.setTitle(this.getTitle().trim());
			f.setGoodsid(this.getGoodsid().trim());
			f.setTag(null);
			f.setDescript(null);  
			f.setUserid(user.getUserid());
			f.setState("0");
			f.setAddtime(BaseTools.systemtime());
			f.setReadcount(Integer.parseInt(this.getReadcount().trim()));
			f.setMemberprice(this.getMemberprice());
			if(this.getFavoriteTService().addFavorite(f)>0){
				this.setSucflag(true);
				return "json";
			}else{
				this.setSucflag(false);
				return "json";
			}
		}else{
			this.setSlogin(false);
			return "json";
		}
	}
	
	/**
	 * 查询收藏夹
	 * @return
	 * @throws UnknownHostException 
	 */
	@Action(value = "GetMyFavoriteByUserId", results = { 
			@Result(name = "success",type="freemarker",location = "WEB-INF/theme/default/shop/favorite.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String GetMyFavoriteByUserId(){
		UserT user=(UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(user!=null){
			int currentPage=1;
			int lineSize=50;
			try{
				currentPage=Integer.parseInt(this.getCp());
			}catch(Exception e){
		}
			List<FavoriteT>list=this.getFavoriteTService().findAllFavoriteByUserid(user.getUserid(), currentPage, lineSize);
			try {
				int allRecorders=this.getFavoriteTService().countfindAllFavoriteByUserid(user.getUserid());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取我的收藏
			ActionContext.getContext().put("favorite", list);
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
		return INPUT;
	}
	
	/**
	 * 删除用户收藏
	 * @return
	 */
	@Action(value = "DelMyFavoriteByid", results = { 
			@Result(name = "success",type="chain",location = "GetMyFavoriteByUserId"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String DelMyFavoriteByid(){
		UserT user=(UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(user!=null){
			this.setSlogin(true);
			if(Validate.StrNotNull(this.getFavoriteid())){
				String [] strs=this.getFavoriteid().split(",");
				if(this.getFavoriteTService().delFavorite(strs)>0){
					return SUCCESS;
				}else{
					return INPUT;
				}
			}else{
				return INPUT;
			}
		}
		return INPUT;
	}
	
	
	
}
