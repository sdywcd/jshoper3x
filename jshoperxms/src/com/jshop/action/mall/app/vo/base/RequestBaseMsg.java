package com.jshop.action.mall.app.vo.base;
/**
 * 返回基本消息
* @ClassName: RequestBaseMsg 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年4月13日 下午5:07:48 
*
 */
public class RequestBaseMsg {
	private boolean sucflag;
	/**
	 * 提示消息
	 */
	private String msg;
	/**
	 * token 请app在请求接口时带上该参数，除了请求registerUuid4App
	 */
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
