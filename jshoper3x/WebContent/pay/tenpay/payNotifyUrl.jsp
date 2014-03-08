<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ page
	import="com.jshop.action.backstage.thirdpartyplatform.tenpay.*"%>

<%@ include file="config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//---------------------------------------------------------
//财付通支付通知（后台通知）示例，商户按照此文档进行开发即可 改文档处理和本系统相关的逻辑
//---------------------------------------------------------

//创建支付应答对象
ResponseHandler resHandler = new ResponseHandler(request, response);
resHandler.setKey(key);

System.out.println("后台回调返回参数:"+resHandler.getAllParameters());

//判断签名
if(resHandler.isTenpaySign()) {
	
	//通知id
	String notify_id = resHandler.getParameter("notify_id");
	
	//创建请求对象
	RequestHandler queryReq = new RequestHandler(null, null);
	//通信对象
	TenpayHttpClient httpClient = new TenpayHttpClient();
	//应答对象
	ClientResponseHandler queryRes = new ClientResponseHandler();
	
	//通过通知ID查询，确保通知来至财付通
	queryReq.init();
	queryReq.setKey(TenPayConfig.key);
	queryReq.setGateUrl("https://gw.tenpay.com/gateway/simpleverifynotifyid.xml");
	queryReq.setParameter("partner", TenPayConfig.partner);
	queryReq.setParameter("notify_id", notify_id);
	
	//通信对象
	httpClient.setTimeOut(5);
	//设置请求内容
	httpClient.setReqContent(queryReq.getRequestURL());
	System.out.println("验证ID请求字符串:" + queryReq.getRequestURL());
	
	//后台调用
	if(httpClient.call()) {
		//设置结果参数
		queryRes.setContent(httpClient.getResContent());
		System.out.println("验证ID返回字符串:" + httpClient.getResContent());
		queryRes.setKey(key);
			
			
		//获取id验证返回状态码，0表示此通知id是财付通发起
		String retcode = queryRes.getParameter("retcode");
		
		//商户订单号
		String out_trade_no = resHandler.getParameter("out_trade_no");
		//财付通订单号
		String transaction_id = resHandler.getParameter("transaction_id");
		//金额,以分为单位
		String total_fee = resHandler.getParameter("total_fee");
		//如果有使用折扣券，discount有值，total_fee+discount=原请求的total_fee
		String discount = resHandler.getParameter("discount");
		//支付结果
		String trade_state = resHandler.getParameter("trade_state");
		//交易模式，1即时到账，2中介担保
		String trade_mode = resHandler.getParameter("trade_mode");
			
		//判断签名及结果
		if(queryRes.isTenpaySign()&& "0".equals(retcode)){ 
			System.out.println("id验证成功");
			
			if("1".equals(trade_mode)){       //即时到账 
				if( "0".equals(trade_state)){
					
					//这里主要是给本系统进行后端的业务处理，例如更新订单状态等
			        //------------------------------
					//即时到账处理业务开始
					//------------------------------
					
					//处理数据库逻辑
					//注意交易单不要重复处理
					//注意判断返回金额
					
					//------------------------------
					//即时到账处理业务完毕
					//------------------------------
					
					System.out.println("即时到账支付成功");
					//给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
					resHandler.sendToCFT("success");
					
				}else{
					System.out.println("即时到账支付失败");
					resHandler.sendToCFT("fail");
				}
			}else if("2".equals(trade_mode)){    //中介担保
				//------------------------------
				//中介担保处理业务开始
				//------------------------------
				
				//处理数据库逻辑
				//注意交易单不要重复处理
				//注意判断返回金额
				
				int iStatus = TenpayUtil.toInt(trade_state);
				switch(iStatus) {
					case 0:		//付款成功
					
						break;
					case 1:		//交易创建
					
						break;
					case 2:		//收获地址填写完毕
					
						break;
					case 4:		//卖家发货成功
					
						break;
					case 5:		//买家收货确认，交易成功
					
						break;
					case 6:		//交易关闭，未完成超时关闭
					
						break;
					case 7:		//修改交易价格成功
					
						break;
					case 8:		//买家发起退款
					
						break;
					case 9:		//退款成功
					
						break;
					case 10:	//退款关闭
					
						break;
					default:
				}
				
				//------------------------------
				//中介担保处理业务完毕
				//------------------------------
				
				System.out.println("trade_state = " + trade_state);
				//给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
				resHandler.sendToCFT("success");
			}
		}else{
			//错误时，返回结果未签名，记录retcode、retmsg看失败详情。
			System.out.println("查询验证签名失败或id验证失败"+",retcode:" + queryRes.getParameter("retcode"));
		}
	} else {
		System.out.println("后台调用通信失败");
		System.out.println(httpClient.getResponseCode());
		System.out.println(httpClient.getErrInfo());
		//有可能因为网络原因，请求已经处理，但未收到应答。
	}
}else{
	System.out.println("通知签名验证失败");
}

%>

