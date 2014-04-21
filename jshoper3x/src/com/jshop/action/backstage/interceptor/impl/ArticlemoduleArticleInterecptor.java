package com.jshop.action.backstage.interceptor.impl;

import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.backstage.interceptor.ArticlemoduleInterecptor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@ParentPackage("jshop")

public class ArticlemoduleArticleInterecptor  extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	private ArticlemoduleInterecptor articlemoduleInterecptor;
	
	public ArticlemoduleInterecptor getArticlemoduleInterecptor() {
		return articlemoduleInterecptor;
	}

	public void setArticlemoduleInterecptor(ArticlemoduleInterecptor articlemoduleInterecptor) {
		this.articlemoduleInterecptor = articlemoduleInterecptor;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=invocation.getInvocationContext();
		Map<String,Object> params=invocation.getInvocationContext().getParameters();
		if(actionContext.getName().equals("updateArticleCategoryT")){
			if(params.get("articleCategoryTid")!=null&&params.get("position")!=null){
				String []positionstrs=(String[])params.get("position");
				String []articleCategoryTidstrs=(String[])params.get("articleCategoryTid");
				String position=positionstrs[0];
				String articleCategoryTid=articleCategoryTidstrs[0];
				this.getArticlemoduleInterecptor().updateArticleposition(articleCategoryTid, position);
			}
			return invocation.invoke();			
		}
		return invocation.invoke();
	}

}
