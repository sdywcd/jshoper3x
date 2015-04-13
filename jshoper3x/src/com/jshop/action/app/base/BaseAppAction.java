package com.jshop.action.app.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jshop.action.app.common.AppMsg;
import com.jshop.action.app.goods.GoodsCategoryAppAction;
import com.jshop.action.app.vo.base.RequestBaseMsg;
import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.GsonJson;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.AppRegisterTokenT;
import com.jshop.redis.service.RedisBaseTService;
import com.jshop.service.BaseTService;
import com.jshop.service.impl.Serial;

@Namespace("/app")
@ParentPackage("jshop")
public class BaseAppAction extends BaseTAction implements ServletRequestAware, ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BaseAppAction.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String uuid;
	
	private String token;
	
	@Resource
	private BaseTService<AppRegisterTokenT> baseTService;
	@Resource
	private RedisBaseTService<String>redisBaseTService;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 1，app带上uuid请求该接口
	 * 2，保存服务器返回的token
	 * 注册请求权限
	 */
	@Action(value="registerUuid4App")
	public void registerUuid(){
		PrintWriter out = null;
		RequestBaseMsg rm=new RequestBaseMsg();
		try{
			if(StringUtils.isNotBlank(this.getUuid())){
				
				//如果uuid对应的token存在redis中
				String existsToken=this.redisBaseTService.get(this.getUuid(), String.class);
				if(existsToken==null){
					AppRegisterTokenT art=new AppRegisterTokenT();
					art.setAid(this.getSerial().Serialid(Serial.APPREGISTERTOKEN));
					art.setMemberid(StaticKey.EMPTY);
					art.setUuid(this.getUuid());
					art.setToken(this.getSerial().Serialid(Serial.TOKENKEY));
					art.setCreatetime(BaseTools.getSystemTime());
					this.baseTService.save(art);
					//以token为key放入redis
					this.redisBaseTService.put(art.getToken(), art.getToken(), String.class);
					//以uuid为key放入redis
					this.redisBaseTService.put(art.getUuid(), art.getToken(), String.class);
					rm.setSucflag(true);
					rm.setToken(art.getToken());
				}else{
					rm.setSucflag(true);
					rm.setToken(existsToken);
				}
			}else{
				rm.setMsg("uuid不存在");
			}
			String jsonstr = GsonJson.parseDataToJson(rm);
			response.setContentType(AppMsg.CONTENTTYPE);
			response.setCharacterEncoding(AppMsg.ENCODING);
			out = response.getWriter();
			out.write(jsonstr);
		}catch(IOException e){
			log.debug(GoodsCategoryAppAction.class.getName() + "has thrown an exception: "
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
