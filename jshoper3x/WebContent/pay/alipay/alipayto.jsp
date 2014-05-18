
<%
	/*
	功能：设置商品有关信息（入口页）
	 *详细：该页面是接口入口页面，生成支付时的URL
	 *版本：3.1
	 *日期：2010-11-25
	 *说明：
	 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
	 *************************注意*****************
	如果您在接口集成过程中遇到问题，
	您可以到商户服务中心（https://b.alipay.com/support/helperApply.htm?action=consultationApply），提交申请集成协助，我们会有专业的技术工程师主动联系您协助解决，
	您也可以到支付宝论坛（http://club.alipay.com/read-htm-tid-8681712.html）寻找相关解决方案
	要传递的参数要么不允许为空，要么就不要出现在数组与隐藏控件或URL链接里。
	 **********************************************
	 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jshop.action.backstage.pay.thirdpartyplatform.alipay.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付宝双功能付款</title>
<style type="text/css">
.font_content {
	font-family: "宋体";
	font-size: 14px;
	color: #FF6600;
}

.font_title {
	font-family: "宋体";
	font-size: 16px;
	color: #FF0000;
	font-weight: bold;
}

table {
	border: 1px solid #CCCCCC;
}
</style>
</head>
<%
		//request.setCharacterEncoding("UTF-8");
			//AlipyConfig.java中配置信息（不可以修改）
			String input_charset = AlipayConfig.input_charset;
			String sign_type = AlipayConfig.sign_type;
			String seller_email = AlipayConfig.seller_email;
			String partner = AlipayConfig.partner;
			String key = AlipayConfig.key;

			String show_url = AlipayConfig.show_url;
			String notify_url = AlipayConfig.notify_url;
			String return_url = AlipayConfig.return_url;
						
			///////////////////////////////////////////////////////////////////////////////////
			
			//以下参数是需要通过下单时的订单数据传入进来获得
			//必填参数
			UtilDate date = new UtilDate();//调取支付宝工具类生成订单号
			
	        String out_trade_no = AlipayConfig.out_trade_no;//请与贵网站订单系统中的唯一订单号匹配
	        //订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
	        String subject =AlipayConfig.subject;
	        //订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
	        String body =AlipayConfig.body;
	        //订单总金额，显示在支付宝收银台里的“应付总额”里
	        String price = AlipayConfig.price;

	        String logistics_fee =AlipayConfig.logistics_fee;			//物流费用，即运费。
	        String logistics_type = "EXPRESS";			//物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
	        String logistics_payment = "SELLER_PAY";	//物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）

	        String quantity = "1";						//商品数量，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品。

	        //扩展参数——买家收货信息（推荐作为必填）
	        //该功能作用在于买家已经在商户网站的下单流程中填过一次收货信息，而不需要买家在支付宝的付款流程中再次填写收货信息。
	        //若要使用该功能，请至少保证receive_name、receive_address有值
	        String receive_name	= AlipayConfig.receive_name;	//收货人姓名，如：张三
	        String receive_address = AlipayConfig.receive_address;		//收货人地址，如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号
	        String receive_zip = AlipayConfig.reveive_zip;		//收货人邮编，如：123456
	        String receive_phone =AlipayConfig.reveive_phone;	//收货人电话号码，如：0571-81234567
	        String receive_mobile =AlipayConfig.reveive_mobile;	//收货人手机号码，如：13312341234

	        //扩展参数——第二组物流方式
	        //物流方式是三个为一组成组出现。若要使用，三个参数都需要填上数据；若不使用，三个参数都需要为空
	        //有了第一组物流方式，才能有第二组物流方式，且不能与第一个物流方式中的物流类型相同，
	        //即logistics_type="EXPRESS"，那么logistics_type_1就必须在剩下的两个值（POST、EMS）中选择
	        String logistics_fee_1 = "";				//物流费用，即运费。
	        String logistics_type_1	= "";				//物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
	        String logistics_payment_1 = "";			//物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）

	        //扩展参数——第三组物流方式
	        //物流方式是三个为一组成组出现。若要使用，三个参数都需要填上数据；若不使用，三个参数都需要为空
	        //有了第一组物流方式和第二组物流方式，才能有第三组物流方式，且不能与第一组物流方式和第二组物流方式中的物流类型相同，
	        //即logistics_type="EXPRESS"、logistics_type_1="EMS"，那么logistics_type_2就只能选择"POST"
	        String logistics_fee_2 = "";				//物流费用，即运费。
	        String logistics_type_2	= "";				//物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
	        String logistics_payment_2 = "";			//物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）

	        //扩展功能参数——其他
	        String buyer_email = "";					//默认买家支付宝账号
	        String discount = "";						//折扣，是具体的金额，而不是百分比。若要使用打折，请使用负数，并保证小数点最多两位数

	        /////////////////////////////////////////////////////////////////////////////////////////////////////

			////构造函数，生成请求URL
	        String sHtmlText = AlipayService.BuildForm(partner,seller_email,return_url,notify_url,show_url,out_trade_no,
				subject,body,price,logistics_fee,logistics_type,logistics_payment,quantity,receive_name,receive_address,
				receive_zip,receive_phone,receive_mobile,logistics_fee_1,logistics_type_1,logistics_payment_1,
				logistics_fee_2,logistics_type_2,logistics_payment_2,buyer_email,discount,input_charset,key,sign_type);
	%>

<body>
	<table align="center" width="350" cellpadding="5" cellspacing="0">
		<tr>
			<td align="center" class="font_title" colspan="2">订单确认</td>
		</tr>
		<tr>
			<td class="font_content" align="right">订单号：</td>
			<td class="font_content" align="left"><%=out_trade_no%></td>
		</tr>
		<tr>
			<td class="font_content" align="right">付款总金额：</td>
			<td class="font_content" align="left"><%=price%></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><%=sHtmlText%></td>
		</tr>
	</table>
</body>
</html>
