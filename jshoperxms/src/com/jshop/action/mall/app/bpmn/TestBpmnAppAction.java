package com.jshop.action.mall.app.bpmn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jshop.action.mall.app.vo.goods.RequestGoodsCategoryMsg;
import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.GsonJson;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.service.GoodsCategoryTService;
/**
 * app 商品分类页面接口
* @ClassName: GoodsCategoryAppAction 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年3月24日 下午5:34:53 
*
 */
@Namespace("/app")
@ParentPackage("jshop")
@InterceptorRefs({ @InterceptorRef("defaultStack") })
public class TestBpmnAppAction extends BaseTAction implements
ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TestBpmnAppAction.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Resource
	private GoodsCategoryTService goodsCategoryTService;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	
	/**
	 * 获取所有可用的商品分类信息
	 */
	@Action(value = "testbpmn")
	public void testbpmn(){
		PrintWriter out = null;
		RequestGoodsCategoryMsg rm=new RequestGoodsCategoryMsg();
		try{
			ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
			RepositoryService repositoryService=processEngine.getRepositoryService();
			DeploymentBuilder builder=repositoryService.createDeployment();
			builder.addClasspathResource("com/jshop/action/mall/bpmn/diagram/HelloProcess.bpmn");
			builder.deploy();
			RuntimeService runtimeService=processEngine.getRuntimeService();
			runtimeService.startProcessInstanceByKey("helloProcess");
			//rm.setGct(list);
			rm.setSucflag(true);
			String jsonstr = GsonJson.parseDataToJson(rm);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			out.write(jsonstr);
		}catch(IOException e){
			log.debug(TestBpmnAppAction.class.getName() + "has thrown an exception: "
					+ e.getMessage());
			rm.setMsg(StaticKey.SERVER_BUSY);
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
	}

}
