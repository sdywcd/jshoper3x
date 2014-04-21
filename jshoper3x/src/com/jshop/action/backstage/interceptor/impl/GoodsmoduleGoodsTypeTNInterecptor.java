package com.jshop.action.backstage.interceptor.impl;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.backstage.goods.GoodsTypeTNAction;
import com.jshop.action.backstage.interceptor.GoodsmoduleInterecptor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
@ParentPackage("jshop")
public class GoodsmoduleGoodsTypeTNInterecptor extends MethodFilterInterceptor {
	
	private static final long serialVersionUID = 1L;
	private GoodsTypeTNAction goodsTypeTNAction;
	private GoodsmoduleInterecptor goodsmoduleInterecptor;
	
	public GoodsmoduleInterecptor getGoodsmoduleInterecptor() {
		return goodsmoduleInterecptor;
	}

	public void setGoodsmoduleInterecptor(GoodsmoduleInterecptor goodsmoduleInterecptor) {
		this.goodsmoduleInterecptor = goodsmoduleInterecptor;
	}

	public GoodsTypeTNAction getGoodsTypeTNAction() {
		return goodsTypeTNAction;
	}

	public void setGoodsTypeTNAction(GoodsTypeTNAction goodsTypeTNAction) {
		this.goodsTypeTNAction = goodsTypeTNAction;
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=invocation.getInvocationContext();
		Map<String,Object> params=invocation.getInvocationContext().getParameters();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		if(actionContext.getName().equals("UpdateGoodsTypeTN")){
			if(params.get("name")!=null&&params.get("goodsTypeId")!=null){
				String []namestrs=(String[]) params.get("name");
				String []goodsTypeIdstrs=(String[])params.get("goodsTypeId");
				String goodsTypeName=namestrs[0];
				String goodsTypeId=goodsTypeIdstrs[0];
				this.getGoodsmoduleInterecptor().updateGoodsTypeBrandTname(goodsTypeName,goodsTypeId);
				this.getGoodsmoduleInterecptor().updateGoodsAttributeTgoodsTypeName(goodsTypeName,goodsTypeId);	
				this.getGoodsmoduleInterecptor().updateGoodsTypeNameBygoodsTypeId(goodsTypeName, goodsTypeId);
			}
			return invocation.invoke();
		}
		if(actionContext.getName().equals("DelGoodsTypeTN")){
			if(params.get("goodsTypeId")!=null){
				String []goodsTypeIdstrs=(String[])params.get("goodsTypeId");
				String goodsTypeIdstr=goodsTypeIdstrs[0];
				String []goodsTypeId=goodsTypeIdstr.split(",");
				this.getGoodsmoduleInterecptor().updateGoodsSaleState(goodsTypeId[0]);
			}
			return invocation.invoke();
		}

		return invocation.invoke();
	}

}
