package com.jshop.action.merchant.backstage.base;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.JshopOpenState;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.impl.Serial;

/**
 *商户相关处理
* @ClassName: MerchantAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jcchen
* @date 2015年5月23日 下午6:13:19 
*
 */
@ParentPackage("jshop")
@Namespace("/merchant")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class MerchantAction extends BaseTAction{

	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	private String jshopname;
	private String street;
	private String weixinservice;
	private String phoneservice;
	private String basepath;
	private boolean sucflag;
	
	public String getBasepath() {
		return basepath;
	}


	public void setBasepath(String basepath) {
		this.basepath = BaseTools.getBasePath();
	}

	public String getJshopname() {
		return jshopname;
	}


	public void setJshopname(String jshopname) {
		this.jshopname = jshopname;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getWeixinservice() {
		return weixinservice;
	}


	public void setWeixinservice(String weixinservice) {
		this.weixinservice = weixinservice;
	}


	public String getPhoneservice() {
		return phoneservice;
	}


	public void setPhoneservice(String phoneservice) {
		this.phoneservice = phoneservice;
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
	 * 注册商户基本信息
	 * 
	 * @return
	 */
	@Action(value = "saveMerchantApply",results = {
			@Result(name = "success", type = "freemarker", location = "/WEB-INF/theme/default/shop/searchgoods.ftl"),
			@Result(name = "input", type = "chain",params={"namespace","/xms"}, location = "servererror")
	})
	public String saveMerchantApply() {
		JshopbasicInfoT jbi = new JshopbasicInfoT();
		jbi.setBasicinfoid(this.getSerial().Serialid(Serial.JSHOPBASICINFO));
		jbi.setJshopname(this.getJshopname().trim());
		jbi.setJshopslogan(StaticKey.EMPTY);
		jbi.setCountry(StaticKey.EMPTY);
		jbi.setProvince(StaticKey.EMPTY);
		jbi.setCity(StaticKey.EMPTY);
		jbi.setStreet(StaticKey.EMPTY);
		jbi.setQqservice(StaticKey.EMPTY);
		jbi.setSkypeservice(StaticKey.EMPTY);
		jbi.setWeixinservice(this.getWeixinservice().trim());
		jbi.setSinaweiboservice(StaticKey.EMPTY);
		jbi.setEmailservice(StaticKey.EMPTY);
		jbi.setPhoneservice(this.getPhoneservice().trim());
		jbi.setOpenstate(JshopOpenState.CLOSE.getState());
		jbi.setSiteclosenotes(StaticKey.EMPTY);
		jbi.setSitelogo(StaticKey.EMPTY);
		jbi.setLicensed(StaticKey.EMPTY);
		jbi.setIcpnum(StaticKey.EMPTY);
		jbi.setState(DataUsingState.USING.getState());
		jbi.setDistrict(StaticKey.EMPTY);
		jbi.setCreatorid(StaticKey.ZERO);//0表示前台增加
		jbi.setCreatetime(BaseTools.getSystemTime());
		jbi.setMetaDes(StaticKey.EMPTY);
		jbi.setMetaKeywords(StaticKey.EMPTY);
		this.jshopbasicInfoTService.save(jbi);
		this.setSucflag(true);
		return INPUT;
	}
	
	
}
