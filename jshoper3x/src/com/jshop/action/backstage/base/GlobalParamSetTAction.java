package com.jshop.action.backstage.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.utils.statickey.GlobalParam;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GlobalParamM;
import com.jshop.service.GlobalParamService;
import com.opensymphony.xwork2.ActionContext;

@Namespace("")
@ParentPackage("jshop")
public class GlobalParamSetTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private GlobalParamService globalParamService;
	// 基础相关
	private String language;
	private String isstockment;
	private String ispurchaseplan;
	private String isfinancement;
	private String isworkflowengine;
	private String istaskschedule;
	private String isvisitcount;
	private String isusercanregister;
	private String issendactivatemail;
	private String isqueuemail;
	private String isshoppinghelp;
	private String iswebsitehelp;
	private String islog;
	private String isauthoritycontrol;
	// 内容相关
	private String iscommentmoderation;
	private String commenttarget;
	private String isautosharecomment;
	// 订单相关
	private String isinvoice;
	private String isusepoint;
	private String isdiscountcoupon;
	private String isstockoutprocess;
	private String isconfirmtomail;
	private String ispaymail;
	private String isdelivergoodsmail;
	private String iscancelordermail;
	private String isnoticeservice;
	private String isnoticeneworder;
	private String iscashondelivery;
	private String freeshoppinglines;
	
	// 短信相关
	private String salemobile;
	private String isordermsg;
	private String ispaymsg;
	private String isdelivermsg;
	// 移动平台相关
	private String issyncmobileplatform;
	private String issyncgoodsdata;
	private String issynccontentdata;
	private String issynccartdata;
	private String issyncorderdata;
	// 会员相关
	private String freepoint;
	// 库存相关
	private String stockreduce;
	private String defaultstock;
	private String inventorywarning;
	// 图片相关
	private String watermarkfileimg;
	private String watermarkclarity;
	private String issaveoriginalbitmap;
	private String thumbnailwidth;
	private String thumbnailheight;
	private String defaultwidth;
	private String defaultheight;
	private String isimagecompression;
	// 商品相关
	private String pointrename;
	private String integralconversionration;
	private String proportionintegralpayment;
	private String isvirtualitemsupport;
	private String isspecificationsupport;
	private String goodscommentcondition;
	private String isintelligentproductnamed;
	private String associateattributecount;
	// icp备案相关
	private String icp;
	private List<GlobalParamM> beanlist;
	private Map<String, String> map = new HashMap<String, String>();
	private boolean sucflag;

	@JSON(serialize = false)
	public GlobalParamService getGlobalParamService() {
		return globalParamService;
	}

	public void setGlobalParamService(GlobalParamService globalParamService) {
		this.globalParamService = globalParamService;
	}

	public String getIssendactivatemail() {
		return issendactivatemail;
	}

	public void setIssendactivatemail(String issendactivatemail) {
		this.issendactivatemail = issendactivatemail;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public List<GlobalParamM> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<GlobalParamM> beanlist) {
		this.beanlist = beanlist;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsstockment() {
		return isstockment;
	}

	public void setIsstockment(String isstockment) {
		this.isstockment = isstockment;
	}

	public String getIspurchaseplan() {
		return ispurchaseplan;
	}

	public void setIspurchaseplan(String ispurchaseplan) {
		this.ispurchaseplan = ispurchaseplan;
	}

	public String getIsfinancement() {
		return isfinancement;
	}

	public void setIsfinancement(String isfinancement) {
		this.isfinancement = isfinancement;
	}

	public String getIsworkflowengine() {
		return isworkflowengine;
	}

	public void setIsworkflowengine(String isworkflowengine) {
		this.isworkflowengine = isworkflowengine;
	}

	public String getIstaskschedule() {
		return istaskschedule;
	}

	public void setIstaskschedule(String istaskschedule) {
		this.istaskschedule = istaskschedule;
	}

	public String getIsvisitcount() {
		return isvisitcount;
	}

	public void setIsvisitcount(String isvisitcount) {
		this.isvisitcount = isvisitcount;
	}

	public String getIsusercanregister() {
		return isusercanregister;
	}

	public void setIsusercanregister(String isusercanregister) {
		this.isusercanregister = isusercanregister;
	}

	public String getIsqueuemail() {
		return isqueuemail;
	}

	public void setIsqueuemail(String isqueuemail) {
		this.isqueuemail = isqueuemail;
	}

	public String getIsshoppinghelp() {
		return isshoppinghelp;
	}

	public void setIsshoppinghelp(String isshoppinghelp) {
		this.isshoppinghelp = isshoppinghelp;
	}

	public String getIswebsitehelp() {
		return iswebsitehelp;
	}

	public void setIswebsitehelp(String iswebsitehelp) {
		this.iswebsitehelp = iswebsitehelp;
	}

	public String getIslog() {
		return islog;
	}

	public void setIslog(String islog) {
		this.islog = islog;
	}

	public String getIsauthoritycontrol() {
		return isauthoritycontrol;
	}

	public void setIsauthoritycontrol(String isauthoritycontrol) {
		this.isauthoritycontrol = isauthoritycontrol;
	}

	public String getIscommentmoderation() {
		return iscommentmoderation;
	}

	public void setIscommentmoderation(String iscommentmoderation) {
		this.iscommentmoderation = iscommentmoderation;
	}

	public String getCommenttarget() {
		return commenttarget;
	}

	public void setCommenttarget(String commenttarget) {
		this.commenttarget = commenttarget;
	}

	public String getIsautosharecomment() {
		return isautosharecomment;
	}

	public void setIsautosharecomment(String isautosharecomment) {
		this.isautosharecomment = isautosharecomment;
	}

	public String getIsinvoice() {
		return isinvoice;
	}

	public void setIsinvoice(String isinvoice) {
		this.isinvoice = isinvoice;
	}

	public String getIsusepoint() {
		return isusepoint;
	}

	public void setIsusepoint(String isusepoint) {
		this.isusepoint = isusepoint;
	}

	public String getIsdiscountcoupon() {
		return isdiscountcoupon;
	}

	public void setIsdiscountcoupon(String isdiscountcoupon) {
		this.isdiscountcoupon = isdiscountcoupon;
	}

	public String getIsstockoutprocess() {
		return isstockoutprocess;
	}

	public void setIsstockoutprocess(String isstockoutprocess) {
		this.isstockoutprocess = isstockoutprocess;
	}

	public String getIsconfirmtomail() {
		return isconfirmtomail;
	}

	public void setIsconfirmtomail(String isconfirmtomail) {
		this.isconfirmtomail = isconfirmtomail;
	}

	public String getIspaymail() {
		return ispaymail;
	}

	public void setIspaymail(String ispaymail) {
		this.ispaymail = ispaymail;
	}

	public String getIsdelivergoodsmail() {
		return isdelivergoodsmail;
	}

	public void setIsdelivergoodsmail(String isdelivergoodsmail) {
		this.isdelivergoodsmail = isdelivergoodsmail;
	}

	public String getIscancelordermail() {
		return iscancelordermail;
	}

	public void setIscancelordermail(String iscancelordermail) {
		this.iscancelordermail = iscancelordermail;
	}

	public String getIsnoticeservice() {
		return isnoticeservice;
	}

	public void setIsnoticeservice(String isnoticeservice) {
		this.isnoticeservice = isnoticeservice;
	}

	public String getIsnoticeneworder() {
		return isnoticeneworder;
	}

	public void setIsnoticeneworder(String isnoticeneworder) {
		this.isnoticeneworder = isnoticeneworder;
	}

	public String getSalemobile() {
		return salemobile;
	}

	public void setSalemobile(String salemobile) {
		this.salemobile = salemobile;
	}

	public String getIsordermsg() {
		return isordermsg;
	}

	public void setIsordermsg(String isordermsg) {
		this.isordermsg = isordermsg;
	}

	public String getIspaymsg() {
		return ispaymsg;
	}

	public void setIspaymsg(String ispaymsg) {
		this.ispaymsg = ispaymsg;
	}

	public String getIsdelivermsg() {
		return isdelivermsg;
	}

	public void setIsdelivermsg(String isdelivermsg) {
		this.isdelivermsg = isdelivermsg;
	}

	public String getIssyncmobileplatform() {
		return issyncmobileplatform;
	}

	public void setIssyncmobileplatform(String issyncmobileplatform) {
		this.issyncmobileplatform = issyncmobileplatform;
	}

	public String getIssyncgoodsdata() {
		return issyncgoodsdata;
	}

	public void setIssyncgoodsdata(String issyncgoodsdata) {
		this.issyncgoodsdata = issyncgoodsdata;
	}

	public String getIssynccontentdata() {
		return issynccontentdata;
	}

	public void setIssynccontentdata(String issynccontentdata) {
		this.issynccontentdata = issynccontentdata;
	}

	public String getIssynccartdata() {
		return issynccartdata;
	}

	public void setIssynccartdata(String issynccartdata) {
		this.issynccartdata = issynccartdata;
	}

	public String getIssyncorderdata() {
		return issyncorderdata;
	}

	public void setIssyncorderdata(String issyncorderdata) {
		this.issyncorderdata = issyncorderdata;
	}

	public String getFreepoint() {
		return freepoint;
	}

	public void setFreepoint(String freepoint) {
		this.freepoint = freepoint;
	}

	public String getStockreduce() {
		return stockreduce;
	}

	public void setStockreduce(String stockreduce) {
		this.stockreduce = stockreduce;
	}

	public String getDefaultstock() {
		return defaultstock;
	}

	public void setDefaultstock(String defaultstock) {
		this.defaultstock = defaultstock;
	}

	public String getInventorywarning() {
		return inventorywarning;
	}

	public void setInventorywarning(String inventorywarning) {
		this.inventorywarning = inventorywarning;
	}

	public String getWatermarkfileimg() {
		return watermarkfileimg;
	}

	public void setWatermarkfileimg(String watermarkfileimg) {
		this.watermarkfileimg = watermarkfileimg;
	}

	public String getWatermarkclarity() {
		return watermarkclarity;
	}

	public void setWatermarkclarity(String watermarkclarity) {
		this.watermarkclarity = watermarkclarity;
	}

	public String getIssaveoriginalbitmap() {
		return issaveoriginalbitmap;
	}

	public void setIssaveoriginalbitmap(String issaveoriginalbitmap) {
		this.issaveoriginalbitmap = issaveoriginalbitmap;
	}

	public String getThumbnailwidth() {
		return thumbnailwidth;
	}

	public void setThumbnailwidth(String thumbnailwidth) {
		this.thumbnailwidth = thumbnailwidth;
	}

	public String getThumbnailheight() {
		return thumbnailheight;
	}

	public void setThumbnailheight(String thumbnailheight) {
		this.thumbnailheight = thumbnailheight;
	}

	public String getDefaultwidth() {
		return defaultwidth;
	}

	public void setDefaultwidth(String defaultwidth) {
		this.defaultwidth = defaultwidth;
	}

	public String getDefaultheight() {
		return defaultheight;
	}

	public void setDefaultheight(String defaultheight) {
		this.defaultheight = defaultheight;
	}

	public String getIsimagecompression() {
		return isimagecompression;
	}

	public void setIsimagecompression(String isimagecompression) {
		this.isimagecompression = isimagecompression;
	}

	public String getPointrename() {
		return pointrename;
	}

	public void setPointrename(String pointrename) {
		this.pointrename = pointrename;
	}

	public String getIntegralconversionration() {
		return integralconversionration;
	}

	public void setIntegralconversionration(String integralconversionration) {
		this.integralconversionration = integralconversionration;
	}

	public String getProportionintegralpayment() {
		return proportionintegralpayment;
	}

	public void setProportionintegralpayment(String proportionintegralpayment) {
		this.proportionintegralpayment = proportionintegralpayment;
	}

	public String getIsvirtualitemsupport() {
		return isvirtualitemsupport;
	}

	public void setIsvirtualitemsupport(String isvirtualitemsupport) {
		this.isvirtualitemsupport = isvirtualitemsupport;
	}

	public String getIsspecificationsupport() {
		return isspecificationsupport;
	}

	public void setIsspecificationsupport(String isspecificationsupport) {
		this.isspecificationsupport = isspecificationsupport;
	}

	public String getGoodscommentcondition() {
		return goodscommentcondition;
	}

	public void setGoodscommentcondition(String goodscommentcondition) {
		this.goodscommentcondition = goodscommentcondition;
	}

	public String getIsintelligentproductnamed() {
		return isintelligentproductnamed;
	}

	public void setIsintelligentproductnamed(String isintelligentproductnamed) {
		this.isintelligentproductnamed = isintelligentproductnamed;
	}

	public String getAssociateattributecount() {
		return associateattributecount;
	}

	public void setAssociateattributecount(String associateattributecount) {
		this.associateattributecount = associateattributecount;
	}

	public String getIcp() {
		return icp;
	}

	public void setIcp(String icp) {
		this.icp = icp;
	}

	public String getIscashondelivery() {
		return iscashondelivery;
	}

	public void setIscashondelivery(String iscashondelivery) {
		this.iscashondelivery = iscashondelivery;
	}

	public String getFreeshoppinglines() {
		return freeshoppinglines;
	}

	public void setFreeshoppinglines(String freeshoppinglines) {
		this.freeshoppinglines = freeshoppinglines;
	}

	/**
	 * 获取所有全局参数
	 * 
	 * @return
	 */
	@Action(value = "findAllGlobalParam", results = { @Result(name = "json", type = "json") })
	public String findAllGlobalParam() {
		beanlist = this.getGlobalParamService().findAllGlobalParam();
		if (!beanlist.isEmpty()) {
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

	/**
	 * 根据gkey更新全局参数
	 * 
	 * @return
	 * @throws IOException 
	 */
	@Action(value = "updateGolbalParambygkey", results = { @Result(name = "json", type = "json") })
	public String updateGolbalParambygkey() throws IOException {
		// 查询一次所有全局参数
		List<GlobalParamM> list = this.getGlobalParamService().findAllGlobalParam();
		for (Iterator<GlobalParamM> it = list.iterator(); it.hasNext();) {
			GlobalParamM gm = (GlobalParamM) it.next();
			// 写下来是基础相关更新
			if (GlobalParam.LANGUAGE.equals(gm.getGkey())) {
				if (this.getLanguage()!=null&&!gm.getGvalue().equals(this.getLanguage())) {
					gm.setGkey(GlobalParam.LANGUAGE);
					gm.setGvalue(this.getLanguage());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSTOCKMENT.equals(gm.getGkey())) {
				if (this.getIsstockment()!=null&&!gm.getGvalue().equals(this.getIsstockment())) {
					gm.setGkey(GlobalParam.ISSTOCKMENT);
					gm.setGvalue(this.getIsstockment());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISPURCHASEPLAN.equals(gm.getGkey())) {
				if (this.getIspurchaseplan()!=null&&!gm.getGvalue().equals(this.getIspurchaseplan())) {
					gm.setGkey(GlobalParam.ISPURCHASEPLAN);
					gm.setGvalue(this.getIspurchaseplan());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISFINANCEMENT.equals(gm.getGkey())) {
				if (this.getIsfinancement()!=null&&!gm.getGvalue().equals(this.getIsfinancement())) {
					gm.setGkey(GlobalParam.ISFINANCEMENT);
					gm.setGvalue(this.getIsfinancement());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISWORKFLOWENGINE.equals(gm.getGkey())) {
				if (this.getIsworkflowengine()!=null&&!gm.getGvalue().equals(this.getIsworkflowengine())) {
					gm.setGkey(GlobalParam.ISWORKFLOWENGINE);
					gm.setGvalue(this.getIsworkflowengine());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISTASKSCHEDULE.equals(gm.getGkey())) {
				if (this.getIstaskschedule()!=null&&!gm.getGvalue().equals(this.getIstaskschedule())) {
					gm.setGkey(GlobalParam.ISTASKSCHEDULE);
					gm.setGvalue(this.getIstaskschedule());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISVISITCOUNT.equals(gm.getGkey())) {
				if (this.getIsvisitcount()!=null&&!gm.getGvalue().equals(this.getIsvisitcount())) {
					gm.setGkey(GlobalParam.ISVISITCOUNT);
					gm.setGvalue(this.getIsvisitcount());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISUSERCANREGISTER.equals(gm.getGkey())) {
				if (this.getIsusercanregister()!=null&&!gm.getGvalue().equals(this.getIsusercanregister())) {
					gm.setGkey(GlobalParam.ISUSERCANREGISTER);
					gm.setGvalue(this.getIsusercanregister());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSENDACTIVATEMAIL.equals(gm.getGkey())) {
				if (this.getIssendactivatemail()!=null&&!gm.getGvalue().equals(this.getIssendactivatemail())) {
					gm.setGkey(GlobalParam.ISSENDACTIVATEMAIL);
					gm.setGvalue(this.getIssendactivatemail());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISQUEUEMAIL.equals(gm.getGkey())) {
				if (this.getIsqueuemail()!=null&&!gm.getGvalue().equals(this.getIsqueuemail())) {
					gm.setGkey(GlobalParam.ISQUEUEMAIL);
					gm.setGvalue(this.getIsqueuemail());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSHOPPINGHELP.equals(gm.getGkey())) {
				if (this.getIsshoppinghelp()!=null&&!gm.getGvalue().equals(this.getIsshoppinghelp())) {
					gm.setGkey(GlobalParam.ISSHOPPINGHELP);
					gm.setGvalue(this.getIsshoppinghelp());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISWEBSITEHELP.equals(gm.getGkey())) {
				if (this.getIswebsitehelp()!=null&&!gm.getGvalue().equals(this.getIswebsitehelp())) {
					gm.setGkey(GlobalParam.ISWEBSITEHELP);
					gm.setGvalue(this.getIswebsitehelp());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISLOG.equals(gm.getGkey())) {
				if (this.getIslog()!=null&&!gm.getGvalue().equals(this.getIslog())) {
					gm.setGkey(GlobalParam.ISLOG);
					gm.setGvalue(this.getIslog());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISAUTHORITYCONTROL.equals(gm.getGkey())) {
				if (this.getIsauthoritycontrol()!=null&&!gm.getGvalue().equals(this.getIsauthoritycontrol())) {
					gm.setGkey(GlobalParam.ISAUTHORITYCONTROL);
					gm.setGvalue(this.getIsauthoritycontrol());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISCOMMENTMODERATION.equals(gm.getGkey())) {// 接下来的是内容相关更新
				if (this.getIscommentmoderation()!=null&&!gm.getGvalue().equals(this.getIscommentmoderation())) {
					gm.setGkey(GlobalParam.ISCOMMENTMODERATION);
					gm.setGvalue(this.getIscommentmoderation());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.COMMENTTARGET.equals(gm.getGkey())) {
				if (this.getCommenttarget()!=null&&!gm.getGvalue().equals(this.getCommenttarget())) {
					gm.setGkey(GlobalParam.COMMENTTARGET);
					gm.setGvalue(this.getCommenttarget());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISAUTOSHARECOMMENT.equals(gm.getGkey())) {
				if (this.getIsautosharecomment()!=null&&!gm.getGvalue().equals(this.getIsautosharecomment())) {
					gm.setGkey(GlobalParam.ISAUTOSHARECOMMENT);
					gm.setGvalue(this.getIsautosharecomment());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISINVOICE.equals(gm.getGkey())) {// 接下来的是订单相关更新
				if (this.getIsinvoice()!=null&&!gm.getGvalue().equals(this.getIsinvoice())) {
					gm.setGkey(GlobalParam.ISINVOICE);
					gm.setGvalue(this.getIsinvoice());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISUSEPOINT.equals(gm.getGkey())) {
				if (this.getIsusepoint()!=null&&!gm.getGvalue().equals(this.getIsusepoint())) {
					gm.setGkey(GlobalParam.ISUSEPOINT);
					gm.setGvalue(this.getIsusepoint());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISDISCOUNTCOUPON.equals(gm.getGkey())) {
				if (this.getIsdiscountcoupon()!=null&&!gm.getGvalue().equals(this.getIsdiscountcoupon())) {
					gm.setGkey(GlobalParam.ISDISCOUNTCOUPON);
					gm.setGvalue(this.getIsdiscountcoupon());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSTOCKOUTPROCESS.equals(gm.getGkey())) {
				if (this.getIsstockoutprocess()!=null&&!gm.getGvalue().equals(this.getIsstockoutprocess())) {
					gm.setGkey(GlobalParam.ISSTOCKOUTPROCESS);
					gm.setGvalue(this.getIsstockoutprocess());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISCONFIRMTOMAIL.equals(gm.getGkey())) {
				if (this.getIsconfirmtomail()!=null&&!gm.getGvalue().equals(this.getIsconfirmtomail())) {
					gm.setGkey(GlobalParam.ISCONFIRMTOMAIL);
					gm.setGvalue(this.getIsconfirmtomail());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISPAYMAIL.equals(gm.getGkey())) {
				if (this.getIspaymail()!=null&&!gm.getGvalue().equals(this.getIspaymail())) {
					gm.setGkey(GlobalParam.ISPAYMAIL);
					gm.setGvalue(this.getIspaymail());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISDELIVERGOODSMAIL.equals(gm.getGkey())) {
				if (this.getIsdelivergoodsmail()!=null&&!gm.getGvalue().equals(this.getIsdelivergoodsmail())) {
					gm.setGkey(GlobalParam.ISDELIVERGOODSMAIL);
					gm.setGvalue(this.getIsdelivergoodsmail());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISCANCELORDERMAIL.equals(gm.getGkey())) {
				if (this.getIscancelordermail()!=null&&!gm.getGvalue().equals(this.getIscancelordermail())) {
					gm.setGkey(GlobalParam.ISCANCELORDERMAIL);
					gm.setGvalue(this.getIscancelordermail());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISNOTICESERVICE.equals(gm.getGkey())) {
				if (this.getIsnoticeservice()!=null&&!gm.getGvalue().equals(this.getIsnoticeservice())) {
					gm.setGkey(GlobalParam.ISNOTICESERVICE);
					gm.setGvalue(this.getIsnoticeservice());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISNOTICENEWORDER.equals(gm.getGkey())) {
				if (this.getIsnoticeneworder()!=null&&!gm.getGvalue().equals(this.getIsnoticeneworder())) {
					gm.setGkey(GlobalParam.ISNOTICENEWORDER);
					gm.setGvalue(this.getIsnoticeneworder());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISCASHONDELIVERY.equals(gm.getGkey())) {
				if (this.getIscashondelivery()!=null&&!gm.getGvalue().equals(this.getIscashondelivery())) {
					gm.setGkey(GlobalParam.ISCASHONDELIVERY);
					gm.setGvalue(this.getIscashondelivery());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.FREESHOPPINGLINES.equals(gm.getGkey())) {
				if (this.getFreeshoppinglines()!=null&&!gm.getGvalue().equals(this.getFreeshoppinglines())) {
					gm.setGkey(GlobalParam.FREESHOPPINGLINES);
					gm.setGvalue(this.getFreeshoppinglines());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			}else if (GlobalParam.SALEMOBILE.equals(gm.getGkey())) {// 接下来是短信相关的更新
				if (this.getSalemobile()!=null&&!gm.getGvalue().equals(this.getSalemobile())) {
					gm.setGkey(GlobalParam.SALEMOBILE);
					gm.setGvalue(this.getSalemobile());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISORDERMSG.equals(gm.getGkey())) {
				if (this.getIsordermsg()!=null&&!gm.getGvalue().equals(this.getIsordermsg())) {
					gm.setGkey(GlobalParam.ISORDERMSG);
					gm.setGvalue(this.getIsordermsg());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISPAYMSG.equals(gm.getGkey())) {
				if (this.getIspaymsg()!=null&&!gm.getGvalue().equals(this.getIspaymsg())) {
					gm.setGkey(GlobalParam.ISPAYMSG);
					gm.setGvalue(this.getIspaymsg());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISDELIVERMSG.equals(gm.getGkey())) {
				if (this.getIsdelivermsg()!=null&&!gm.getGvalue().equals(this.getIsdelivermsg())) {
					gm.setGkey(GlobalParam.ISDELIVERMSG);
					gm.setGvalue(this.getIsdelivermsg());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSYNCMOBILEPLATFORM.equals(gm.getGkey())) {// 接下来是移动平台的更新
				if (this.getIssyncmobileplatform()!=null&&!gm.getGvalue().equals(this.getIssyncmobileplatform())) {
					gm.setGkey(GlobalParam.ISSYNCMOBILEPLATFORM);
					gm.setGvalue(this.getIssyncmobileplatform());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSYNCGOODSDATA.equals(gm.getGkey())) {
				if (this.getIssyncgoodsdata()!=null&&!gm.getGvalue().equals(this.getIssyncgoodsdata())) {
					gm.setGkey(GlobalParam.ISSYNCGOODSDATA);
					gm.setGvalue(this.getIssyncgoodsdata());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSYNCCONTENTDATA.equals(gm.getGkey())) {
				if (this.getIssynccontentdata()!=null&&!gm.getGvalue().equals(this.getIssynccontentdata())) {
					gm.setGkey(GlobalParam.ISSYNCCONTENTDATA);
					gm.setGvalue(this.getIssynccontentdata());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSYNCCARTDATA.equals(gm.getGkey())) {
				if (this.getIssynccartdata()!=null&&!gm.getGvalue().equals(this.getIssynccartdata())) {
					gm.setGkey(GlobalParam.ISSYNCCARTDATA);
					gm.setGvalue(this.getIssynccartdata());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSYNCORDERDATA.equals(gm.getGkey())) {
				if (this.getIssyncorderdata()!=null&&!gm.getGvalue().equals(this.getIssyncorderdata())) {
					gm.setGkey(GlobalParam.ISSYNCORDERDATA);
					gm.setGvalue(this.getIssyncorderdata());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.FREEPOINT.equals(gm.getGkey())) {// 接下来是会员相关更新
				if (this.getFreepoint()!=null&&!gm.getGvalue().equals(this.getFreepoint())) {
					gm.setGkey(GlobalParam.FREEPOINT);
					gm.setGvalue(this.getFreepoint());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.STOCKREDUCE.equals(gm.getGkey())) {// 接下来是库存相关更新
				if (this.getStockreduce()!=null&&!gm.getGvalue().equals(this.getStockreduce())) {
					gm.setGkey(GlobalParam.STOCKREDUCE);
					gm.setGvalue(this.getStockreduce());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.DEFAULTSTOCK.equals(gm.getGkey())) {
				if (this.getDefaultstock()!=null&&!gm.getGvalue().equals(this.getDefaultstock())) {
					gm.setGkey(GlobalParam.DEFAULTSTOCK);
					gm.setGvalue(this.getDefaultstock());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.INVENTORYWARNING.equals(gm.getGkey())) {
				if (this.getInventorywarning()!=null&&!gm.getGvalue().equals(this.getInventorywarning())) {
					gm.setGkey(GlobalParam.INVENTORYWARNING);
					gm.setGvalue(this.getInventorywarning());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.WATERMARKFILE.equals(gm.getGkey())) {// 接下来是图片相关更新(watermarkfileimg)
				if (this.getWatermarkfileimg()!=null&&!gm.getGvalue().equals(this.getWatermarkfileimg())) {
					gm.setGkey(GlobalParam.WATERMARKFILE);
					gm.setGvalue(this.getWatermarkfileimg());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.WATERMARKCLARITY.equals(gm.getGkey())) {
				if (this.getWatermarkclarity()!=null&&!gm.getGvalue().equals(this.getWatermarkclarity())) {
					gm.setGkey(GlobalParam.WATERMARKCLARITY);
					gm.setGvalue(this.getWatermarkclarity());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSAVEORIGINALBITMAP.equals(gm.getGkey())) {
				if (this.getIssaveoriginalbitmap()!=null&&!gm.getGvalue().equals(this.getIssaveoriginalbitmap())) {
					gm.setGkey(GlobalParam.ISSAVEORIGINALBITMAP);
					gm.setGvalue(this.getIssaveoriginalbitmap());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.THUMBNAILWIDTH.equals(gm.getGkey())) {
				if (this.getThumbnailwidth()!=null&&!gm.getGvalue().equals(this.getThumbnailwidth())) {
					gm.setGkey(GlobalParam.THUMBNAILWIDTH);
					gm.setGvalue(this.getThumbnailwidth());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.THUMBNAILHEIGHT.equals(gm.getGkey())) {
				if (this.getThumbnailheight()!=null&&!gm.getGvalue().equals(this.getThumbnailheight())) {
					gm.setGkey(GlobalParam.THUMBNAILHEIGHT);
					gm.setGvalue(this.getThumbnailheight());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.DEFAULTWIDTH.equals(gm.getGkey())) {
				if (this.getDefaultwidth()!=null&&!gm.getGvalue().equals(this.getDefaultwidth())) {
					gm.setGkey(GlobalParam.DEFAULTWIDTH);
					gm.setGvalue(this.getDefaultwidth());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.DEFAULTHEIGHT.equals(gm.getGkey())) {
				if (this.getDefaultheight()!=null&&!gm.getGvalue().equals(this.getDefaultheight())) {
					gm.setGkey(GlobalParam.DEFAULTHEIGHT);
					gm.setGvalue(this.getDefaultheight());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISIMAGECOMPRESSION.equals(gm.getGkey())) {
				if (this.getIsimagecompression()!=null&&!gm.getGvalue().equals(this.getIsimagecompression())) {
					gm.setGkey(GlobalParam.ISIMAGECOMPRESSION);
					gm.setGvalue(this.getIsimagecompression());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.POINTRENAME.equals(gm.getGkey())) {// 接下来是商品相关更新
				if (this.getPointrename()!=null&&!gm.getGvalue().equals(this.getPointrename())) {
					gm.setGkey(GlobalParam.POINTRENAME);
					gm.setGvalue(this.getPointrename());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.INTEGRALCONVERSIONRATION.equals(gm.getGkey())) {
				if (this.getIntegralconversionration()!=null&&!gm.getGvalue().equals(this.getIntegralconversionration())) {
					gm.setGkey(GlobalParam.INTEGRALCONVERSIONRATION);
					gm.setGvalue(this.getIntegralconversionration());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.PROPORTIONINTEGRALPAYMENT.equals(gm.getGkey())) {
				if (this.getProportionintegralpayment()!=null&&!gm.getGvalue().equals(this.getProportionintegralpayment())) {
					gm.setGkey(GlobalParam.PROPORTIONINTEGRALPAYMENT);
					gm.setGvalue(this.getProportionintegralpayment());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISVIRTUALITEMSUPPORT.equals(gm.getGkey())) {
				if (this.getIsvirtualitemsupport()!=null&&!gm.getGvalue().equals(this.getIsvirtualitemsupport())) {
					gm.setGkey(GlobalParam.ISVIRTUALITEMSUPPORT);
					gm.setGvalue(this.getIsvirtualitemsupport());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISSPECIFICATIONSUPPORT.equals(gm.getGkey())) {
				if (this.getIsspecificationsupport()!=null&&!gm.getGvalue().equals(this.getIsspecificationsupport())) {
					gm.setGkey(GlobalParam.ISSPECIFICATIONSUPPORT);
					gm.setGvalue(this.getIsspecificationsupport());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.GOODSCOMMENTCONDITION.equals(gm.getGkey())) {
				if (this.getGoodscommentcondition()!=null&&!gm.getGvalue().equals(this.getGoodscommentcondition())) {
					gm.setGkey(GlobalParam.GOODSCOMMENTCONDITION);
					gm.setGvalue(this.getGoodscommentcondition());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ISINTELLIGENTPRODUCTNAMED.equals(gm.getGkey())) {
				if (this.getIsintelligentproductnamed()!=null&&!gm.getGvalue().equals(this.getIsintelligentproductnamed())) {
					gm.setGkey(GlobalParam.ISINTELLIGENTPRODUCTNAMED);
					gm.setGvalue(this.getIsintelligentproductnamed());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ASSOCIATEATTRIBUTECOUNT.equals(gm.getGkey())) {
				if (this.getAssociateattributecount()!=null&&!gm.getGvalue().equals(this.getAssociateattributecount())) {
					gm.setGkey(GlobalParam.ASSOCIATEATTRIBUTECOUNT);
					gm.setGvalue(this.getAssociateattributecount());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			} else if (GlobalParam.ICP.equals(gm.getGkey())) {// 接下来是icp备案相关更新
				if (this.getIcp()!=null&&!gm.getGvalue().equals(this.getIcp())) {
					gm.setGkey(GlobalParam.ICP);
					gm.setGvalue(this.getIcp());
					this.getGlobalParamService().updateGolbalParamByKey(gm);
				}
			}
		}
		this.setSucflag(true);
		updateGlobalParamProperties();
		return "json";
	}
	
	/**
	 * 将配置文件保存
	 * @throws IOException
	 */
	private void updateGlobalParamProperties() throws IOException{
		String filePath="";
		ActionContext ac=ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		filePath=sc.getRealPath("/")+StaticKey.SYSTEM_CONFIG_FILE;
		InputStream inputStream = new FileInputStream(filePath);
		Properties p = new Properties();
		p.load(inputStream);
		OutputStream outputStream = new FileOutputStream(filePath);
		List<GlobalParamM>list=this.getGlobalParamService().findAllGlobalParam();
 		for (Iterator<GlobalParamM> it = list.iterator(); it.hasNext();) {
                             			GlobalParamM gm = (GlobalParamM) it.next();
			p.setProperty(gm.getGkey(), gm.getGvalue());
		}
		p.store(outputStream, "update_config");
		outputStream.close();
		inputStream.close();
		
	}

}
