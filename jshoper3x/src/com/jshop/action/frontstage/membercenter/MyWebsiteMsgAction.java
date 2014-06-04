package com.jshop.action.frontstage.membercenter;
import java.sql.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberT;
import com.jshop.entity.MsgtextT;
import com.jshop.entity.UserT;
import com.jshop.entity.WebsiteMsgT;
import com.jshop.service.MsgtextTService;
import com.jshop.service.WebsiteMsgTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class MyWebsiteMsgAction extends ActionSupport {
	private Serial serial;
	private WebsiteMsgTService websiteMsgTService;
	private MsgtextTService msgtextTService;
	private DataCollectionTAction dataCollectionTAction;
	private String hidurl;
	private String msgtextid;
	private String text;
	private Date sendTime;
	private String msgid;
	private String msgToUsername;
	private String msgFromUserid;
	private String msgFromUsrname;
	private String state;
	private String title;
	private Date createtime;
	private static Date createtime1;
	private String msgState;	
	private String cp;
	private MsgtextT msgbean = new MsgtextT();
	private WebsiteMsgT webbean= new WebsiteMsgT();
	
	private boolean sflag;
	private boolean slogin;
	
	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize=false)
	public WebsiteMsgTService getWebsiteMsgTService() {
		return websiteMsgTService;
	}
	public void setWebsiteMsgTService(WebsiteMsgTService websiteMsgTService) {
		this.websiteMsgTService = websiteMsgTService;
	}
	@JSON(serialize=false)
	public MsgtextTService getMsgtextTService() {
		return msgtextTService;
	}
	public void setMsgtextTService(MsgtextTService msgtextTService) {
		this.msgtextTService = msgtextTService;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getMsgtextid() {
		return msgtextid;
	}
	public void setMsgtextid(String msgtextid) {
		this.msgtextid = msgtextid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getMsgToUsername() {
		return msgToUsername;
	}
	public void setMsgToUsername(String msgToUsername) {
		this.msgToUsername = msgToUsername;
	}
	public String getMsgFromUserid() {
		return msgFromUserid;
	}
	public void setMsgFromUserid(String msgFromUserid) {
		this.msgFromUserid = msgFromUserid;
	}
	public String getMsgFromUsrname() {
		return msgFromUsrname;
	}
	public void setMsgFromUsrname(String msgFromUsrname) {
		this.msgFromUsrname = msgFromUsrname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getMsgState() {
		return msgState;
	}
	public void setMsgState(String msgState) {
		this.msgState = msgState;
	}
	public boolean isSflag() {
		return sflag;
	}
	public void setSflag(boolean sflag) {
		this.sflag = sflag;
	}
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getHidurl() {
		return hidurl;
	}
	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public MsgtextT getMsgbean() {
		return msgbean;
	}
	public void setMsgbean(MsgtextT msgbean) {
		this.msgbean = msgbean;
	}
	public WebsiteMsgT getWebbean() {
		return webbean;
	}
	public void setWebbean(WebsiteMsgT webbean) {
		this.webbean = webbean;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	}
	
	
	/**
	 * 增加站内信消息
	 * @return
	 */
	@Action(value = "addWebsiteMsgT", results = { 
			@Result(name = "json",type="json")
	})
	public String addWebsiteMsgT(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setSlogin(true);
			MsgtextT mt=new MsgtextT();
			mt.setMsgtextid(this.getSerial().Serialid(Serial.MSGTEXT));
			mt.setText(this.getText());
			mt.setSendtime(BaseTools.systemtime());
			this.getMsgtextTService().save(mt);
				WebsiteMsgT wm=new WebsiteMsgT();
				wm.setMsgid(this.getSerial().Serialid(Serial.WEBSITEMSG));
				wm.setMsgtousername(this.getMsgToUsername().trim());
				wm.setMsgfromuserid(memberT.getId());
				wm.setMsgfromusrname(memberT.getLoginname());
				wm.setMsgtextid(this.getMsgtextid());
				wm.setMsgstate("1");
				wm.setState("0");
				wm.setTitle(this.getTitle().trim());
				wm.setCreatetime(createtime1);
				this.getWebsiteMsgTService().save(wm);
					this.setSflag(true);
					return "json";
				
			
		}else{
			this.setSlogin(false);
			return "json";
		}
	}
	
	/**
	 *获取所有是发给我的消息
	 * @return
	 */
	@Action(value = "findAllWebsiteMsgByToUsername", results = { 
			@Result(name = "success",type="freemarker",location = "WEB-INF/theme/default/shop/mywebsitemsg.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/login.html")
	})
	public String findAllWebsiteMsgByToUsername(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			int currentPage=1;
			int lineSize =15;
			List<WebsiteMsgT> list = this.getWebsiteMsgTService().findAllWebsiteMsgByToUsername(currentPage, lineSize, memberT.getLoginname());
			int allRecorders=this.getWebsiteMsgTService().countfindAllWebsiteMsgByToUsername(memberT.getLoginname());
			if(list!=null){
				//路径获取
				ActionContext.getContext().put("basePath", this.getDataCollectionTAction().getBasePath());
				//获取我的信件
				ActionContext.getContext().put("websitemsg", list);
				//获取导航数据
				ActionContext.getContext().put("siteNavigationList", this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
				//获取商城基本数据
				ActionContext.getContext().put("jshopbasicinfo", this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
				//获取页脚分类数据
				ActionContext.getContext().put("footcategory", this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
				//获取页脚文章数据
				ActionContext.getContext().put("footerarticle", this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
				return SUCCESS;
			}else{
				//路径获取
				ActionContext.getContext().put("basePath", this.getDataCollectionTAction().getBasePath());
				//获取我的信件
				ActionContext.getContext().put("websitemsg", list);
				//获取导航数据
				ActionContext.getContext().put("siteNavigationList", this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
				//获取商城基本数据
				ActionContext.getContext().put("jshopbasicinfo", this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
				//获取页脚分类数据
				ActionContext.getContext().put("footcategory", this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
				//获取页脚文章数据
				ActionContext.getContext().put("footerarticle", this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
				return SUCCESS;
			}
		}else{
			return INPUT;
		}
		
	}
	
	
	/**
	 * 删除站内消息
	 * @return
	 */
	@Action(value = "delWebsiteMsgT", results = {
			@Result(name = "success",type="chain",location = "findAllWebsiteMsgByToUsername"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/login.html")
	})
	public String delWebsiteMsgT(){
		String temp=this.getMsgid().trim()+",";
		String strs[]=StringUtils.split(temp, ",");
		@SuppressWarnings("unused")
		int i=this.getWebsiteMsgTService().delWebsiteMsgT(strs);
		return SUCCESS;
	}
	
	/**
	 *  根据id获取内容信息
	 * @return
	 */
	@Action(value = "findMsgtextById", results = { 
			@Result(name = "json",type="json")			
	})
	public String findMsgtextById(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){			
			if(!this.getMsgtextid().isEmpty()){
				String temp=this.getMsgtextid().trim()+",";
				String []tempid=temp.split(",");
				int i=this.getWebsiteMsgTService().updateWebsiteMsgstate(tempid, "1");
				msgbean=this.getMsgtextTService().findMsgtextById(this.getMsgtextid().trim());
				webbean= this.getWebsiteMsgTService().findMsgtextById(this.getMsgtextid());
				this.setSflag(true);
				
				//路径获取
				ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
				//获取内容
				ActionContext.getContext().put("msgtext", msgbean);
				//获取单个信息
				ActionContext.getContext().put("webmsg", webbean);
				//获取导航数据				
				ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
				//获取商城基本数据
				ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
				//获取页脚分类数据
				ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
				//获取页脚文章数据
				ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
				return "json";
			}else{
				String temp=this.getMsgtextid().trim()+",";
				String []tempid=temp.split(",");
				int i=this.getWebsiteMsgTService().updateWebsiteMsgstate(tempid, "1");	
				//获取单个信息
				ActionContext.getContext().put("webmsg", webbean);
				//路径获取
				ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
				//获取内容
				ActionContext.getContext().put("msgtext", msgbean);
				//获取导航数据				
				ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
				//获取商城基本数据
				ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
				//获取页脚分类数据
				ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
				//获取页脚文章数据
				ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
				this.setSflag(true);
				return "json";
			}
		}
		this.setSflag(false);
		return "json";
	}

	
	
}
