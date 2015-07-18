package com.jshop.action.xms.frontstage.webapp;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.mall.backstage.base.BaseTAction;
/**
 * webapp搜索
* @ClassName: WappSearchAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jcchen
* @date 2015年5月28日 上午1:17:17 
*
 */
@ParentPackage("jshop")
@Namespace("/xmswebapp")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class WappSearchAction extends BaseTAction {

}
