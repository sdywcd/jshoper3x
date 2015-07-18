package com.jshop.action.xms.frontstage.webapp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.service.GoodsCategoryTService;
/**
 * 首页webapp接口方法
* @ClassName: WappIndexAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jcchen
* @date 2015年5月28日 上午1:16:48 
*
 */
@ParentPackage("jshop")
@Namespace("/xmswebapp")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class WappIndexAction extends BaseTAction {
	@Resource
	private GoodsCategoryTService goodsCategoryTService;
	private List<GoodsCategoryT>list;
	/**
	 * 获取webapp 首页 导航分类
	 * @return
	 */
	public String getIndexGoodsCategory(){
		
		//List<GoodsCategoryT>list=goodsCategoryTService.findByCriteria(t, criterion)
		return JSON;
	}
	
	/**
	 * 获取首页推荐商品
	 * @return
	 */
	public String getIndexRecommentGoods(){
		
		return JSON;
	}
	
	
	
	
	
}
