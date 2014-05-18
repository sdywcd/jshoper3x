
<%
/* *
 功能：付完款后跳转的页面（页面跳转同步通知页面）
 版本：3.1
 日期：2010-11-24
 说明：
 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 //***********页面功能说明***********
 该页面可在本机电脑测试
 该页面称作“页面跳转同步通知页面”，是由支付宝服务器同步调用，可当作是支付完成后的提示信息页，如“您的某某某订单，多少金额已支付成功”。
 可放入HTML等美化页面的代码和订单交易完成后的数据库更新程序代码
 WAIT_SELLER_SEND_GOODS(表示买家已在支付宝交易管理中产生了交易记录且付款成功，但卖家没有发货);
 TRADE_FINISHED(表示买家已经确认收货，这笔交易完成);
 
  *************注意******************
 如何判断该笔交易是通过即时到帐方式付款还是通过担保交易方式付款？
 
 担保交易的交易状态变化顺序是：等待买家付款→买家已付款，等待卖家发货→卖家已发货，等待买家收货→买家已收货，交易完成
 即时到帐的交易状态变化顺序是：等待买家付款→交易完成
 
 每当收到支付宝发来通知中，就可以获取到这笔交易的交易状态，并且商户需要利用商户订单号查询商户网站的订单数据，
 得到这笔订单在商户网站中的状态是什么，把商户网站中的订单状态与从支付宝通知中获取到的状态来做对比。
 如果商户网站中目前的状态是等待买家付款，而从支付宝通知获取来的状态是买家已付款，等待卖家发货，那么这笔交易买家是用担保交易方式付款的
 如果商户网站中目前的状态是等待买家付款，而从支付宝通知获取来的状态是交易完成，那么这笔交易买家是用即时到帐方式付款的
 **********************************
 
 //********************************
 * */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.jshop.action.backstage.pay.thirdpartyplatform.alipay.*"%>
<%@ page import="com.jshop.action.frontstage.pay.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付成功客户端返回</title>
<link rel="stylesheet" type="text/css" title="Green"
	href="<%=basePath%>ui/default/css/style_green.css" />


</head>
<body>
	<%
	CallBackAlipayOrderAction cbaction=new CallBackAlipayOrderAction();
	String key = AlipayConfig.key;
	//获取支付宝GET过来反馈信息
	Map params = new HashMap();
	Map requestParams = request.getParameterMap();
	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
		params.put(name, valueStr);
	}
	
	//判断responsetTxt是否为ture，生成的签名结果mysign与获得的签名结果sign是否一致
	//responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
	//mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
	String mysign = AlipayNotify.GetMysign(params,key);
	String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
	String sign = request.getParameter("sign");
	
	//写日志记录（若要调试，请取消下面两行注释）
	//String sWord = "responseTxt=" + responseTxt + "\n return_url_log:sign=" + sign + "&mysign=" + mysign + "\n return回来的参数：" + AlipayFunction.CreateLinkString(params);
	//AlipayFunction.LogResult(sWord);
	
	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
	String trade_no = request.getParameter("trade_no");				//支付宝交易号
	String order_no = request.getParameter("out_trade_no");	        //获取订单号
	String total_fee = request.getParameter("price");  		      	//获取总金额
	String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");//商品名称、订单名称
	String body = "";
	if(request.getParameter("body") != null){
		body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");//商品描述、订单备注、描述
	}
	String buyer_email = request.getParameter("buyer_email");		//买家支付宝账号
	String receive_name = "";//收货人姓名
	if(request.getParameter("receive_name") != null){
		receive_name = new String(request.getParameter("receive_name").getBytes("ISO-8859-1"), "UTF-8");
	}
	String receive_address = "";//收货人地址
	if(request.getParameter("receive_address") != null){
		new String(request.getParameter("receive_address").getBytes("ISO-8859-1"), "UTF-8");
	}
	String receive_zip = "";//收货人邮编
	if(request.getParameter("receive_zip") != null){
		new String(request.getParameter("receive_zip").getBytes("ISO-8859-1"), "UTF-8");
	}
	String receive_phone = "";//收货人电话
	if(request.getParameter("receive_phone") != null){
		new String(request.getParameter("receive_phone").getBytes("ISO-8859-1"), "UTF-8");
	}
	String receive_mobile = "";//收货人手机
	if(request.getParameter("receive_mobile") != null){
		new String(request.getParameter("receive_mobile").getBytes("ISO-8859-1"), "UTF-8");
	}
	String trade_status = request.getParameter("trade_status");		//交易状态
	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

	String verifyStatus = "";

	if(mysign.equals(sign) && responseTxt.equals("true")){
		//////////////////////////////////////////////////////////////////////////////////////////
		//请在这里加上商户的业务逻辑程序代码

		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
		if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){
			//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				//int i=cbaction.CallBackToChangeOrderState(order_no.trim(),"3");
				//int j=cbaction.CallBackToChangeOrderPayState(order_no.trim(),"1");
				//int k=cbaction.CallBackToChangeOrderShippingState(order_no.trim(),"0");
				
		}
		
		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——	
		if(trade_status.equals("TRADE_FINISHED")){
			//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				//int i=cbaction.CallBackToChangeOrderState(order_no.trim(),"6");
				//int j=cbaction.CallBackToChangeOrderPayState(order_no.trim(),"1");
				//int k=cbaction.CallBackToChangeOrderShippingState(order_no.trim(),"1");
			
		}
		
		verifyStatus = "验证成功";
		//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

		//////////////////////////////////////////////////////////////////////////////////////////
	}else{
		verifyStatus = "验证失败";
	}
%>-->

	<div id="top_header">
		<div id="top_header_menu">
			<!--<jsp:include page="../top_header.jsp"></jsp:include>-->
		</div>
	</div>
	<div id="header">

		<div id="header_inner" class="fixed">

			<div id="logo">
				<h2>www.soipay.com</h2>
			</div>

			<!-- 读取导航菜单 -->
			<s:action name="GetIndexMenu" namespace="/jshop_system" id="bean" />
			<div id="menu">
				<ul>
					<li><a href="<%=basePath %>index.jsp " class="active">首页</a></li>
					<s:if test="#bean.mainmenu!=null">
						<s:iterator id="bean" value="#bean.mainmenu"
							status="findindexmenu">
							<li><a
								href="<%=basePath %>goods/goodslist.jsp?navid=<s:property value="navid"/>"
								target="_blank" class="active"><s:property value="nname" /></a></li>
						</s:iterator>
					</s:if>
				</ul>
			</div>


		</div>
	</div>

	<div id="main">

		<div id="main_inner" class="fixed">
			<div id="top_main_inner" class="fixed">
				<!--<jsp:include page="../header.jsp"></jsp:include>-->
			</div>
			<div id="primaryContent_2columns">
				<div id="columnA_2columns">
					<table>
						<tr>
							<td class="font_content" align="right">状态：</td>
							<td class="font_content" align="left"><%=verifyStatus %></td>
						</tr>
						<tr>
							<td class="font_content" align="right"></td>
							<td class="font_content" align="left"><a
								href="InitUserCenterIndex.action">返回soipay用户中心</a></td>
						</tr>
					</table>
				</div>

			</div>

			<div id="secondaryContent_2columns"></div>

			<br class="clear" />

		</div>

	</div>

	<!--<jsp:include page="../footer.jsp"></jsp:include>-->
	<!-- This JavaScript snippet activates those tabs -->

</body>

</html>

<!-- <table align="center" width="350" cellpadding="5" cellspacing="0">
            <tr>
                <td align="center" class="font_title" colspan="2">
                    通知返回</td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    支付宝交易号：</td>
                <td class="font_content" align="left"><%=trade_no %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    订单号：</td>
                <td class="font_content" align="left"><%=order_no %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    付款总金额：</td>
                <td class="font_content" align="left"><%=total_fee %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    商品标题：</td>
                <td class="font_content" align="left"><%=subject %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    商品描述：</td>
                <td class="font_content" align="left"><%=body %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    买家账号：</td>
                <td class="font_content" align="left"><%=buyer_email %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    收货人姓名：</td>
                <td class="font_content" align="left"><%=receive_name %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    收货人地址：</td>
                <td class="font_content" align="left"><%=receive_address %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    收货人邮编：</td>
                <td class="font_content" align="left"><%=receive_zip %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    收货人电话：</td>
                <td class="font_content" align="left"><%=receive_phone %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    收货人手机：</td>
                <td class="font_content" align="left"><%=receive_mobile %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    交易状态：</td>
                <td class="font_content" align="left"><%=trade_status %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    验证状态：</td>
                <td class="font_content" align="left"><%=verifyStatus %></td>
            </tr>
        </table> -->

