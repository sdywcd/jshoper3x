package com.jshop.action.mall.app.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.mall.app.common.AppMsg;
import com.jshop.action.mall.app.vo.base.RequestBaseMsg;
import com.jshop.action.mall.backstage.utils.GsonJson;
import com.jshop.redis.service.RedisBaseTService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 验证app访问接口的权限
* @ClassName: ValidateAppInterceptor 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年4月13日 下午4:14:14 
*
 */
@ParentPackage("jshop")
public class ValidateAppInterceptor extends MethodFilterInterceptor{
	@Resource
	private RedisBaseTService<String> redisBaseTService;
	private boolean sucflag;
	

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	
	

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> params=invocation.getInvocationContext().getParameters();
		String []token=(String[])params.get("token");
		if(token!=null&&token.length>0){
			//在redis中查询token
			String rtoken=redisBaseTService.get(token[0], String.class);
			if(rtoken!=null){
				if(StringUtils.equals(rtoken, token[0])){
					return invocation.invoke();
				}
			}
		}
		printMsg();
		return null;
	}
	
	
	
	private void printMsg() throws IOException{
		RequestBaseMsg rm=new RequestBaseMsg();
		rm.setMsg(AppMsg.INVALIDACCESS);
		String jsonstr = GsonJson.parseDataToJson(rm);
		PrintWriter out = null;
		HttpServletResponse response = ServletActionContext.getResponse();  
		response.setContentType(AppMsg.CONTENTTYPE);
		response.setCharacterEncoding(AppMsg.ENCODING);
		out = response.getWriter();
		out.write(jsonstr);
	}

}
